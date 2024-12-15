package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Subject;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class represents an evaluation in the system.
 * It is used to transfer data about the evaluation between different parts of the application.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {
    private long evaluationId;
    private String evaluationType;
    private long evaluationWeight;
    private LocalDate evaluationDate;
    private long subjectId;
    private long classroomId;
    private LocalTime evaluationHour;
    private boolean computer;
    private long evaluationPosition;
}
