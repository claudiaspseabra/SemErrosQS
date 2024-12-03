package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Evaluation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class ClassroomDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;
    private String tag;
    private String description;
    private String classroomType;
    private int capacity;
    //@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    //@JsonManagedReference
//    private ArrayList<Evaluation> evaluations;
//    @JsonManagedReference  // Evita referências circulares no JSON
//    private List<Evaluation> evaluations;
    private Date classroomInUseDate;
}