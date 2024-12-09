package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private long CourseId;
    private String courseName;
    private List<SubjectDto> subjects;
}
