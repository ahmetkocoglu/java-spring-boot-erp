package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoAddress;
import ank.phito.erp.dto.DtoAddressIU;
import ank.phito.erp.entity.AddressEntity;
import ank.phito.erp.repository.AddressRepository;
import ank.phito.erp.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress response = new DtoAddress();
        AddressEntity log = new AddressEntity();
        BeanUtils.copyProperties(dtoAddressIU, log);

        AddressEntity dbAddress = addressRepository.save(log);
        BeanUtils.copyProperties(dbAddress, response);

        return response;
    }

    @Override
    public List<DtoAddress> getAllAddress() {
        List<DtoAddress> dtoList = new ArrayList<>();

        List<AddressEntity> logList = addressRepository.findAll();
        for (AddressEntity log : logList) {
            DtoAddress dto = new DtoAddress();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoAddress getAddressById(String id) {
        DtoAddress dtoAddress = new DtoAddress();
        Optional<AddressEntity> optional =  addressRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        AddressEntity dbAddress = optional.get();
        BeanUtils.copyProperties(dbAddress, dtoAddress);

        return dtoAddress;
    }

    @Override
    public void deleteAddress(String id) {
        Optional<AddressEntity> optional = addressRepository.findById(id);
        optional.ifPresent(logEntity -> addressRepository.delete(logEntity));
    }

    @Override
    public DtoAddress updateAddress(String id, DtoAddressIU dtoAddressIU) {
        DtoAddress dto = new DtoAddress();

        Optional<AddressEntity> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            AddressEntity dbAddress = optional.get();

            dbAddress.setTitle(dtoAddressIU.getTitle());
            dbAddress.setDescription(dtoAddressIU.getDescription());

            AddressEntity updatedAddress = addressRepository.save(dbAddress);

            BeanUtils.copyProperties(updatedAddress, dto);
            return dto;
        }
        return null;
    }
}
