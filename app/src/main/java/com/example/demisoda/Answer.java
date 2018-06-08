package com.example.demisoda;

public class Answer {

    private String answer;
    private String type;

    public Answer(String answer, String type) {
        this.answer = answer;
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
