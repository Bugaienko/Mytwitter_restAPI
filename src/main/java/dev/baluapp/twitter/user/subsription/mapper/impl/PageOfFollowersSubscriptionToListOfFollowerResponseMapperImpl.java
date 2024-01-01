package dev.baluapp.twitter.user.subsription.mapper.impl;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.mapper.PageOfFollowersSubscriptionToListOfFollowerResponseMapper;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.web.model.FollowerResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageOfFollowersSubscriptionToListOfFollowerResponseMapperImpl implements PageOfFollowersSubscriptionToListOfFollowerResponseMapper {
    @Override
    public List<FollowerResponse> map(Page<FollowersSubscription> subscriptions) {

        return subscriptions.stream().map(item -> new FollowerResponse(
                item.getId(),
                item.getFollower().getId(),
                item.getFollower().getNickname(),
                item.getFollower().getImageLink(),
                item.getCreatedTimestamp()
        )).toList();
    }
}
