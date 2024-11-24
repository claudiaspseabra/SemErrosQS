package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long semesterId;

    @Column(name = "startSemester", nullable = false)
    private Date startSemester;

    @Column(name = "endSemester", nullable = false)
    private Date endSemester;

    @Column(name = "speciaExamStart", nullable = false)
    private Date specialExamStart;

    @Column(name = "specialExamEnd", nullable = false)
    private Date specialExamEnd;

    @Column(name = "normalSeasonStart", nullable = false)
    private Date normalSeasonStart;

    @Column(name = "normalSeasonEnd", nullable = false)
    private Date normalSeasonEnd;

    @Column(name = "recoverySeasonStart", nullable = false)
    private Date recoverySeasonStart;

    @Column(name = "recoverySeasonEnd", nullable = false)
    private Date recoverySeasonEnd;

}
