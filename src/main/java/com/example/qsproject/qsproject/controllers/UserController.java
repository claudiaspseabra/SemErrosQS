package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.services.UserService;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// to do
@AllArgsConstructor
@RestController
@RequestMapping("/app/users")


public class UserController {

    private UserService userService;
    private UsersRespository usersRespository;

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUsersDto = userService.createUser(usersDto);
        return new ResponseEntity<>(savedUsersDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("id") long id) {
        UsersDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsersDto> deleteUserById(@PathVariable("id") long id) {
        UsersDto deleteUsersDto = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUsersDto, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        List<UsersDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable("id") long userId,@RequestBody UsersDto updatedUser){
        UsersDto usersDto = userService.updateUser(userId,updatedUser);
        return ResponseEntity.ok(usersDto);
    }

}