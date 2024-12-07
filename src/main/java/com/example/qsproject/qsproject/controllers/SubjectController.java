package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.services.SubjectService;
import com.example.qsproject.qsproject.services.UserService;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import lombok.AllArgsConstructor;
import org.hibernate.boot.jaxb.hbm.spi.SubEntityInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// to do
@AllArgsConstructor
@RestController
@RequestMapping("/app/subjects")

public class SubjectController {

    private SubjectService subjectService;
    private SubjectRepository subjectespository;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto savedSubjectDto = subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(savedSubjectDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") int id) {
        SubjectDto subjectDto = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subjectDto);
    }

    // 05/11
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SubjectDto> deleteSubjectById(@PathVariable("id") int id) {
        SubjectDto deleteSubjectDto = subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(deleteSubjectDto, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<SubjectDto>> getAllSubjects(){
        List<SubjectDto> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectDto> updateUSubject(@PathVariable int id, @RequestBody SubjectDto subjectDto) {


        Subject subjectUpdate = subjectespository.findById((long) id).orElseThrow(()-> new Exceptions("Couldnt update this subject."));


        subjectUpdate.setSubjectName(subjectUpdate.getSubjectName());
        subjectUpdate.setSubjectEvaluationType(subjectUpdate.getSubjectEvaluationType());
        subjectUpdate.setStudentsEnrolled(subjectUpdate.getStudentsEnrolled());
        subjectUpdate.setSubjectAttendance(subjectUpdate.getSubjectAttendance());

        return ResponseEntity.ok(subjectDto);
    }
}