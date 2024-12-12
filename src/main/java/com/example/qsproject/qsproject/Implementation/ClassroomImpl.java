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


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class implements the ClassroomServices interface, providing the logic for managing classrooms.
 * It has methods for importing data from a CSV file, retrieving classroom data, and updating classroom details.
 */


@AllArgsConstructor
public class ClassroomImpl {
    @Service

    public static class ClassroomServiceImpl implements ClassroomServices {

        @Autowired
        private ClassroomRepository classroomRepository;


        /**
         * Imports classroom data from a CSV file and saves the classrooms in the repository.
         *
         * @param filePath The path to the CSV file containing classroom data.
         */

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

        /**
         * Retrieves the classroom by its ID.
         *
         * @param id The ID of the classroom to retrieve.
         * @return A ClassroomDto object containing the classroom details.
         * @throws Exceptions if the classroom is not found.
         */

        @Override
        public ClassroomDto getClassroomById(long id) {
            Classroom classroom = classroomRepository.findById(id)
                    .orElseThrow(()-> new Exceptions("Classroom not found with this id: "+id));
            return ClassroomMapper.mapToClassroomDto(classroom);
        }


        /**
         * Retrieves all classrooms.
         *
         * @return A list of ClassroomDto objects representing all classrooms.
         */

        @Override
        public List<ClassroomDto> getAllClassrooms() {
            List<Classroom> classrooms = classroomRepository.findAll();
            return classrooms.stream()
                    .map(ClassroomMapper::mapToClassroomDto)
                    .collect(Collectors.toList());
        }


        /**
         * Updates the details of an existing classroom.
         *
         * @param classroomId The ID of the classroom to update.
         * @param updatedClassroom The ClassroomDto containing the updated classroom details.
         * @return A ClassroomDto object containing the updated classroom details.
         * @throws Exceptions if the classroom is not found.
         */

        @Override
        public ClassroomDto updateClassroom(long classroomId, ClassroomDto updatedClassroom) {
            Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(
                    () -> new Exceptions("User does not exist with this id: " + classroomId)
            );
            classroom.setCapacity(updatedClassroom.getCapacity());
            classroom.setTag(updatedClassroom.getTag());
            classroom.setDescription(updatedClassroom.getDescription());
            classroom.setClassroomType(updatedClassroom.getClassroomType());
            Classroom updateClassroomObj = classroomRepository.save(classroom);
            return ClassroomMapper.mapToClassroomDto(updateClassroomObj);
        }
    }

}