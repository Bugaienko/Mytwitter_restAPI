package dev.baluapp.twitter.security.model;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
@Entity
@Table(schema = "identity", name = "user_roles")
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authority;
}
