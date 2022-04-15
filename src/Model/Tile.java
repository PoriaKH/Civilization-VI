package Model;

import Model.Units.Unit;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
    private boolean isDesert;
    private boolean isMeadow;//Alafzar
    private boolean isHill;//Tape
    private boolean isMountain;
    private boolean isOcean;
    private boolean isPlain;
    private boolean isSnow;
    private boolean isTundra;

    private int food;
    private int production;
    private int gold;
    private int combatChange;
    private int mpCost;

    float x,y;
    int radius;
    private ArrayList<Unit> units;
    private ArrayList<Resource> resources;
    private ArrayList<Attribute> attributes;
    private ArrayList<Improvement> improvements;

    private Improvement workingOnImprovement;//if == null -> null
    private HashMap<Improvement,int> ImprovementEarnedPercent;

    private boolean doesHaveRoad;
    private boolean doesHaveRailWay;
}