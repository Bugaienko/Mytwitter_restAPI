package dev.baluapp.twitter.user.timeline.web;
/*
@date 04.01.2024
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.timeline.usecase.TimeLineFindUseCase;
import dev.baluapp.twitter.user.timeline.web.model.TimelineFindRequest;
import dev.baluapp.twitter.user.timeline.web.model.TimelinePageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "Get users timelines", tags = { "timelines" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TimelinePageResponse.class))}),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
            })
    public TimelinePageResponse findTimelines(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        TimelineFindRequest findRequest = new TimelineFindRequest(page, limit);

        return timeLineFindUseCase.findTimelines(findRequest);
    }
}
