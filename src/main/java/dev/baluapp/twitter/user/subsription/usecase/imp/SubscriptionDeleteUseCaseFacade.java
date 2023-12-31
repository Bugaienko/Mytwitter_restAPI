package dev.baluapp.twitter.user.subsription.usecase.imp;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.user.subsription.mapper.UnSubscribeRequestToSubscriptionMapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.service.SubscriptionService;
import dev.baluapp.twitter.user.subsription.usecase.SubscriptionDeleteUseCase;
import dev.baluapp.twitter.user.subsription.web.model.UnSubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {

    private final UnSubscribeRequestToSubscriptionMapper unSubscribeRequestToSubscriptionMapper;

    private final SubscriptionService subscriptionService;

    public SubscriptionDeleteUseCaseFacade(UnSubscribeRequestToSubscriptionMapper unSubscribeRequestToSubscriptionMapper,
                                           SubscriptionService subscriptionService) {
        this.unSubscribeRequestToSubscriptionMapper = unSubscribeRequestToSubscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void unSubscribe(UnSubscribeRequest unSubscribeRequest) {
        Subscription subscriptionRaw = this.unSubscribeRequestToSubscriptionMapper.map(unSubscribeRequest);

        Subscription subscription = this.subscriptionService
                .findByFollowerAndFollowers(subscriptionRaw.getFollower(), subscriptionRaw.getFollowed())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Пользователь %s не подписан на %s",
                            subscriptionRaw.getFollower().getNickname(),
                            subscriptionRaw.getFollowed().getNickname()
                    );
                    return new TwitterException(errorMessage);
                });


        this.subscriptionService.deleteSubscription(subscription);

    }
}
