package dev.baluapp.twitter.user.subsription.mapper;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.web.model.FollowerResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PageOfFollowersSubscriptionToListOfFollowerResponseMapper
        extends Mapper<List<FollowerResponse>, Page<FollowersSubscription>> {
}

