package dev.baluapp.twitter.user.profile.api.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.api.model.CurrentUserApiModel;
import dev.baluapp.twitter.security.api.service.IdentityApiService;
import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
                .orElseThrow(() -> new RuntimeException("Пользователь доджен быть авторизован в системе"));

        UserProfile userProfile = this.userProfileService
                .findUserProfileById(userApiModel.userAccountId())
                .orElseThrow(() -> {
                            String errorMessage = String.format("Профиля пользователя с id %d в системе не существует", userApiModel.userAccountId());
                            return new RuntimeException(errorMessage);
                        }
                );

        return userProfile;
    }
}
