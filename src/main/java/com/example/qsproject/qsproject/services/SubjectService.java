package com.example.qsproject.qsproject.services;

import com.example.qsproject.qsproject.dtos.SubjectDto;
import com.example.qsproject.qsproject.dtos.UsersDto;

import java.util.List;

/**
 * @version 1.0
 * @author Group 6
 */

/**
 * Service interface for managing Subject-related operations.
 * Provides methods to import data, retrieve, and update classroom information.
 */


public interface SubjectService {


    /**
     * Creates a new subject and returns the details of the created subject.
     *
     * @param subjectDto A SubjectDto object containing the subject data to be created.
     * @return The created SubjectDto object with the subject details.
     */

    SubjectDto createSubject(SubjectDto subjectDto);


    /**
     * Retrieves a subject by its ID.
     *
     * @param id The ID of the subject to be retrieved.
     * @return The SubjectDto object containing the details of the requested subject.
     */

    SubjectDto getSubjectById(long id);


    /**
     * Deletes a subject by its ID.
     *
     * @param id The ID of the subject to be deleted.
     * @return The deleted SubjectDto object.
     */

    SubjectDto deleteSubjectById(long id);


    /**
     * Retrieves all subjects available in the system.
     *
     * @return A list of all SubjectDto objects representing the available subjects.
     */

    List<SubjectDto> getAllSubjects();


    /**
     * Updates an existing subject with the new data.
     *
     * @param subjectId The ID of the subject to be updated.
     * @param updatedSubject A SubjectDto object containing the updated subject data.
     * @return The updated SubjectDto object with the new data.
     */

    SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubject);
}
