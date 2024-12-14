package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.mappers.SubjectMapper;
import com.example.qsproject.qsproject.repositories.CourseRepository;
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



/**
 * @version 1.0
 * @author Sem Erros
 */


/**
 * This class is responsible for managing the requests of the subjects.
 * It has CRUD methods.
 */


@AllArgsConstructor
@RestController
@RequestMapping("/app/subjects")

public class SubjectController {

    private SubjectService subjectService;
    private CourseRepository courseRepository;
    private SubjectRepository subjectespository;

    /**
     * This method is used to create a new subject.
     *
     * @param subjectDto The details of the subject to be created.
     * @return A ResponseEntity with the created subject and status 201.
     */

    @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody SubjectDto subjectDto) {
        if (subjectDto.getSubjectAttendance() != null && !"sim".equalsIgnoreCase(subjectDto.getSubjectAttendance()) && !"nao".equalsIgnoreCase(subjectDto.getSubjectAttendance())) {
            return ResponseEntity.badRequest().body("Attendance must be 'sim' or 'nao'");
        }

        SubjectDto savedSubjectDto = subjectService.createSubject(subjectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubjectDto);
    }



    /**
     * This method gets a specific subject by its ID.
     *
     * @param id The ID of the subject.
     * @return A ResponseEntity with the subject details.
     */

    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") int id) {
        SubjectDto subjectDto = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subjectDto);
    }


    /**
     * This method deletes a subject by its ID.
     *
     * @param id The ID of the subject to be deleted.
     * @return A ResponseEntity with the deleted subject.
     */

    @DeleteMapping("{id}")
    public ResponseEntity<SubjectDto> deleteSubjectById(@PathVariable("id") int id) {
        SubjectDto deleteSubjectDto = subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(deleteSubjectDto, HttpStatus.OK);
    }


    /**
     * This method gets all the subjects.
     *
     * @return A ResponseEntity with a list of all subjects.
     */

    @GetMapping()
    public ResponseEntity<List<SubjectDto>> getAllSubjects(){
        List<SubjectDto> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }


    /**
     * Updates an existing subject based on the provided ID and new subject data.
     *
     * @param subjectId The ID of the subject to be updated.
     * @param updatedSubject The data transfer object containing the updated subject information.
     * @return A ResponseEntity containing the updated SubjectDto.
     */

    @PutMapping("{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable("id") long subjectId,@RequestBody SubjectDto updatedSubject){
        SubjectDto subjectDto = subjectService.updateSubject(subjectId,updatedSubject);
        return ResponseEntity.ok(subjectDto);
    }
}