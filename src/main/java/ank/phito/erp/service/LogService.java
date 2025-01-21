package ank.phito.erp.service;

import ank.phito.erp.entity.LogEntity;
import ank.phito.erp.model.LogRequest;
import ank.phito.erp.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    LogsRepository logsRepository;

    public List<LogEntity> getAll() {
        return logsRepository.findAll();
    }

    public String saveLog(LogEntity logEntity) {

        logsRepository.save(logEntity);

        return "OK";
    }
}
