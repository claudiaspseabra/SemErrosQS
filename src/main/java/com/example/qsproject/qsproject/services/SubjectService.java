package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;


public interface SubjectService {

    SubjectDto createSubject(SubjectDto subjectDto);

    SubjectDto getSubjectById(long id);

    SubjectDto deleteSubjectById(long id);

    List<SubjectDto> getAllSubjects();

    SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubject);
}
