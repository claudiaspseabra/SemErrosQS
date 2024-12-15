package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.Implementation.EvaluationImpl;
import com.example.qsproject.qsproject.dtos.EvaluationDto;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.services.EvaluationServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EvaluationImplTest {

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Mock
    private EvaluationRepository evaluationRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private EvaluationImpl evaluationImpl;

    private EvaluationDto evaluationDto;

    private Subject subject;
    private Evaluation evaluation;
    private Classroom classroom;
    private EvaluationServices evaluationServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        subject = new Subject();
        subject.setSubjectId(1L);
        subject.setStudentsEnrolled(30);

        Course course1 = new Course();
        course1.setCourseId(1L);
        course1.setCourseName("Engenharia Informática");
        Course course2 = new Course();
        course2.setCourseId(2L);
        course2.setCourseName("Engenharia e Gestão Industrial");

        subject.setCourses(course1);
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course1));
        classroom = new Classroom(1L, "301", "Sala de Aula", "Mesas", 30, new ArrayList<>());

        evaluation = new Evaluation();
        evaluation.setEvaluationId(1L);
        evaluation.setEvaluationType("Exercício Prático Individual");
        evaluation.setEvaluationWeight(20);
        evaluation.setEvaluationDate(LocalDate.of(2024, 12, 15));
        evaluation.setEvaluationtHour(LocalTime.of(10, 0,0));
        evaluation.setClassroom(classroom);
        evaluationDto = new EvaluationDto();
        evaluationDto.setSubjectId(1L);
        evaluationDto.setEvaluationType("Exercício Prático Individual");
        evaluationDto.setEvaluationWeight(20);
        evaluationDto.setEvaluationDate(LocalDate.of(2024, 12, 15));
        evaluationDto.setEvaluationHour(LocalTime.of(10, 0,0));
        evaluationDto.setClassroomId(1L);
    }

    @Test
    public void testCreateEvaluation() {
        when(subjectRepository.findById(evaluationDto.getSubjectId())).thenReturn(Optional.of(subject));
        when(classroomRepository.findById(evaluationDto.getClassroomId())).thenReturn(Optional.of(classroom));
        evaluationDto.setEvaluationId(1L);
        when(evaluationRepository.save(any(Evaluation.class))).thenReturn(evaluation);
        EvaluationDto result = evaluationImpl.createEvaluation(evaluationDto);

        assertNotNull(result);
        assertEquals(evaluationDto.getEvaluationType(), result.getEvaluationType());
        assertEquals(evaluationDto.getEvaluationWeight(), result.getEvaluationWeight());
        assertEquals(evaluationDto.getEvaluationDate(), result.getEvaluationDate());
        assertEquals(evaluationDto.getEvaluationHour(), result.getEvaluationHour());
        assertEquals(evaluationDto.getClassroomId(), result.getClassroomId());
    }



    @Test
    public void testDeleteEvaluationById() {
        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluationId(1L);
        when(evaluationRepository.findById(1L)).thenReturn(Optional.of(evaluation));
        EvaluationDto result = evaluationImpl.deleteEvaluationById(1L);

        assertEquals(1L, result.getEvaluationId());
    }

    @Test
    public void testGetEvaluationById() {
        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluationId(1L);
        when(evaluationRepository.findById(1L)).thenReturn(Optional.of(evaluation));
        EvaluationDto result = evaluationImpl.getEvaluationById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getEvaluationId());
    }

    @Test
    public void testGetAllEvaluations() {
        Evaluation evaluation1 = new Evaluation();
        evaluation1.setEvaluationId(1L);
        Evaluation evaluation2 = new Evaluation();
        evaluation2.setEvaluationId(2L);
        when(evaluationRepository.findAll()).thenReturn(List.of(evaluation1, evaluation2));
        List<EvaluationDto> result = evaluationImpl.getAllEvaluations();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getEvaluationId());
        assertEquals(2L, result.get(1).getEvaluationId());
    }


    @Test
    public void testUpdateEvaluations_Success() {
        Evaluation existingEvaluation = new Evaluation();
        existingEvaluation.setEvaluationId(1L);
        existingEvaluation.setEvaluationType("Mista");
        Evaluation updatedEvaluation = new Evaluation();
        updatedEvaluation.setEvaluationType("Continua");
        when(evaluationRepository.findById(1L)).thenReturn(Optional.of(existingEvaluation));
        when(evaluationRepository.save(existingEvaluation)).thenReturn(existingEvaluation);
        EvaluationDto result = evaluationImpl.updateEvaluations(1L, updatedEvaluation);

        assertNotNull(result);
        assertEquals("Continua", result.getEvaluationType());
        assertEquals(1L, result.getEvaluationId());
    }


    @Test
    public void testGetEvaluationsBySubjectId() {
        Evaluation evaluation1 = new Evaluation();
        evaluation1.setEvaluationId(1L);
        evaluation1.setSubject(new Subject());
        evaluation1.getSubject().setSubjectId(1L);
        Evaluation evaluation2 = new Evaluation();
        evaluation2.setEvaluationId(2L);
        evaluation2.setSubject(new Subject());
        evaluation2.getSubject().setSubjectId(1L);
        when(evaluationRepository.findBySubject_SubjectId(1L)).thenReturn(List.of(evaluation1, evaluation2));
        List<EvaluationDto> result = evaluationImpl.getEvaluationsBySubjectId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getSubjectId());
        assertEquals(1L, result.get(1).getSubjectId());
    }

}