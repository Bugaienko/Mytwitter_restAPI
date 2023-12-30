package dev.baluapp.twitter.security.service;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import org.springframework.security.core.Authentication;

public interface AccessTokenService {
    String generateIdToken(Authentication authentication);
}
