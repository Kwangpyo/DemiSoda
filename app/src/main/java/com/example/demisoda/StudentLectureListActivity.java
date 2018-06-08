package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentLectureListActivity extends AppCompatActivity {

    private String studentName = "Kwangpyo";
    private String lectureName = "math";
    private String teacherName = "Hwanbum";
    private String lectureId = "lectureId";
    private ArrayList<Lecture> lectures;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        lectures = new ArrayList<>();
        Lecture lecture = new Lecture(lectureName,lectureId,teacherName);
        lectures.add(lecture);

        listView=(ListView)findViewById(R.id.listview);

        StudentLectureAdapter adapter=new StudentLectureAdapter(this,R.layout.activity_student_lecture_adapter,lectures);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Lecture lecture = lectures.get(position);
                Log.d("data.geti",lecture.getLectureName());
                Intent intent1 = new Intent(getApplicationContext(),TakeQuizActivity.class);
                intent1.putExtra("data",lecture);
                startActivity(intent1);

            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent1);
    }
}
