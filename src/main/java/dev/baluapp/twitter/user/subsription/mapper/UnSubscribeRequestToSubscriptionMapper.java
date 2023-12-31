package dev.baluapp.twitter.user.subsription.mapper;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.web.model.UnSubscribeRequest;

public interface UnSubscribeRequestToSubscriptionMapper extends Mapper<Subscription, UnSubscribeRequest> {
}
