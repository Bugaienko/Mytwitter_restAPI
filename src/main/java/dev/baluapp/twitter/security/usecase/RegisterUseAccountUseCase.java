package dev.baluapp.twitter.security.usecase;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.web.model.RegisterRequest;

public interface RegisterUseAccountUseCase {
    void register(RegisterRequest registerRequest);
}
