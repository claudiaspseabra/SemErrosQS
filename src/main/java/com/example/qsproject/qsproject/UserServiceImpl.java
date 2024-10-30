package com.example.qsproject.qsproject;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
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
}
