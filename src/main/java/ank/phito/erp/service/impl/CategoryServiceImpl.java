package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoCategory;
import ank.phito.erp.dto.DtoCategoryIU;
import ank.phito.erp.entity.CategoryEntity;
import ank.phito.erp.repository.CategoryRepository;
import ank.phito.erp.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public DtoCategory saveCategory(DtoCategoryIU dtoCategoryIU) {
        DtoCategory response = new DtoCategory();
        CategoryEntity log = new CategoryEntity();
        BeanUtils.copyProperties(dtoCategoryIU, log);

        CategoryEntity dbCategory = categoryRepository.save(log);
        BeanUtils.copyProperties(dbCategory, response);

        return response;
    }

    @Override
    public List<DtoCategory> getAllCategory() {
        List<DtoCategory> dtoList = new ArrayList<>();

        List<CategoryEntity> logList = categoryRepository.findAll();
        for (CategoryEntity log : logList) {
            DtoCategory dto = new DtoCategory();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoCategory getCategoryById(String id) {
        DtoCategory dtoCategory = new DtoCategory();
        Optional<CategoryEntity> optional =  categoryRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        CategoryEntity dbCategory = optional.get();
        BeanUtils.copyProperties(dbCategory, dtoCategory);

        return dtoCategory;
    }

    @Override
    public void deleteCategory(String id) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        optional.ifPresent(logEntity -> categoryRepository.delete(logEntity));
    }

    @Override
    public DtoCategory updateCategory(String id, DtoCategoryIU dtoCategoryIU) {
        DtoCategory dto = new DtoCategory();

        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            CategoryEntity dbCategory = optional.get();

            dbCategory.setTitle(dtoCategoryIU.getTitle());
            dbCategory.setDescription(dtoCategoryIU.getDescription());

            CategoryEntity updatedCategory = categoryRepository.save(dbCategory);

            BeanUtils.copyProperties(updatedCategory, dto);
            return dto;
        }
        return null;
    }
}
