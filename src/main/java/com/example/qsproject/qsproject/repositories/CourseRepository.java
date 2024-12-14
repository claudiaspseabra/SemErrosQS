package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Repository interface for accessing and managing Course entities in the database.
 * Extends JpaRepository to provide basic CRUD operations and to do query methods.
 */


public interface CourseRepository extends JpaRepository<Course,Long> {
}
