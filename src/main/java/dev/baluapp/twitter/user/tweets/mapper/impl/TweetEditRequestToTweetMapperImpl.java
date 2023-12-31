package dev.baluapp.twitter.user.tweets.mapper.impl;
/*
@date 28.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.user.tweets.mapper.TweetEditRequestToTweetMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.web.model.TweetEditRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {
    private final TweetService tweetService;

    public TweetEditRequestToTweetMapperImpl(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public Tweet map(TweetEditRequest editRequest) {

        Tweet currentTweet = tweetService
                .findTweetById(editRequest.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не найден", editRequest.id());
                    return new TwitterException(errorMessage);
                });

        currentTweet.setMessage(editRequest.message());

        return currentTweet;
    }
}
