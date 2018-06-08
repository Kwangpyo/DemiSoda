package com.example.demisoda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demisoda.API.ChangeQuestionAPI;
import com.example.demisoda.API.ChangeQuestionAPITask;
import com.example.demisoda.API.PUTAnswerContextAPITask;

public class MultipleQuesionActivity extends AppCompatActivity {

    private int position;
    private Question question;

    private Button btn;
    private EditText answer1txt;
    private EditText answer2txt;
    private EditText answer3txt;
    private EditText answer4txt;
    private EditText questionContext;
    private EditText answer;
    private EditText number_txt;
    private Button cancel;

    private String quizId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_quesion);

        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);
        question = (Question) intent.getSerializableExtra("data");
        quizId = intent.getStringExtra("quizId");

        questionContext = (EditText) findViewById(R.id.questionContext);
        btn = (Button)findViewById(R.id.questionanswer_btn);
        answer1txt = (EditText)findViewById(R.id.questionAnswer1);
        answer2txt = (EditText)findViewById(R.id.questionAnswer2);
        answer3txt = (EditText)findViewById(R.id.questionAnswer3);
        answer4txt = (EditText)findViewById(R.id.questionAnswer4);
        answer = (EditText)findViewById(R.id.questionAnswer);
        number_txt = (EditText)findViewById(R.id.questionNumber);
        cancel = (Button)findViewById(R.id.questionCancel_btn);


        Log.d("multiplep", String.valueOf(position));

        if(!question.getContext().equals("UNTREATED QUESTION"))
        {

            number_txt.setText(Integer.toString(question.getNumber()));
            questionContext.setText(question.getContext());
            answer1txt.setText(question.getAnswer1());
            answer2txt.setText(question.getAnswer2());
            answer3txt.setText(question.getAnswer3());
            answer4txt.setText(question.getAnswer4());
            answer.setText(question.getAnswer_context());

            btn.setText("MODIFY");

        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btn.getText().equals("MODIFY"))
                {
                    String number = number_txt.getText().toString();
                    String questionstr = questionContext.getText().toString();
                    String answer1 = answer1txt.getText().toString();
                    String answer2 = answer2txt.getText().toString();
                    String answer3 = answer3txt.getText().toString();
                    String answer4 = answer4txt.getText().toString();
                    String questionAnswerer = answer.getText().toString();

                    ChangeQuestionAPITask w = new ChangeQuestionAPITask();
                    w.execute(quizId,questionstr,answer1,answer2,answer3,answer4,questionAnswerer,number);

                    Question question1 = new Question(questionstr);

                    Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                    int flag = 1;
                    returnIntent.putExtra("result", question1);
                    returnIntent.putExtra("position", position);
                    returnIntent.putExtra("flag", flag);
                    returnIntent.putExtra("quizId", quizId);
                    startActivity(returnIntent);

                }

                else {

                    String number = number_txt.getText().toString();
                    String questionstr = questionContext.getText().toString();
                    String answer1 = answer1txt.getText().toString();
                    String answer2 = answer2txt.getText().toString();
                    String answer3 = answer3txt.getText().toString();
                    String answer4 = answer4txt.getText().toString();
                    String questionAnswerer = answer.getText().toString();

                    PUTAnswerContextAPITask t = new PUTAnswerContextAPITask();
                    t.execute(quizId, "multiple", questionstr, answer1, answer2, answer3, answer4, questionAnswerer, "made", number);

                    Question question1 = new Question(questionstr);

                    Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                    returnIntent.putExtra("result", question1);
                    returnIntent.putExtra("position", position);
                    returnIntent.putExtra("quizId", quizId);
                    startActivity(returnIntent);

                }
            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String questionstr = questionContext.getText().toString();

                Intent intent1 = new Intent(getApplicationContext(),QuestionListActivity.class);
                Intent returnIntent = new Intent(getApplicationContext(), QuestionListActivity.class);
                Question question1 = new Question(questionstr);
                returnIntent.putExtra("result", question1);
                returnIntent.putExtra("position", position);
                returnIntent.putExtra("quizId", quizId);
                startActivity(returnIntent);
                startActivity(intent1);

            }
        });


    }
}
