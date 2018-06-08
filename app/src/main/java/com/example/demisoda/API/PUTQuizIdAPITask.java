package com.example.demisoda.API;

import android.os.AsyncTask;

public class PUTQuizIdAPITask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {


        PUTQuizIdAPI putQuizIdAPI = new PUTQuizIdAPI();

        putQuizIdAPI.getJson(params[0],params[1]);

        return "true";
    }
}

