package ank.phito.erp.repository;

import ank.phito.erp.entity.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
}
