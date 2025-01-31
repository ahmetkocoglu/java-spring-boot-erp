package ank.phito.erp.service;

import ank.phito.erp.dto.DtoProduct;
import ank.phito.erp.dto.DtoProductIU;

import java.util.List;

public interface IProductService {

    public DtoProduct saveProduct(DtoProductIU dtoProduct);

    public List<DtoProduct> getAllProduct();

    public DtoProduct getProductById(String id);

    public void deleteProduct(String id);

    public DtoProduct updateProduct(String id , DtoProductIU dtoProductIU);

}
