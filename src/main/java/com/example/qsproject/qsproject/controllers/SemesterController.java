package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.repositories.SemesterRepository;
import com.example.qsproject.qsproject.services.SemesterService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/app/semesters")
public class SemesterController {

    private SemesterService semesterService;
    private SemesterRepository semesterRepository;

    @PostMapping
    public ResponseEntity<SemesterDto> createSemester(@RequestBody SemesterDto semesterDto) {
        SemesterDto savedSemesterDto = semesterService.createSemester(semesterDto);
        return new ResponseEntity<>(savedSemesterDto, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable("id") long id) {
        SemesterDto semesterDto = semesterService.getSemesterById(id);
        return ResponseEntity.ok(semesterDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SemesterDto> deleteSemesterById(@PathVariable("id") long id) {
        SemesterDto deleteSemesterDto = semesterService.deleteSemesterById(id);
        return new ResponseEntity<>(deleteSemesterDto, HttpStatus.OK);
    }

}
