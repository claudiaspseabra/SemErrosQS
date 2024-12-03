package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

// Interface com os métodos que terao de ser utilizados no UserServiceImpl

public interface UserService {
    UsersDto createUser(UsersDto usersDto);

    UsersDto getUserById(int id);

    UsersDto deleteUserById(int id);

    List<UsersDto> getAllUsers();
}
