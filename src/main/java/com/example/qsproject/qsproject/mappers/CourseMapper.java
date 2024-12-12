package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.dtos.CourseDto;

public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDuration(),
                SubjectMapper.mapToSubjectsDto(course.getSubjects())
        );
    }

    public static Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getCourseDuration(),
                SubjectMapper.mapToSubjects(courseDto.getSubjects())
        );
    }
}
