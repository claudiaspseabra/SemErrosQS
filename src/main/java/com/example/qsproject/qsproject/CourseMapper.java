package com.example.qsproject.qsproject;

public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getSubjects()
        );
    }

    public static Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getSubjects()
        );
    }
}
