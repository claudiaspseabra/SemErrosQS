package com.example.qsproject.qsproject;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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
    @Column(name = "classroomName",nullable = false,unique = true)
    private String classroomName;
    @Column(name="classroomDescription",nullable = false)
    private String classroomDescription;
    @Column(name = "classroomType",nullable = false)
    private String classroomType;
    @Column(name = "classroomCapacity",nullable = false)
    private int classroomCapacity;
    @Column(name = "classroomInUseDate",nullable = true)
    private Date classroomInUseDate;

}