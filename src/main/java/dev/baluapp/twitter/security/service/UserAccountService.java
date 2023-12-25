package dev.baluapp.twitter.security.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserAccount;
import org.springframework.stereotype.Service;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);
}
