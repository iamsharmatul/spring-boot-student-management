package com.learning.studentmanagementsystem.service;

import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    List<Student> fetchAllStudents();

    Student saveStudent(Student student);

    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
