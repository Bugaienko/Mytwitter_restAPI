package dev.baluapp.twitter.user.tweets.usecase.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.mapper.TweetAddRequestToTweetMapper;
import dev.baluapp.twitter.user.tweets.mapper.TweetToTweetResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.usecase.TweetAddUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetAddUseCaseFacade implements TweetAddUseCase {

    private final TweetService tweetService;
    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetAddUseCaseFacade(TweetService tweetService,
                                 TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper,
                                 TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.tweetService = tweetService;
        this.tweetAddRequestToTweetMapper = tweetAddRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public TweetResponse addTweet(TweetAddRequest tweetAddRequest) {

        Tweet mappedTweet = this.tweetAddRequestToTweetMapper.map(tweetAddRequest);
        Tweet createdTweet = tweetService.createTweet(mappedTweet);
        TweetResponse tweetResponse = this.tweetToTweetResponseMapper.map(createdTweet);

        return tweetResponse;
    }
}
