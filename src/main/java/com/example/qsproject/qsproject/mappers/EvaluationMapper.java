package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.EvaluationDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static List<EvaluationDto> mapToEvaluationDto(List<Evaluation> evaluations) {
        if(evaluations == null){
            return Collections.emptyList();
        }
        List<EvaluationDto> evaluationDtos = new ArrayList<>();
        for(Evaluation evaluation: evaluations){
            EvaluationDto evaluationDto = EvaluationMapper.mapToEvaluationDto(evaluation);
            evaluationDtos.add(evaluationDto);
        }
        return evaluationDtos;
    }

    public static Evaluation mapToEvaluation(EvaluationDto evaluationDto) {
        Subject subject = new Subject();
        subject.setSubjectId(evaluationDto.getSubjectId());
        Classroom classroom = new Classroom();
        classroom.setClassroomId(evaluationDto.getClassroomId());
        return new Evaluation(
                evaluationDto.getEvaluationId(),
                evaluationDto.getEvaluationType(),
                evaluationDto.getEvaluationWeight(),
                evaluationDto.getEvaluationDate(),
                subject,
                classroom
        );
    }

    public static List<Evaluation> mapToEvaluation(List<EvaluationDto> evaluationsDto) {
        if(evaluationsDto == null){
            return Collections.emptyList();
        }
        List<Evaluation> evaluations = new ArrayList<>();
        for (EvaluationDto evaluationDto : evaluationsDto) {
            Evaluation evaluation = EvaluationMapper.mapToEvaluation(evaluationDto);
            evaluations.add(evaluation);
        }
        return evaluations;
    }
}