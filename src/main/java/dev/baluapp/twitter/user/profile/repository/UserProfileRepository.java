package dev.baluapp.twitter.user.profile.repository;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByNickname(String nickname);

    Optional<UserProfile> findUserProfileById(Long userProfileId);
}
