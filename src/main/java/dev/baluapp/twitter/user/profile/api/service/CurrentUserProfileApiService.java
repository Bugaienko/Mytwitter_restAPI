package dev.baluapp.twitter.user.profile.api.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;

public interface CurrentUserProfileApiService {
    UserProfile currentUserProfile();
}
