package com.example.demisoda.API;

import android.os.AsyncTask;

public class UpdateQuizAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {


        UpdateQuizAPI t = new UpdateQuizAPI();

        t.getJson(params[0]);

        return "true";
    }
}