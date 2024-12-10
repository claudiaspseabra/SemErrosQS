package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long evaluationId;

    @Column(name = "evaluationType", nullable = false, unique = true) // need computer was removed because we can add test with computer
    private String evaluationType;

    @Column(name = "evaluationWeight", nullable = false)
    private double evaluationWeight;

    @Column(name = "evaluationDate", nullable = false)
    private LocalDate evaluationDate;

    @JoinColumn(name = "subject_id")
    @ManyToOne(optional = true)
    //@JsonBackReference // added this
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false) // Foreign key column
    //@JsonManagedReference // Handles the other side of the bidirectional relationship
    private Classroom classroom;
}

