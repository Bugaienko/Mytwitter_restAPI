package dev.baluapp.twitter.user.profile.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    Optional<UserProfile> findUserProfileById(Long userProfileId);
}
