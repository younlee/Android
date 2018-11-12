package yuni.suhang;

/**
 * Created by fkdbs on 2017-06-24.
 */

public class Question {

    private String question,answer;
    Question(String q,String a){
        this.question=q;
        this.answer=a;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
