package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Evaluation;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.mappers.EvaluationMapper;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.services.EvaluationServices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EvaluationImpl implements EvaluationServices {
    private EvaluationRepository evaluationRepository;

    @Override
    public EvaluationDto createEvaluation(EvaluationDto evaluationDto) {
        Evaluation evaluation = EvaluationMapper.mapToEvaluation(evaluationDto);
        Evaluation saveEvaluation = evaluationRepository.save(evaluation);
        return EvaluationMapper.mapToEvaluationDto(saveEvaluation);
    }


    @Override
    public EvaluationDto getEvaluationById(long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Evaluation not found with this id: "+id));
        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    @Override
    public EvaluationDto deleteEvaluationById(long id){
        Evaluation evaluation = evaluationRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove evaluation with this id: "+id));
        evaluationRepository.delete(evaluation);
        return EvaluationMapper.mapToEvaluationDto(evaluation);
    }


    @Override
    public List<EvaluationDto> getAllEvaluations(){
        List<Evaluation> evaluations = evaluationRepository.findAll();
        return evaluations.stream().map((evaluation)->EvaluationMapper.mapToEvaluationDto(evaluation))
                .collect(Collectors.toList());
    }
}
