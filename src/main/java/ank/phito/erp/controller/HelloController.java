package ank.phito.erp.controller;

import ank.phito.erp.model.MeResponse;
import ank.phito.erp.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PasswordEncoder passwordEncoder;

    public HelloController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, world! This is public to everyone";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Everyone can see this";
    }

    @GetMapping("/test")
    public String test() {
        return passwordEncoder.encode("12345678");
    }

    @GetMapping("/matches")
    public boolean matches() {
        return passwordEncoder.matches("12345678", "$2a$10$qgNkgxdHPBkt.Lbzi0sz5uwEnF68LJOMPjgcDWGNVWvLY9/64yM0.");
    }

    @GetMapping("/me")
    public MeResponse me(@AuthenticationPrincipal UserPrincipal principal) {
        return MeResponse.builder().massage("Me is successful").email(principal.getEmail()).build();
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