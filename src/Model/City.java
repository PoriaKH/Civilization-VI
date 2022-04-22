package Model;

import java.util.ArrayList;

public class City {
    private int gold;
    private ArrayList<Citizen> citizens;
    private Tile centerTile;
    private ArrayList<Tile> tiles;
    private int defenceStrength;
    private int sciencePerTurn;

    public Tile getCenterTile() {
        return centerTile;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public int getGold() {
        return gold;
    }
}

