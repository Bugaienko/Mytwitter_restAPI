package dev.baluapp.twitter.user.tweets.web.model;
/*
@date 28.12.2023
@author Sergey Bugaienko
*/

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetEditRequest(
        @NotNull
        long id,
        @NotNull
        @Size(min = 10, max = 251)
        String message
) {
}
