package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentQuestionListActivity extends AppCompatActivity {

    private ListView listView;
    private Button finish_btn;
    private Quiz quiz;
    private ArrayList<Question> questions;
    private String quizId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_question_list);

        listView=(ListView)findViewById(R.id.listview_question);
        finish_btn = (Button)findViewById(R.id.finishquestion_btn);

        Intent intent = getIntent();
        quiz = (Quiz) intent.getSerializableExtra("quiz");

        questions = new ArrayList<>();
        questions = quiz.getQuestionList();
        quizId = quiz.getQuizId();

        StudentQuestionAdapter adapter=new StudentQuestionAdapter(this,R.layout.activity_student_question_adapter,questions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Question question1 = questions.get(position);

                Log.d("questiongradeSetting",question1.getGradeSetting());

                if(question1.getType().equals("multiple"))
                {
                    Log.d("pop",question1.getContext());
                    Intent intent1 = new Intent(getApplicationContext(),MultiQuestionAnswerActivity.class);
                    intent1.putExtra("data",question1);
                    intent1.putExtra("position",position);
                    intent1.putExtra("quiz",quiz);
                    startActivity(intent1);
                }

                else if(question1.getType().equals("short"))
                {

                    Log.d("pop",question1.getContext());
                    Intent intent1 = new Intent(getApplicationContext(),ShortQuestionAnswerActivity.class);
                    intent1.putExtra("quiz",quiz);
                    intent1.putExtra("data",question1);
                    intent1.putExtra("position",position);
                    startActivity(intent1);
                }






            }
        });

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),ShortQuestionAnswerActivity.class);
                intent1.putExtra("quiz",quiz);
                intent1.putExtra("quizid",quizId);
                startActivity(intent1);

            }
        });


    }
}
