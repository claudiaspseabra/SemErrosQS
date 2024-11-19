package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.ClassroomDto;

public class ClassroomMapper {

    public static ClassroomDto mapToClassroomDto(Classroom classroom) {
        return new ClassroomDto(
                classroom.getClassroomId(),
                classroom.getTag(),
                classroom.getDescription(),
                classroom.getClassroomType(),
                classroom.getCapacity(),
                classroom.getEvaluations(),
                classroom.getClassroomInUseDate()
        );
    }

    public static Classroom mapToClassroom(ClassroomDto classroomDto){
        return new Classroom(
                classroomDto.getClassroomId(),
                classroomDto.getTag(),
                classroomDto.getDescription(),
                classroomDto.getClassroomType(),
                classroomDto.getCapacity(),
                classroomDto.getEvaluations(),
                classroomDto.getClassroomInUseDate()
        );
    }
}


