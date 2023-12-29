package dev.baluapp.twitter.user.tweets.mapper.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.mapper.TweetPageToTweetPageResponseMapper;
import dev.baluapp.twitter.user.tweets.mapper.TweetToTweetResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetPageResponse;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TweetPageToTweetPageResponseMapperImpl implements TweetPageToTweetPageResponseMapper {

    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetPageToTweetPageResponseMapperImpl(TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public TweetPageResponse map(Page<Tweet> allOwnerTweets) {

        Collection<TweetResponse> tweets = allOwnerTweets
                .stream()
                .map(this.tweetToTweetResponseMapper::map)
                .toList();

        return new TweetPageResponse(
                allOwnerTweets.getTotalElements(),
                allOwnerTweets.isFirst(),
                allOwnerTweets.isLast() ,
                tweets);
    }
}
