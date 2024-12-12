package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.*;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.mappers.SemesterMapper;
import com.example.qsproject.qsproject.mappers.SubjectMapper;
import com.example.qsproject.qsproject.mappers.UserMapper;
import com.example.qsproject.qsproject.repositories.CourseRepository;
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


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the SubjectService interface, providing logic for managing subjects.
 * It offers methods for creating, retrieving, deleting, and updating subjects in the system.
 */

@Service
@AllArgsConstructor
public class SubjectImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private CourseRepository courseRepository;


    /**
     * Creates a new subject from the provided SubjectDto.
     *
     * @param subjectDto The SubjectDto object containing the subject details.
     * @return A SubjectDto object representing the newly created subject.
     */

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = SubjectMapper.mapToSubject(subjectDto);
        Subject saveSubject = subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDto(saveSubject);
    }


    /**
     * Retrieves a subject by its ID.
     *
     * @param id The ID of the subject to retrieve.
     * @return A SubjectDto object containing the details of the requested subject.
     * @throws Exceptions if the subject is not found.
     */

    @Override
    public SubjectDto getSubjectById(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Subject not found with this id: "+id));
        return SubjectMapper.mapToSubjectDto(subject);
    }


    /**
     * Deletes a subject by its ID.
     *
     * @param id The ID of the subject to delete.
     * @return A SubjectDto object containing the details of the deleted subject.
     * @throws Exceptions if the subject is not found.
     */

    @Override
    public SubjectDto deleteSubjectById(long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove subject with this id: "+id));
        subjectRepository.delete(subject);
        return SubjectMapper.mapToSubjectDto(subject);
    }


    /**
     * Retrieves all subjects in the system.
     *
     * @return A list of SemesterDto objects representing all subjects.
     */

    @Override
    public List<SubjectDto> getAllSubjects(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map((subject)->SubjectMapper.mapToSubjectDto(subject))
                .collect(Collectors.toList());
    }


    /**
     * Updates the details of an existing subject.
     *
     * @param subjectId The ID of the subject to update.
     * @param updatedSubject The SubjectDto object containing the updated subject details.
     * @return A SubjectDto object containing the updated subject details.
     * @throws Exceptions if the subject is not found.
     */

    @Override
    public SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubject) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new Exceptions("Subject does not exist with this id: "+subjectId)
        );

        subject.setSubjectName(updatedSubject.getSubjectName());
        subject.setStudentsEnrolled(updatedSubject.getStudentsEnrolled());
        subject.setSubjectEvaluationType(updatedSubject.getSubjectEvaluationType());
        subject.setSubjectAttendance(updatedSubject.getSubjectAttendance());
        subject.setSubjectYear(updatedSubject.getSubjectYear());
        subject.setSubjectSemester(updatedSubject.getSubjectSemester());

        Subject updatedSubjectObj = subjectRepository.save(subject);

        return SubjectMapper.mapToSubjectDto(updatedSubjectObj);
    }
}
