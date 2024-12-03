package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @Column(name = "evaluationType", nullable = false, unique = true)
    private String evaluationType;

    @Column(name = "needComp", nullable = false)
    private boolean needComp;

    @Column(name = "evaluationWeight", nullable = false)
    private double evaluationWeight;

    @JoinColumn(name = "subject_id", nullable = false)
    @ManyToOne
    private Subject subject;

    @JoinColumn(name = "classroom_id", nullable = false)
    @ManyToOne
    private Classroom classroom;
}

