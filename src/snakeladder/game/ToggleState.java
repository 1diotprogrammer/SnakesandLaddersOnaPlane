package snakeladder.game;

import java.util.List;

/*
 Wed 2pm, Team 1, Zheren Huang, Chaowen Zeng, Cheng Yin Loh
 */

// Task 4, interface
public class ToggleState implements Toggle{

    @Override
    public boolean onclickToggle(NavigationPane np, GamePane gp){

        int maxSteps = np.getNumberOfDice() * 6;
        boolean isToggleOpen;

        List<Connection> connections = gp.getConnections();

        // Task 4, to get the next player
        int nextPlayerIndex = gp.getCurrentPuppetIndex() == 1 ? 0 : 1;
        Puppet nextPlayer = gp.getAllPuppets().get(nextPlayerIndex);

        // Task 4, get to range the next player may locate after rolling
        int nextPlayerCell = nextPlayer.getCellIndex();
        int maxRangeOfMovement = nextPlayerCell + maxSteps;
        int minRangeOfMovement = nextPlayerCell + np.getNumberOfDice();

        int totalUpCon = 0;
        int totalDownCon = 0;

        // Task 4, check in the range, more up connection or down connection
        for (Connection connection : connections) {
            if (connection.cellStart < connection.cellEnd) {
                if (connection.cellStart <= maxRangeOfMovement && connection.cellStart >= minRangeOfMovement) {
                    totalUpCon += 1;
                }
            } else if (connection.cellStart > connection.cellEnd){
                if (connection.cellStart <= maxRangeOfMovement && connection.cellStart >= minRangeOfMovement) {
                    totalDownCon += 1;
                }
            }
        }

        // Task 4, open the toggle mode after algorithm
        if(totalUpCon == 0 && totalDownCon == 0)
        {
            isToggleOpen = false;
        }else {
            isToggleOpen = (totalUpCon >= totalDownCon);
        }
        return isToggleOpen;

    }
}
