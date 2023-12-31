package dev.baluapp.twitter.security.api.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.api.model.CurrentUserApiModel;
import dev.baluapp.twitter.security.api.service.IdentityApiService;
import dev.baluapp.twitter.security.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityApiServiceImpl implements IdentityApiService {

    private final UserAccountService userAccountService;

    public IdentityApiServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {

        SecurityContext context = SecurityContextHolder.getContext();

        return Optional.ofNullable(context.getAuthentication())
                .map(Authentication::getName)
                .flatMap(this::extractCurrentUserApiModel);

    }

    private Optional<CurrentUserApiModel> extractCurrentUserApiModel(String username) {
        return this.userAccountService
                .findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
