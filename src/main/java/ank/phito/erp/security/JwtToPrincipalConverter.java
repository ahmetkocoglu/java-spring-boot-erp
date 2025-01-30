package ank.phito.erp.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT jwt) {
        var authorityList = getClaimOrEmptyList(jwt).stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        return UserPrincipal.builder()
                .userId(jwt.getSubject())
                .email(jwt.getClaim("e").asString())
                .authorities(authorityList)
                .build();
    }

    private List<String> getClaimOrEmptyList(DecodedJWT jwt) {
        if (jwt.getClaim("au").isNull()) return List.of();
        return jwt.getClaim("au").asList(String.class);
    }
}