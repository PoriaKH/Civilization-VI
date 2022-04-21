package Model;

import Model.Units.Unit;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
    private boolean isDesert;                   //Smooth
    private boolean isMeadow;//Alafzar          //Smooth
    private boolean isHill;//Tape               //2             //isBlocker
    private boolean isMountain;                 //NA            //isBlocker
    private boolean isOcean;                    //NA
    private boolean isPlain;                    //Smooth
    private boolean isSnow;                     //Smooth
    private boolean isTundra;                   //Smooth
    private boolean isBlocker;

    private int food;
    private int production;
    private int gold;
    private int combatChange;
    private int mpCost;

    private int tileNumber;
    private float x,y;
    private int radius;

    private ArrayList<Unit> units;
    private Resource resource;
    private Attribute attribute;
    private ArrayList<Improvement> improvements;
    public Tile(boolean isDesert, boolean isMeadow, boolean isHill, boolean isMountain, boolean isOcean, boolean isPlain, boolean isSnow, boolean isTundra, int tileNumber, float x, float y){
        this.isDesert = isDesert;
        this.isMeadow = isMeadow;
        this.isHill = isHill;
        this.isMountain = isMountain;
        this.isOcean = isOcean;
        this.isPlain = isPlain;
        this.isSnow = isSnow;
        this.isTundra = isTundra;
        this.isBlocker = false;
        if(isHill || isMountain)
            this.isBlocker = true;

        this.tileNumber = tileNumber;
        this.x = x;
        this.y = y;
        this.radius = 5;

        this.food = 0;
        this.production = 0;
        this.gold = 0;
        this.combatChange = 0;
        this.mpCost = 0;

        if(tileNumber == 19 || tileNumber == 20){
            attribute = new Attribute();
        }
        //
        if(isDesert){
            combatChange -= 33;
            mpCost += 1;
        }
        else if(isMeadow){
            food += 2;
            combatChange -= 33;
            mpCost += 1;
        }
        else if(isHill){
            production += 2;
            combatChange += 25;
            mpCost += 2;
        }
        else if(isMountain){
            mpCost = 100000000;
        }
        else if(isOcean){
            mpCost = 100000000;
        }
        else if(isPlain){
            food += 1;
            production += 1;
            combatChange -= 33;
            mpCost += 1;
        }
        else if(isSnow){
            combatChange -= 33;
            mpCost += 1;
        }
        else if(isTundra){
            food += 1;
            combatChange -= 33;
            mpCost += 1;
        }
        //
    }

    private Improvement workingOnImprovement;//if == null -> null
    private HashMap<Improvement, Integer> ImprovementEarnedPercent;

    private boolean doesHaveRoad;
    private boolean doesHaveRailWay;

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addUnit (Unit unit) {
        units.add(unit);
    }
}