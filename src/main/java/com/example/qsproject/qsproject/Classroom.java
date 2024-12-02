package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

// test
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//TESTE
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;

    @Column(name = "tag",nullable = false,unique = true)
    private String tag;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "classroomType",nullable = false)
    private String classroomType;

    @Column(name = "capacity",nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private ArrayList<Evaluation> evaluations;

    @Column(name = "classroomInUseDate",nullable = true)
    private Date classroomInUseDate;

}