package dev.baluapp.twitter.user.subsription.usecase.imp;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.mapper.PageOfFollowersSubscriptionToFollowerPageResponseMapper;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.model.Subscription_;
import dev.baluapp.twitter.user.subsription.service.SubscriptionService;
import dev.baluapp.twitter.user.subsription.usecase.SubscriptionFindAllFollowersUseCase;
import dev.baluapp.twitter.user.subsription.web.model.FollowerFindRequest;
import dev.baluapp.twitter.user.subsription.web.model.FollowerPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionFindAllFollowersUseCaseFacade implements SubscriptionFindAllFollowersUseCase {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final SubscriptionService subscriptionService;
    private final PageOfFollowersSubscriptionToFollowerPageResponseMapper pageOfFollowersSubscriptionToFollowerPageResponseMapper;


    public SubscriptionFindAllFollowersUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                                     SubscriptionService subscriptionService,
                                                     PageOfFollowersSubscriptionToFollowerPageResponseMapper pageOfFollowersSubscriptionToFollowerPageResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.subscriptionService = subscriptionService;
        this.pageOfFollowersSubscriptionToFollowerPageResponseMapper = pageOfFollowersSubscriptionToFollowerPageResponseMapper;
    }

    @Override
    public FollowerPageResponse findFollowers(FollowerFindRequest findRequest) {

        UserProfile currentUserProfile = this.currentUserProfileApiService.currentUserProfile();

        Pageable pageable = PageRequest.of(
                findRequest.page(),
                findRequest.limit(),
                Sort.by(
                        Sort.Direction.DESC,
                        Subscription_.CREATED_TIMESTAMP
                )
        );

        Page<FollowersSubscription> subscriptions = this.subscriptionService.findAllFollowerSubscriptions(currentUserProfile, pageable);

        return pageOfFollowersSubscriptionToFollowerPageResponseMapper.map(subscriptions);

    }
}
