package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @author Sem Erros
 */


/**
 * This class is responsible for managing the requests of the courses.
 * It has CRUD methods.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/app/courses")
public class CourseController {

    private CourseService courseService;

    /**
     * This method is used to create a new course.
     *
     * @param courseDto The details of the course to be created.
     * @return A ResponseEntity with the created course and status 201.
     */

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto savedCourseDto = courseService.createCourse(courseDto);
        return new ResponseEntity<>(savedCourseDto, HttpStatus.CREATED);
    }


    /**
     * This method gets a specific course by its ID.
     *
     * @param id The ID of the course.
     * @return A ResponseEntity with the course details.
     */

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") int id) {
        CourseDto courseDto = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDto);
    }


    /**
     * This method deletes a course by its ID.
     *
     * @param id The ID of the course to be deleted.
     * @return A ResponseEntity with the deleted course.
     */

    @DeleteMapping("{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable("id") int id) {
        CourseDto deletedCourseDto = courseService.deleteCourseById(id);
        return new ResponseEntity<>(deletedCourseDto, HttpStatus.OK);
    }


    /**
     * This method gets all the courses.
     *
     * @return A ResponseEntity with a list of all courses.
     */

    @GetMapping()
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
