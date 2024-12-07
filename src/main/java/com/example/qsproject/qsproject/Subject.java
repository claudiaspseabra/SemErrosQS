package com.example.qsproject.qsproject;

import jakarta.persistence.*;
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


@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    @Column(name = "subjectName",nullable = false,unique = true)
    private String subjectName;

    @ManyToOne
    @JoinColumn(name= "course_id", nullable = false)
    private Course courses;

    @Column(name="evaluations")
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @Column(name = "studentsEnrolled",nullable = false)
    private int studentsEnrolled;

    @Column(name = "subjectEvaluationType",nullable = false)
    private String subjectEvaluationType;

    @Column(name = "subjectAttendance", nullable = false)
    private String subjectAttendance;
    // falta assiduidade
}
