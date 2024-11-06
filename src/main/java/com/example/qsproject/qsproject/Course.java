package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "courseName",unique = true,nullable = false)
    private String courseName;

    @Column(name = "subjects")
    private ArrayList<Subject> subjects;
}
