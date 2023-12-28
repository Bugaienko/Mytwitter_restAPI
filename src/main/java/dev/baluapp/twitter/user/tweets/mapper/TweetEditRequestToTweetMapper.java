package dev.baluapp.twitter.user.tweets.mapper;
/*
@date 28.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.Mapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetEditRequest;

public interface TweetEditRequestToTweetMapper extends Mapper<Tweet, TweetEditRequest> {
}
