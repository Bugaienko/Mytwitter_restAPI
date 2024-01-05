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
import org.springframework.data.jpa.repository.Query;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);

    @Query("""
        SELECT t
        FROM  Tweet t
        JOIN FETCH t.userProfile up
        JOIN up.followers flws
        JOIN flws.follower flw
        WHERE flw.id = ?1
        """)
    Page<Tweet> findAllFollowerTweets(Long followerId, Pageable pageable);
}
