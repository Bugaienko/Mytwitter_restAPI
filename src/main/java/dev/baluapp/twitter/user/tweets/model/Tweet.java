package dev.baluapp.twitter.user.tweets.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table (schema = "twitter", name = "tweets")
@EntityListeners(AuditingEntityListener.class)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;

    @ManyToOne(optional = false) //недопустимо, когда не принадлежит пользователю
    private UserProfile userProfile;

}
