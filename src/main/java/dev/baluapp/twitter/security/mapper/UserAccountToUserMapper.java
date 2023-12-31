package dev.baluapp.twitter.security.mapper;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.common.mapper.Mapper;
import dev.baluapp.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {
}
