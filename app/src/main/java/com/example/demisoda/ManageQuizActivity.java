package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demisoda.API.GETQUizListAPITask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ManageQuizActivity extends AppCompatActivity {

    private ListView listView;
    private Lecture lecture;
    private ArrayList<String> quizArrayList;
    private String teacherName = "Hwanbum";
    private Button makequiz_btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_quiz);

        makequiz_btn = (Button)findViewById(R.id.makequiz_btn);
        txt = (TextView)findViewById(R.id.lecture_name_txt);

        final Intent intent = getIntent();
        lecture = (Lecture) intent.getSerializableExtra("data");

        txt.setText("Lecture Name : "+lecture.getLectureName());

        //quizArrayList = lecture.getQuizIdList();

        GETQUizListAPITask t = new GETQUizListAPITask();
        try {
            quizArrayList = t.execute(String.valueOf(lecture.getLectureId())).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        if(quizArrayList.size() == 0)
        {
            Toast.makeText(getApplicationContext(),"There is no registered quiz in this "+lecture.getLectureName()+" lecture",Toast.LENGTH_SHORT).show();
        }

        listView=(ListView)findViewById(R.id.listview_quiz);

        QuizAdapter adapter=new QuizAdapter(this,R.layout.activity_quiz_adapter, quizArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String quizId = quizArrayList.get(position);
                int flag=1;
                Intent intent1 = new Intent(getApplicationContext(),QuestionListActivity.class);
                intent1.putExtra("quizId",quizId);
                intent1.putExtra("flag",flag);
                startActivity(intent1);

            }
        });

        makequiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),QuizDescriptionSetting.class);
                intent1.putExtra("lecture",lecture);
                startActivity(intent1);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(),Teacher_LectureList.class);
        startActivity(intent1);
    }
}
