package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IProductController;
import ank.phito.erp.dto.DtoProduct;
import ank.phito.erp.dto.DtoProductIU;
import ank.phito.erp.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements IProductController {

    @Autowired
    private IProductService productService;

    @PostMapping(path = "")
    @Override
    public DtoProduct saveProduct(@RequestBody @Valid DtoProductIU dtoProductIU) {
        System.out.println("dtoProductIU");
        return productService.saveProduct(dtoProductIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoProduct> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoProduct getProductById(@PathVariable(name = "id") String id) {
        return productService.getProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteProduct(@PathVariable(name = "id") String id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoProduct updateProduct(@PathVariable(name = "id") String id, @RequestBody DtoProductIU dtoProductIU) {
        return productService.updateProduct(id, dtoProductIU);
    }
}
