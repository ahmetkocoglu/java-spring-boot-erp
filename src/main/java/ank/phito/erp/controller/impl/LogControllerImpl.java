package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.ILogController;
import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;
import ank.phito.erp.service.ILogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogControllerImpl implements ILogController {

    @Autowired
    private ILogService logService;

    @PostMapping(path = "")
    public DtoLog saveLog(@RequestBody @Valid DtoLogIU dtoLogIU) {
        return logService.saveLog(dtoLogIU);
    }

    @GetMapping(path = "")
    public List<DtoLog> getAllLog() {
        return logService.getAllLog();
    }

    @GetMapping(path = "/{id}")
    public DtoLog getLogById(@PathVariable(name = "id") String id) {
        return logService.getLogById(String.valueOf(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLog(@PathVariable(name = "id") String id) {
        logService.deleteLog(String.valueOf(id));
    }

    @PutMapping(path = "/{id}")
    public DtoLog updateLog(@PathVariable(name = "id") String id, @RequestBody DtoLogIU dtoLogIU) {
        return logService.updateLog(String.valueOf(id), dtoLogIU);
    }
}
