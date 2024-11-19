package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
