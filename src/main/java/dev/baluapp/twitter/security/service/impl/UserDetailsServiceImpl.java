package dev.baluapp.twitter.security.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.UserAccountToUserMapper;
import dev.baluapp.twitter.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAccountService userAccountService;
    private final UserAccountToUserMapper userMapper;

    public UserDetailsServiceImpl(UserAccountService userAccountService,
                                  UserAccountToUserMapper userMapper) {
        this.userAccountService = userAccountService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService
                .findUserByUsername(username)
                .map(this.userMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Неверные учетные данные пользователя"));
    }
}
