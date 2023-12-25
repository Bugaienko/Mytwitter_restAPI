package dev.baluapp.twitter.user.profile.usecase;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest registerRequest);
}
