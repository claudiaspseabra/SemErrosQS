package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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


    @Column(name = "evaluationType",nullable = false,unique = true)
    private String evaluationType;

    @Column(name="needComp",nullable = false)
    private boolean needComp;

    @ManyToOne
    @JoinColumn(name= "subject_id",nullable = false)
    private Subject subject;


    @ManyToOne
    @JoinColumn(name = "classroom_id",nullable = false)
    private Classroom classroom;
}
