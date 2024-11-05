package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluationId;


    @Column(name = "evaluationType",nullable = false,unique = true)
    private String evaluationType;
}
