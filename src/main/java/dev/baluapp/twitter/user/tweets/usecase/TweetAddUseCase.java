package dev.baluapp.twitter.user.tweets.usecase;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;

public interface TweetAddUseCase {
    TweetResponse addTweet(TweetAddRequest tweetAddRequest);
}
