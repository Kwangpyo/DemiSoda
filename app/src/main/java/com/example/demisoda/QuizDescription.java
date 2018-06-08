package com.example.demisoda;

import java.io.Serializable;

public class QuizDescription implements Serializable {

    private String lectureName;
    private String teacherName;
    private String deadline;
    private int gradeSetting;

    public QuizDescription(String lectureName, String teacherName, String deadline, int gradeSetting) {
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.deadline = deadline;
        this.gradeSetting = gradeSetting;
    }

    public int getGradeSetting() {
        return gradeSetting;
    }

    public void setGradeSetting(int gradeSetting) {
        this.gradeSetting = gradeSetting;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
