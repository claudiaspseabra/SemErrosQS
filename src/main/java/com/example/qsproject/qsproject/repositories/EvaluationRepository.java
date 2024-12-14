package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
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
    //List<Evaluation> findBySubject_Id(long subjectId);
    List<Evaluation> findBySubject_SubjectId(long subjectId);
    Optional<Evaluation> findBySubject_Courses_CourseIdAndEvaluationDate(long courseId, LocalDate evaluationDate);
}
