package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Semester;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.SemesterMapper;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import com.example.qsproject.qsproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the UserService interface, providing logic for managing users.
 * It offers methods for creating, retrieving, deleting, and updating users in the system.
 */


@Service
@AllArgsConstructor
public class UserImpl implements UserService {
    private UsersRespository usersRespository;


    /**
     * Creates a new user from the provided UsersDto.
     *
     * @param usersDto The UsersDto object containing the users details.
     * @return A UsersDto object representing the newly created user.
     */

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        User user = UserMapper.mapToUser(usersDto);
        User saveUser = usersRespository.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }


    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return A UsersDto object containing the details of the requested user.
     * @throws Exceptions if the user is not found.
     */

    @Override
    public UsersDto getUserById(long id) {
        User user = usersRespository.findById(id)
                .orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
        return UserMapper.mapToUserDto(user);
    }



    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return A UsersDto object containing the details of the deleted user.
     * @throws Exceptions if the user is not found.
     */

    @Override
    public UsersDto deleteUserById(long id){
        User user = usersRespository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove admin with this id: "+id));
        usersRespository.delete(user);
        return UserMapper.mapToUserDto(user);
    }


    /**
     * Retrieves all users in the system.
     *
     * @return A list of UsersDto objects representing all users.
     */

    @Override
    public List<UsersDto> getAllUsers(){
        List<User> users = usersRespository.findAll();
        return users.stream().map((user)->UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }


    /**
     * Updates the details of an existing user.
     *
     * @param userId The ID of the user to update.
     * @param updatedUser The UsersDto object containing the updated user details.
     * @return A UsersDto object containing the updated user details.
     * @throws Exceptions if the user is not found.
     */

    @Override
    public UsersDto updateUser(Long userId, UsersDto updatedUser) {
        User user = usersRespository.findById(userId).orElseThrow(
                () -> new Exceptions("User does not exist with this id: "+userId)
        );

        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());
        user.setUsername(updatedUser.getUsername());

        User updatedUserObj = usersRespository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }
    public User validateUser(String username, String password) {
        User user = usersRespository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
