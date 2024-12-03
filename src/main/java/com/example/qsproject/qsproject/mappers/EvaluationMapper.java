package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.EvaluationDto;

public class EvaluationMapper {

    public static EvaluationDto mapToEvaluationDto(Evaluation evaluation) {
        return new EvaluationDto(
                evaluation.getEvaluationId(),
                evaluation.getEvaluationType(),
                evaluation.getEvaluationWeight(),
                evaluation.getEvaluationDate(),
                evaluation.getSubject() != null ? evaluation.getSubject().getSubjectId() : 0L,
                evaluation.getClassroom() != null ? evaluation.getClassroom().getClassroomId() : 0L
        );
    }

    public static Evaluation mapToEvaluation(EvaluationDto evaluationDto, Subject subject, Classroom classroom){
        return new Evaluation(
                evaluationDto.getEvaluationId(),
                evaluationDto.getEvaluationType(),
                evaluationDto.getEvaluationWeight(),
                evaluationDto.getEvaluationDate(),
                subject, // Use the actual Subject entity here
                classroom // Use the actual Classroom entity here
        );
    }
}


