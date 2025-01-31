package ank.phito.erp.service;

import ank.phito.erp.dto.DtoContact;
import ank.phito.erp.dto.DtoContactIU;

import java.util.List;

public interface IContactService {

    public DtoContact saveContact(DtoContactIU dtoContact);

    public List<DtoContact> getAllContact();

    public DtoContact getContactById(String id);

    public void deleteContact(String id);

    public DtoContact updateContact(String id , DtoContactIU dtoContactIU);

}
