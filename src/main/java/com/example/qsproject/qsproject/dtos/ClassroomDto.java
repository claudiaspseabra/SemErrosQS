package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Evaluation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classrooms")
public class ClassroomDto {
    private long classroomId;
    private String tag;
    private String description;
    private String classroomType;
    private int capacity;
    private List<Long> evaluationIds; // Simplified representation of evaluations
    //private LocalDate classroomInUseDate; // Updated from java.sql.Date to java.time.LocalDate
}
