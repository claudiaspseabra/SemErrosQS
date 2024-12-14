package com.example.qsproject.qsproject.services;
import com.example.qsproject.qsproject.dtos.ClassroomDto;
import com.example.qsproject.qsproject.dtos.CourseDto;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Service interface for managing Classroom-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */


public interface ClassroomServices {

    /**
     * Imports classroom data from a CSV file and processes it into the system.
     *
     * @param csvFilePath The file path to the CSV file containing classroom data.
     */

    void importCSV(String csvFilePath);

    /**
     * Retrieves a Classroom by its unique ID.
     *
     * @param id The ID of the classroom to be retrieved.
     * @return A ClassroomDto object containing the classroom details.
     */

    ClassroomDto getClassroomById(long id);

    /**
     * Retrieves all classrooms available in the system.
     *
     * @return A list of ClassroomDto objects representing all classrooms.
     */

    List<ClassroomDto> getAllClassrooms();

    /**
     * Updates an existing classroom with new data.
     *
     * @param classroomId The ID of the classroom to be updated.
     * @param updatedClassroom A ClassroomDto containing the updated classroom information.
     * @return The updated ClassroomDto object.
     */

    ClassroomDto updateClassroom(long classroomId, ClassroomDto updatedClassroom);
}