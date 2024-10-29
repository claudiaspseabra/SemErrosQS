package com.example.qsproject.qsproject;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;

    @Column(name = "capacity",nullable = false)
    private int capacity;

    @Column(name = "computer",nullable = false)
    private boolean computers;

}