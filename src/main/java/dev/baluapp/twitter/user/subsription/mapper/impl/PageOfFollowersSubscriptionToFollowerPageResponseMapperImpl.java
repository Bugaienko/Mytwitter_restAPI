package dev.baluapp.twitter.user.subsription.mapper.impl;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.mapper.PageOfFollowersSubscriptionToFollowerPageResponseMapper;
import dev.baluapp.twitter.user.subsription.mapper.PageOfFollowersSubscriptionToListOfFollowerResponseMapper;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.web.model.FollowerPageResponse;
import dev.baluapp.twitter.user.subsription.web.model.FollowerResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageOfFollowersSubscriptionToFollowerPageResponseMapperImpl implements PageOfFollowersSubscriptionToFollowerPageResponseMapper {


    private final PageOfFollowersSubscriptionToListOfFollowerResponseMapper pageOfFollowersSubscriptionToListOfFollowerResponseMapper;

    public PageOfFollowersSubscriptionToFollowerPageResponseMapperImpl(PageOfFollowersSubscriptionToListOfFollowerResponseMapper pageOfFollowersSubscriptionToListOfFollowerResponseMapper) {
        this.pageOfFollowersSubscriptionToListOfFollowerResponseMapper = pageOfFollowersSubscriptionToListOfFollowerResponseMapper;
    }

    @Override
    public FollowerPageResponse  map(Page<FollowersSubscription> subscriptions) {

        List<FollowerResponse> followerResponses = pageOfFollowersSubscriptionToListOfFollowerResponseMapper.map(subscriptions);

        return new FollowerPageResponse(
                subscriptions.getTotalElements(),
                subscriptions.isFirst(),
                subscriptions.isLast(),
                followerResponses
        );
    }
}
