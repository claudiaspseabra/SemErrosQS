package com.example.qsproject.qsproject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class represents a Semester entity, storing information about the semester's start and end dates,
 * as well as the dates for special exams, normal season exams, and recovery season exams.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "semester")
public class Semester {

    /**
     * The unique ID of the semester.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long semesterId;

    /**
     * The start date of the semester.
     */

    @Column(name = "startSemester", nullable = false)
    private Date startSemester;


    /**
     * The end date of the semester.
     */

    @Column(name = "endSemester", nullable = false)
    private Date endSemester;

    /**
     * The start date for special exams in this semester.
     */

    @Column(name = "speciaExamStart", nullable = false)
    private Date specialExamStart;


    /**
     * The end date for special exams in this semester.
     */

    @Column(name = "specialExamEnd", nullable = false)
    private Date specialExamEnd;


    /**
     * The start date for normal season exams in this semester.
     */

    @Column(name = "normalSeasonStart", nullable = false)
    private Date normalSeasonStart;


    /**
     * The end date for normal season exams in this semester.
     */


    @Column(name = "normalSeasonEnd", nullable = false)
    private Date normalSeasonEnd;


    /**
     * The start date for recovery season exams in this semester.
     */

    @Column(name = "recoverySeasonStart", nullable = false)
    private Date recoverySeasonStart;


    /**
     * The end date for recovery season exams in this semester.
     */

    @Column(name = "recoverySeasonEnd", nullable = false)
    private Date recoverySeasonEnd;

}
