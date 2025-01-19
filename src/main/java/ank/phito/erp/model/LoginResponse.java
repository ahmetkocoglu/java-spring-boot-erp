package ank.phito.erp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private Boolean error;
    private String token;
    private String massage;
}
