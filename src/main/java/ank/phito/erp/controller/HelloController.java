package ank.phito.erp.controller;

import ank.phito.erp.entity.LogEntity;
import ank.phito.erp.model.LogRequest;
import ank.phito.erp.model.MeResponse;
import ank.phito.erp.security.UserPrincipal;
import ank.phito.erp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    LogService logService;

    @GetMapping("/")
    public String hello() {
        return "Hello, world! This is public to everyone";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Everyone can see this";
    }

    @GetMapping("/me")
    public MeResponse me(@AuthenticationPrincipal UserPrincipal principal, @RequestBody @Validated LogRequest logRequest) {
        LogEntity logEntity = new LogEntity();
        logEntity.setTitle("title");
        logEntity.setDescription("description");

        String lst = logService.saveLog(logEntity);
        return MeResponse.builder().massage("Me is successful").build();
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "This can only be seen by a logged in user. Your Email is: "
                + principal.getEmail() + " your ID: " + principal.getUserId();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this, you are an admin. Your ID: " + principal.getUserId();
    }
}