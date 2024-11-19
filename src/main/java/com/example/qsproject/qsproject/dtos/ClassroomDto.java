package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Evaluation;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {
    private long classroomId;
    private int capacity;
    private boolean computers;
    private List<Evaluation> evaluations;
    private Date classroomInUseDate;

}

