package dev.baluapp.twitter.user.tweets.mapper.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.mapper.TweetToTweetResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet modelTweet) {
        return new TweetResponse(
                modelTweet.getId(),
                modelTweet.getMessage(),
                modelTweet.getCreatedTimestamp(),
                modelTweet.getModifiedTimestamp()
        );
    }
}
