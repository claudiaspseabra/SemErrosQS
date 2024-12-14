package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.dtos.EvaluationDto;

import java.util.List;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Service interface for managing Evaluation-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */

public interface EvaluationServices {

    /**
     * Creates a new evaluation and returns the created evaluation details.
     *
     * @param evaluationDto A EvaluationDto object containing the evaluation data to be created.
     * @return The created EvaluationDto object.
     */

    EvaluationDto createEvaluation(EvaluationDto evaluationDto);


    /**
     * Retrieves an evaluation by its ID.
     *
     * @param id The ID of the evaluation to be retrieved.
     * @return A EvaluationDto object containing the evaluation details.
     */

    EvaluationDto getEvaluationById(long id);


    /**
     * Deletes an evaluation by its unique ID.
     *
     * @param id The ID of the evaluation to be deleted.
     * @return The deleted EvaluationDto object.
     */

    EvaluationDto deleteEvaluationById(long id);


    /**
     * Retrieves all evaluations available in the system.
     *
     * @return A list of EvaluationDto objects representing all evaluations.
     */

    List<EvaluationDto> getAllEvaluations();


    /**
     * Updates an existing evaluation with new data.
     *
     * @param evaluationId The ID of the evaluation to be updated.
     * @param updateEvalution An Evaluation object containing the updated evaluation data.
     * @return The updated EvaluationDto object.
     */

    EvaluationDto updateEvaluations(long evaluationId, Evaluation updateEvalution);

    List<EvaluationDto> getEvaluationsBySubjectId(long subjectId);

}
