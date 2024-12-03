package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Role;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.RoleRepository;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import com.example.qsproject.qsproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UsersRespository usersRespository;
    private RoleRepository roleRepository;

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        List<Role> availableRole = roleRepository.findAll();
        User user = UserMapper.mapToUser(usersDto, availableRole);
        User savedUser = usersRespository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }


    @Override
    public UsersDto getUserById(int id) {
        User user = usersRespository.findById(id)
                .orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
        return UserMapper.mapToUserDto(user);


    }


    // 05/11
    @Override
    public UsersDto deleteUserById(int id){
        User user = usersRespository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove admin with this id: "+id));
        usersRespository.delete(user);
        return UserMapper.mapToUserDto(user);
    }


    //Alteração Feita
    @Override
    public List<UsersDto> getAllUsers() {
        List<User> users = usersRespository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }
}
