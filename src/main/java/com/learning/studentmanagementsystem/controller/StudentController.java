package com.learning.studentmanagementsystem.controller;

import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String index(Model model) {
        model.addAttribute("students", studentService.fetchAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "new_student";
    }

    @PostMapping("/students/create")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student existing_student = studentService.findStudentById(id);
        existing_student.setFirstName(student.getFirstName());
        existing_student.setLastName(student.getLastName());
        existing_student.setEmail(student.getEmail());
        studentService.saveStudent(existing_student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
