package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.0
 * @author Group 6
 */

/**
 * Represents a course entity with properties like course name, duration, and related subjects.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "courses")
public class Course {

    /**
     * The unique ID of the course.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;


    /**
     * Name of the course (unique).
     */

    @Column(name = "courseName",unique = true,nullable = false)
    private String courseName;


    /**
     * Duration of the course.
     */

    @Column(name = "courseDuration",nullable = false)
    private int courseDuration;


    /**
     * List of subjects related to this course.
     */

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Subject> subjects;
}
