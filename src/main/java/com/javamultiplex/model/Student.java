package com.javamultiplex.model;

/**
 * @author Rohit Agarwal on 26/09/20 11:52 pm
 * @copyright www.javamultiplex.com
 */
public class Student {
    private final Integer studentId;
    private String studentName;

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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
