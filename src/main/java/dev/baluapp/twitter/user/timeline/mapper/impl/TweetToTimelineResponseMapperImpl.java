package dev.baluapp.twitter.user.timeline.mapper.impl;
/*
@date 05.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.timeline.mapper.TweetToTimelineResponseMapper;
import dev.baluapp.twitter.user.timeline.web.model.TimelineResponse;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetToTimelineResponseMapperImpl implements TweetToTimelineResponseMapper {
    @Override
    public TimelineResponse map(Tweet tweet) {
        return new TimelineResponse(
                tweet.getId(),
                tweet.getUserProfile().getId(),
                tweet.getMessage(),
                tweet.getUserProfile().getNickname(),
                tweet.getUserProfile().getImageLink(),
                tweet.getCreatedTimestamp()
        );
    }
}
