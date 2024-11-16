package com.example.qsproject.qsproject;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

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
                classroom.setClassroomName(numeroSala);
                classroom.setClassroomDescription(descricao);
                classroom.setClassroomType(tipoMaterial);
                classroom.setClassroomCapacity(capacidade);

                classroomRepository.save(classroom);
            }
            System.out.println("Importação concluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
