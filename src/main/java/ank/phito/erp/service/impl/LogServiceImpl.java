package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;
import ank.phito.erp.entity.LogEntity;
import ank.phito.erp.repository.LogsRepository;
import ank.phito.erp.service.ILogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    LogsRepository logsRepository;

    @Override
    public DtoLog saveLog(DtoLogIU dtoLogIU) {
        DtoLog response = new DtoLog();
        LogEntity log = new LogEntity();
        BeanUtils.copyProperties(dtoLogIU, log);

        LogEntity dbLog = logsRepository.save(log);
        BeanUtils.copyProperties(dbLog, response);

        return response;
    }

    @Override
    public List<DtoLog> getAllLog() {
        List<DtoLog> dtoList = new ArrayList<>();

        List<LogEntity> logList = logsRepository.findAll();
        for (LogEntity log : logList) {
            DtoLog dto = new DtoLog();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoLog getLogById(String id) {
        DtoLog dtoLog = new DtoLog();
        Optional<LogEntity> optional =  logsRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        LogEntity dbLog = optional.get();
        BeanUtils.copyProperties(dbLog, dtoLog);

        return dtoLog;
    }

    @Override
    public void deleteLog(String id) {
        Optional<LogEntity> optional = logsRepository.findById(id);
        optional.ifPresent(logEntity -> logsRepository.delete(logEntity));
    }

    @Override
    public DtoLog updateLog(String id, DtoLogIU dtoLogIU) {
        DtoLog dto = new DtoLog();

        Optional<LogEntity> optional = logsRepository.findById(id);
        if (optional.isPresent()) {
            LogEntity dbLog = optional.get();

            dbLog.setTitle(dtoLogIU.getTitle());
            dbLog.setDescription(dtoLogIU.getDescription());

            LogEntity updatedLog = logsRepository.save(dbLog);

            BeanUtils.copyProperties(updatedLog, dto);
            return dto;
        }
        return null;
    }
}
