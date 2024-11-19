package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.SubjectDto;

import java.util.List;


public interface SubjectServices {
    SubjectDto createSubject(SubjectDto subjectDto);
    SubjectDto getSubjectById(long id);
    SubjectDto deleteSubjectById(long id);
    List<SubjectDto> getAllSubjects();
}
