package com.example.demisoda;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private String studentId;
    private String studentName;
    private ArrayList<String> lectureIdList;

    public Student(String studentName)
    {
        this.studentName = studentName;
    }

    public Student(String studentId, String studentName, ArrayList<String> lectureList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lectureIdList = lectureList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<String> getLectureIdList() {
        return lectureIdList;
    }

    public void setLectureIdList(ArrayList<String> lectureIdList) {
        this.lectureIdList = lectureIdList;
    }
}
