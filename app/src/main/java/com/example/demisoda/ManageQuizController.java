package com.example.demisoda;

import com.example.demisoda.API.POSTQuizDescriptionAPITask;
import com.example.demisoda.API.PUTQuizIdAPITask;

public class ManageQuizController {

    public void createQuiz(QuizDescription quizDescription, String lectureId,String quizId,String questionAmount)
    {
        PUTQuizIdAPITask putQuizIdAPITask = new PUTQuizIdAPITask();
        putQuizIdAPITask.execute(lectureId,quizId);

        POSTQuizDescriptionAPITask postQuizDescriptionAPI = new POSTQuizDescriptionAPITask();
        postQuizDescriptionAPI.execute(quizId,lectureId, String.valueOf(quizDescription.getGradeSetting()),quizDescription.getDeadline(),questionAmount);



    }

    public Quiz selectQuiz(String lectureId)
    {

        return null;
    }

    public void uploadQuiz(Quiz quiz, String quizId)
    {

    }


}
