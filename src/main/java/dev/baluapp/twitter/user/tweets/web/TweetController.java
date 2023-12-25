package dev.baluapp.twitter.user.tweets.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.usecase.TweetAddUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;

    public TweetController(TweetAddUseCase tweetAddUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest) {
        return tweetAddUseCase.addTweet(addRequest);
    }

}
