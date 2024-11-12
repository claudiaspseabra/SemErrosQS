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
    private UsersRespository usersRespository;

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUsersDto = userService.createUser(usersDto);
        return new ResponseEntity<>(savedUsersDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("id") int id) {
        UsersDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // 05/11
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsersDto> deleteUserById(@PathVariable("id") int id) {
        UsersDto deleteUsersDto = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUsersDto, HttpStatus.OK);
    }


    /*

        @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }


     */


    // Por acabar
//    @PutMapping("/update/{id}")
//    public ResponseEntity<UsersDto> updateUser(@PathVariable int id, @RequestBody UsersDto userDto) {
//
//
//        User userUpdate = usersRespository.findById(id).orElseThrow(()-> new Exceptions("Couldnt update this admin."));
//
//        userUpdate.setName(userUpdate.getName());
//        userUpdate.setPassword(userUpdate.getPassword());
//        userUpdate.setUsername(userUpdate.getUsername());
//
//        //.orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
//
//        return ResponseEntity.ok(userDto);
//    }
}