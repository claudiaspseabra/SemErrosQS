package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.repositories.SemesterRepository;
import com.example.qsproject.qsproject.services.SemesterService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * @version 1.0
 * @author Group 6
 */


/**
 * This class is responsible for managing the requests of the semester.
 * It has CRUD methods.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/app/semesters")
public class SemesterController {

    private SemesterService semesterService;
    private SemesterRepository semesterRepository;


    /**
     * This method is used to create a new semester.
     *
     * @param semesterDto The details of the semester to be created.
     * @return A ResponseEntity with the created semester and status 201.
     */

    @PostMapping
    public ResponseEntity<SemesterDto> createSemester(@RequestBody SemesterDto semesterDto) {
        SemesterDto savedSemesterDto = semesterService.createSemester(semesterDto);
        return new ResponseEntity<>(savedSemesterDto, HttpStatus.CREATED);
    }


    /**
     * This method gets a specific semester by its ID.
     *
     * @param id The ID of the semester.
     * @return A ResponseEntity with the semester details.
     */

    @GetMapping("{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable("id") long id) {
        SemesterDto semesterDto = semesterService.getSemesterById(id);
        return ResponseEntity.ok(semesterDto);
    }


    /**
     * This method deletes a semester by its ID.
     *
     * @param id The ID of the semester to be deleted.
     * @return A ResponseEntity with the deleted semester.
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SemesterDto> deleteSemesterById(@PathVariable("id") long id) {
        SemesterDto deleteSemesterDto = semesterService.deleteSemesterById(id);
        return new ResponseEntity<>(deleteSemesterDto, HttpStatus.OK);
    }

    /**
     * This method gets all the semesters.
     *
     * @return A ResponseEntity with a list of all semesters.
     */

    @GetMapping()
    public ResponseEntity<ArrayList<SemesterDto>> getAllSemester(){
        ArrayList<SemesterDto> semesters = semesterService.getAllSemesters();
        return ResponseEntity.ok(semesters);
    }


    /**
     * Updates an existing semester based on the provided ID and new semester data.
     *
     * @param semesterId The ID of the semester to be updated.
     * @param updatedSemester The data transfer object containing the updated semester information.
     * @return A ResponseEntity containing the updated SemesterDto.
     */

    @PutMapping("{id}")
    public ResponseEntity<SemesterDto> updateSemester(@PathVariable("id") long semesterId,@RequestBody SemesterDto updatedSemester){
        SemesterDto semesterDto = semesterService.updateSemester(semesterId,updatedSemester);
        return ResponseEntity.ok(semesterDto);
    }

}
