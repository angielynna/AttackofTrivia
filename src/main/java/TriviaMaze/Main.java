package TriviaMaze;

import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws Exception {

        new TriviaMaze(new Maze(), new DataBank(),new Game(), new Scanner(System.in));
    }
}
