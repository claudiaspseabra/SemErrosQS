package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Service interface for managing User-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */

public interface UserService {

    /**
     * Creates a new user and returns the details of the created user.
     *
     * @param usersDto A UsersDto object containing the user data to be created.
     * @return The created UsersDto object with the user details.
     */

    UsersDto createUser(UsersDto usersDto);


    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The ID of the user to be retrieved.
     * @return The UsersDto object containing the details of the requested user.
     */

    UsersDto getUserById(long id);


    /**
     * Deletes a user by their unique ID.
     *
     * @param id The ID of the user to be deleted.
     * @return The deleted UsersDto object.
     */

    UsersDto deleteUserById(long id);


    /**
     * Retrieves all users available in the system.
     *
     * @return A list of all UsersDto objects representing the available users.
     */

    List<UsersDto> getAllUsers();


    /**
     * Updates an existing user with the new data.
     *
     * @param userId The ID of the user to be updated.
     * @param updatedUser A UsersDto object containing the updated user data.
     * @return The updated UsersDto object with the new data.
     */

    UsersDto updateUser(Long userId, UsersDto updatedUser);
    User validateUser(String username, String password);

}
