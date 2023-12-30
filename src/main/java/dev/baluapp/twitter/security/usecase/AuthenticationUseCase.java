package dev.baluapp.twitter.security.usecase;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.web.model.AccessToken;
import dev.baluapp.twitter.security.web.model.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest loginRequest);
}
