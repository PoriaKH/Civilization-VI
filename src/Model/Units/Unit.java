package Model.Units;

import Model.Tile;

public class Unit {
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

    private Tile destination;//if == null -> null
}
