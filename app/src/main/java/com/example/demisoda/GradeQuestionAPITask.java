package com.example.demisoda;

import android.os.AsyncTask;

import com.example.demisoda.API.UpdateQuizAPI;

public class GradeQuestionAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {

        GradeQuestionAPI t = new GradeQuestionAPI();
        t.getJson(params[0],params[1]);

        return "true";
    }
}