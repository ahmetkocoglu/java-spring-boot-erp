package ank.phito.erp.service;

import ank.phito.erp.dto.DtoPrice;
import ank.phito.erp.dto.DtoPriceIU;

import java.util.List;

public interface IPriceService {

    public DtoPrice savePrice(DtoPriceIU dtoPrice);

    public List<DtoPrice> getAllPrice();

    public DtoPrice getPriceById(String id);

    public void deletePrice(String id);

    public DtoPrice updatePrice(String id , DtoPriceIU dtoPriceIU);

}
