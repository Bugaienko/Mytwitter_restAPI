package dev.baluapp.twitter.user.profile.api.service.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.UserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileApiServiceImpl implements UserProfileApiService {

    private final UserProfileService userProfileService;

    public UserProfileApiServiceImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile findUserProfileById(Long followId) {
        return this.userProfileService
                .findUserProfileByIdRequired(followId);
    }
}
