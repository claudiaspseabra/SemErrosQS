package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class represents a Subject entity in the system, storing information about the subject name,
 * the associated course, evaluations, number of students enrolled, evaluation type, attendance requirements,
 * year, and semester.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "subjects")
public class Subject {

    /**
     * The unique ID of the subject.
     * This is the primary key of the subject entity.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;


    /**
     * The name of the subject.
     * This field must be unique and cannot be null.
     */

    @Column(name = "subjectName",nullable = false,unique = true)
    private String subjectName;


    /**
     * The course associated with the subject.
     * A subject is linked to one course.
     */

    @ManyToOne
    @JoinColumn(name= "course_id")
    private Course courses;


    /**
     * The evaluations associated with the subject.
     * A subject can have multiple evaluations.
     */

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;


    /**
     * The number of students enrolled in the subject.
     * This field cannot be null.
     */

    @Column(name = "studentsEnrolled",nullable = false)
    private int studentsEnrolled;


    /**
     * The type of evaluation for the subject.
     * This field cannot be null.
     */

    @Column(name = "subjectEvaluationType",nullable = false)
    private String subjectEvaluationType;


    /**
     * The attendance requirements for the subject.
     * This field cannot be null.
     */

    @Column(name = "subjectAttendance", nullable = false)
    private String subjectAttendance;


    /**
     * The year in which the subject is taught.
     * This field cannot be null.
     */

    @Column(name = "subjectYear", nullable = false)
    private int subjectYear;


    /**
     * The semester in which the subject is taught.
     * This field cannot be null.
     */

    @Column(name = "subjectSemester", nullable = false)
    private int subjectSemester;

}
