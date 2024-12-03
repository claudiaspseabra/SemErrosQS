package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import com.example.qsproject.qsproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {
    private UsersRespository usersRespository;

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        User user = UserMapper.mapToUser(usersDto);
        User saveUser = usersRespository.save(user);
        return UserMapper.mapToUserDto(saveUser);
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


    @Override
    public List<UsersDto> getAllUsers(){
        List<User> users = usersRespository.findAll();
        return users.stream().map((user)->UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }
}
