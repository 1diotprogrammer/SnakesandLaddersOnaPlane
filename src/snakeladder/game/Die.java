package snakeladder.game;

import ch.aplu.jgamegrid.Actor;

/*
 Wed 2pm, Team 1, Zheren Huang, Chaowen Zeng, Cheng Yin Loh
 */
public class Die extends Actor
{

  private final DieController dieController;
  private final int index;

  Die(int nb, DieController dieController, int index)
  {
    super("sprites/pips" + nb + ".gif", 7);

    this.dieController = dieController;
    this.index = index;
  }

  public void act()
  {
    showNextSprite();
    if (getIdVisible() == 6)
    {
      setActEnabled(false);

      // Task 1, play roll the all dice, then change player
      dieController.finishedRoll(index);
    }
  }

}
