package dev.baluapp.twitter.user.subsription.usecase.imp;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.service.SubscriptionService;
import dev.baluapp.twitter.user.subsription.usecase.SubscriptionAddUseCase;
import dev.baluapp.twitter.user.subsription.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {
    //    private final CurrentUserApiModel currentUserApiModel;
    private final SubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionAddUseCaseFacade(SubscribeRequestToSubscriptionMapper subscriptionMapper,
                                        SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = this.subscriptionMapper.map(subscribeRequest);

        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (follower.equals(followed)) {
            throw new RuntimeException("Подписка на самого себя не имеет смысла");
        }

        if (this.subscriptionService.existsSubscription(subscription)) {
            String errorMessage = String.format("Вы уже подписаны на %s", followed.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.subscriptionService.createSubscription(subscription);
    }
}
