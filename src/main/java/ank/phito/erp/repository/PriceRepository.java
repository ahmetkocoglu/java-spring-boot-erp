package ank.phito.erp.repository;

import ank.phito.erp.entity.MovementEntity;
import ank.phito.erp.entity.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<PriceEntity, String> {
}
