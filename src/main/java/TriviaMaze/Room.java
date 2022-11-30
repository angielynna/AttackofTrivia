package TriviaMaze;

//testing

import java.util.Arrays;

public class Room {
    protected Door myNorth;
    protected Door myEast;
    protected Door myWest;
    protected Door mySouth;

    public Room(String[] theNorthData, String[] theEastData,
                String[] theWestData, String[] theSouthData){
        if(theNorthData != null){
            myNorth = new Door(theNorthData[0], Arrays.copyOfRange(theNorthData,1,5),
                    theNorthData[5]);
        } else {
            myNorth = null;
        }
        if(theEastData != null){
            myEast = new Door(theEastData[0], Arrays.copyOfRange(theEastData,1,5),
                    theEastData[5]);
        } else {
            myEast = null;
        }
        if(theWestData != null){
            myWest = new Door(theWestData[0], Arrays.copyOfRange(theWestData,1,5),
                    theWestData[5]);
        } else {
            myWest = null;
        }
        if(theSouthData != null){
            mySouth = new Door(theSouthData[0], Arrays.copyOfRange(theSouthData,1,5),
                    theSouthData[5]);
        } else {
            mySouth = null;
        }
    }
}
