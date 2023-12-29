package dev.baluapp.twitter.user.subsription.web.model;
/*
@date 29.12.2023
@author Sergey Bugaienko
*/

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(@NotNull Long followId) {
}
