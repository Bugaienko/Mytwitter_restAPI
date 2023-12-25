package dev.baluapp.twitter.user.profile.web.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import jakarta.validation.constraints.NotBlank;

public record UserProfileRegisterRequest(
        @NotBlank
        String nickname,
        @NotBlank
        String imageLink) {
}
