package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.services.ClassroomServices;
import com.example.qsproject.qsproject.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/app/classrooms")
public class ClassroomController {

    private ClassroomServices classroomServices;

    @GetMapping("{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable("id") long id) {
        ClassroomDto classroomDto = classroomServices.getClassroomById(id);
        return ResponseEntity.ok(classroomDto);
    }

    @GetMapping()
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms(){
        List<ClassroomDto> classrooms = classroomServices.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }

}
