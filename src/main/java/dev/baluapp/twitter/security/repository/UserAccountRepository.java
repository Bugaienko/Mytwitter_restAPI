package dev.baluapp.twitter.security.repository;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


    boolean existsByUsername(String username);


    //@EntityGraph(attributePaths = "authorities")
    Optional<UserAccount> findByUsername(String username);
}
