package com.learning.studentmanagementsystem;

import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(null, "Iron", "Man", "iron_man@example.com");
        studentRepository.save(student1);

        Student student2 = new Student(null, "Tony", "Stark", "tony_stark@example.com");
        studentRepository.save(student2);

        Student student3 = new Student(null, "The", "Hulk", "the_hulk@example.com");
        studentRepository.save(student3);
    }
}
