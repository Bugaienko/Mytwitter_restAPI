package dev.baluapp.twitter.user.subsription.usecase;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.web.model.UnSubscribeRequest;

public interface SubscriptionDeleteUseCase {
    void unSubscribe(UnSubscribeRequest unSubscribeRequest);
}
