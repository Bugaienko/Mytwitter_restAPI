package dev.baluapp.twitter.security.usecase.impl;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.service.AccessTokenService;
import dev.baluapp.twitter.security.usecase.AuthenticationUseCase;
import dev.baluapp.twitter.security.web.model.AccessToken;
import dev.baluapp.twitter.security.web.model.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUseCaseFacade implements AuthenticationUseCase {

    private final AuthenticationManager authenticationManager;
    private final AccessTokenService accessTokenService;

    public AuthenticationUseCaseFacade(AuthenticationManager authenticationManager,
                                       AccessTokenService accessTokenService) {
        this.authenticationManager = authenticationManager;
        this.accessTokenService = accessTokenService;
    }

    @Override
    public AccessToken authenticate(LoginRequest loginRequest) {

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
          loginRequest.username(),
          loginRequest.password()
        );

        Authentication authenticate = this.authenticationManager.authenticate(authenticationToken);

        String jwtToken = this.accessTokenService.generateIdToken(authenticate);

        return new AccessToken(jwtToken);
    }
}
