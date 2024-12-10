package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

// Interface com os métodos que terao de ser utilizados no UserServiceImpl

public interface UserService {
    UsersDto createUser(UsersDto usersDto);

    UsersDto getUserById(long id);

    UsersDto deleteUserById(long id);

    List<UsersDto> getAllUsers();

    UsersDto updateUser(Long userId, UsersDto updatedUser);
}
