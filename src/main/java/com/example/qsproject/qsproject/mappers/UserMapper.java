package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.Role;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {




    // Serve para converter os dados , userDto serve para passar dados de um user para um website por exemplo
    public static UsersDto mapToUserDto(User user) {
        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        return new UsersDto(
                user.getUserId(),
                user.getName(),
                user.getPassword(),
                user.getUsername(), roles
        );
    }

    // Serve para converter um UserDto em User, por exemplo ao receber algum input num website/app
    public static User mapToUser(UsersDto usersDto, List<Role>availableRole){

        User user = new User();
        user.setUserId(usersDto.getUserId());
        user.setName(usersDto.getName());
        user.setPassword(usersDto.getPassword());
        user.setUsername(usersDto.getUsername());

        Collection<Role> roles = availableRole.stream()
                .filter(role -> usersDto.getRoles().contains(role.getName()))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        return user;

    }


}
