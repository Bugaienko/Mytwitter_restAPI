package dev.baluapp.twitter.user.tweets.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.model.Tweet;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
}
