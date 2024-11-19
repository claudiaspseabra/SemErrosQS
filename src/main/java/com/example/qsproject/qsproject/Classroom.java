package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

// test
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//TESTE
@Entity
@Table(name = "classrooms")
public classlassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;



    @Column(name = "capacity",nullable = false)
    private int capacity;

    @Column(name = "computers",nullable = false)
    private boolean computers;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @Column(name = "classroomInUseDate",nullable = true)
    private Date classroomInUseDate;

    /*
        @Column(name = "classroomType",nullable = false)
    private String classroomType;

     */

}