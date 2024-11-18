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
    private int id;
    private String name;
    private String subjects;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubjects() {
        return subjects;
    }
}
