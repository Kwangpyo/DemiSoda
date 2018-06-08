package com.example.demisoda.API;

import android.util.Log;

import com.example.demisoda.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GETStudentQuestionAPI {

    ArrayList<Question> questions = new ArrayList<>();

    public ArrayList<Question> getJson() {

        String urlLocation = "http://192.168.25.249:3000/getAllTaskDocuments";
        final String openURL = urlLocation;

        try {

            Log.d("openurl",openURL);
            URL url = new URL(openURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

//            JSONObject json = new JSONObject(getStringFromInputStream(in));
//            parseJSON(json);
            String result ="";
            result =getStringFromInputStream(in);
            Log.d("resultTest",result);
            parsing(result);

        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();
            return null;

        } catch (JSONException e) {

            System.err.println("JSON parsing error");

            e.printStackTrace();

            return null;

        } catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();

            return null;

        }

        return questions;
    }


    private void parsing(String result) throws JSONException {


        JSONArray Jarray = new JSONObject(result).getJSONArray("tasks");


        int size = Jarray.length();

        for(int i=0;i<size;i++)
        {
            JSONObject JObject = null;
            JObject = Jarray.getJSONObject(i);

            String lectureId = JObject.getString("lectureId");
            String quizId = JObject.getString("quizId");
            String gradeSetting = JObject.getString("gradeSetting");
            String questionAmount = JObject.getString("questionAmount");

            String upload = JObject.getString("uploadStatus");
            String deadline = JObject.getString("deadline");

            Log.d("deadline",deadline);

            ArrayList<String> questionContext = new ArrayList<>();

            String str2 = JObject.getString("questionContext");
            Log.d("qwerasd",str2);

            if(upload.equals("upload"))
            {
                JSONArray subArray2 = new JSONArray(str2);
                for(int j = 0; j < subArray2.length(); j++) {

                    String st = subArray2.get(j).toString();
                    Log.d("studentObject", st);
                    questionContext.add(st);
                }

                ArrayList<String> questionAnswer = new ArrayList<>();

                String str = JObject.getString("questionAnswer");
                Log.d("str",str);


                JSONArray subArray = new JSONArray(str);
                for(int j = 0; j < subArray.length(); j++) {

                    String st = subArray.get(j).toString();
                    Log.d("studentObject", st);
                    questionAnswer.add(st);
                }





                ArrayList<String> questionStatus = new ArrayList<>();

                String str3 = JObject.getString("questionStatus");
                Log.d("str",str2);

                JSONArray subArray3 = new JSONArray(str3);
                for(int j = 0; j < subArray3.length(); j++) {

                    String st = subArray3.get(j).toString();
                    Log.d("studentObject", st);
                    questionStatus.add(st);
                }


                ArrayList<String> questionType = new ArrayList<>();

                String str4 = JObject.getString("questionType");
                Log.d("str",str2);

                JSONArray subArray4 = new JSONArray(str4);
                for(int j = 0; j < subArray4.length(); j++) {

                    String st = subArray4.get(j).toString();
                    Log.d("studentObject", st);
                    questionType.add(st);
                }

                ArrayList<String> questionNumber = new ArrayList<>();

                String str5 = JObject.getString("questionNumber");
                Log.d("str",str2);

                JSONArray subArray5 = new JSONArray(str5);
                for(int j = 0; j < subArray5.length(); j++) {

                    String st = subArray5.get(j).toString();
                    Log.d("studentObject", st);
                    questionNumber.add(st);
                }

                ArrayList<String> answerContext1 = new ArrayList<>();

                String str6 = JObject.getString("answerContext1");
                Log.d("str",str2);

                JSONArray subArray6 = new JSONArray(str6);
                for(int j = 0; j < subArray6.length(); j++) {

                    String st = subArray6.get(j).toString();
                    Log.d("studentObject", st);
                    answerContext1.add(st);
                }

                ArrayList<String> answerContext2 = new ArrayList<>();

                String str7 = JObject.getString("answerContext2");
                Log.d("str",str2);

                JSONArray subArray7 = new JSONArray(str7);
                for(int j = 0; j < subArray7.length(); j++) {

                    String st = subArray7.get(j).toString();
                    Log.d("studentObject", st);
                    answerContext2.add(st);
                }

                ArrayList<String> answerContext3 = new ArrayList<>();

                String str8 = JObject.getString("answerContext3");
                Log.d("str",str2);

                JSONArray subArray8 = new JSONArray(str8);
                for(int j = 0; j < subArray8.length(); j++) {

                    String st = subArray8.get(j).toString();
                    Log.d("studentObject", st);
                    answerContext3.add(st);
                }

                ArrayList<String> answerContext4 = new ArrayList<>();

                String str9 = JObject.getString("answerContext4");
                Log.d("str",str2);

                JSONArray subArray9 = new JSONArray(str9);
                for(int j = 0; j < subArray9.length(); j++) {

                    String st = subArray9.get(j).toString();
                    Log.d("studentObject", st);
                    answerContext4.add(st);
                }



                for(int a=0;a<questionContext.size();a++)
                {
                    Question q = new Question(questionType.get(a),Integer.valueOf(questionNumber.get(a)),questionStatus.get(a),questionContext.get(a),questionAnswer.get(a),quizId,lectureId,gradeSetting,answerContext1.get(a),answerContext2.get(a),answerContext3.get(a),answerContext4.get(a),Integer.valueOf(questionAmount),upload,deadline);
                    questions.add(q);
                }



            }



        }


    }



    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}

