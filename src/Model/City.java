package Model;

import Model.Units.Unit;
import Model.Units.Warrior;

import java.util.ArrayList;

public class City {
    private int gold;
    private int food;

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
        this.sciencePerTurn = 0;
        this.defenceStrength = 0;
        this.food = 0;
    }
    public int getDefenceStrength(){
        //every tile adds +3 point
        this.defenceStrength += 3 * tiles.size();

        //add units strength
        for(Tile tile : getTiles()){
            for(Unit unit : tile.getUnits()){
                if(!unit.isCivilian()){
                    Warrior warrior = (Warrior) unit;
                    this.defenceStrength += warrior.getCombatStrength();
                }
            }
        }
        return this.defenceStrength;
    }

    public int getSciencePerTurn() {
        //every citizen adds +10 point
        this.sciencePerTurn += 10 * citizens.size();

        return sciencePerTurn;
    }

    public int getGold(){
        for(Tile tile : tiles){
            if(tile.getCitizen() != null){

            }
        }
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


    public ArrayList<Citizen> getCitizens() {
        return citizens;
    }
}
