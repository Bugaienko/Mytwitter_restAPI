package dev.baluapp.twitter.user.profile.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "twitter", name = "user_profiles")
public class UserProfile {

    @Id
    private Long id;

    @Column (unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String imageLink;

}
