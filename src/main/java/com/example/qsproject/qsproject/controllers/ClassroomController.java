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

/**
 * @version 1.0
 * @author Sem Erros
 */


/**
 * This class is responsible for handling classroom requests.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/app/classrooms")
public class ClassroomController {

    private ClassroomServices classroomServices;


    /**
     * Fetches a specific classroom by its ID.
     *
     * @param id The unique identifier of the classroom.
     * @return A ResponseEntity containing the ClassroomDto
     */

    @GetMapping("{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable("id") long id) {
        ClassroomDto classroomDto = classroomServices.getClassroomById(id);
        return ResponseEntity.ok(classroomDto);
    }


    /**
     * Fetches all the classrooms registered.
     * @return A ResponseEntity containing a list of ClassroomDto objects.
     */

    @GetMapping()
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms(){
        List<ClassroomDto> classrooms = classroomServices.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }
}
