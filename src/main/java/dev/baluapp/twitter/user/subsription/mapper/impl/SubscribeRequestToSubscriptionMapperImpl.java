package dev.baluapp.twitter.user.subsription.mapper.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.api.service.UserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscribeRequestToSubscriptionMapperImpl implements SubscribeRequestToSubscriptionMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private  final UserProfileApiService userProfileApiService;

    public SubscribeRequestToSubscriptionMapperImpl(CurrentUserProfileApiService currentUserProfileApiService,
                                                    UserProfileApiService userProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.userProfileApiService = userProfileApiService;
    }

    @Override
    public Subscription map(SubscribeRequest subscribeRequest) {

        UserProfile currentUser = this.currentUserProfileApiService.currentUserProfile();
        UserProfile followedUser = this.userProfileApiService.findUserProfileById(subscribeRequest.followId());

        Subscription subscription = new Subscription();
        subscription.setFollower(currentUser);
        subscription.setFollowed(followedUser);

        return subscription;
    }
}
