package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.SemesterDto;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class transforms Semester entities into SemesterDto objects and vice versa.
 */

public class SemesterMapper {

    /**
     * Converts a Semester entity to a SemesterDto.
     *
     * @param semester The Semester entity to be converted.
     * @return A SemesterDto object with data mapped from the Semester entity.
     */

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


    /**
     * Converts a SemesterDto to a Semester entity.
     *
     * @param semesterDto The SemesterDto to be converted.
     * @return A Semester entity with data mapped from the SemesterDto.
     */

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


