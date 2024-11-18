package com.example.qsproject.qsproject;

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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @Column(name = "courseName",unique = true,nullable = false)
    private String courseName;

    /*
    @Column(name = "years" , nullable = false)
    private int years;
*/

    @OneToMany(mappedBy = "courses" , cascade = CascadeType.ALL)
    private List<Subject> subjects;

}
