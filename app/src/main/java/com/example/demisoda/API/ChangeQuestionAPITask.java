package com.example.demisoda.API;

import android.os.AsyncTask;

public class ChangeQuestionAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {


        ChangeQuestionAPI t = new ChangeQuestionAPI();

        t.getJson(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7]);

        return "true";
    }
}
