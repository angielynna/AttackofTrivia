package triviamaze;

import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws Exception {
        Game g = new Game();
        g.welcomeMessage();
        new TriviaMaze(new DataBank(), g, new Scanner(System.in));
    }
}
