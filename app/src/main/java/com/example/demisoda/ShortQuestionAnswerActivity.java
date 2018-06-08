package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demisoda.API.PUTAnswerByStudentAPITask;

public class ShortQuestionAnswerActivity extends AppCompatActivity {

    private TextView question_txt;
    private EditText answer_txt;
    private Question question;
    private Integer position;
    private Button finish_btn;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_question_answer);

        question_txt = (TextView)findViewById(R.id.shortanswer_question_txt);
        answer_txt = (EditText)findViewById(R.id.shortanswer_answer_txt);
        finish_btn = (Button)findViewById(R.id.shortanswer_finish_btn);

        Intent getintent = getIntent();
        question = (Question) getintent.getSerializableExtra("data");
        position = getintent.getIntExtra("position",-1);
        quiz = (Quiz) getintent.getSerializableExtra("quiz");


        question_txt.setText("Question "+question.getNumber()+".  " + question.getContext());



        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer = answer_txt.getText().toString();

                PUTAnswerByStudentAPITask putAnswerByStudentAPITask = new PUTAnswerByStudentAPITask();
                putAnswerByStudentAPITask.execute(question.getQuizId(),answer);

                String score="";

                if(answer.equals(question.getAnswer()))
                {
                    score = "1";
                }

                else
                {
                   score = "0";
                }


                GradeQuestionAPITask t = new GradeQuestionAPITask();
                t.execute(question.getQuizId(),score);

                Intent intent1 = new Intent(getApplicationContext(),StudentQuestionListActivity.class);
                intent1.putExtra("quiz",quiz);
                startActivity(intent1);

            }
        });

    }
}
