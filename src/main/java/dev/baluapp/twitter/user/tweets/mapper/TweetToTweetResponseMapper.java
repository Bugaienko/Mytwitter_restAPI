package dev.baluapp.twitter.user.tweets.mapper;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.Mapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;

public interface TweetToTweetResponseMapper extends Mapper<TweetResponse, Tweet> {
}
