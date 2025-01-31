package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoContact;
import ank.phito.erp.dto.DtoContactIU;
import ank.phito.erp.entity.ContactEntity;
import ank.phito.erp.repository.ContactRepository;
import ank.phito.erp.service.IContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public DtoContact saveContact(DtoContactIU dtoContactIU) {
        DtoContact response = new DtoContact();
        ContactEntity log = new ContactEntity();
        BeanUtils.copyProperties(dtoContactIU, log);

        ContactEntity dbContact = contactRepository.save(log);
        BeanUtils.copyProperties(dbContact, response);

        return response;
    }

    @Override
    public List<DtoContact> getAllContact() {
        List<DtoContact> dtoList = new ArrayList<>();

        List<ContactEntity> logList = contactRepository.findAll();
        for (ContactEntity log : logList) {
            DtoContact dto = new DtoContact();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoContact getContactById(String id) {
        DtoContact dtoContact = new DtoContact();
        Optional<ContactEntity> optional =  contactRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        ContactEntity dbContact = optional.get();
        BeanUtils.copyProperties(dbContact, dtoContact);

        return dtoContact;
    }

    @Override
    public void deleteContact(String id) {
        Optional<ContactEntity> optional = contactRepository.findById(id);
        optional.ifPresent(logEntity -> contactRepository.delete(logEntity));
    }

    @Override
    public DtoContact updateContact(String id, DtoContactIU dtoContactIU) {
        DtoContact dto = new DtoContact();

        Optional<ContactEntity> optional = contactRepository.findById(id);
        if (optional.isPresent()) {
            ContactEntity dbContact = optional.get();

            dbContact.setTitle(dtoContactIU.getTitle());
            dbContact.setDescription(dtoContactIU.getDescription());

            ContactEntity updatedContact = contactRepository.save(dbContact);

            BeanUtils.copyProperties(updatedContact, dto);
            return dto;
        }
        return null;
    }
}
