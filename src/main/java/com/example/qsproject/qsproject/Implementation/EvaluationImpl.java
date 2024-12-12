package com.example.qsproject.qsproject.Implementation;


import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.mappers.EvaluationMapper;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.services.EvaluationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the EvaluationServices interface, providing functionality to manage evaluations.
 * It offers methods for creating, retrieving, deleting, and updating evaluations in the system.
 */

@Service
public class EvaluationImpl implements EvaluationServices {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;


    /**
     * Creates a new evaluation using the provided EvaluationDto and fetches the associated Subject and Classroom entities.
     *
     * @param evaluationDto The EvaluationDto object containing evaluation details.
     * @return A EvaluationDto object representing the newly created evaluation.
     * @throws RuntimeException If the Subject or Classroom is not found.
     */

    @Override
    public EvaluationDto createEvaluation(EvaluationDto evaluationDto) {
        // Fetch Subject and Classroom by their IDs
        Subject subject = subjectRepository.findById(evaluationDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Classroom classroom = classroomRepository.findById(evaluationDto.getClassroomId())
                .orElseThrow(() -> new RuntimeException("Classroom not found"));


        evaluationDto.setSubjectId(subject.getSubjectId());
        evaluationDto.setClassroomId(classroom.getClassroomId());
        Evaluation evaluation = EvaluationMapper.mapToEvaluation(evaluationDto);

        evaluation = evaluationRepository.save(evaluation);

        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    /**
     * Retrieves an evaluation by its ID.
     *
     * @param id The ID of the evaluation to retrieve.
     * @return An EvaluationDto object containing the details of the requested evaluation.
     * @throws Exceptions if the evaluation is not found.
     */

    @Override
    public EvaluationDto getEvaluationById(long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));

        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    /**
     * Deletes an evaluation by its ID.
     *
     * @param id The ID of the evaluation to delete.
     * @return An EvaluationDto object containing the details of the deleted evaluation.
     * @throws Exceptions if the evaluation is not found.
     */

    @Override
    public EvaluationDto deleteEvaluationById(long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));

        evaluationRepository.delete(evaluation);

        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    /**
     * Retrieves all evaluations in the system.
     *
     * @return A list of objects representing all evaluations.
     */

    @Override
    public List<EvaluationDto> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationRepository.findAll();

        return evaluations.stream()
                .map(EvaluationMapper::mapToEvaluationDto)
                .collect(Collectors.toList());
    }


    /**
     * Updates the details of an existing evaluation.
     *
     * @param evaluationId The ID of the evaluation to update.
     * @param updateEvalution The Evaluation object containing the updated evaluation details.
     * @return A EvaluationDto object containing the updated evaluation details.
     * @throws Exceptions if the evaluation is not found.
     */

    @Override
    public EvaluationDto updateEvaluations(long evaluationId, Evaluation updateEvalution) {
        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(
                () -> new Exceptions("Evaluation does not exist with this id: " + evaluationId)
        );
        evaluation.setEvaluationType(updateEvalution.getEvaluationType());
        //    evaluation.setEvaluationWeight(updateEvaluation.get());
        Evaluation updateEvaluationObj = evaluationRepository.save(evaluation);
        return EvaluationMapper.mapToEvaluationDto(updateEvaluationObj);
    }
}
