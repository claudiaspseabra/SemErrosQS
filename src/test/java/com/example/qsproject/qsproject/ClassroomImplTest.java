package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.Implementation.ClassroomImpl;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassroomImplTest {

    @Mock
    private ClassroomRepository classroomRepository;

    @InjectMocks
    private ClassroomImpl.ClassroomServiceImpl classroomService;

    private Classroom classroom;
    private ClassroomDto classroomDto;

    @BeforeEach
    void setUp() {
        classroom = new Classroom();
        classroom.setTag("209");
        classroom.setDescription("Sala de Aula");
        classroom.setClassroomType("Mesas");
        classroom.setCapacity(60);
        classroomDto = new ClassroomDto();
        classroomDto.setTag("301");
        classroomDto.setDescription("Sala de Aula");
        classroomDto.setClassroomType("Mesas");
        classroomDto.setCapacity(60);
    }

    @Test
    void testGetClassroomById() {
        when(classroomRepository.findById(anyLong())).thenReturn(Optional.of(classroom));
        ClassroomDto result = classroomService.getClassroomById(1L);

        assertNotNull(result);
        assertEquals(classroom.getTag(), result.getTag());
        assertEquals(classroom.getDescription(), result.getDescription());
        assertEquals(classroom.getClassroomType(), result.getClassroomType());
        assertEquals(classroom.getCapacity(), result.getCapacity());
    }


    @Test
    void testGetAllClassrooms() {
        when(classroomRepository.findAll()).thenReturn(List.of(classroom));
        List<ClassroomDto> result = classroomService.getAllClassrooms();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(classroom.getTag(), result.get(0).getTag());
        assertEquals(classroom.getDescription(), result.get(0).getDescription());
        assertEquals(classroom.getClassroomType(), result.get(0).getClassroomType());
        assertEquals(classroom.getCapacity(), result.get(0).getCapacity());
    }

    @Test
    void testUpdateClassroom() {
        when(classroomRepository.findById(anyLong())).thenReturn(Optional.of(classroom));
        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);
        classroomDto.setCapacity(50);
        ClassroomDto result = classroomService.updateClassroom(1L, classroomDto);

        assertNotNull(result);
        assertEquals(50, result.getCapacity());
        assertEquals(classroomDto.getTag(), result.getTag());
        assertEquals(classroomDto.getDescription(), result.getDescription());
        assertEquals(classroomDto.getClassroomType(), result.getClassroomType());
    }
}
