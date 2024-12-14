package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.UsersDto;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class transforms User entities into UsersDto objects and vice versa.
 */

public class UserMapper {


    /**
     * Converts a User entity to a UsersDto.
     *
     * @param user The User entity to be converted.
     * @return A UsersDto object with data mapped from the User entity.
     */

    public static UsersDto mapToUserDto(User user) {
        return new UsersDto(
                user.getUserId(),
                user.getName(),
                user.getPassword(),
                user.getUsername(),
                user.isAdmin()
        );
    }


    /**
     * Converts a UsersDto to a User entity.
     *
     * @param usersDto The UsersDto to be converted.
     * @return A User entity with data mapped from the UsersDto.
     */

    public static User mapToUser(UsersDto usersDto){
        return new User(
                usersDto.getUserId(),
                usersDto.getName(),
                usersDto.getPassword(),
                usersDto.getUsername(),
                usersDto.isAdmin()
        );
    }


}
