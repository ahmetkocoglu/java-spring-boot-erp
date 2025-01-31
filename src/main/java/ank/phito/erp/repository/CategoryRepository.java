package ank.phito.erp.repository;

import ank.phito.erp.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {
}
