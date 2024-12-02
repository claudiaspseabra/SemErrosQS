package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.services.ClassroomServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataImporter {

    @Autowired
    private ClassroomServices classroomServices;

    @PostConstruct
    public void runImport() {
        String csvFilePath = "./FilesForUs/filldb.csv";
        classroomServices.importCSV(csvFilePath);
    }
}
