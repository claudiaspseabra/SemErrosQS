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

@Service
@AllArgsConstructor
public class SemesterImpl implements SemesterService {
    private SemesterRepository semesterRepository;

    @Override
    public SemesterDto createSemester(SemesterDto semesterDto) {
        Semester semester = SemesterMapper.mapToSemester(semesterDto);
        Semester saveSemester = semesterRepository.save(semester);
        return SemesterMapper.mapToSemesterDto(saveSemester);
    }


    @Override
    public SemesterDto getSemesterById(long id) {
        Semester semester = semesterRepository.findById(id)
                .orElseThrow(()-> new Exceptions("Semester not found with this id: "+id));
        return SemesterMapper.mapToSemesterDto(semester);
    }


    @Override
    public SemesterDto deleteSemesterById(long id){
        Semester semester = semesterRepository.findById(id).orElseThrow(()-> new Exceptions("Couldnt remove semester with this id: "+id));
        semesterRepository.delete(semester);
        return SemesterMapper.mapToSemesterDto(semester);
    }


    @Override
    public ArrayList<SemesterDto> getAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesters.stream()
                .map(semester -> SemesterMapper.mapToSemesterDto(semester))
                .collect(Collectors.toCollection(ArrayList::new));
    }

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



