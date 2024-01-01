package dev.baluapp.twitter.user.subsription.mapper;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.web.model.FollowerPageResponse;
import org.springframework.data.domain.Page;

public interface PageOfFollowersSubscriptionToFollowerPageResponseMapper
        extends Mapper<FollowerPageResponse, Page<FollowersSubscription>> {
}
