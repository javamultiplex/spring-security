package com.javamultiplex.service;

import com.javamultiplex.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohit Agarwal on 11/10/20 5:47 pm
 * @copyright www.javamultiplex.com
 */
@Service
public class StudentService {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Rohit Agarwal"));
        students.add(new Student(2, "Bhavna Agarwal"));
        students.add(new Student(3, "Shivani Agarwal"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(Integer studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + studentId + " not found"));
    }

    public Student registerStudent(Student student) {
        int studentsCount = students.size();
        Student newStudent = new Student(studentsCount + 1, student.getStudentName());
        students.add(newStudent);
        return newStudent;
    }

    public void deleteStudent(Integer studentId) {
        Student student = getStudent(studentId);
        students.remove(student);
        System.out.println("Successfully deleted student with id : " + studentId);
    }

    public void updateStudent(Integer studentId, Student updatedStudent) {
        Student student = getStudent(studentId);
        student.setStudentName(updatedStudent.getStudentName());
        System.out.println("Successfully updated student with id : " + studentId);
    }
}
