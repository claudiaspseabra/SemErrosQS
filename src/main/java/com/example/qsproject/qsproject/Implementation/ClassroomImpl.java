package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.Classroom;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.mappers.ClassroomMapper;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.services.ClassroomServices;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomImpl implements ClassroomServices {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public void importCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Ignorar o cabeçalho
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                String numeroSala = line[0];
                String descricao = line[1];
                String tipoMaterial = line[2];
                int capacidade = Integer.parseInt(line[3]);

                // Verificar se já existe uma sala com a mesma tag
                if (classroomRepository.existsByTag(numeroSala)) {
                    System.out.println("Sala com a tag '" + numeroSala + "' já existe, ignorando inserção.");
                    continue;  // Ignorar essa sala e continuar com a próxima
                }

                // Criação da entidade Classroom
                Classroom classroom = new Classroom();
                classroom.setTag(numeroSala);
                classroom.setDescription(descricao);
                classroom.setClassroomType(tipoMaterial);
                classroom.setCapacity(capacidade);

                // Salvar a entidade Classroom no banco de dados
                classroomRepository.save(classroom);
            }
            System.out.println("Importação concluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<ClassroomDto> getAllClassrooms() {
        // Buscar todas as salas do banco de dados
        List<Classroom> classrooms = classroomRepository.findAll();

        // Converter a lista de entidades Classroom para uma lista de DTOs ClassroomDto
        return classrooms.stream()
                .map(ClassroomMapper::mapToClassroomDto)  // Usando o mapper para converter
                .collect(Collectors.toCollection(ArrayList::new));  // Força a conversão para ArrayList
    }


}
