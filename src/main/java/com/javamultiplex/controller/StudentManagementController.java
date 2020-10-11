package com.javamultiplex.controller;

import com.javamultiplex.model.Student;
import com.javamultiplex.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rohit Agarwal on 26/09/20 11:53 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private final StudentService studentService;

    @Autowired
    public StudentManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        System.out.println("Inside getStudents() method");
        return studentService.getStudents();
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        System.out.println("Inside registerStudent() method");
        return studentService.registerStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        System.out.println("Inside deleteStudent() method");
        try {
            studentService.deleteStudent(studentId);
        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer studentId, @RequestBody Student updatedStudent) {
        System.out.println("Inside updateStudent() method");
        try {
            studentService.updateStudent(studentId, updatedStudent);
        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
