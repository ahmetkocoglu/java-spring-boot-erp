package ank.phito.erp.repository;

import ank.phito.erp.entity.ContactEntity;
import ank.phito.erp.entity.MovementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementRepository extends MongoRepository<MovementEntity, String> {
}
