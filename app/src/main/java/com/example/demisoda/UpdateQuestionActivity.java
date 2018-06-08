package com.example.demisoda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class UpdateQuestionActivity extends AppCompatActivity {

    private Button multiple_btn;
    private Button shortanswer_btn;

    private int position;
    private Question question;
    private String quizId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_question);

        multiple_btn = (Button)findViewById(R.id.multiple_btn);
        shortanswer_btn = (Button)findViewById(R.id.shortanswer_btn);


        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);
        question = (Question) intent.getSerializableExtra("data");
        quizId = intent.getStringExtra("quizId");

        Log.d("updatep", String.valueOf(position));


        multiple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),MultipleQuesionActivity.class);
                intent1.putExtra("data",question);
                intent1.putExtra("position",position);
                intent1.putExtra("quizId",quizId);
                startActivity(intent1);



            }
        });

        shortanswer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),ShortAnswerActivity.class);
                intent1.putExtra("data",question);
                intent1.putExtra("position",position);
                intent1.putExtra("quizId",quizId);
                startActivity(intent1);



            }
        });



    }


}
