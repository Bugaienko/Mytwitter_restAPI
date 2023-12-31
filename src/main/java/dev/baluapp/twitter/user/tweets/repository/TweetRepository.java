package dev.baluapp.twitter.user.tweets.repository;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import dev.baluapp.twitter.user.tweets.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
