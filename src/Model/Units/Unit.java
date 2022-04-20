package Model.Units;

import Model.Civilization;
import Model.Tile;

public class Unit {
    private Civilization civilization;
    private Tile origin;
    private int health;
    private int mp;
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
}
