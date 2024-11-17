package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

public class EvaluationMapper {

    public static EvaluationDto mapToEvaluationDto(Evaluation evaluation) {
        return new EvaluationDto(
                evaluation.getEvaluationId(),
                evaluation.getEvaluationType(),
                evaluation.isNeedComp(),
                evaluation.getEvaluationWeight(),
                evaluation.getSubject(),
                evaluation.getClassroom()
        );
    }

    public static Evaluation mapToEvaluation(EvaluationDto evaluationDto){
        return new Evaluation(
                evaluationDto.getEvaluationId(),
                evaluationDto.getEvaluationType(),
                evaluationDto.isNeedComp(),
                evaluationDto.getEvaluationWeight(),
                evaluationDto.getSubject(),
                evaluationDto.getClassroom()
        );
    }
}


