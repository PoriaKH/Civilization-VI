package Model;

import java.util.ArrayList;

public class City {
    private int gold;
    private ArrayList<Citizen> citizens;
    private Tile centerTile;
    private ArrayList<Tile> tiles;
    private int defenceStrength;
    private int sciencePerTurn;

    public City(Tile centerTile, ArrayList<Tile> map){
        this.centerTile = centerTile;
        citizens = new ArrayList<>();
        citizens.add(new Citizen(centerTile));

        tiles = new ArrayList<>();
        for(Tile tile : map){
            if(areTilesNeighbour(centerTile, tile)){
                tiles.add(tile);
            }
        }

        this.gold = 0;
    }

    public boolean areTilesNeighbour(Tile tile1, Tile tile2){
        float distance = (float)Math.sqrt(Math.pow(tile1.getX() - tile2.getX(), 2) + Math.pow(tile1.getY() - tile2.getY(), 2));
        if(distance <= tile1.getRadius() * Math.sqrt(3))
            return true;

        return false;
    }
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
