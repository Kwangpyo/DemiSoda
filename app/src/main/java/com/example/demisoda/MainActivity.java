package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button teacher_btn;
    private Button student_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        teacher_btn = (Button) findViewById(R.id.select_teacher);
        student_btn = (Button)findViewById(R.id.select_student);

        teacher_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Teacher_LectureList.class);
                startActivity(intent);
            }
        });

        student_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),StudentLectureListActivity.class);
                startActivity(intent);
            }
        });



    }
}
