package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.Course;
import com.example.qsproject.qsproject.Exceptions;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.mappers.ClassroomMapper;
import com.example.qsproject.qsproject.mappers.CourseMapper;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.services.ClassroomServices;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ClassroomImpl {
    @Service

    public static class ClassroomServiceImpl implements ClassroomServices {

        @Autowired
        private ClassroomRepository classroomRepository;

        @Override
        public void importCSV(String filePath) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] line;

                reader.readNext();

                while ((line = reader.readNext()) != null) {
                    String numeroSala = line[0];
                    String descricao = line[1];
                    String tipoMaterial = line[2];
                    int capacidade = Integer.parseInt(line[3]);


                    Classroom classroom = new Classroom();
                    classroom.setTag(numeroSala);
                    classroom.setDescription(descricao);
                    classroom.setClassroomType(tipoMaterial);
                    classroom.setCapacity(capacidade);

                    if (!classroomRepository.existsByTag(numeroSala)) {
                        classroomRepository.save(classroom);
                        System.out.println("Sala " + numeroSala + " importada com sucesso.");
                    } else {

                        System.out.println("Sala " + numeroSala + " já existe, não será importada.");
                    }
                }
                System.out.println("Importação concluída com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public ClassroomDto getClassroomById(long id) {
            Classroom classroom = classroomRepository.findById(id)
                    .orElseThrow(()-> new Exceptions("Classroom not found with this id: "+id));
            return ClassroomMapper.mapToClassroomDto(classroom);
        }

        @Override
        public List<ClassroomDto> getAllClassrooms() {
            List<Classroom> classrooms = classroomRepository.findAll();
            return classrooms.stream()
                    .map(ClassroomMapper::mapToClassroomDto)
                    .collect(Collectors.toList());
        }


    }

}