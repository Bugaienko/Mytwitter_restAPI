package dev.baluapp.twitter.security.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(schema = "identity", name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany // (fetch = FetchType.EAGER)
    @JoinTable(
            schema = "identity",
            name = "user_accounts_roles",
            joinColumns = {
                @JoinColumn(name = "user_account_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
            }

    )
    private Set<UserRole> authorities = new HashSet<>();

    // use class User with default all flags true

}
