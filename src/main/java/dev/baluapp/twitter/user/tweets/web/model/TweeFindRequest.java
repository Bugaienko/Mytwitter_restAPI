package dev.baluapp.twitter.user.tweets.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TweeFindRequest(
        @Min(0)
        int page,
        @Min(25) @Max(100)
        int limit) {
}
