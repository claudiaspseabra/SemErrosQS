package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.ClassroomDto;

import java.util.stream.Collectors;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class transforms Classroom entities into ClassroomDto objects and vice versa.
 */

public class ClassroomMapper {


    /**
     * Converts a Classroom entity to a ClassroomDto.
     *
     * @param classroom The Classroom entity to be converted.
     * @return A ClassroomDto object with data mapped from the Classroom entity.
     */

    public static ClassroomDto mapToClassroomDto(Classroom classroom) {
        return new ClassroomDto(
                classroom.getClassroomId(),
                classroom.getTag(),
                classroom.getDescription(),
                classroom.getClassroomType(),
                classroom.getCapacity(),
                classroom.getEvaluations().stream()
                        .map(evaluation -> evaluation.getEvaluationId()) // Map to evaluation IDs
                        .collect(Collectors.toList())// Add logic for classroomInUseDate if needed
        );
    }


    /**
     * Converts a ClassroomDto to a Classroom entity.
     *
     * @param classroomDto The ClassroomDto to be converted.
     * @return A Classroom entity with data mapped from the ClassroomDto.
     */

    public static Classroom mapToClassroom(ClassroomDto classroomDto) {
        Classroom classroom = new Classroom();
        classroom.setClassroomId(classroomDto.getClassroomId());
        classroom.setTag(classroomDto.getTag());
        classroom.setDescription(classroomDto.getDescription());
        classroom.setClassroomType(classroomDto.getClassroomType());
        classroom.setCapacity(classroomDto.getCapacity());
        return classroom;
    }
}
