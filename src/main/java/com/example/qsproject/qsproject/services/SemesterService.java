package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.CourseDto;
import com.example.qsproject.qsproject.dtos.SemesterDto;

import java.util.ArrayList;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Service interface for managing Semester-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */

public interface SemesterService {

    /**
     * Creates a new semester and returns the details of the created semester.
     *
     * @param semesterDto A SemesterDto object containing the semester data to be created.
     * @return The created SemesterDto object with the semester details.
     */

    SemesterDto createSemester(SemesterDto semesterDto);


    /**
     * Retrieves a semester by its ID.
     *
     * @param id The ID of the semester to be retrieved.
     * @return The SemesterDto object containing the details of the requested semester.
     */

    SemesterDto getSemesterById(long id);

    /**
     * Deletes a semester by its unique ID.
     *
     * @param id The ID of the semester to be deleted.
     * @return The deleted SemesterDto object.
     */

    SemesterDto deleteSemesterById(long id);


    /**
     * Retrieves all semesters available in the system.
     *
     * @return A list of all SemesterDto objects representing the available semesters.
     */

    ArrayList<SemesterDto> getAllSemesters();


    /**
     * Updates an existing semester with the new data.
     *
     * @param semesterId The ID of the semester to be updated.
     * @param updatedSemester A SemesterDto object containing the updated semester data.
     * @return The updated SemesterDto object with the new data.
     */

    SemesterDto updateSemester(Long semesterId, SemesterDto updatedSemester);
}
