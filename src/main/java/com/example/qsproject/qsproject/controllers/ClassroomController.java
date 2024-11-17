package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.services.ClassroomServices;
import com.example.qsproject.qsproject.services.EvaluationServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/app/classrooms")
public class ClassroomController {
    private ClassroomServices classroomServices;
    private ClassroomRepository classroomRepository;


    @PostMapping
    public ResponseEntity<ClassroomDto> createClassroom(@RequestBody ClassroomDto classroomDto) {
        ClassroomDto savedClassroomDto = classroomServices.createClassroom(classroomDto);
        return new ResponseEntity<>(savedClassroomDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable("id") long id) {
        ClassroomDto classroomDto = classroomServices.getClassroomById(id);
        return ResponseEntity.ok(classroomDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClassroomDto> deleteClassroomById(@PathVariable("id") long id) {
        ClassroomDto deleteClassroomdto = classroomServices.deleteClassroomById(id);
        return new ResponseEntity<>(deleteClassroomdto, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms(){
        List<ClassroomDto> classrooms = classroomServices.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }

}








