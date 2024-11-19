package com.example.qsproject.qsproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private int CourseId;
    private String CourseName;
    private ArrayList<Subject> subjects;



}
