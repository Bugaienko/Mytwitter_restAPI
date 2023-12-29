package dev.baluapp.twitter.user.tweets.web.model;

import java.util.Collection;

public record TweetPageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<TweetResponse> tweets

) {
}
