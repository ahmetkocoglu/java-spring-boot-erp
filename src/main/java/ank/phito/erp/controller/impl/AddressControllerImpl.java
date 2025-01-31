package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IAddressController;
import ank.phito.erp.dto.DtoAddress;
import ank.phito.erp.dto.DtoAddressIU;
import ank.phito.erp.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping(path = "")
    @Override
    public DtoAddress saveAddress(@RequestBody @Valid DtoAddressIU dtoAddressIU) {
        System.out.println("dtoAddressIU");
        return addressService.saveAddress(dtoAddressIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoAddress> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoAddress getAddressById(@PathVariable(name = "id") String id) {
        return addressService.getAddressById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteAddress(@PathVariable(name = "id") String id) {
        addressService.deleteAddress(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoAddress updateAddress(@PathVariable(name = "id") String id, @RequestBody DtoAddressIU dtoAddressIU) {
        return addressService.updateAddress(id, dtoAddressIU);
    }
}
