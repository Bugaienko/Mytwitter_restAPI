package dev.baluapp.twitter.user.profile.mapper.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.api.model.CurrentUserApiModel;
import dev.baluapp.twitter.security.api.service.IdentityApiService;
import dev.baluapp.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl implements UserProfileRegisterRequestToUserProfileMapper {

    private final IdentityApiService identityApiService;

    public UserProfileRegisterRequestToUserProfileMapperImpl(IdentityApiService identityApiService) {
        this.identityApiService = identityApiService;
    }

    @Override
    public UserProfile map(UserProfileRegisterRequest registerRequest) {

        CurrentUserApiModel userApiModel = this.identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Для создания профиля пользователь должен быть авторизован в системе"));

        UserProfile userProfile = new UserProfile();
        //TODO id link
        userProfile.setId(userApiModel.userAccountId());
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());

        return userProfile;
    }
}
