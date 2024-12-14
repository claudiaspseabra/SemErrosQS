package com.example.qsproject.qsproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class represents a semester in the system.
 * It is used to transfer data about the semester between different parts of the application.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDto {
    private long semesterId;
    private Date startSemester;
    private Date endSemester;
    private Date specialExamStart;
    private Date specialExamEnd;
    private Date normalSeasonStart;
    private Date normalSeasonEnd;
    private Date recoverySeasonStart;
    private Date recoverySeasonEnd;
}
