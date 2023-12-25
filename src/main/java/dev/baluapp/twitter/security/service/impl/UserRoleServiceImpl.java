package dev.baluapp.twitter.security.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserRole;
import dev.baluapp.twitter.security.repository.UserRoleRepository;
import dev.baluapp.twitter.security.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<UserRole> findUserRole() {
        return this.userRoleRepository.findByAuthority("ROLE_USER");
    }
}
