package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.dtos.CourseDto;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class transforms Course entities into CourseDto objects and vice versa.
 */

public class CourseMapper {


    /**
     * Converts a Course entity to a CourseDto object.
     *
     * @param course the Course entity to be converted
     * @return the corresponding CourseDto object
     */

    public static CourseDto mapToCourseDto(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDuration(),
                SubjectMapper.mapToSubjectsDto(course.getSubjects())
        );
    }


    /**
     * Converts a CourseDto object to a Course entity.
     *
     * @param courseDto the CourseDto object to be converted
     * @return the corresponding Course entity
     */
    public static Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getCourseDuration(),
                SubjectMapper.mapToSubjects(courseDto.getSubjects())
        );
    }
}
