package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class represents an Evaluation entity storing information about the evaluation type,
 * weight, date, and its associations with a Subject and a Classroom.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "evaluations")
public class Evaluation {

    /**
     * Unique identifier for the evaluation.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long evaluationId;


    /**
     * The type of the evaluation (e.g., test, assignment, etc.).
     * This field is unique and cannot be null.
     */

    @Column(name = "evaluationType", nullable = false, unique = true)
    private String evaluationType;

    /**
     * The weight of the evaluation in the overall grading.
     * This field cannot be null.
     */

    @Column(name = "evaluationWeight", nullable = false)
    private double evaluationWeight;


    /**
     * The date when the evaluation takes place.
     * This field cannot be null.
     */

    @Column(name = "evaluationDate", nullable = false)
    private LocalDate evaluationDate;


    /**
     * The subject associated with this evaluation.
     * This is an optional relationship and can be null.
     */

    @JoinColumn(name = "subject_id")
    @ManyToOne(optional = true)
    private Subject subject;

    /**
     * The classroom in which the evaluation takes place.
     * This is a mandatory relationship and cannot be null.
     */

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;
}

