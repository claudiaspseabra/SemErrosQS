package com.example.qsproject.qsproject;

// Interface com os métodos que terao de ser utilizados no UserServiceImpl
public interface CourseService {

    CourseDto createCourse(CourseDto coursesDto);

    CourseDto getCourseById(int id);

    CourseDto deleteCourseById(int id);
}
