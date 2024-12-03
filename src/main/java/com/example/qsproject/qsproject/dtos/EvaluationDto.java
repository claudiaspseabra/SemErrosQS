package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Subject;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {
    private long evaluationId;
    private String evaluationType;
    private double evaluationWeight;
    private LocalDate evaluationDate;
    private long subjectId; // Lightweight representation of Subject
    private long classroomId; // Lightweight representation of Classroom
}
