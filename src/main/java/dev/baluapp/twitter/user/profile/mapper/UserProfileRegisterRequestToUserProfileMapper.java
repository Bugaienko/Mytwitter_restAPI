package dev.baluapp.twitter.user.profile.mapper;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
