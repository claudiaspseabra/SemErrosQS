package com.example.qsproject.qsproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private int userId;
    private String name;
    private String password;
    private String username;
}
