package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.mappers.ClassroomMapper;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.services.ClassroomServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassroomImpl implements ClassroomServices {

    private ClassroomRepository classroomRepository;

    @Override
    public ClassroomDto createClassroom(ClassroomDto classroomDto) {
        Classroom classroom = ClassroomMapper.mapToClassroom(classroomDto);
        Classroom saveClassroom = classroomRepository.save(classroom);
        return ClassroomMapper.mapToClassroomDto(saveClassroom);
    }


    @Override
    public ClassroomDto getClassroomById(long id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Classroom not found with this id: "+id));
        return ClassroomMapper.mapToClassroomDto(classroom);
    }


    @Override
    public ClassroomDto deleteClassroomById(long id){
        Classroom classroom = classroomRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove classroom with this id: "+id));
        classroomRepository.delete(classroom);
        return ClassroomMapper.mapToClassroomDto(classroom);
    }


    @Override
    public List<ClassroomDto> getAllClassrooms(){
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream().map((classroom)->ClassroomMapper.mapToClassroomDto(classroom))
                .collect(Collectors.toList());
    }

}