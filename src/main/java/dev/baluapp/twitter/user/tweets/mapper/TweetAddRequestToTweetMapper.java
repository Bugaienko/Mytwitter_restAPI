package dev.baluapp.twitter.user.tweets.mapper;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;

public interface TweetAddRequestToTweetMapper extends Mapper<Tweet, TweetAddRequest> {
}
