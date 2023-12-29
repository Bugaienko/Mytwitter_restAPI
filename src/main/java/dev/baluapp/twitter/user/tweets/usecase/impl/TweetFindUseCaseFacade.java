package dev.baluapp.twitter.user.tweets.usecase.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.mapper.TweetToTweetResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.usecase.TweetFindUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                  TweetService tweetService,
                                  TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetService = tweetService;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public Collection<TweetResponse> findTweets() {

        UserProfile owner = this.currentUserProfileApiService.currentUserProfile();

        Collection<Tweet> allOwnerTweets = this.tweetService.findAllTweets(owner);

        return allOwnerTweets
                .stream()
                .map(this.tweetToTweetResponseMapper::map)
                .toList();

    }
}
