package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class transforms Subject entities into SubjectDto objects and vice versa.
 */


public class SubjectMapper {


    /**
     * Converts a Subject entity to a SubjectDto.
     *
     * @param subject The Subject entity to be converted.
     * @return A SubjectDto object with data mapped from the Subject entity.
     */

    public static SubjectDto mapToSubjectDto(Subject subject) {

        return new SubjectDto(
                subject.getSubjectId(),
                subject.getSubjectName(),
                subject.getCourses() != null ? subject.getCourses().getCourseId() : 0L,
                EvaluationMapper.mapToEvaluationDto(subject.getEvaluations()),
                subject.getStudentsEnrolled(),
                subject.getSubjectEvaluationType(),
                subject.getSubjectAttendance(),
                subject.getSubjectYear(),
                subject.getSubjectSemester()

        );
    }


    /**
     * Converts a list of Subject entities to a list of SubjectDto objects.
     *
     * @param subjects The list of Subject entities to be converted.
     * @return A list of SubjectDto objects.
     */

    public static List<SubjectDto> mapToSubjectsDto(List<Subject> subjects) {
        if(subjects == null){
            return Collections.emptyList();
        }
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for(Subject subject: subjects){
            SubjectDto subjectDto = SubjectMapper.mapToSubjectDto(subject);
            subjectDtos.add(subjectDto);
        }
        return subjectDtos;
    }

    public static Subject mapToSubject(SubjectDto subjectDto){
        Course course = new Course();
        course.setCourseId(subjectDto.getCourseId());
        return new Subject(
                subjectDto.getSubjectId(),
                subjectDto.getSubjectName(),
                course,
                EvaluationMapper.mapToEvaluation(subjectDto.getEvaluations()),
                subjectDto.getStudentsEnrolled(),
                subjectDto.getSubjectEvaluationType(),
                subjectDto.getSubjectAttendance(),
                subjectDto.getSubjectYear(),
                subjectDto.getSubjectSemester()
        );
    }


    /**
     * Converts a SubjectDto to a Subject entity.
     *
     * @param subjectDtos The SubjectDto to be converted.
     * @return A Subject entity with data mapped from the SubjectDto.
     */

    public static List<Subject> mapToSubjects(List<SubjectDto> subjectDtos) {
        if(subjectDtos == null){
            return Collections.emptyList();
        }
        List<Subject> subjects = new ArrayList<>();
        for(SubjectDto subjectDto: subjectDtos){
            Subject subject = SubjectMapper.mapToSubject(subjectDto);
            subjects.add(subject);
        }
        return subjects;
    }
}