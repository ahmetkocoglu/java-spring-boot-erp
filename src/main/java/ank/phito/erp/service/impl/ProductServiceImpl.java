package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoProduct;
import ank.phito.erp.dto.DtoProductIU;
import ank.phito.erp.entity.ProductEntity;
import ank.phito.erp.repository.ProductRepository;
import ank.phito.erp.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public DtoProduct saveProduct(DtoProductIU dtoProductIU) {
        DtoProduct response = new DtoProduct();
        ProductEntity log = new ProductEntity();
        BeanUtils.copyProperties(dtoProductIU, log);

        ProductEntity dbProduct = productRepository.save(log);
        BeanUtils.copyProperties(dbProduct, response);

        return response;
    }

    @Override
    public List<DtoProduct> getAllProduct() {
        List<DtoProduct> dtoList = new ArrayList<>();

        List<ProductEntity> logList = productRepository.findAll();
        for (ProductEntity log : logList) {
            DtoProduct dto = new DtoProduct();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoProduct getProductById(String id) {
        DtoProduct dtoProduct = new DtoProduct();
        Optional<ProductEntity> optional =  productRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        ProductEntity dbProduct = optional.get();
        BeanUtils.copyProperties(dbProduct, dtoProduct);

        return dtoProduct;
    }

    @Override
    public void deleteProduct(String id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        optional.ifPresent(logEntity -> productRepository.delete(logEntity));
    }

    @Override
    public DtoProduct updateProduct(String id, DtoProductIU dtoProductIU) {
        DtoProduct dto = new DtoProduct();

        Optional<ProductEntity> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            ProductEntity dbProduct = optional.get();

            dbProduct.setTitle(dtoProductIU.getTitle());
            dbProduct.setDescription(dtoProductIU.getDescription());

            ProductEntity updatedProduct = productRepository.save(dbProduct);

            BeanUtils.copyProperties(updatedProduct, dto);
            return dto;
        }
        return null;
    }
}
