package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demisoda.API.ChangeQuestionAPITask;
import com.example.demisoda.API.PUTAnswerContextAPITask;

public class ShortAnswerActivity extends AppCompatActivity {


    private EditText shortQuestion;
    private EditText shortAnswer;
    private Button Next_btn;
    private EditText number_txt;

    private int position;
    private Question question;
    private String quizId;

    private Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_answer);

        shortQuestion = (EditText)findViewById(R.id.shortquesion_txt);
        shortAnswer = (EditText)findViewById(R.id.shortanswer_txt);
        Next_btn = (Button)findViewById(R.id.shortanswer_next_btn);
        cancel_btn = (Button)findViewById(R.id.shortanswer_cancel_btn);
        number_txt = (EditText)findViewById(R.id.shortquesion_number_txt);


        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);
        question = (Question) intent.getSerializableExtra("data");
        quizId = intent.getStringExtra("quizId");


        if(!question.getContext().equals("UNTREATED QUESTION"))
        {

            shortQuestion.setText(question.getContext());
            shortAnswer.setText(question.getAnswer_context());
            number_txt.setText(Integer.toString(question.getNumber()));

            Next_btn.setText("MODIFY");
        }



        Next_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if(Next_btn.getText().equals("MODIFY"))
                {
                    String question;
                    String answer;
                    String number;

                    number = number_txt.getText().toString();
                    question = shortQuestion.getText().toString();
                    answer = shortAnswer.getText().toString();

                    ChangeQuestionAPITask w = new ChangeQuestionAPITask();
                    w.execute(quizId,question,"0","0","0","0",answer,number);

                    Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                    returnIntent.putExtra("position", position);
                    returnIntent.putExtra("quizId", quizId);
                    startActivity(returnIntent);
                }

                else
                {
                    String question;
                    String answer;
                    String number;

                    number = number_txt.getText().toString();
                    question = shortQuestion.getText().toString();
                    answer = shortAnswer.getText().toString();

                    PUTAnswerContextAPITask t = new PUTAnswerContextAPITask();
                    t.execute(quizId, "short", question, "0", "0", "0", "0", answer, "made", number);

                    Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                    returnIntent.putExtra("position", position);
                    returnIntent.putExtra("quizId", quizId);
                    startActivity(returnIntent);
                }








            }
        });


        cancel_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),QuestionListActivity.class);
                Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                returnIntent.putExtra("position", position);
                returnIntent.putExtra("quizId", quizId);
                startActivity(returnIntent);
                startActivity(intent1);

            }
        });


    }
}
