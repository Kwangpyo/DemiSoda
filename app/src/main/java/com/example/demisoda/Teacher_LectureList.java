package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Teacher_LectureList extends AppCompatActivity {

    private ListView listView;
    private Teacher teacher;
    private ArrayList<Lecture> data;
    private String teacherName = "Hwanbum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__lecture_list);

        listView=(ListView)findViewById(R.id.listview);

        Intent intent = getIntent();
    //    teacher = (Teacher)intent.getSerializableExtra("teacher");
      //  teacherName = (String)intent.getStringExtra("teacher");
        data=new ArrayList<>();

        Log.d("teachername",teacherName);

        data = openManageQuizMenu(teacherName);

        LectureAdapter adapter=new LectureAdapter(this,R.layout.lectureadpter,data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Lecture lecture = data.get(position);
                Log.d("data.geti",lecture.getLectureName());
                Intent intent1 = new Intent(getApplicationContext(),ManageQuizActivity.class);
                intent1.putExtra("data",lecture);
                startActivity(intent1);

            }
        });


    }


    public ArrayList<Lecture> openManageQuizMenu(String teacherName)
    {

        Log.d("listteacherName",teacherName);
        DBHandler dbHandler = new DBHandler();
        ArrayList<Lecture> lectures = dbHandler.getLectureList(teacherName);

        return lectures;

    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent1);
    }
}
