package dev.baluapp.twitter.user.profile.api.service;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;

public interface UserProfileApiService {
    UserProfile findUserProfileById(Long followId);

}
