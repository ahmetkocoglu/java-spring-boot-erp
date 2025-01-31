package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoProduct;
import ank.phito.erp.dto.DtoProductIU;

import java.util.List;

public interface IProductController {
    public DtoProduct saveProduct(DtoProductIU dtoProductIU);

    public List<DtoProduct> getAllProduct();

    public DtoProduct getProductById(String id);

    public void deleteProduct(String id);

    public DtoProduct updateProduct(String id , DtoProductIU dtoProductIU);
}
