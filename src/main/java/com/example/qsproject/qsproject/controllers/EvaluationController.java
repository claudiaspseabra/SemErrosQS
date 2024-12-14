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


/**
 * @version 1.0
 * @author Sem Erros
 */


/**
 * This class is responsible for managing evaluations requests.
 * It has CRUD methods.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/app/evaluations")
public class EvaluationController {

    private EvaluationServices evaluationServices;
    private EvaluationRepository evaluationRepository;


    /**
     * This method is used to create a new evaluation.
     *
     * @param evaluationDto The details of the evalution to be created.
     * @return A ResponseEntity with the created evalution and status 201.
     */

    @PostMapping
    public ResponseEntity<EvaluationDto> createEvaluation(@RequestBody EvaluationDto evaluationDto) {
        EvaluationDto savedEvaluationDto = evaluationServices.createEvaluation(evaluationDto);
        return new ResponseEntity<>(savedEvaluationDto, HttpStatus.CREATED);
    }


    /**
     * This method gets a specific evaluation by its ID.
     *
     * @param id The ID of the evaluation.
     * @return A ResponseEntity with the evaluation details.
     */

    @GetMapping("{id}")
    public ResponseEntity<EvaluationDto> getEvaluationById(@PathVariable("id") long id) {
        EvaluationDto evaluationDto = evaluationServices.getEvaluationById(id);
        return ResponseEntity.ok(evaluationDto);
    }


    /**
     * This method deletes an evaluation by its ID.
     *
     * @param id The ID of the evaluation to be deleted.
     * @return A ResponseEntity with the deleted evaluation.
     */

    @DeleteMapping("{id}")
    public ResponseEntity<EvaluationDto> deleteEvaluationById(@PathVariable("id") long id) {
        EvaluationDto deleteEvaluationDto = evaluationServices.deleteEvaluationById(id);
        return new ResponseEntity<>(deleteEvaluationDto, HttpStatus.OK);
    }


    /**
     * This method gets all the evaluations.
     *
     * @return A ResponseEntity with a list of all evaluation.
     */

    @GetMapping()
    public ResponseEntity<List<EvaluationDto>> getAllEvaluations(@RequestParam(value = "subjectId", required = false) Long subjectId) {
        List<EvaluationDto> evaluations;
        if (subjectId != null) {
            evaluations = evaluationServices.getEvaluationsBySubjectId(subjectId);
        } else {
            evaluations = evaluationServices.getAllEvaluations();
        }

        return ResponseEntity.ok(evaluations);
    }

}
