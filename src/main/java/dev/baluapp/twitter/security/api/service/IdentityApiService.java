package dev.baluapp.twitter.security.api.service;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
