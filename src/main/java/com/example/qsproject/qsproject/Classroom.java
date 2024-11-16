package com.example.qsproject.qsproject;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// test
@Getter
@Setter
//TESTE
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;

    @Column(name = "capacity",nullable = false)
    private int capacity;

    @Column(name = "computers",nullable = false)
    private boolean computers;

}