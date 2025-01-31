package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoPrice;
import ank.phito.erp.dto.DtoPriceIU;
import ank.phito.erp.entity.PriceEntity;
import ank.phito.erp.repository.PriceRepository;
import ank.phito.erp.service.IPriceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements IPriceService {
    @Autowired
    PriceRepository priceRepository;

    @Override
    public DtoPrice savePrice(DtoPriceIU dtoPriceIU) {
        DtoPrice response = new DtoPrice();
        PriceEntity log = new PriceEntity();
        BeanUtils.copyProperties(dtoPriceIU, log);

        PriceEntity dbPrice = priceRepository.save(log);
        BeanUtils.copyProperties(dbPrice, response);

        return response;
    }

    @Override
    public List<DtoPrice> getAllPrice() {
        List<DtoPrice> dtoList = new ArrayList<>();

        List<PriceEntity> logList = priceRepository.findAll();
        for (PriceEntity log : logList) {
            DtoPrice dto = new DtoPrice();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoPrice getPriceById(String id) {
        DtoPrice dtoPrice = new DtoPrice();
        Optional<PriceEntity> optional =  priceRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        PriceEntity dbPrice = optional.get();
        BeanUtils.copyProperties(dbPrice, dtoPrice);

        return dtoPrice;
    }

    @Override
    public void deletePrice(String id) {
        Optional<PriceEntity> optional = priceRepository.findById(id);
        optional.ifPresent(logEntity -> priceRepository.delete(logEntity));
    }

    @Override
    public DtoPrice updatePrice(String id, DtoPriceIU dtoPriceIU) {
        DtoPrice dto = new DtoPrice();

        Optional<PriceEntity> optional = priceRepository.findById(id);
        if (optional.isPresent()) {
            PriceEntity dbPrice = optional.get();

            dbPrice.setTitle(dtoPriceIU.getTitle());
            dbPrice.setDescription(dtoPriceIU.getDescription());

            PriceEntity updatedPrice = priceRepository.save(dbPrice);

            BeanUtils.copyProperties(updatedPrice, dto);
            return dto;
        }
        return null;
    }
}
