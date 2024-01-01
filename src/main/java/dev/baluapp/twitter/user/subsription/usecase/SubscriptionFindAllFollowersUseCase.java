package dev.baluapp.twitter.user.subsription.usecase;
/*
@date 01.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.web.model.FollowerFindRequest;
import dev.baluapp.twitter.user.subsription.web.model.FollowerPageResponse;
import dev.baluapp.twitter.user.subsription.web.model.FollowerResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Validated
public interface SubscriptionFindAllFollowersUseCase {

    FollowerPageResponse findFollowers(@Valid FollowerFindRequest findRequest);
}
