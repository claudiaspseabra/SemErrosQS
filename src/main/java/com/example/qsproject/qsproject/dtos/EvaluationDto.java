package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Subject;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


/**
 * @version 1.0
 * @author Group 6
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
    private double evaluationWeight;
    private LocalDate evaluationDate;
    private long subjectId;
    private long classroomId;
}
