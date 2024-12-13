package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * Repository interface for accessing and managing Evaluation entities in the database.
 * Extends JpaRepository to provide basic CRUD operations and to do query methods.
 */

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
    //List<Evaluation> findBySubject_Id(long subjectId);
    List<Evaluation> findBySubject_SubjectId(long subjectId);
}
