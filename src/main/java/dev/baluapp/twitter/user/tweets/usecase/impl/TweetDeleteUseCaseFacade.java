package dev.baluapp.twitter.user.tweets.usecase.impl;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.usecase.TweetDeleteUseCase;
import org.springframework.stereotype.Component;

@Component
public class TweetDeleteUseCaseFacade implements TweetDeleteUseCase {

    private final TweetService tweetService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetDeleteUseCaseFacade(TweetService tweetService,
                                    CurrentUserProfileApiService currentUserProfileApiService) {
        this.tweetService = tweetService;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public void deleteTweet(long tweetId) {

        UserProfile activeUser = this.currentUserProfileApiService.currentUserProfile();

        UserProfile owner = this.tweetService
                .findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не найден", tweetId);
                    return new TwitterException(errorMessage);
                });


        if (!activeUser.equals(owner)) {
            String errorMessage = String.format("Вам запрещено удаление твита с id = %d. Пользователь %s не является его автором",
                    tweetId,
                    activeUser.getNickname()
            );
            throw new TwitterException(errorMessage);
        }

        this.tweetService.deleteTweet(tweetId);

    }
}
