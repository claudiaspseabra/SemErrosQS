package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class represents a course in the system.
 * It is used to transfer data about the course between different parts of the application.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private long CourseId;
    private String courseName;
    private int courseDuration;
    private List<SubjectDto> subjects;
}
