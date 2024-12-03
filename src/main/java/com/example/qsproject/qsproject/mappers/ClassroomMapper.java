package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.ClassroomDto;

import java.util.stream.Collectors;

public class ClassroomMapper {


        public static ClassroomDto mapToClassroomDto(Classroom classroom) {
            return new ClassroomDto(
            classroom.getClassroomId(),
                    classroom.getTag(),
                    classroom.getDescription(),
                    classroom.getClassroomType(),
                    classroom.getCapacity(),
                    classroom.getEvaluations().stream()
                            .map(evaluation -> evaluation.getEvaluationId()) // Map to evaluation IDs
                            .collect(Collectors.toList()),
                    null // Add logic for classroomInUseDate if needed
        );
        }

        public static Classroom mapToClassroom(ClassroomDto classroomDto){
            Classroom classroom = new Classroom();
            classroom.setClassroomId(classroomDto.getClassroomId());
            classroom.setTag(classroomDto.getTag());
            classroom.setDescription(classroomDto.getDescription());
            classroom.setClassroomType(classroomDto.getClassroomType());
            classroom.setCapacity(classroomDto.getCapacity());
            return classroom;
        }
    }
