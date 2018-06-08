package com.example.demisoda.API;

import android.os.AsyncTask;

public class PUTAnswerByStudentAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {

        PUTAnswerByStudentAPI t = new PUTAnswerByStudentAPI();

        t.getJson(params[0],params[1]);

        return "true";
    }
}