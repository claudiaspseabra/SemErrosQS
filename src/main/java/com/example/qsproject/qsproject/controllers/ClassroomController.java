package com.example.qsproject.qsproject.controllers;

import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.services.ClassroomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/app/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomServices classroomServices;

    @GetMapping
    public ResponseEntity<?> getAllClassrooms() {
        try {
            ArrayList<ClassroomDto> classrooms = classroomServices.getAllClassrooms();
            return ResponseEntity.ok(classrooms);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
