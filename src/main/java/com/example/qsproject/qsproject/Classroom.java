package com.example.qsproject.qsproject;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

// test
@Getter
@Setter
//TESTE
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;
    @Column(name = "classroomName",nullable = false,unique = true)
    private String classroomName;
    @Column(name="classroomDescription",nullable = false)
    private String classroomDescription;
    @Column(name = "classroomType",nullable = false)
    private String classroomType;
    @Column(name = "classroomCapacity",nullable = false)
    private int classroomCapacity;
    @Column(name = "classroomInUseDate",nullable = true)
    private Date classroomInUseDate;

    public Classroom(int classroomId, String classroomName, String classroomDescription, String classroomType, int classroomCapacity, Date classroomInUseDate) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.classroomDescription = classroomDescription;
        this.classroomType = classroomType;
        this.classroomCapacity = classroomCapacity;
        this.classroomInUseDate = classroomInUseDate;
    }
    public Classroom(){}

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomDescription() {
        return classroomDescription;
    }

    public void setClassroomDescription(String classroomDescription) {
        this.classroomDescription = classroomDescription;
    }

    public String getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(String classroomType) {
        this.classroomType = classroomType;
    }

    public int getClassroomCapacity() {
        return classroomCapacity;
    }

    public void setClassroomCapacity(int classroomCapacity) {
        this.classroomCapacity = classroomCapacity;
    }

    public Date getClassroomInUseDate() {
        return classroomInUseDate;
    }

    public void setClassroomInUseDate(Date classroomInUseDate) {
        this.classroomInUseDate = classroomInUseDate;
    }
}