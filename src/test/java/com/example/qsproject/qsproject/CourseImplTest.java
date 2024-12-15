package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.Implementation.CourseImpl;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.repositories.EvaluationRepository;
import com.example.qsproject.qsproject.repositories.SubjectRepository;
import com.example.qsproject.qsproject.services.EvaluationServices;
import java.util.*;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CourseImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseImpl courseService;

    @Mock
    private EvaluationServices evaluationServices;

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Mock
    private EvaluationRepository evaluationRepository;

    private Course course;
    private CourseDto courseDto;
    private Subject subject;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        course = new Course(1L, "Sistemas de Informação", 12, new ArrayList<>());
        courseDto = new CourseDto(1L, "Sistemas de Informação", 12, new ArrayList<>());

        subject = new Subject();
        subject.setSubjectId(1L);
        subject.setStudentsEnrolled(30);
    }


    @Test
    public void testCreateCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        CourseDto result = courseService.createCourse(courseDto);

        assertNotNull(result);
        assertEquals(courseDto.getCourseName(), result.getCourseName());
        assertEquals(courseDto.getCourseDuration(), result.getCourseDuration());
    }


    @Test
    public void testGetCourseById() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        CourseDto result = courseService.getCourseById(1L);

        assertNotNull(result);
        assertEquals(course.getCourseName(), result.getCourseName());
        assertEquals(course.getCourseDuration(), result.getCourseDuration());
    }

    @Test
    public void testDeleteCourseById() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        CourseDto result = courseService.deleteCourseById(1L);

        assertNotNull(result);
        assertEquals(course.getCourseName(), result.getCourseName());
        assertEquals(course.getCourseDuration(), result.getCourseDuration());
    }

    @Test
    public void testGetAllCourses() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));
        List<CourseDto> result = courseService.getAllCourses();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(course.getCourseName(), result.get(0).getCourseName());
        assertEquals(course.getCourseDuration(), result.get(0).getCourseDuration());
    }

    @Test
    public void testUpdateCourse() {
        Course updatedCourse = new Course(1L, "Sistemas de Informação para Gestão", 4, new ArrayList<>());
        CourseDto updatedCourseDto = new CourseDto(1L, "Sistemas de Informação para Gestão", 4, new ArrayList<>());
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(updatedCourse);
        CourseDto result = courseService.updateCourse(1L, updatedCourseDto);

        assertNotNull(result);
        assertEquals(updatedCourseDto.getCourseName(), result.getCourseName());
        assertEquals(updatedCourseDto.getCourseDuration(), result.getCourseDuration());
    }
}
