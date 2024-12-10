package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.dtos.EvaluationDto;

import java.util.List;


public interface EvaluationServices {

    EvaluationDto createEvaluation(EvaluationDto evaluationDto);
    // Get Evaluation by ID
    EvaluationDto getEvaluationById(long id);

    // Delete Evaluation by ID
    EvaluationDto deleteEvaluationById(long id);

    // Get all Evaluations
    List<EvaluationDto> getAllEvaluations();

    EvaluationDto updateEvaluations(long evaluationId, Evaluation updateEvalution);
}
