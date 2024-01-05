package dev.baluapp.twitter.user.tweets.api.service.impl;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.api.service.TweetApiService;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TweetApiServiceImpl implements TweetApiService {
    private  final TweetService tweetService;

    public TweetApiServiceImpl(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public Page<Tweet> findAllFollowerTweets(UserProfile follower, Pageable pageable) {
        return tweetService.findAllFollowerTweets(follower, pageable);
    }
}
