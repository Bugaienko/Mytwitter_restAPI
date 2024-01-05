package dev.baluapp.twitter.user.timeline.web;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.timeline.usecase.TimeLineFindUseCase;
import dev.baluapp.twitter.user.timeline.web.model.TimelineFindRequest;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/timelines")
public class TimeLineController {

    private final TimeLineFindUseCase timeLineFindUseCase;

    public TimeLineController(TimeLineFindUseCase timeLineFindUseCase) {
        this.timeLineFindUseCase = timeLineFindUseCase;
    }

    @GetMapping
    public TimelinePageResponse findTimelines(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        TimelineFindRequest findRequest = new TimelineFindRequest(page, limit);

        return timeLineFindUseCase.findTimelines(findRequest);
    }
}
