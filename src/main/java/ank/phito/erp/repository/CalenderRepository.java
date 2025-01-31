package ank.phito.erp.repository;

import ank.phito.erp.entity.CalenderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalenderRepository extends MongoRepository<CalenderEntity, String> {
}
