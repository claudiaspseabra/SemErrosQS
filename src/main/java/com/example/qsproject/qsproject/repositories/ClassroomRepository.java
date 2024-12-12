package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * Repository interface for accessing and managing Classroom entities in the database.
 * Extends JpaRepository to provide basic CRUD operations and to do query methods.
 */


public interface ClassroomRepository extends JpaRepository<Classroom,Long> {

    /**
     * Checks if a Classroom with the specified tag exists in the database.
     *
     * @param tag The tag of the Classroom to check.
     * @return true if a Classroom with the specified tag exists, otherwise false.
     */

    boolean existsByTag(String tag);
}