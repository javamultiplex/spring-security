package com.javamultiplex.model;

/**
 * @author Rohit Agarwal on 26/09/20 11:52 pm
 * @copyright www.javamultiplex.com
 */
public class Student {
    private final Integer studentId;
    private final String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
