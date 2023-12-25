package dev.baluapp.twitter.security.repository;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByAuthority(String authority);
}
