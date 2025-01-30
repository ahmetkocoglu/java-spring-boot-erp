package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoUser;
import ank.phito.erp.dto.DtoUserIU;
import ank.phito.erp.model.LoginRequest;
import ank.phito.erp.model.LoginResponse;
import ank.phito.erp.service.AuthService;
import ank.phito.erp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    @PostMapping("/register")
    public DtoUser register(@RequestBody @Validated DtoUserIU dtoUserIU) {
        return userService.saveUser(dtoUserIU);
    }
}
