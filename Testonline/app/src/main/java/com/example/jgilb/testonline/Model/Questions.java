package com.example.jgilb.testonline.Model;

public class Questions {

    public String question, option1, option2, option3, answer;

    public Questions(String question1, String option1, String option2, String option3, String answer) {
        this.question = question1;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
    }

    public Questions() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion1(String question1) {
        this.question = question1;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
