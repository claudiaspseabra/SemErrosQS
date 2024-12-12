package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.Semester;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.mappers.CourseMapper;
import com.example.qsproject.qsproject.mappers.SemesterMapper;
import com.example.qsproject.qsproject.repositories.SemesterRepository;
import com.example.qsproject.qsproject.services.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the SemesterService interface, providing logic for managing semesters.
 * It offers methods for creating, retrieving, deleting, and updating semesters in the system.
 */

@Service
@AllArgsConstructor
public class SemesterImpl implements SemesterService {
    private SemesterRepository semesterRepository;

    /**
     * Creates a new semester from the provided SemesterDto.
     *
     * @param semesterDto The SemesterDto object containing the semester details.
     * @return A CourseDto object representing the newly created semester.
     */

    @Override
    public SemesterDto createSemester(SemesterDto semesterDto) {
        Semester semester = SemesterMapper.mapToSemester(semesterDto);
        Semester saveSemester = semesterRepository.save(semester);
        return SemesterMapper.mapToSemesterDto(saveSemester);
    }


    /**
     * Retrieves a semester by its ID.
     *
     * @param id The ID of the semester to retrieve.
     * @return A SemesterDto object containing the details of the requested semester.
     * @throws Exceptions if the semester is not found.
     */

    @Override
    public SemesterDto getSemesterById(long id) {
        Semester semester = semesterRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Semester not found with this id: "+id));
        return SemesterMapper.mapToSemesterDto(semester);
    }


    /**
     * Deletes a semester by its ID.
     *
     * @param id The ID of the semester to delete.
     * @return A SemesterDto object containing the details of the deleted semester.
     * @throws Exceptions if the semester is not found.
     */

    @Override
    public SemesterDto deleteSemesterById(long id){
        Semester semester = semesterRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove semester with this id: "+id));
        semesterRepository.delete(semester);
        return SemesterMapper.mapToSemesterDto(semester);
    }


    /**
     * Retrieves all semesters in the system.
     *
     * @return A list of SemesterDto objects representing all semesters.
     */

    @Override
    public ArrayList<SemesterDto> getAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesters.stream()
                .map(semester -> SemesterMapper.mapToSemesterDto(semester))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Updates the details of an existing semester.
     *
     * @param semesterId The ID of the semester to update.
     * @param updatedSemester The SemesterDto object containing the updated semester details.
     * @return A SemesterDto object containing the updated semester details.
     * @throws Exceptions if the semester is not found.
     */

    @Override
    public SemesterDto updateSemester(Long semesterId, SemesterDto updatedSemester) {
        Semester semester = semesterRepository.findById(semesterId).orElseThrow(
                () -> new Exceptions("Semester does not exist with this id: "+semesterId)
        );

        semester.setStartSemester(updatedSemester.getEndSemester());
        semester.setEndSemester(updatedSemester.getEndSemester());

        Semester updatedSemesterObj = semesterRepository.save(semester);

        return SemesterMapper.mapToSemesterDto(updatedSemesterObj);
    }

}



