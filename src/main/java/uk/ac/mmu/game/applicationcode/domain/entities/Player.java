package uk.ac.mmu.game.applicationcode.domain.entities;

public class Player {
    private final int index;
    private final String name;
    private final String textColour;
    private final int startPos;
    private int finalTrackPos = 0;
    public static final Player PLAYER1 = new Player(0,"Red",0,"\u001B[31m",0);
    public static final Player PLAYER2 = new Player(1,"Blue",9,"\u001B[34m",0);
    public static final Player PLAYER3 = new Player(2,"Green",18,"\u001B[32m",17);
    public static final Player PLAYER4 = new Player(3,"Yellow",27,"\u001B[33m",26);

    private Player(int index,String color, int startPos, String textColour,int finalPos){
        this.index = index;
        this.name = color;
        this.startPos = startPos;
        this.textColour = textColour;
        this.finalTrackPos = finalPos;
    }

    public String getName() {
        return name;
    }

    public String getTextColour(){return textColour;}

    public void SetFinalTrackPos(int finalTrackPos){
        this.finalTrackPos = finalTrackPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getFinalTrackPos() {
        return finalTrackPos;
    }

    public int getIndex(){
        return index;
    }


    @Override
    public String toString() {
        return this.textColour +this.name+" Starting Position is: " +this.startPos +" Final Position is: "+ this.finalTrackPos;
    }
}