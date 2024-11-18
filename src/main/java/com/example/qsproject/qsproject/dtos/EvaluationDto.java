package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {
    private long evaluationId;
    private String evaluationType;
    private boolean needComp;
    private Subject subject;
    private Classroom classroom;
}
