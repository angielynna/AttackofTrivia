package TriviaMaze;
//testing
public class Door {
    private Question myQuestion;

    private boolean myStatus;

    public Door(String theQuestion, String[] theAnsOptions, String theCorrectAns){

        myQuestion = new Question(theQuestion,theAnsOptions,theCorrectAns);
        myStatus = false;

    }

    public void lockDoor(){

        myStatus = true;
    }

    public boolean isLocked(){

        return myStatus;
    }


    public String getQuestion(){

        return (myQuestion.toString());
    }


}
