package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {

    private Button quiz_btn;
    private Teacher teacher;
    private final String teacherName = "Hwanbum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        quiz_btn = (Button)findViewById(R.id.teacher_quiz_btn);

/*
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Lecture> lectureList = new ArrayList<>();
        ArrayList<String> lectureIdList = new ArrayList<>();

        lectureIdList.add("lecture1");
        lectureIdList.add("lecture2");

        Student student1 = new Student("kkp","Kwangpyo Ko",lectureIdList);
        Student student2 = new Student("jisoo","Jisoo Seo",lectureIdList);

        studentList.add(student1);
        studentList.add(student2);

        Lecture lecture1 = new Lecture("lecture1","English","Hwangbum Lee", studentList);
        Lecture lecture2 = new Lecture("lecture2","Math","Hwangbum Lee", studentList);

        lectureList.add(lecture1);
        lectureList.add(lecture2); */

     //   teacher = new Teacher("Lee","Hwanbum",lectureList);

     //   Log.d("teacheras",teacher.getTeacherName());

        quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("teacherqwe",teacherName);
                Intent intent = new Intent(getApplicationContext(),Teacher_LectureList.class);
                //intent.putExtra("teacher",teacherName);
                startActivity(intent);

            }
        });

    }
}
