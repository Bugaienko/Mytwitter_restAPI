package dev.baluapp.twitter.security.mapper.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.UserAccountToUserMapper;
import dev.baluapp.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities());
    }
}
