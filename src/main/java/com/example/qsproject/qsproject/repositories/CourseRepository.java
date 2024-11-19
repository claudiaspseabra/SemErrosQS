package com.example.qsproject.qsproject.repositories;

import com.example.qsproject.qsproject.Course;
import org.springframework.data.jpa.repository.JpaRepository;


// Isto faz com que o User tenha os métodos CRUD (create ,read ,update,delete)
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
