package dev.baluapp.twitter.user.timeline.mapper;
/*
@date 05.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import org.springframework.data.domain.Page;

public interface TweetPageToTimelinePageResponse extends Mapper<TimelinePageResponse, Page<Tweet>> {
}
