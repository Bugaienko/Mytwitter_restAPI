package dev.baluapp.twitter.user.tweets.usecase.impl;
/*
@date 28.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.mapper.TweetEditRequestToTweetMapper;
import dev.baluapp.twitter.user.tweets.mapper.TweetToTweetResponseMapper;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import dev.baluapp.twitter.user.tweets.service.TweetService;
import dev.baluapp.twitter.user.tweets.usecase.TweetEditUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweetEditRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetEditUseCaseFacade implements TweetEditUseCase {

    private final TweetService tweetService;
    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetEditUseCaseFacade(TweetService tweetService,
                                  TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper,
                                  TweetToTweetResponseMapper tweetToTweetResponseMapper,
                                  CurrentUserProfileApiService currentUserProfileApiService) {
        this.tweetService = tweetService;
        this.tweetEditRequestToTweetMapper = tweetEditRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public TweetResponse editTweet(TweetEditRequest editRequest) {
        UserProfile activeUser = this.currentUserProfileApiService.currentUserProfile();

        UserProfile owner = this.tweetService
                .findTweetById(editRequest.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не найден", editRequest.id());
                    return new TwitterException(errorMessage);
                });


        if (!activeUser.equals(owner)) {
            String errorMessage = String.format("Вам запрещено редактирование твита с id = %d. Пользователь %s не является его автором",
                    editRequest.id(),
                    activeUser.getNickname()
            );
            throw new TwitterException(errorMessage);
        }

        Tweet tweet = this.tweetEditRequestToTweetMapper.map(editRequest);
        Tweet updatedTweet = this.tweetService.updateTweet(tweet);


        return this.tweetToTweetResponseMapper.map(updatedTweet);
    }
}
