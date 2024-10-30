package com.example.qsproject.qsproject;

// métodos que terao de ser utilizados no UserServiceImpl
public interface UserService {
    UsersDto createUser(UsersDto usersDto);

    UsersDto getUserById(int id);
}
