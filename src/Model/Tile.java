package Model;

import Model.Units.Civilian;
import Model.Units.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
    private float radius;
    private double h;

    private Citizen citizen;
    private ArrayList<Unit> units;
    private HashMap<Unit, Integer> turnForUnitMaking = new HashMap<>();
    private Resource resource;
    private Attribute attribute;
    private ArrayList<Improvement> improvements = new ArrayList<>();


    private ArrayList<Tile> roads;
    private ArrayList<Tile> railRoads;

    public Tile(int tileNumber, boolean isDesert, boolean isMeadow, boolean isHill, boolean isMountain, boolean isOcean, boolean isPlain, boolean isSnow, boolean isTundra, float x, float y){
        this.roads = new ArrayList<>();
        this.railRoads = new ArrayList<>();
        this.units = new ArrayList<>();
        this.improvements = new ArrayList<>();
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
        this.h = radius * Math.sqrt(3) / 2;

        this.food = 0;
        this.production = 0;
        this.gold = 0;
        this.combatChange = 0;
        this.mpCost = 0;

        if(tileNumber == 17 || tileNumber == 13 || tileNumber == 19 || tileNumber == 20 || tileNumber == 22){
            this.attribute = new Attribute(true,false,false,false,false,false);
        }
        //
        if(isDesert){
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null) {
                Random rand = new Random();
                int number = rand.nextInt(2);

                if (number == 1) {//Attribute exists
                    number = rand.nextInt(2);

                    if (number == 0) {//not Oasis
                        number = rand.nextInt(2);
                        if (number == 0) {//Ice
                            this.attribute = new Attribute(false, false, true, false, false, false);
                        } else {//Marsh
                            this.attribute = new Attribute(false, false, false, false, true, false);
                        }
                    } else {//Oasis
                        this.attribute = new Attribute(false, false, false, false, false, true);
                    }
                }
            }
        }
        else if(isMeadow){
            food += 2;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null) {
                Random rand = new Random();
                int number = rand.nextInt(2);

                if (number == 1) {//Attribute exists
                    number = rand.nextInt(2);
                    if (number == 0) {//RainForest
                        this.attribute = new Attribute(false, false, false, true, false, false);
                    } else {//Marsh
                        this.attribute = new Attribute(false, false, false, false, true, false);
                    }
                }
            }
        }
        else if(isHill){
            production += 2;
            combatChange += 25;
            mpCost += 2;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(2);
                    if(number == 1){//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                    else {//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                }
            }
        }
        else if(isMountain){
            mpCost = 100000000;
            this.attribute = new Attribute(false,true,false,false,false,false);
        }
        else if(isOcean){
            mpCost = 100000000;
        }
        else if(isPlain){
            food += 1;
            production += 1;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(3);
                    if(number == 0){//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                    else if(number == 1){//RainForest
                        this.attribute = new Attribute(false,false,false,true,false,false);
                    }
                    else {//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                }
            }
        }
        else if(isSnow){
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){//Ice
                    this.attribute = new Attribute(false,false,true,false,false,false);
                }
            }
        }
        else if(isTundra){
            food += 1;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(3);
                    if(number == 0){//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                    else if(number == 1){//RainForest
                        this.attribute = new Attribute(false,false,false,true,false,false);
                    }
                    else {//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                }
            }
        }
        //
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    private Improvement workingOnImprovement;//if == null -> null
    private HashMap<Improvement, Integer> improvementEarnedPercent = new HashMap<>();

    private boolean doesHaveRoad;
    private boolean doesHaveRailWay;
    private HashMap<Unit, Integer> workingOnRoadUntilFinish = new HashMap<>();
    private HashMap<Unit, Integer> workingOnRailUntilFinish = new HashMap<>();

    public void assignWorkerToRoad (Unit unit, Integer turn) {
        workingOnRoadUntilFinish.put(unit, turn);
    }
    public void assignWorkerToRail (Unit unit, Integer turn) {
        workingOnRailUntilFinish.put(unit, turn);
    }
    public int sizeOfHashMapRoad () {
        return workingOnRoadUntilFinish.size();
    }
    public int sizeOfHashMapRail () {
        return workingOnRailUntilFinish.size();
    }
    public Integer getNumberOfTurnsRail (Unit unit) {
        return workingOnRailUntilFinish.get(unit);
    }
    public Integer getNumberOfTurnsRoad (Unit unit) {
        return workingOnRoadUntilFinish.get(unit);
    }
    public void setNewNumberForTurnRoad (Unit unit, Integer turn) {
        workingOnRoadUntilFinish.replace(unit, turn);
    }
    public void setNewNumberForTurnRail (Unit unit, Integer turn) {
        workingOnRailUntilFinish.replace(unit, turn);
    }
    public void removeWorkerFromRoad (Unit unit) {
        workingOnRoadUntilFinish.remove(unit);
    }

    public void setDoesHaveRoad(boolean doesHaveRoad) {
        this.doesHaveRoad = doesHaveRoad;
    }

    public void setDoesHaveRailWay(boolean doesHaveRailWay) {
        this.doesHaveRailWay = doesHaveRailWay;
    }

    public void removeWorkerFromRail (Unit unit) {
        workingOnRailUntilFinish.remove(unit);
    }


    public Resource getResource() {
        return resource;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addUnit (Unit unit) {
        units.add(unit);
    }

    public boolean isDesert() {
        return isDesert;
    }

    public boolean isMeadow() {
        return isMeadow;
    }

    public boolean isHill() {
        return isHill;
    }

    public boolean isMountain() {
        return isMountain;
    }

    public boolean isOcean() {
        return isOcean;
    }

    public boolean isPlain() {
        return isPlain;
    }

    public boolean isSnow() {
        return isSnow;
    }

    public boolean isTundra() {
        return isTundra;
    }

    public boolean isBlocker() {
        return isBlocker;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public int getCombatChange() {
        return combatChange;
    }

    public int getMpCost() {
        return mpCost;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public double getH() {
        return h;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public ArrayList<Improvement> getImprovements() {
        return improvements;
    }

    public Improvement getWorkingOnImprovement() {
        return workingOnImprovement;
    }

    public HashMap<Improvement, Integer> getImprovementEarnedPercent() {
        return improvementEarnedPercent;
    }

    public boolean isDoesHaveRoad() {
        return doesHaveRoad;
    }

    public boolean isDoesHaveRailWay() {
        return doesHaveRailWay;
    }

    public ArrayList<Tile> getRoads() {
        return roads;
    }

    public ArrayList<Tile> getRailRoads() {
        return railRoads;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void removeUnit (Unit unit) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).equals(unit)) {
                units.remove(i);
                break;
            }
        }
    }
    public void addImprovement (Improvement improvement){
        this.improvements.add(improvement);
    }
    public void addToImprovementEarnedPercent(Improvement improvement, Integer roundLeft){
        if (!this.improvementEarnedPercent.containsKey(improvement))
            this.improvementEarnedPercent.put(improvement, roundLeft);
        this.workingOnImprovement = improvement;
    }
    public void reduceImprovementRound(){
        Integer roundLeft = this.improvementEarnedPercent.get(this.workingOnImprovement) - 1;
        if (roundLeft == 0) {
            this.improvementEarnedPercent.remove(this.workingOnImprovement);
            this.addImprovement(this.workingOnImprovement);
        }
        this.improvementEarnedPercent.replace(this.workingOnImprovement, roundLeft);
    }
    public void setImprovements (ArrayList<Improvement> improvements){
        this.improvements = improvements;
    }

    public void setTurnForUnit (Unit unit, int turn) {
        turnForUnitMaking.replace(unit, turn);
    }
    public void removeUnitFromMakingProgress(Unit unit) {
        turnForUnitMaking.remove(unit);
    }
    public void addUnitToMakingProgress (Unit unit, int turn) {
        turnForUnitMaking.put(unit, turn);
    }

    public HashMap<Unit, Integer> getTurnForUnitMaking() {
        return turnForUnitMaking;
    }
}