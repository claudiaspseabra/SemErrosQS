package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

public class SubjectMapper {

    public static SubjectDto mapToSubjectDto(Subject subject) {
        return new SubjectDto(
                subject.getSubjectId(),
                subject.getSubjectName(),
                subject.getCourses(),
                subject.getEvaluations(),
                subject.getStudentsEnrolled(),
                subject.getSubjectEvaluationType()

        );
    }

    public static Subject mapToSubject(SubjectDto subjectDto){
        return new Subject(
                subjectDto.getSubjectId(),
                subjectDto.getSubjectName(),
                subjectDto.getCourses(),
                subjectDto.getEvaluations(),
                subjectDto.getStudentsEnrolled(),
                subjectDto.getSubjectEvaluationType()
        );
    }
}

