package dev.baluapp.twitter.user.subsription.model;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;

import java.time.Instant;

public interface FollowersSubscription {
    long getId();
    UserProfile getFollower();
    Instant getCreatedTimestamp();
}
