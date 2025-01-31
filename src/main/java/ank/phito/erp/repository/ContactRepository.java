package ank.phito.erp.repository;

import ank.phito.erp.entity.CategoryEntity;
import ank.phito.erp.entity.ContactEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<ContactEntity, String> {
}
