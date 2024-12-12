package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.CourseMapper;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import com.example.qsproject.qsproject.services.CourseService;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the CourseService interface, providing logic for managing courses.
 * It offers methods for creating, retrieving, deleting, and updating courses in the system.
 */

@Service
@AllArgsConstructor
public class CourseImpl implements CourseService {
    private CourseRepository courseRepository;

    /**
     * Creates a new course from the provided CourseDto.
     *
     * @param coursesDto The CourseDto object containing the course details.
     * @return A CourseDto object representing the newly created course.
     */

    @Override
    public CourseDto createCourse(CourseDto coursesDto) {
        Course course = CourseMapper.mapToCourse(coursesDto);
        Course saveCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(saveCourse);
    }


    /**
     * Retrieves a course by its ID.
     *
     * @param id The ID of the course to retrieve.
     * @return A CourseDto object containing the details of the requested course.
     * @throws Exceptions if the course is not found.
     */

    @Override
    public CourseDto getCourseById(long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
        return CourseMapper.mapToCourseDto(course);
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id The ID of the course to delete.
     * @return A CourseDto object containing the details of the deleted course.
     * @throws Exceptions if the course is not found.
     */

    @Override
    public CourseDto deleteCourseById(long id){
        Course course = courseRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove admin with this id: "+id));
        courseRepository.delete(course);
        return CourseMapper.mapToCourseDto(course);
    }


    /**
     * Retrieves all courses in the system.
     *
     * @return A list of CourseDto objects representing all courses.
     */

    @Override
    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> CourseMapper.mapToCourseDto(course))
                .collect(Collectors.toList());
    }


    /**
     * Updates the details of an existing course.
     *
     * @param courseId The ID of the course to update.
     * @param updateCourse The CourseDto object containing the updated course details.
     * @return A CourseDto object containing the updated course details.
     * @throws Exceptions if the course is not found.
     */

    @Override
    public CourseDto updateCourse(long courseId, CourseDto updateCourse) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new Exceptions("Course does not exist with this id: " + courseId)
        );

        course.setCourseName(updateCourse.getCourseName());

        course.setCourseDuration(updateCourse.getCourseDuration());

        Course updateCourseObj = courseRepository.save(course);

        return CourseMapper.mapToCourseDto(updateCourseObj);
    }
}
