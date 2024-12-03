package com.example.qsproject.qsproject.services;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;

import java.util.ArrayList;
import java.util.List;

public interface ClassroomServices {
    void importCSV(String csvFilePath);
    ClassroomDto getClassroomById(long id);
    List<ClassroomDto> getAllClassrooms();
}