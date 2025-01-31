package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.ICategoryController;
import ank.phito.erp.dto.DtoCategory;
import ank.phito.erp.dto.DtoCategoryIU;
import ank.phito.erp.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping(path = "")
    @Override
    public DtoCategory saveCategory(@RequestBody @Valid DtoCategoryIU dtoCategoryIU) {
        System.out.println("dtoCategoryIU");
        return categoryService.saveCategory(dtoCategoryIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoCategory> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoCategory getCategoryById(@PathVariable(name = "id") String id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteCategory(@PathVariable(name = "id") String id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoCategory updateCategory(@PathVariable(name = "id") String id, @RequestBody DtoCategoryIU dtoCategoryIU) {
        return categoryService.updateCategory(id, dtoCategoryIU);
    }
}
