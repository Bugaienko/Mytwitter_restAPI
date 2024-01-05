package dev.baluapp.twitter.user.profile.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.user.subsription.model.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "followed_id", referencedColumnName = "id")
    private List<Subscription> followers;

}
