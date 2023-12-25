package dev.baluapp.twitter.user.profile.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import dev.baluapp.twitter.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileRegisterUseCase registerUseCase;

    public UserProfileController(UserProfileRegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest registerRequest) {
        this.registerUseCase.registerUserProfile(registerRequest);
    }


}
