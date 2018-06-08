package com.example.demisoda;

import java.io.Serializable;
import java.util.ArrayList;

public class Lecture implements Serializable {

    private String lectureId;
    private String lectureName;
    private String teacherName;
    private ArrayList<Student> studentList;
    private ArrayList<String> quizIdList;
    private ArrayList<Quiz> quizList;

    public Lecture(String lectureName,String lectureId,String teacherName)
    {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.teacherName = teacherName;
    }

    public Lecture(String lectureId, String lectureName, String teacherName, ArrayList<Student> studentList) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.studentList = studentList;
    }

    public Lecture(String lectureId, String lectureName, String teacherName, ArrayList<Student> studentList, ArrayList<String> quizIdList) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.studentList = studentList;
        this.quizIdList=quizIdList;
    }


    public Lecture(String lectureId, String lectureName, String teacherName, ArrayList<Student> studentList, ArrayList<String> quizIdList, ArrayList<Quiz> quizList) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.studentList = studentList;
        this.quizIdList = quizIdList;
        this.quizList = quizList;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
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

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<String> getQuizIdList() {
        return quizIdList;
    }

    public void setQuizIdList(ArrayList<String> quizIdList) {
        this.quizIdList = quizIdList;
    }
}

