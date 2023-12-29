package dev.baluapp.twitter.user.subsription.mapper;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.Mapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.web.model.SubscribeRequest;

public interface SubscribeRequestToSubscriptionMapper extends Mapper<Subscription, SubscribeRequest> {
}
