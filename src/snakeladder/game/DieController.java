package snakeladder.game;

import java.util.ArrayList;
import java.util.List;

/*
 Wed 2pm, Team 1, Zheren Huang, Chaowen Zeng, Cheng Yin Loh
 */

// Task 1, use the controller to control the dice,
public class DieController {

    private final NavigationPane np;
    private List<Die> dice;
    private int totalDie;

    public DieController(NavigationPane np) {
        this.np = np;
        this.dice = new ArrayList<>();
        this.totalDie = 0;
    }

    // Task 1, roll every dice
    public void roll(int nb){
        int sizeOfDie = dice.size();
        Die die = new Die(nb, this, sizeOfDie+1);
        dice.add(die);
        totalDie += nb;
    }

    private boolean isFinished(int currentRoll){
        return currentRoll == np.getNumberOfDice();
    }

    // Task 1, clear record attribute
    public void finishedRoll(int index){
        if (isFinished(index)) {
            np.startMoving(totalDie);
            // reset list
            this.totalDie = 0;
            this.dice.clear();
        }
    }

    private List<Die> getAllDice(){
        return this.dice;
    }

    public Die LastDie(){
        dice = getAllDice();
        return dice.get(dice.size()-1);
    }
}
