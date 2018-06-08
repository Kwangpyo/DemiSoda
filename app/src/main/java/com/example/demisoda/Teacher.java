package com.example.demisoda;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable {

    private String teahcerId;
    private String teacherName;
    private ArrayList<Lecture> lectureList;

    public Teacher(String teahcerId, String teacherName, ArrayList<Lecture> lectureList) {
        this.teahcerId = teahcerId;
        this.teacherName = teacherName;
        this.lectureList = lectureList;
    }

    public String getTeahcerId() {
        return teahcerId;
    }

    public void setTeahcerId(String teahcerId) {
        this.teahcerId = teahcerId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public ArrayList<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(ArrayList<Lecture> lectureList) {
        this.lectureList = lectureList;
    }
}
