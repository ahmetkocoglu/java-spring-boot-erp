package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;

import java.util.List;

public interface ILogController {
    public DtoLog saveLog(DtoLogIU dtoLogIU);

    public List<DtoLog> getAllLog();

    public DtoLog getLogById(Integer id);

    public void deleteLog(Integer id);

    public DtoLog updateLog(Integer id , DtoLogIU dtoLogIU);
}
