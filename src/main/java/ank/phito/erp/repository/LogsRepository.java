package ank.phito.erp.repository;

import ank.phito.erp.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogsRepository extends MongoRepository<LogEntity, String> {
}
