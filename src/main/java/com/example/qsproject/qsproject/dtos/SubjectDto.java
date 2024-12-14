package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Evaluation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalTime;
import java.util.List;



/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class represents a subject in the system.
 * It is used to transfer data about the subject between different parts of the application.
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private long subjectId;
    private String subjectName;
    //private Course courses;
    private long courseId;
    private List<EvaluationDto> evaluations;
    private int studentsEnrolled;
    private String subjectEvaluationType;
    private String subjectAttendance;
    private int subjectYear;
    private int subjectSemester;
}

