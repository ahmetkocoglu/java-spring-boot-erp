package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;

import java.util.List;

public interface ILogController {
    public DtoLog saveLog(DtoLogIU dtoLogIU);

    public List<DtoLog> getAllLog();

    public DtoLog getLogById(String id);

    public void deleteLog(String id);

    public DtoLog updateLog(String id , DtoLogIU dtoLogIU);
}
