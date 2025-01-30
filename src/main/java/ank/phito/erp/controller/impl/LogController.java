package ank.phito.erp.controller.impl;

import ank.phito.erp.dto.DtoLog;
import ank.phito.erp.dto.DtoLogIU;
import ank.phito.erp.service.ILogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private ILogService logService;

    @PostMapping(path = "")
    public DtoLog saveLog(@RequestBody @Valid DtoLogIU dtoLogIU) {
        return logService.saveLog(dtoLogIU);
    }

    @GetMapping(path = "")
    public List<DtoLog> getAllLogs() {
        return logService.getAllLog();
    }

    @GetMapping(path = "/{id}")
    public DtoLog getLogById(@PathVariable(name = "id") Integer id) {
        return logService.getLogById(String.valueOf(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLog(@PathVariable(name = "id") Integer id) {
        logService.deleteLog(String.valueOf(id));
    }

    @PutMapping(path = "/{id}")
    public DtoLog updateLog(@PathVariable(name = "id") Integer id, @RequestBody DtoLogIU dtoLogIU) {
        return logService.updateLog(String.valueOf(id), dtoLogIU);
    }
}
