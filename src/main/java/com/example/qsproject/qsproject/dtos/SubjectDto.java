package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private long subjectId;
    private String subjectName;
    private Course courses;
    private List<EvaluationDto> evaluations;
    private int studentsEnrolled;
    private String subjectEvaluationType;
    private String subjectAttendance;
}

