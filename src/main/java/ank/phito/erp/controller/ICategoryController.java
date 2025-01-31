package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoCategory;
import ank.phito.erp.dto.DtoCategoryIU;

import java.util.List;

public interface ICategoryController {
    public DtoCategory saveCategory(DtoCategoryIU dtoCategoryIU);

    public List<DtoCategory> getAllCategory();

    public DtoCategory getCategoryById(String id);

    public void deleteCategory(String id);

    public DtoCategory updateCategory(String id , DtoCategoryIU dtoCategoryIU);
}
