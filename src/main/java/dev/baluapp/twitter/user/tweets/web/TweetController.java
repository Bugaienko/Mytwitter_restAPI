package dev.baluapp.twitter.user.tweets.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.tweets.usecase.TweetAddUseCase;
import dev.baluapp.twitter.user.tweets.usecase.TweetDeleteUseCase;
import dev.baluapp.twitter.user.tweets.usecase.TweetEditUseCase;
import dev.baluapp.twitter.user.tweets.usecase.TweetFindUseCase;
import dev.baluapp.twitter.user.tweets.web.model.*;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    private final TweetDeleteUseCase tweetDeleteUseCase;
    private final TweetFindUseCase tweetFindUseCase;

    public TweetController(TweetAddUseCase tweetAddUseCase,
                           TweetEditUseCase tweetEditUseCase,
                           TweetDeleteUseCase tweetDeleteUseCase,
                           TweetFindUseCase tweetFindUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
        this.tweetEditUseCase = tweetEditUseCase;
        this.tweetDeleteUseCase = tweetDeleteUseCase;
        this.tweetFindUseCase = tweetFindUseCase;
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
    public void deleteTweet(@PathVariable long tweetId) {
        tweetDeleteUseCase.deleteTweet(tweetId);
    }


    @GetMapping
    public TweetPageResponse findOwnerTweets(@PathParam("page") int page, @PathParam("limit") int limit){
        TweeFindRequest tweeFindRequest = new TweeFindRequest(page, limit);


        return this.tweetFindUseCase.findTweets(tweeFindRequest);
    }



}
