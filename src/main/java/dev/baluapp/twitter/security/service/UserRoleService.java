package dev.baluapp.twitter.security.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
