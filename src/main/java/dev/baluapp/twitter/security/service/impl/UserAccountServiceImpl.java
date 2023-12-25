package dev.baluapp.twitter.security.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserAccount;
import dev.baluapp.twitter.security.repository.UserAccountRepository;
import dev.baluapp.twitter.security.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean isUsernameExists = this.userAccountRepository.existsByUsername(userAccount.getUsername());

        if (isUsernameExists) {
            throw new RuntimeException("Account with this username already exists");
        }

        this.userAccountRepository.save(userAccount);
    }
}
