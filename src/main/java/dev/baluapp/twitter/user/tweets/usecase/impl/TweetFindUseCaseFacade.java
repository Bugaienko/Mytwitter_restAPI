package dev.baluapp.twitter.user.tweets.usecase.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.mapper.TweetPageToTweetPageResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.usecase.TweetFindUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweeFindRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static dev.baluapp.twitter.user.tweets.model.Tweet_.CREATED_TIMESTAMP;

@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper;

    public TweetFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                  TweetService tweetService,
                                  TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetService = tweetService;
        this.tweetPageToTweetPageResponseMapper = tweetPageToTweetPageResponseMapper;
    }

    @Override
    public TweetPageResponse findTweets(TweeFindRequest findRequest) {

        UserProfile owner = this.currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);

        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Page<Tweet> pageableTweets = this.tweetService.findAllTweets(owner, pageable);


        return this.tweetPageToTweetPageResponseMapper.map(pageableTweets);


    }
}
