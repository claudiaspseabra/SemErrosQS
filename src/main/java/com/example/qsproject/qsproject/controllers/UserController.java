package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.services.UserService;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @version 1.0
 * @author Sem Erros
 */


/**
 * This class is responsible for managing the requests of the user.
 * It has create, read, update and delete and methods.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/app/users")


public class UserController {

    private UserService userService;
    private UsersRespository usersRespository;


    /**
     * This method is used to create a new user.
     *
     * @param usersDto The details of the user to be created.
     * @return A ResponseEntity with the created user and status 201.
     */

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUsersDto = userService.createUser(usersDto);
        return new ResponseEntity<>(savedUsersDto, HttpStatus.CREATED);
    }


    /**
     * This method gets a specific user by its ID.
     *
     * @param id The ID of the user.
     * @return A ResponseEntity with the user details.
     */

    @GetMapping("{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("id") long id) {
        UsersDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }


    /**
     * This method deletes a user by its ID.
     *
     * @param id The ID of the user to be deleted.
     * @return A ResponseEntity with the deleted user.
     */

    @DeleteMapping("{id}")
    public ResponseEntity<UsersDto> deleteUserById(@PathVariable("id") long id) {
        UsersDto deleteUsersDto = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUsersDto, HttpStatus.OK);
    }

    /**
     * This method gets all the users.
     *
     * @return A ResponseEntity with a list of all users.
     */

    @GetMapping()
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        List<UsersDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Updates an existing user based on the provided ID and new user data.
     *
     * @param userId The ID of the user to be updated.
     * @param updatedUser The data transfer object containing the updated user information.
     * @return A ResponseEntity containing the updated UsersDto.
     */

    @PutMapping("{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable("id") long userId,@RequestBody UsersDto updatedUser){
        UsersDto usersDto = userService.updateUser(userId,updatedUser);
        return ResponseEntity.ok(usersDto);
    }
    @PostMapping("/login")
    public ResponseEntity<UsersDto> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.validateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            UsersDto usersDto = UserMapper.mapToUserDto(user);
            return ResponseEntity.ok(usersDto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}