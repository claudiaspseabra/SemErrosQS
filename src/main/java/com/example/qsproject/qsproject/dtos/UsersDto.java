package com.example.qsproject.qsproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class represents a user in the system.
 * It is used to transfer data about the user between different parts of the application.
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private long userId;
    private String name;
    private String password;
    private String username;
    private String role;
}
