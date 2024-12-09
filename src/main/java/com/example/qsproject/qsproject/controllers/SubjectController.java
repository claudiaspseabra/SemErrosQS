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

// to do
@AllArgsConstructor
@RestController
@RequestMapping("/app/subjects")

public class SubjectController {

    private SubjectService subjectService;
    private CourseRepository courseRepository;
    private SubjectRepository subjectespository;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto savedSubjectDto = subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(savedSubjectDto, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
//        // Encontra o curso pelo ID
//        Course course = courseRepository.findById(subjectDto.getCourses().getCourseId())
//                .orElseThrow(() -> new RuntimeException("Course not found"));
//
//        // Cria o Subject
//        Subject subject = new Subject();
//        subject.setSubjectName(subjectDto.getSubjectName());
//        subject.setStudentsEnrolled(subjectDto.getStudentsEnrolled());
//        subject.setSubjectEvaluationType(subjectDto.getSubjectEvaluationType());
//        subject.setSubjectAttendance(subjectDto.getSubjectAttendance());
//        subject.setCourses(course);  // Associa o Subject ao Course
//
//        // Salva o Subject no banco
//        subjectespository.save(subject);
//
//        return new ResponseEntity<>(SubjectMapper.mapToSubjectDto(subject), HttpStatus.CREATED);
//    }


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


    @PutMapping("{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable("id") long subjectId,@RequestBody SubjectDto updatedSubject){
        SubjectDto subjectDto = subjectService.updateSubject(subjectId,updatedSubject);
        return ResponseEntity.ok(subjectDto);
    }

}