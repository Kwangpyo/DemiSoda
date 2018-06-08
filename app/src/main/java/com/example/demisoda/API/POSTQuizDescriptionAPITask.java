package com.example.demisoda.API;

import android.os.AsyncTask;

public class POSTQuizDescriptionAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {

        POSTQuizDescriptionAPI t = new POSTQuizDescriptionAPI();
        t.getJson(params[0],params[1],params[2],params[3],params[4]);

        return "true";
    }
}