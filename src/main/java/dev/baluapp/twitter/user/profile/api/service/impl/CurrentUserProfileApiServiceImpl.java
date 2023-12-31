package dev.baluapp.twitter.user.profile.api.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.security.api.model.CurrentUserApiModel;
import dev.baluapp.twitter.security.api.service.IdentityApiService;
import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {

    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    public CurrentUserProfileApiServiceImpl(IdentityApiService identityApiService,
                                            UserProfileService userProfileService) {
        this.identityApiService = identityApiService;
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile currentUserProfile() {

        CurrentUserApiModel userApiModel = identityApiService.currentUserAccount()
                .orElseThrow(() -> new TwitterException("Пользователь должен быть авторизован в системе"));

        UserProfile userProfile = this.userProfileService
                .findUserProfileByIdRequired(userApiModel.userAccountId());

        return userProfile;
    }
}
