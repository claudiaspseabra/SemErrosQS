package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.dtos.ClassroomDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<ClassroomDto,Long> {
}