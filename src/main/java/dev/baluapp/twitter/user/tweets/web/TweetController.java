package dev.baluapp.twitter.user.tweets.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.usecase.TweetAddUseCase;
import dev.baluapp.twitter.user.tweets.usecase.TweetDeleteUseCase;
import dev.baluapp.twitter.user.tweets.usecase.TweetEditUseCase;
import dev.baluapp.twitter.user.tweets.web.model.TweetAddRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetEditRequest;
import dev.baluapp.twitter.user.tweets.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    private final TweetDeleteUseCase tweetDeleteUseCase;

    public TweetController(TweetAddUseCase tweetAddUseCase,
                           TweetEditUseCase tweetEditUseCase,
                           TweetDeleteUseCase tweetDeleteUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
        this.tweetEditUseCase = tweetEditUseCase;
        this.tweetDeleteUseCase = tweetDeleteUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest) {
        return tweetAddUseCase.addTweet(addRequest);
    }

    @PutMapping
    public TweetResponse editTweet(@Valid @RequestBody TweetEditRequest editRequest) {
        return tweetEditUseCase.editTweet(editRequest);
    }

    @DeleteMapping("/{tweetId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTweet(@PathVariable long tweetId) {
        tweetDeleteUseCase.deleteTweet(tweetId);
    }


}
