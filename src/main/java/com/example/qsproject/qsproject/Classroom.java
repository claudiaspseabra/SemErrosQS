package com.example.qsproject.qsproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    //classe classroom

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;

    @Column(name = "tag", nullable = false, unique = true)
    private String tag;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "classroomType", nullable = false)
    private String classroomType;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    // Bidirectional mapping to Evaluation
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // Avoid circular references in serialization
    private List<Evaluation> evaluations = new ArrayList<>();
}
