package dev.baluapp.twitter.user.profile.service.impl;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.exception.TwitterException;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.repository.UserProfileRepository;
import dev.baluapp.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void createUserProfile(UserProfile userProfile) {

        if (this.userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String.format("Профиль пользователя с данным id = %d уже существует", userProfile.getId());
            throw new TwitterException(errorMessage);
        }

        if (this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
            String errorMessage = String
                    .format("Профиль пользователя с данным Nickname = %s уже существует",
                            userProfile.getNickname());
            throw new TwitterException(errorMessage);
        }

        this.userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileByIdRequired(Long userProfileId) {
        return this.userProfileRepository
                .findById(userProfileId)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Профиля пользователя с id %d в системе не существует", userProfileId);
                    return new TwitterException(errorMessage);
                }
        );
    }
}
