package dev.baluapp.twitter.user.timeline.mapper;
/*
@date 05.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.timeline.web.model.TimelineResponse;
import dev.baluapp.twitter.user.tweets.model.Tweet;

public interface TweetToTimelineResponseMapper extends Mapper<TimelineResponse, Tweet> {
}
