package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getSubjects()
        );
    }

    public static Course mapToCourse(CourseDto courseDto){
        return new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getSubjects()
        );
    }


}


