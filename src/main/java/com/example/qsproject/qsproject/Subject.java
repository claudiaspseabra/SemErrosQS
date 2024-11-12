package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @Column(name = "subjectName",nullable = false,unique = true)
    private String subjectName;

    @Column(name="evaluations",nullable = false)
    private ArrayList<Evaluation> evaluations;

    @Column(name = "studentsEnrolled",nullable = false)
    private int studentsEnrolled;
}
