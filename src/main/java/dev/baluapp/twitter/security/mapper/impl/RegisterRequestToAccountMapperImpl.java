package dev.baluapp.twitter.security.mapper.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.security.mapper.RegisterRequestToAccountMapper;
import dev.baluapp.twitter.security.model.UserAccount;
import dev.baluapp.twitter.security.model.UserRole;
import dev.baluapp.twitter.security.service.UserRoleService;
import dev.baluapp.twitter.security.web.model.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Set;

@Component
public class RegisterRequestToAccountMapperImpl implements RegisterRequestToAccountMapper {

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public RegisterRequestToAccountMapperImpl(UserRoleService userRoleService,
                                              PasswordEncoder passwordEncoder) {
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount map(RegisterRequest registerRequest) {
        UserRole userRole = this.userRoleService
                .findUserRole()
                .orElseThrow(() -> new TwitterException("User Role not found "));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        return userAccount;
    }
}
