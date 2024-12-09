package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.ClassroomMapper;
import com.example.qsproject.qsproject.mappers.CourseMapper;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import com.example.qsproject.qsproject.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseImpl implements CourseService {
    private CourseRepository courseRepository;

    @Override
    public CourseDto createCourse(CourseDto coursesDto) {
        Course course = CourseMapper.mapToCourse(coursesDto);
        Course saveCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(saveCourse);
    }


    @Override
    public CourseDto getCourseById(long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
        return CourseMapper.mapToCourseDto(course);
    }


    @Override
    public CourseDto deleteCourseById(long id){
        Course course = courseRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove admin with this id: "+id));
        courseRepository.delete(course);
        return CourseMapper.mapToCourseDto(course);
    }

    @Override
    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> CourseMapper.mapToCourseDto(course))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto updateCourse(long courseId, CourseDto updatedCourse) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new Exceptions("User does not exist with this id: " + courseId)
        );

        course.setCourseName(updatedCourse.getCourseName());
       // course.setSubjects(updatedCourse.getSubjects());

        Course updateCourseObj = courseRepository.save(course);

        return CourseMapper.mapToCourseDto(updateCourseObj);
    }

}
