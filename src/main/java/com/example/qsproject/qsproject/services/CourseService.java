package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;

import java.util.ArrayList;
import java.util.List;



/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Service interface for managing Course-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */

public interface CourseService {

    /**
     * Creates a new course and returns the created course details.
     *
     * @param coursesDto A CourseDto object containing the course data to be created.
     * @return The created CourseDto object.
     */

    CourseDto createCourse(CourseDto coursesDto);


    /**
     * Retrieves a course by its ID.
     *
     * @param id The ID of the course to be retrieved.
     * @return A CourseDto object containing the course details.
     */

    CourseDto getCourseById(long id);

    /**
     * Deletes a course by its ID.
     *
     * @param id The ID of the course to be deleted.
     * @return The deleted CourseDto object.
     */

    CourseDto deleteCourseById(long id);


    /**
     * Retrieves all courses available in the system.
     *
     * @return A list of CourseDto objects representing all courses.
     */

    List<CourseDto> getAllCourses();


    /**
     * Updates an existing course with new data.
     *
     * @param courseId The ID of the course to be updated.
     * @param updateCourse A CourseDto object containing the updated course data.
     * @return The updated CourseDto object.
     */

    CourseDto updateCourse(long courseId, CourseDto updateCourse);

}
