package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;

import java.util.ArrayList;
import java.util.List;

// Interface com os métodos que terao de ser utilizados no UserServiceImpl
public interface CourseService {

    CourseDto createCourse(CourseDto coursesDto);

    CourseDto getCourseById(long id);

    CourseDto deleteCourseById(long id);

    List<CourseDto> getAllCourses();
}
