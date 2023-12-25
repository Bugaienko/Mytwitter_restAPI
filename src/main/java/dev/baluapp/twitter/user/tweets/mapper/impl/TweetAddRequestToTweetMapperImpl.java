package dev.baluapp.twitter.user.tweets.mapper.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.tweets.mapper.TweetAddRequestToTweetMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetAddRequestToTweetMapperImpl(CurrentUserProfileApiService currentUserProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public Tweet map(TweetAddRequest tweetAddRequest) {
        Tweet tweet = new Tweet();
        tweet.setUserProfile(currentUserProfileApiService.currentUserProfile());
//        tweet.setCreatedTimestamp();  add in Model By Spring
        tweet.setMessage(tweetAddRequest.message());
        return tweet;
    }
}
