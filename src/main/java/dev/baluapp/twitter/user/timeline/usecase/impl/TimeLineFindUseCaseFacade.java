package dev.baluapp.twitter.user.timeline.usecase.impl;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.timeline.mapper.TweetPageToTimelinePageResponse;
import dev.baluapp.twitter.user.timeline.usecase.TimeLineFindUseCase;
import dev.baluapp.twitter.user.timeline.web.model.TimelineFindRequest;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import dev.baluapp.twitter.user.tweets.api.service.TweetApiService;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.model.Tweet_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class TimeLineFindUseCaseFacade implements TimeLineFindUseCase {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetApiService tweetApiService;
    private final TweetPageToTimelinePageResponse mapper;



    public TimeLineFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                     TweetApiService tweetApiService,
                                     TweetPageToTimelinePageResponse mapper
    ) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetApiService = tweetApiService;
        this.mapper = mapper;
    }

    @Override
    public TimelinePageResponse findTimelines(TimelineFindRequest findRequest) {
        Sort sort = Sort.by(Sort.Direction.DESC, Tweet_.CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        UserProfile follower = currentUserProfileApiService.currentUserProfile();

        Page<Tweet> tweets = tweetApiService.findAllFollowerTweets(follower, pageable);

        return mapper.map(tweets);
    }
}
