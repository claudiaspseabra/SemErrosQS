package com.example.qsproject.qsproject;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// to do
@AllArgsConstructor
@RestController
@RequestMapping("/app/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto){
        UsersDto savedUsersDto = userService.createUser(usersDto);
        return new ResponseEntity<>(savedUsersDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersDto>getUserById(@PathVariable("id") int id){
        UsersDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // 05/11
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsersDto>deleteUserById(@PathVariable("id") int id){
        UsersDto deleteUsersDto = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUsersDto, HttpStatus.OK);
    }


}
