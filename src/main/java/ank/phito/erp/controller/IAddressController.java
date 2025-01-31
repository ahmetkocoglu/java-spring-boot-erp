package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoAddress;
import ank.phito.erp.dto.DtoAddressIU;

import java.util.List;

public interface IAddressController {
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

    public List<DtoAddress> getAllAddress();

    public DtoAddress getAddressById(String id);

    public void deleteAddress(String id);

    public DtoAddress updateAddress(String id , DtoAddressIU dtoAddressIU);
}
