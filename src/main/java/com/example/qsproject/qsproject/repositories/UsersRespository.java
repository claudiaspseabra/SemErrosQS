package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * Repository interface for accessing and managing User entities in the database.
 * Extends JpaRepository to provide basic CRUD operations and to do query methods.
 */

public interface UsersRespository extends JpaRepository<User,Long> {
}
