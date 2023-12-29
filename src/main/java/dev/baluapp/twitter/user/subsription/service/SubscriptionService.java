package dev.baluapp.twitter.user.subsription.service;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.subsription.model.Subscription;

import java.util.Optional;

public interface SubscriptionService {
    void createSubscription(Subscription subscription);
    void deleteSubscription(Subscription subscription);

    boolean existsSubscription (Subscription subscription);

    Optional<Subscription> findByFollowerAndFollowers(UserProfile follower, UserProfile followed);
}
