package dev.baluapp.twitter.security.repository;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


    boolean existsByUsername(String username);
}
