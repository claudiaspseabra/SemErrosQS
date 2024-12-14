package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Represents a classroom entity with properties like tag, description, type, capacity and a list of associated evaluations.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    /**
     * The unique ID of the classroom.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;

    /**
     * Unique tag of the classroom.
     */

    @Column(name = "tag", nullable = false, unique = true)
    private String tag;


    /**
     * Description of the classroom.
     */

    @Column(name = "description", nullable = false)
    private String description;


    /**
     * Type of the classroom.
     */

    @Column(name = "classroomType", nullable = false)
    private String classroomType;


    /**
     * Capacity of the classroom.
     */

    @Column(name = "capacity", nullable = false)
    private int capacity;


    /**
     * List of evaluations related to this classroom.
     */

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations = new ArrayList<>();
}
