package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Semester;
import com.example.qsproject.qsproject.Subject;
import com.example.qsproject.qsproject.User;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.SemesterMapper;
import com.example.qsproject.qsproject.mappers.SubjectMapper;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import com.example.qsproject.qsproject.services.SubjectService;
import com.example.qsproject.qsproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SubjectImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = SubjectMapper.mapToSubject(subjectDto);
        Subject saveSubject= subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDto(saveSubject);
    }

    @Override
    public SubjectDto getSubjectById(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Subject not found with this id: "+id));
        return SubjectMapper.mapToSubjectDto(subject);
    }

    @Override
    public SubjectDto deleteSubjectById(long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove subject with this id: "+id));
        subjectRepository.delete(subject);
        return SubjectMapper.mapToSubjectDto(subject);
    }



    @Override
    public List<SubjectDto> getAllSubjects(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map((subject)->SubjectMapper.mapToSubjectDto(subject))
                .collect(Collectors.toList());
    }
}
