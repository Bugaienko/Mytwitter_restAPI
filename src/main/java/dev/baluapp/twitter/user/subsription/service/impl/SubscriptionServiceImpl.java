package dev.baluapp.twitter.user.subsription.service.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.model.FollowersSubscription;
import dev.baluapp.twitter.user.subsription.model.Subscription;
import dev.baluapp.twitter.user.subsription.repository.SubscriptionRepository;
import dev.baluapp.twitter.user.subsription.service.SubscriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void createSubscription(Subscription subscription) {
        this.subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        this.subscriptionRepository.delete(subscription);
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        return this.subscriptionRepository.existsByFollowerAndFollowed(follower, followed);
    }

    @Override
    public Optional<Subscription> findByFollowerAndFollowers(UserProfile follower, UserProfile followed) {
        return this.subscriptionRepository.findByFollowerAndFollowed(follower, followed);
    }

    @Override
    public Page<FollowersSubscription> findAllFollowerSubscriptions(UserProfile author, Pageable pageable) {
        return this.subscriptionRepository.findAllByFollowed(author, pageable);
    }
}
