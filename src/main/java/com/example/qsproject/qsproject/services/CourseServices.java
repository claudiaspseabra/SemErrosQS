package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

public interface CourseServices {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourseById(long id);
    CourseDto deleteCourseById(long id);
    List<CourseDto> getAllCourses();
}