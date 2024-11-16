package com.example.qsproject.qsproject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataImporter {

    @Autowired
    private ClassroomService classroomService;

    @PostConstruct
    public void runImport() {
        String csvFilePath = "./FilesForUs/filldb.csv";
        classroomService.importCSV(csvFilePath);
    }
}
