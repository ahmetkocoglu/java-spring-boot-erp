package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoPrice;
import ank.phito.erp.dto.DtoPriceIU;

import java.util.List;

public interface IPriceController {
    public DtoPrice savePrice(DtoPriceIU dtoPriceIU);

    public List<DtoPrice> getAllPrice();

    public DtoPrice getPriceById(String id);

    public void deletePrice(String id);

    public DtoPrice updatePrice(String id , DtoPriceIU dtoPriceIU);
}
