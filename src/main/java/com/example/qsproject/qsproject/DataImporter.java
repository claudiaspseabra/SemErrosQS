package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.services.ClassroomServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * This class is responsible for importing data into the system from a CSV file.
 */

@Component
public class DataImporter {

    /**
     * Service to handle classroom-related operations.
     */

    @Autowired
    private ClassroomServices classroomServices;


    /**
     * Method that initializes data import from a CSV file after the bean is created.
     */

    @PostConstruct
    public void runImport() {
        String csvFilePath = "./FilesForUs/filldb.csv";
        classroomServices.importCSV(csvFilePath);
    }
}
