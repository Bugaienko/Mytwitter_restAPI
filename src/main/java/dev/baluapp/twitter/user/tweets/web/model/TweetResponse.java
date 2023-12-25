package dev.baluapp.twitter.user.tweets.web.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import java.time.Instant;

public record TweetResponse(
        Long id,
        String message,
        Instant createdTimestamp) {
}
