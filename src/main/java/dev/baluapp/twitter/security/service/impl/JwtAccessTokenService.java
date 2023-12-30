package dev.baluapp.twitter.security.service.impl;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.service.AccessTokenService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class JwtAccessTokenService implements AccessTokenService {
    private final JwtEncoder jwtEncoder;

    public JwtAccessTokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String generateIdToken(Authentication authentication) {

        UserDetails userDetails = Optional.of(authentication.getPrincipal())
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .orElseThrow(() -> new RuntimeException("Не удалось сформировать объект UserDetails из объекта Authentication"));

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(1, ChronoUnit.DAYS);


        JwtClaimsSet jwtClaimsSet = JwtClaimsSet
                .builder()
                .claim("scope", roles)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .subject(userDetails.getUsername())
                .build();



        return this.jwtEncoder
                .encode(JwtEncoderParameters.from(jwtClaimsSet))
                .getTokenValue();
    }
}
