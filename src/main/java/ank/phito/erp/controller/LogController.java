package ank.phito.erp.controller;

import ank.phito.erp.entity.LogEntity;
import ank.phito.erp.model.LogRequest;
import ank.phito.erp.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @PostMapping("/create")
    public String create(@RequestBody LogRequest logRequest) {
        LogEntity logEntity = new LogEntity();

        logEntity.setTitle(logRequest.getTitle());
        logEntity.setDescription(logRequest.getDescription());

        return logService.saveLog(logEntity);
    }
}
