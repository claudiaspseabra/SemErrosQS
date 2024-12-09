package com.example.qsproject.qsproject.services.impl;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Evaluation;
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

@Service
public class EvaluationImpl implements EvaluationServices {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public EvaluationDto createEvaluation(EvaluationDto evaluationDto) {
        // Fetch Subject and Classroom by their IDs
        Subject subject = subjectRepository.findById(evaluationDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Classroom classroom = classroomRepository.findById(evaluationDto.getClassroomId())
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        // Convert EvaluationDto to Evaluation entity with the actual Subject and Classroom entities
        Evaluation evaluation = EvaluationMapper.mapToEvaluation(evaluationDto, subject, classroom);

        // Save the Evaluation entity
        evaluation = evaluationRepository.save(evaluation);

        // Return the saved Evaluation as EvaluationDto
        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    // Get an Evaluation by its ID
    @Override
    public EvaluationDto getEvaluationById(long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));

        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }

    // Delete an Evaluation by its ID
    @Override
    public EvaluationDto deleteEvaluationById(long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));

        evaluationRepository.delete(evaluation);

        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }

    // Get all Evaluations
    @Override
    public List<EvaluationDto> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationRepository.findAll();

        return evaluations.stream()
                .map(EvaluationMapper::mapToEvaluationDto)
                .collect(Collectors.toList());
    }
}
