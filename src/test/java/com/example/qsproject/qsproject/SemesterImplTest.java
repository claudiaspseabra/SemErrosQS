package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.dtos.SemesterDto;
import com.example.qsproject.qsproject.Implementation.SemesterImpl;
import com.example.qsproject.qsproject.repositories.SemesterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SemesterImplTest {

    @Mock
    private SemesterRepository semesterRepository;

    @InjectMocks
    private SemesterImpl semesterService;

    private SemesterDto semesterDto;

    @BeforeEach
    void setUp() {
        semesterDto = new SemesterDto();
        semesterDto.setStartSemester(new Date(2023, 1, 1));
        semesterDto.setEndSemester(new Date(2023, 6, 30));
        semesterDto.setSpecialExamStart(new Date(2023, 6, 10));
        semesterDto.setSpecialExamEnd(new Date(2023, 6, 15));
        semesterDto.setNormalSeasonStart(new Date(2023, 5, 15));
        semesterDto.setNormalSeasonEnd(new Date(2023, 5, 30));
        semesterDto.setRecoverySeasonStart(new Date(2023, 7, 1));
        semesterDto.setRecoverySeasonEnd(new Date(2023, 7, 5));
    }

    @Test
    void testCreateSemester() {
        Semester savedSemester = new Semester();
        savedSemester.setStartSemester(semesterDto.getStartSemester());
        savedSemester.setEndSemester(semesterDto.getEndSemester());
        when(semesterRepository.save(any(Semester.class))).thenReturn(savedSemester);
        SemesterDto result = semesterService.createSemester(semesterDto);

        assertNotNull(result);
        assertEquals(semesterDto.getStartSemester(), result.getStartSemester());
        assertEquals(semesterDto.getEndSemester(), result.getEndSemester());
    }

    @Test
    void testGetSemesterById() {
        Semester semester = new Semester();
        semester.setStartSemester(semesterDto.getStartSemester());
        semester.setEndSemester(semesterDto.getEndSemester());
        when(semesterRepository.findById(1L)).thenReturn(Optional.of(semester));
        SemesterDto result = semesterService.getSemesterById(1L);

        assertNotNull(result);
        assertEquals(semesterDto.getStartSemester(), result.getStartSemester());
        assertEquals(semesterDto.getEndSemester(), result.getEndSemester());
    }

    @Test
    void testDeleteSemesterById() {
        Semester semester = new Semester();
        semester.setStartSemester(semesterDto.getStartSemester());
        semester.setEndSemester(semesterDto.getEndSemester());
        when(semesterRepository.findById(1L)).thenReturn(Optional.of(semester));
        SemesterDto result = semesterService.deleteSemesterById(1L);

        assertNotNull(result);
        assertEquals(semesterDto.getStartSemester(), result.getStartSemester());
        assertEquals(semesterDto.getEndSemester(), result.getEndSemester());
    }


    @Test
    void testGetAllSemesters() {
        Semester semester1 = new Semester();
        semester1.setStartSemester(semesterDto.getStartSemester());
        semester1.setEndSemester(semesterDto.getEndSemester());
        Semester semester2 = new Semester();
        semester2.setStartSemester(new Date(2023, 9, 1));
        semester2.setEndSemester(new Date(2023, 12, 31));
        List<Semester> semesters = List.of(semester1, semester2);
        when(semesterRepository.findAll()).thenReturn(semesters);
        ArrayList<SemesterDto> result = semesterService.getAllSemesters();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(semester1.getStartSemester(), result.get(0).getStartSemester());
        assertEquals(semester2.getStartSemester(), result.get(1).getStartSemester());
    }

    @Test
    void testUpdateSemester() {
        Semester semester = new Semester();
        semester.setStartSemester(new Date(2023, 8, 1));
        semester.setEndSemester(new Date(2023, 12, 31));

        SemesterDto updatedSemesterDto = new SemesterDto();
        updatedSemesterDto.setStartSemester(new Date(2023, 8, 1));
        updatedSemesterDto.setEndSemester(new Date(2023, 12, 31));

        when(semesterRepository.findById(1L)).thenReturn(Optional.of(semester));
        Semester updatedSemester = new Semester();
        updatedSemester.setStartSemester(updatedSemesterDto.getStartSemester());
        updatedSemester.setEndSemester(updatedSemesterDto.getEndSemester());
        when(semesterRepository.save(any(Semester.class))).thenReturn(updatedSemester);
        SemesterDto result = semesterService.updateSemester(1L, updatedSemesterDto);

        assertNotNull(result);
        assertEquals(updatedSemesterDto.getStartSemester(), result.getStartSemester());
        assertEquals(updatedSemesterDto.getEndSemester(), result.getEndSemester());
    }

}