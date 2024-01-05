package dev.baluapp.twitter.user.tweets.api.service;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TweetApiService {
    Page<Tweet> findAllFollowerTweets(UserProfile follower, Pageable pageable);
}
