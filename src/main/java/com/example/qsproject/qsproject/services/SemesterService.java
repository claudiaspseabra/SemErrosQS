package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SemesterDto;

import java.util.ArrayList;

public interface SemesterService {
    SemesterDto createSemester(SemesterDto semesterDto);

    SemesterDto getSemesterById(long id);

    SemesterDto deleteSemesterById(long id);

    ArrayList<SemesterDto> getAllSemesters();

    SemesterDto updateSemester(Long semesterId, SemesterDto updatedSemester);
}
