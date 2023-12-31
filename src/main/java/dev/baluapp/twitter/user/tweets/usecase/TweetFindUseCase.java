package dev.baluapp.twitter.user.tweets.usecase;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.web.model.TweeFindRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TweetFindUseCase {
    TweetPageResponse findTweets(@Valid TweeFindRequest findRequest);
}
