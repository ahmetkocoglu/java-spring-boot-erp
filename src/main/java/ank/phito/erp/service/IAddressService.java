package ank.phito.erp.service;

import ank.phito.erp.dto.DtoAddress;
import ank.phito.erp.dto.DtoAddressIU;

import java.util.List;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddress);

    public List<DtoAddress> getAllAddress();

    public DtoAddress getAddressById(String id);

    public void deleteAddress(String id);

    public DtoAddress updateAddress(String id , DtoAddressIU dtoAddressIU);

}
