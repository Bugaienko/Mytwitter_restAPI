package dev.baluapp.twitter.user.profile.usecase.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.service.UserProfileService;
import dev.baluapp.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import dev.baluapp.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService,
                                            UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = this.mapper.map(registerRequest);
        this.userProfileService.createUserProfile(userProfile);

    }
}
