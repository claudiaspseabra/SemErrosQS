package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;

// Interface com os métodos que terao de ser utilizados no UserServiceImpl
public interface CourseService {

    CourseDto createCourse(CourseDto coursesDto);

    CourseDto getCourseById(int id);

    CourseDto deleteCourseById(int id);
}
