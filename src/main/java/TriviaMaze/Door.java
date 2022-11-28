package TriviaMaze;

public class Door {
    private Question myQuestion;

    private boolean myStatus;

    Door(String theQuestion, String[] theAnsOptions, String theCorrectAns){

        myQuestion = new Question(theQuestion,theAnsOptions,theCorrectAns);
        myStatus = false;

    }

    void lockDoor(){

        myStatus = true;
    }

    boolean isLocked(){
        return myStatus;
    }


    String getQuestion(){
        return (myQuestion.toString());
    }


}