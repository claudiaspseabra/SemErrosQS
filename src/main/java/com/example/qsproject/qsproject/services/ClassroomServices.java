package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.ClassroomDto;

import java.util.List;

public interface ClassroomServices {
    ClassroomDto createClassroom(ClassroomDto classroomDto);
    ClassroomDto getClassroomById(long id);
    ClassroomDto deleteClassroomById(long id);
    List<ClassroomDto> getAllClassrooms();
}
