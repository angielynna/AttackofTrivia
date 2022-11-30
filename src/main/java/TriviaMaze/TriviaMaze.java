package TriviaMaze;


import java.util.Scanner;

//I was thinking we could connect our SQLite DataBase to TriviaMaze
//So that when player is trying to move through a door I can ask a question
//And depending on how they answer I'll either lock or unlock the door

public class TriviaMaze {
    private final Maze myMaze;
    private final Game myGame = new Game();
    private final Scanner scanner = new Scanner(System.in);

    //This constructor's parameters takes in the Maze
    //and if we decide the SQLight database as well.
    protected TriviaMaze(Maze theMaze) {
        startGame();
        this.myMaze = theMaze;

    }
    //print maze out and the player movement instructions
    //depending on player input create a newGame,saveGame,or exitGame.
    private void newGame() {


        System.out.print(this.myMaze);
        myGame.playerMovement();
        myGame.playerMenu();
        playerInput(getPlayerInput());

    }

    private void startGame(){
        myGame.gameMenu();
        int playerInput = Integer.parseInt(scanner.nextLine());
        if(playerInput == 1){
            System.out.println("Started a new game.\n");
            newGame();
        } else if (playerInput == 2) {
            System.out.println("Loaded game.");
            //load game
        } else if (playerInput == 3) {
            System.out.println("Thank you for playing");
        }else {
            System.out.println("Invalid input");
        }
    }

    //Get the players input
    private String getPlayerInput() {
        String input;
        input = scanner.nextLine().toLowerCase();
        return input;
    }
    //Depending on player input, move the player.
    private void playerInput(String theInput) {
        switch (theInput) {
            case "w" -> movePlayerNorth();
            case "a" -> movePlayerWest();
            case "s" -> movePlayerSouth();
            case "d" -> movePlayerEast();
            case "n" -> startGame();
            case "l" -> myGame.saveGame();
            case "e" -> System.out.println("Thank you for playing");
        }
    }
    private void setPlayerLocation(){
        myMaze.setLocation(0, 0);
    }

    private void movePlayerNorth() {
        if (myMaze.isLocked('N')) {// if the door in the North direction is not locked
            System.out.println("You cannot move North");
        } else if (askQuestion()) {//if the door is locked ask a question,correct answer unlock door
            System.out.println("You can continue");
            myMaze.move('N');
        } else {//incorrect answer lock the door
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('N');
        }
    }

    private void movePlayerWest() {
        if (myMaze.isLocked('W')) {// if the door in the West direction is not locked
            System.out.println("You cannot move West");
        } else if (askQuestion()) {//if the door is locked ask a question,correct answer unlock door
            System.out.println("You can continue");
            myMaze.move('W');
        } else {//incorrect answer lock the door
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('W');
        }
    }

    private void movePlayerEast() {
        if (myMaze.isLocked('E')) {// if the door in the East direction is not locked
            System.out.println("You cannot move East");
        } else if (askQuestion()) {//if the door is locked ask a question,correct answer unlock door
            System.out.println("You can continue");
            myMaze.move('E');
        } else {//incorrect answer lock the door
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('E');
        }
    }

    private void movePlayerSouth() {
        if (myMaze.isLocked('S')) {// if the door in the South direction is not locked
            System.out.println("You cannot move South");
        } else if (askQuestion()) {//if the door is locked ask a question,correct answer unlock door
            System.out.println("You can continue");
            myMaze.move('S');
        } else {//incorrect answer lock the door
            System.out.println("INCORRECT ANSWER, DOOR HAS BEEN LOCKED");
            myMaze.isLocked('S');
        }
    }

    private boolean askQuestion() {
        System.out.println("Is 2 an even number");
        System.out.println("Press A: for true");
        System.out.println("Press B: for false");
        return getPlayerInput().equals("A");
    }

    private boolean endGame() {
        if(myMaze.atLastRoom()){
            System.out.println("You've won the game!!!");
        } else if (myMaze.isLocked('N')&&myMaze.isLocked('S')
                && myMaze.isLocked('E')&& myMaze.isLocked('W')) {
            System.out.println("You've LOST the game");
        }
        return false;

    }


}