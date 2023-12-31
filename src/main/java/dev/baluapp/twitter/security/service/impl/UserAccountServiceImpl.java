package dev.baluapp.twitter.security.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.security.model.UserAccount;
import dev.baluapp.twitter.security.repository.UserAccountRepository;
import dev.baluapp.twitter.security.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new TwitterException("Account with this username already exists");
        }

        this.userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByUsername(String username) {
        return this.userAccountRepository.findByUsername(username);
    }
}
