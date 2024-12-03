package com.example.qsproject.qsproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private int userId;
    private String name;
    private String password;
    private String username;

    private List<String> roles; // Representação simples de roles como strings

}
