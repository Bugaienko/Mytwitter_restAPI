package dev.baluapp.twitter.user.timeline.usecase;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.timeline.web.model.TimelineFindRequest;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TimeLineFindUseCase {
    TimelinePageResponse findTimelines(@Valid TimelineFindRequest findRequest);
}
