package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.SemesterDto;

public class SemesterMapper {

    public static SemesterDto mapToSemesterDto(Semester semester) {
        return new SemesterDto(
                semester.getSemesterId(),
                semester.getStartSemester(),
                semester.getEndSemester(),
                semester.getSpecialExamStart(),
                semester.getSpecialExamEnd(),
                semester.getNormalSeasonStart(),
                semester.getNormalSeasonEnd(),
                semester.getRecoverySeasonStart(),
                semester.getRecoverySeasonEnd()
        );
    }

    public static Semester mapToSemester(SemesterDto semesterDto){
        return new Semester(
                semesterDto.getSemesterId(),
                semesterDto.getStartSemester(),
                semesterDto.getEndSemester(),
                semesterDto.getSpecialExamStart(),
                semesterDto.getSpecialExamEnd(),
                semesterDto.getNormalSeasonStart(),
                semesterDto.getNormalSeasonEnd(),
                semesterDto.getRecoverySeasonStart(),
                semesterDto.getRecoverySeasonEnd()
        );
    }
}


