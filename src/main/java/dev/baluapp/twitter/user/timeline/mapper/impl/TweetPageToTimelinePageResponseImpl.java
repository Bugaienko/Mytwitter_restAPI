package dev.baluapp.twitter.user.timeline.mapper.impl;
/*
@date 05.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.timeline.mapper.TweetPageToTimelinePageResponse;
import dev.baluapp.twitter.user.timeline.mapper.TweetToTimelineResponseMapper;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import dev.baluapp.twitter.user.timeline.web.model.TimelineResponse;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TweetPageToTimelinePageResponseImpl implements TweetPageToTimelinePageResponse {

    private final TweetToTimelineResponseMapper mapper;

    public TweetPageToTimelinePageResponseImpl(TweetToTimelineResponseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TimelinePageResponse map(Page<Tweet> tweets) {

        Collection<TimelineResponse> timelineResponses = tweets
                .stream()
                .map(mapper::map)
                .toList();

        return new TimelinePageResponse(
                tweets.getTotalElements(),
                tweets.isFirst(),
                tweets.isLast(),
                timelineResponses

        );
    }
}
