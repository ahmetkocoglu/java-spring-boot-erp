package ank.phito.erp.service;

import ank.phito.erp.dto.DtoCategory;
import ank.phito.erp.dto.DtoCategoryIU;

import java.util.List;

public interface ICategoryService {

    public DtoCategory saveCategory(DtoCategoryIU dtoCategory);

    public List<DtoCategory> getAllCategory();

    public DtoCategory getCategoryById(String id);

    public void deleteCategory(String id);

    public DtoCategory updateCategory(String id , DtoCategoryIU dtoCategoryIU);

}
