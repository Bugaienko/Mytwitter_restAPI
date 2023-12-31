package dev.baluapp.twitter.user.subsription.mapper.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.api.service.UserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.mapper.UnSubscribeRequestToSubscriptionMapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.web.model.UnSubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class UnSubscribeRequestToSubscriptionMapperImpl implements UnSubscribeRequestToSubscriptionMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;


    public UnSubscribeRequestToSubscriptionMapperImpl(CurrentUserProfileApiService currentUserProfileApiService,
                                                      UserProfileApiService userProfileApiService ) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.userProfileApiService = userProfileApiService;
    }

    @Override
    public Subscription map(UnSubscribeRequest unSubscribeRequest) {

        UserProfile currentUserProfile = this.currentUserProfileApiService.currentUserProfile();
        UserProfile followedUser = this.userProfileApiService.findUserProfileById(unSubscribeRequest.followId());

        Subscription subscription = new Subscription();
        subscription.setFollower(currentUserProfile);
        subscription.setFollowed(followedUser);

        return subscription;
    }
}
