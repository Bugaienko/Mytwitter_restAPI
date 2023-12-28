package dev.baluapp.twitter.user.tweets.usecase;
/*
@date 28.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.web.model.TweetEditRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest tweetEditRequest);
}
