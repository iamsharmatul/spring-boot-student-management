package com.learning.studentmanagementsystem.repository;

import com.learning.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
