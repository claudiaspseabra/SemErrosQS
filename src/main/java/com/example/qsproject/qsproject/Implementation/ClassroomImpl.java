package com.example.qsproject.qsproject.Implementation;

import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.repositories.ClassroomRepository;
import com.example.qsproject.qsproject.services.ClassroomServices;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileReader;
public class ClassroomImpl {
    @Service
    public static class ClassroomServiceImpl implements ClassroomServices {
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
                    // Criação da entidade Classroom
                    ClassroomDto classroom = new ClassroomDto();
                    classroom.setTag(numeroSala);
                    classroom.setDescription(descricao);
                    classroom.setClassroomType(tipoMaterial);
                    classroom.setCapacity(capacidade);
                    // Salvar no banco de dados
                    classroomRepository.save(classroom);
                }
                System.out.println("Importação concluída com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}