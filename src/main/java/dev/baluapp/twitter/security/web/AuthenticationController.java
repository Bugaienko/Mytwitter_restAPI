package dev.baluapp.twitter.security.web;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.usecase.AuthenticationUseCase;
import dev.baluapp.twitter.security.web.model.AccessToken;
import dev.baluapp.twitter.security.web.model.LoginRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
@Tag(name = "Auth", description = "Get JWT-token")
public class AuthenticationController {
    private final AuthenticationUseCase authenticationUseCase;

    public AuthenticationController(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    @PostMapping("/access_token")
    public AccessToken getToken(@Valid @RequestBody LoginRequest loginRequest) {
        return this.authenticationUseCase.authenticate(loginRequest);
    }

}
