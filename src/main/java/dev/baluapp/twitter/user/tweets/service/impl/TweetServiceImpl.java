package dev.baluapp.twitter.user.tweets.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.repository.TweetRepository;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }
}
