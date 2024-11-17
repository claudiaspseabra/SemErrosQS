package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import com.example.qsproject.qsproject.services.EvaluationServices;
import com.example.qsproject.qsproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/app/evaluations")
public class EvaluationController {

    private EvaluationServices evaluationServices;
    private EvaluationRepository evaluationRepository;

    @PostMapping
    public ResponseEntity<EvaluationDto> createEvaluation(@RequestBody EvaluationDto evaluationDto) {
        EvaluationDto savedEvaluationsDto = evaluationServices.createEvaluation(evaluationDto);
        return new ResponseEntity<>(savedEvaluationsDto, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<EvaluationDto> getEvaluationById(@PathVariable("id") long id) {
        EvaluationDto evaluationDto = evaluationServices.getEvaluationById(id);
        return ResponseEntity.ok(evaluationDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EvaluationDto> deleteEvaluationById(@PathVariable("id") long id) {
        EvaluationDto deleteEvaluationDto = evaluationServices.deleteEvaluationById(id);
        return new ResponseEntity<>(deleteEvaluationDto, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<EvaluationDto>> getAllEvaluations(){
        List<EvaluationDto> evaluations = evaluationServices.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }

}
