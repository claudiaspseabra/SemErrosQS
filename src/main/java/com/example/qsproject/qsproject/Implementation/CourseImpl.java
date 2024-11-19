package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.mappers.CourseMapper;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import com.example.qsproject.qsproject.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public CourseDto getCourseById(int id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Admin not found with this id: "+id));
        return CourseMapper.mapToCourseDto(course);
    }


    // 05/11
    @Override
    public CourseDto deleteCourseById(int id){
        Course course = courseRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove admin with this id: "+id));
        courseRepository.delete(course);
        return CourseMapper.mapToCourseDto(course);
    }
}
