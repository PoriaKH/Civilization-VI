package Model.Units;

import Model.Civilization;
import Model.Tile;

public class Unit {
    private Civilization civilization;
    private Tile origin;
    private int health;
    private int MP;   // it shows mp for a unit and its final.
    private int mp;  // it changes every time unit moves.


    private int duration;
    private int goldCost;
    private int movesLeft;

    private boolean isOnSleep;
    private boolean isOnWarFooting;//Amade bash
    private boolean isOnBoost;
    private boolean isOnBoostTillRecover;
    private boolean isOnDeployment;//esteghrar dar shahr
    private boolean isCivilian;


    private Tile destination;//if == null -> null

    public int getGoldCost() {
        return goldCost;
    }

    public boolean isCivilian() {
        return isCivilian;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setOnSleep(boolean onSleep) {
        isOnSleep = onSleep;
    }
}
