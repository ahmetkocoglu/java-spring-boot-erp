package ank.phito.erp.service;

import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;

import java.util.List;

public interface ILogService {

    public DtoLog saveLog(DtoLogIU dtoLog);

    public List<DtoLog> getAllLog();

    public DtoLog getLogById(String id);

    public void deleteLog(String id);

    public DtoLog updateLog(String id , DtoLogIU dtoLogIU);

}
