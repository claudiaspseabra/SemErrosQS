package com.example.qsproject.qsproject.dtos;

import com.example.qsproject.qsproject.Evaluation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    private Date classroomInUseDate;
}