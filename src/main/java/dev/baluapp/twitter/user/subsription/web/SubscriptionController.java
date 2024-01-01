package dev.baluapp.twitter.user.subsription.web;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.usecase.SubscriptionAddUseCase;
import dev.baluapp.twitter.user.subsription.usecase.SubscriptionDeleteUseCase;
import dev.baluapp.twitter.user.subsription.usecase.SubscriptionFindAllFollowersUseCase;
import dev.baluapp.twitter.user.subsription.web.model.FollowerFindRequest;
import dev.baluapp.twitter.user.subsription.web.model.FollowerPageResponse;
import dev.baluapp.twitter.user.subsription.web.model.SubscribeRequest;
import dev.baluapp.twitter.user.subsription.web.model.UnSubscribeRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionAddUseCase subscriptionAddUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;
    private final SubscriptionFindAllFollowersUseCase subscriptionFindAllFollowersUseCase;

    public SubscriptionController(SubscriptionAddUseCase subscriptionAddUseCase,
                                  SubscriptionDeleteUseCase subscriptionDeleteUseCase,
                                  SubscriptionFindAllFollowersUseCase subscriptionFindAllFollowersUseCase) {
        this.subscriptionAddUseCase = subscriptionAddUseCase;
        this.subscriptionDeleteUseCase = subscriptionDeleteUseCase;
        this.subscriptionFindAllFollowersUseCase = subscriptionFindAllFollowersUseCase;
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest) {
        this.subscriptionAddUseCase.subscribe(subscribeRequest);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody UnSubscribeRequest unSubscribeRequest) {
        this.subscriptionDeleteUseCase.unSubscribe(unSubscribeRequest);
    }

    @GetMapping("/followers")
    public FollowerPageResponse allFollowers(@RequestParam("page")int page, @RequestParam("limit")int limit){
        FollowerFindRequest findRequest = new FollowerFindRequest(page, limit);
        return this.subscriptionFindAllFollowersUseCase.findFollowers(findRequest);
    }



}
