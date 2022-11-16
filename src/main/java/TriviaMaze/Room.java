package TriviaMaze;

import java.util.Arrays;

public class Room {
    private Door myNorth;
    private Door myEast;
    private Door myWest;
    private Door mySouth;

    public Room(String[] theNorthData, String[] theEastData,
                String[] theWestData, String[] theSouthData){
        if(theNorthData != null){
            myNorth = new Door(theNorthData[0], Arrays.copyOfRange(theNorthData,1,5),
                    theNorthData[5]);
        }
        if(theEastData != null){
            myEast = new Door(theEastData[0], Arrays.copyOfRange(theEastData,1,5),
                    theEastData[5]);
        }
        if(theWestData != null){
            myWest = new Door(theWestData[0], Arrays.copyOfRange(theWestData,1,5),
                    theWestData[5]);
        }
        if(theSouthData != null){
            myNorth = new Door(theSouthData[0], Arrays.copyOfRange(theSouthData,1,5),
                    theSouthData[5]);
        }
    }

}
