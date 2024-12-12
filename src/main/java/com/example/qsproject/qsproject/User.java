package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "username",nullable = false , unique = true)
    private String username;

    @Column(name = "role",nullable = false)
    private String role;

    // new
    /*
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Collection<Role> roles;
*/

}
