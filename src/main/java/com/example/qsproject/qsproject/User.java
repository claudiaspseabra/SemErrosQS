package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class represents a User entity in the system, storing information about the user's unique identifier,
 * name, password, username, and role.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {

    /**
     * The unique ID of the user.
     * This is the primary key of the user entity.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;


    /**
     * The name of the user.
     * This field can be null.
     */

    @Column(name = "name")
    private String name;

    /**
     * The password of the user.
     * This field cannot be null.
     */

    @Column(name = "password",nullable = false)
    private String password;


    /**
     * The unique username of the user.
     * This field cannot be null and must be unique.
     */

    @Column(name = "username",nullable = false , unique = true)
    private String username;

    /**
     * The role of the user in the system.
     * This field cannot be null.
     */

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;
}
