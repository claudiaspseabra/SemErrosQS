package com.example.qsproject.qsproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
