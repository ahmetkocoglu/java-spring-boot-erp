package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IContactController;
import ank.phito.erp.dto.DtoContact;
import ank.phito.erp.dto.DtoContactIU;
import ank.phito.erp.service.IContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactControllerImpl implements IContactController {

    @Autowired
    private IContactService contactService;

    @PostMapping(path = "")
    @Override
    public DtoContact saveContact(@RequestBody @Valid DtoContactIU dtoContactIU) {
        System.out.println("dtoContactIU");
        return contactService.saveContact(dtoContactIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoContact> getAllContact() {
        return contactService.getAllContact();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoContact getContactById(@PathVariable(name = "id") String id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteContact(@PathVariable(name = "id") String id) {
        contactService.deleteContact(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoContact updateContact(@PathVariable(name = "id") String id, @RequestBody DtoContactIU dtoContactIU) {
        return contactService.updateContact(id, dtoContactIU);
    }
}
