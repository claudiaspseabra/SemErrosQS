package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.EvaluationDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class transforms Evaluation entities into EvaluationDto objects and vice versa.
 */

public class EvaluationMapper {

    /**
     * Converts an Evaluation entity to a EvaluationDto.
     *
     * @param evaluation The Evaluation entity to be converted.
     * @return A EvaluationDto object with data mapped from the Evaluation entity.
     */

    public static EvaluationDto mapToEvaluationDto(Evaluation evaluation) {
        return new EvaluationDto(
                evaluation.getEvaluationId(),
                evaluation.getEvaluationType(),
                evaluation.getEvaluationWeight(),
                evaluation.getEvaluationDate(),
                evaluation.getSubject() != null ? evaluation.getSubject().getSubjectId() : 0L,
                evaluation.getClassroom() != null ? evaluation.getClassroom().getClassroomId() : 0L,
                evaluation.getEvaluationtHour()
        );
    }


    /**
     * Converts a list of Evaluation entities to a list of EvaluationDto objects.
     *
     * @param evaluations The list of Evaluation entities to be converted.
     * @return A list of EvaluationDto objects.
     */

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


    /**
     * Converts an EvaluationDto to an Evaluation entity.
     *
     * @param evaluationDto The EvaluationDto to be converted.
     * @return An Evaluation entity with data mapped from the EvaluationDto.
     */

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
                classroom,
                evaluationDto.getEvaluationHour()
        );
    }


    /**
     * Converts a list of EvaluationDto objects to a list of Evaluation entities.
     *
     * @param evaluationsDto The list of EvaluationDto objects to be converted.
     * @return A list of Evaluation entities.
     */

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