package dev.baluapp.twitter.user.tweets.mapper;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;

public interface TweetPageToTweetPageResponseMapper
        extends Mapper<TweetPageResponse, Page<Tweet>> {
}
