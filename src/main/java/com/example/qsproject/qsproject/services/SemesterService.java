package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.SemesterDto;

public interface SemesterService {
    SemesterDto createSemester(SemesterDto semesterDto);

    SemesterDto getSemesterById(long id);

    SemesterDto deleteSemesterById(long id);
}
