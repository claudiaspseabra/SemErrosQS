package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.mappers.SubjectMapper;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubject) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new Exceptions("Subject does not exist with this id: "+subjectId)
        );

        subject.setSubjectName(updatedSubject.getSubjectName());
        subject.setStudentsEnrolled(updatedSubject.getStudentsEnrolled());
        subject.setSubjectEvaluationType(updatedSubject.getSubjectEvaluationType());
        subject.setSubjectAttendance(updatedSubject.getSubjectAttendance());

        Subject updatedSubjectObj = subjectRepository.save(subject);

        return SubjectMapper.mapToSubjectDto(updatedSubjectObj);
    }

    @Override
    public SubjectDto updateSubject(long subjectId, SubjectDto updateSubject) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new Exceptions("User does not exist with this id: " + subjectId)
        );

        subject.setCourses(updateSubject.getCourses());
        subject.setSubjectName(updateSubject.getSubjectName());
        subject.setSubjectAttendance(updateSubject.getSubjectAttendance());
        //subject.setEvaluations(updateSubject.getEvaluations());

        subject.setStudentsEnrolled(updateSubject.getStudentsEnrolled());
        subject.setSubjectEvaluationType(updateSubject.getSubjectEvaluationType());




        Subject updateSubjectObj = subjectRepository.save(subject);

        return SubjectMapper.mapToSubjectDto(updateSubjectObj);
    }

}
