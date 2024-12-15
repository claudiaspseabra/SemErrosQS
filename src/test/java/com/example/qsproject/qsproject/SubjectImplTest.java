package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.Implementation.SubjectImpl;
import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class SubjectImplTest {

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private SubjectImpl subjectService;

    private SubjectDto subjectDto;

    @BeforeEach
    public void setUp() {
        subjectDto = new SubjectDto(1L, "Sistemas Operativos", 1L, new ArrayList<>(), 100, "Mista", "S", 2, 1);
    }

    @Test
    public void testCreateSubject() {
        Course course = new Course();
        course.setCourseDuration(4);
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(subjectRepository.save(any())).thenReturn(new Subject());
        subjectDto.setSubjectYear(2);
        SubjectDto createdSubject = subjectService.createSubject(subjectDto);

        assertNotNull(createdSubject, "SubjectDto must be created");
    }


    @Test
    public void testGetSubjectById() {
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(new Subject()));
        SubjectDto retrievedSubject = subjectService.getSubjectById(1L);

        assertNotNull(retrievedSubject, "SubjectDto must be returned");
    }


    @Test
    public void testGetAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject());
        subjects.add(new Subject());
        when(subjectRepository.findAll()).thenReturn(subjects);
        List<SubjectDto> allSubjects = subjectService.getAllSubjects();

        assertNotNull(allSubjects, "Subjects list cannot be null");
        assertEquals(2, allSubjects.size(), "Must return 2 objects");
    }


    @Test
    public void testDeleteSubjectById() {
        Subject subject = new Subject();
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));
        SubjectDto deletedSubject = subjectService.deleteSubjectById(1L);

        assertNotNull(deletedSubject, "SubjectDto cannot be null");
    }


    @Test
    public void testUpdateSubject() {
        Subject subject = new Subject();
        subject.setSubjectEvaluationType("Continua");
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));
        when(subjectRepository.save(any())).thenReturn(subject);
        SubjectDto updatedSubjectDto = new SubjectDto(1L, "Sistemas Operativos", 1L, new ArrayList<>(), 100, "Mista", "S", 2, 1);
        SubjectDto updatedSubject = subjectService.updateSubject(1L, updatedSubjectDto);

        assertNotNull(updatedSubject, "SubjectDto updated cannot be null");
        assertEquals("Mista", updatedSubject.getSubjectEvaluationType(), "Evaluation type must be updated");
    }
}