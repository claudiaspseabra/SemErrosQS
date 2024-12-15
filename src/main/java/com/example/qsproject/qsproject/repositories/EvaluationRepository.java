package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Repository interface for accessing and managing Evaluation entities in the database.
 * Extends JpaRepository to provide basic CRUD operations and to do query methods.
 */

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
    List<Evaluation> findBySubject_SubjectId(long subjectId);
    Optional<Evaluation> findBySubject_Courses_CourseIdAndEvaluationDate(long courseId, LocalDate evaluationDate);
    Optional<Evaluation> findByClassroom_ClassroomIdAndEvaluationDateAndEvaluationtHour(long classroomId, LocalDate evaluationDate, LocalTime evaluationTime);
    Optional<Evaluation> findBySubject_SubjectIdAndEvaluationDateAndEvaluationtHour(long subjectId, LocalDate evaluationDate, LocalTime evaluationTime);
    Optional<Evaluation> findBySubject_Courses_CourseIdAndEvaluationDateAndEvaluationtHour(long courseId, LocalDate evaluationDate, LocalTime evaluationTime);
    Optional<Evaluation> findBySubject_Courses_CourseIdNotAndEvaluationDateAndEvaluationtHour(long courseId, LocalDate evaluationDate, LocalTime evaluationTime);
    boolean existsByClassroom_ClassroomIdAndEvaluationDateAndEvaluationtHourBetween(long classroomId, LocalDate evaluationDate, LocalTime startTime, LocalTime endTime);

}

