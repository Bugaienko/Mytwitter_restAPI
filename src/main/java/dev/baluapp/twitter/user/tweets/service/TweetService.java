package dev.baluapp.twitter.user.tweets.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.model.Tweet;

import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(long tweetId);

    void deleteTweet(long tweetId);
}
