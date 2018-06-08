package com.example.demisoda.API;

import android.os.AsyncTask;

public class PUTAnswerContextAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {


        PUTAnswerContextAPI t = new PUTAnswerContextAPI();

        t.getJson(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],params[9]);

        return "true";
    }
}
