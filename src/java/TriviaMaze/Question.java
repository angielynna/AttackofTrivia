package TriviaMaze;

public class Question {

    private String myQuestion;
    private String myCorrectAnswer;
    private String [] myAnswerOptions;

    Question(String theQuestion, String[] theAnswerOptions, String theCorrectAnswer){
        if(myQuestion == null || myCorrectAnswer == null || myAnswerOptions == null){
            throw new IllegalArgumentException();
        }

        this.myQuestion = theQuestion;
        this.myCorrectAnswer = theCorrectAnswer;
        this.myAnswerOptions = theAnswerOptions;
    }

    public String getQuestion(){
        return myQuestion;
    }
    public String getAnswer() {
        return myCorrectAnswer;
    }
    public String getOptions() {
        StringBuilder sb  = new StringBuilder();
        sb.append(myAnswerOptions[0]+"\n"+myAnswerOptions[1]+"\n"+myAnswerOptions[2]+"\n"+myAnswerOptions[3]);
        return(sb.toString());
    }

    protected boolean isCorrect(String answer){
        if(answer.equals(this.myCorrectAnswer)){
            return true;
        }
        return false;
    }
    protected String promptQuestion(){
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestion()+"\n"+getOptions()+"\n"+getAnswer());
        return(sb.toString());
    }


}
