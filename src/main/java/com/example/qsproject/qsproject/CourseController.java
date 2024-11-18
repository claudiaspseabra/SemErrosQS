package com.example.qsproject.qsproject;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/app/courses")
public class CourseController {

    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto savedCourseDto = courseService.createCourse(courseDto);
        return new ResponseEntity<>(savedCourseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") int id) {
        CourseDto courseDto = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDto);
    }

    // 05/11
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable("id") int id) {
        CourseDto deletedCourseDto = courseService.deleteCourseById(id);
        return new ResponseEntity<>(deletedCourseDto, HttpStatus.OK);
    }
}