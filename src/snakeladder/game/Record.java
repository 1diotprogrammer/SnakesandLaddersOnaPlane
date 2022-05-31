package snakeladder.game;

import java.util.HashMap;
import java.util.Map;

/*
 Wed 2pm, Team 1, Zheren Huang, Chaowen Zeng, Cheng Yin Loh
 */

// Task 5, record the data
public class Record {

    private final int totalNumOfDice;
    private final String playerName;
    private final Map<Integer,Integer> rolledCounting = new HashMap<>();
    private boolean needMapInitialise = true;
    private int goUp, goDown;

    public Record(String playerName, int totalNumOfDice){
        this.totalNumOfDice = totalNumOfDice;
        this.playerName=playerName;
    }

    // Task 5, initialise a map for the lowest rolling value to highest rolling value
    private void setRecordInitialise(Map<Integer,Integer> rolledCounting){
        int maxDiceValue = totalNumOfDice * 6;
        for (int i = totalNumOfDice; i <= maxDiceValue; i++) {
            rolledCounting.put(i, 0);
        }
        needMapInitialise = false;
    }

    // Task 5, input the rolling value after roll
    public void recordRolled(int nb){
        if(needMapInitialise)
            setRecordInitialise(rolledCounting);
        rolledCounting.put(nb,rolledCounting.get(nb)+1);
    }

    // Task 5, record the counting up and down
    public int getGoUp(){
        return this.goUp;
    }

    public int getGoDown(){
        return this.goDown;
    }

    public void setGoUp(int goUp){
        this.goUp = goUp;
    }

    public void setGoDown(int goDown){
        this.goDown = goDown;
    }

    @Override
    public String toString(){
        // Task 5, if one player has not start, still can get a blank record with all 0
        if(needMapInitialise)
            setRecordInitialise(rolledCounting);
        // Task 5, print the record data on the console
        String output = playerName+" Rolled: "+rolledCounting.entrySet().toString()+
                ", Traversed: up="+goUp+" down="+goDown;
        return output;
    }
}
