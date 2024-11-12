package com.example.qsproject.qsproject;

public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course) {
        return new CourseDto(
                course.getCourseName(),
                course.getCourseId(),
                course.getSubjects()
        );
    }

    public static Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getId(),
                courseDto.getName(),
                courseDto.getSubjects()
        );
    }
}
