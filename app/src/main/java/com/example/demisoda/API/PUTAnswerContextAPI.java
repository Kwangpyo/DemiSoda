package com.example.demisoda.API;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PUTAnswerContextAPI {

    public void getJson(String quizId,String type,String questionContext,String answer1,String answer2,String answer3,String answer4,String questionAnswer,String status,String num) {

        String urlLocation = "http://192.168.25.249:3000/updateAnswerContext/";
        final String openURL = urlLocation+quizId+"?type="+type+"&&h0="+questionContext+"&&h1="+answer1+"&&h2="+answer2+"&&h3="+answer3+"&&h4="+answer4+"&&h5="+questionAnswer+"&&h6="+status+"&&num="+num;

        try {

            Log.d("openurl",openURL);
            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

//            JSONObject json = new JSONObject(getStringFromInputStream(in));
//            parseJSON(json);

        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();

        }  catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();

        }


    }


}


