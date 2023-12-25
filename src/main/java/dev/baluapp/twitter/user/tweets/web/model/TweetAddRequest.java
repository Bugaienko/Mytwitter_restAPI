package dev.baluapp.twitter.user.tweets.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetAddRequest(
        @NotBlank
        @Size(min = 10, max = 251)
        String message) {
}
