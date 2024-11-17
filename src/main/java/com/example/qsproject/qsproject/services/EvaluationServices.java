package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;

import java.util.List;


public interface EvaluationServices {
    EvaluationDto createEvaluation(EvaluationDto evaluationDto);

    EvaluationDto getEvaluationById(long id);

    EvaluationDto deleteEvaluationById(long id);

    List<EvaluationDto> getAllEvaluations();
}
