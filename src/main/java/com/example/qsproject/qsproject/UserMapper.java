package com.example.qsproject.qsproject;

public class UserMapper {

    // Serve para converter os dados , userDto serve para passar dados de um user para um website por exemplo
    public static UsersDto mapToUserDto(User user) {
        return new UsersDto(
                user.getUserId(),
                user.getName(),
                user.getPassword(),
                user.getUsername()
        );
    }

    // Serve para converter um UserDto em User, por exemplo ao receber algum input num website
    public static User mapToUser(UsersDto usersDto){
        return new User(
                usersDto.getUserId(),
                usersDto.getName(),
                usersDto.getPassword(),
                usersDto.getUsername()
        );
    }



}
