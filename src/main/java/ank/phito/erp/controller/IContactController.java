package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoContact;
import ank.phito.erp.dto.DtoContactIU;

import java.util.List;

public interface IContactController {
    public DtoContact saveContact(DtoContactIU dtoContactIU);

    public List<DtoContact> getAllContact();

    public DtoContact getContactById(String id);

    public void deleteContact(String id);

    public DtoContact updateContact(String id , DtoContactIU dtoContactIU);
}
