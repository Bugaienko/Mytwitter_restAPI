package dev.baluapp.twitter.user.tweets.usecase;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;

import java.util.Collection;

public interface TweetFindUseCase {
    Collection<TweetResponse> findTweets();
}
