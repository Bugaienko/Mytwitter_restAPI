package dev.baluapp.twitter.security.usecase.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.RegisterRequestToAccountMapper;
import dev.baluapp.twitter.security.model.UserAccount;
import dev.baluapp.twitter.security.service.UserAccountService;
import dev.baluapp.twitter.security.usecase.RegisterUseAccountUseCase;
import dev.baluapp.twitter.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUseAccountUseCaseFacade implements RegisterUseAccountUseCase {

    private final UserAccountService userAccountService;
    private final RegisterRequestToAccountMapper mapper;

    public RegisterUseAccountUseCaseFacade(UserAccountService userAccountService,
                                           RegisterRequestToAccountMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = mapper.map(registerRequest);

        this.userAccountService.createUserAccount(userAccount);
    }
}
