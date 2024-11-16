package com.example.qsproject.qsproject.mappers;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

public class ClassroomMapper {

    public static ClassroomDto mapToClassroomDto(Classroom classroom) {
        return new ClassroomDto(
                classroom.getClassroomId(),
                classroom.getCapacity(),
                classroom.isComputers(),
                classroom.getEvaluations()
        );
    }

    public static Classroom mapToClassroom(ClassroomDto classroomDto){
        return new Classroom(
                classroomDto.getClassroomId(),
                classroomDto.getCapacity(),
                classroomDto.isComputers(),
                classroomDto.getEvaluations()
        );
    }
}


