package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Civilization {
    private Member member;
    private City capital;
    private int science;
    private ArrayList<Technology> technologies;
    private int gold;
    private int goldPerTurn;
    private int happiness;
    private ArrayList<City> cities;
    private HashMap<Civilization,Resource> trades;
    private ArrayList<String> messages; // (int)turn : message
    private HashMap<Civilization, Integer> winsInUnitsWar; // tamadon shekast khorde va tedad bakht haye on ra neshan mide
    private HashMap<Civilization, Integer> lossesInUnitsWar; // tamadon pirooz va tedad bord haye on ra neshan mide
    private int point;//to compare civilizations


    private Technology workingOn;//if == null -> have to choose
    private HashMap<Technology, Integer> technologyEarnedPercent;

    public Civilization(Member member, City capital){
        messages = new ArrayList<>();
        this.member = member;
        this.capital = capital;
        cities = new ArrayList<>();
        cities.add(capital);
        this.science = 0;
        technologies = new ArrayList<>();
        trades = new HashMap<>();
        technologyEarnedPercent = new HashMap<>();
    }

    public Member getMember() {
        return member;
    }

    public City getCapital() {
        return capital;
    }

    public int getScience() {
        return science;
    }

    public int getGold() {
        return gold;
    }

    public int getGoldPerTurn() {
        return goldPerTurn;
    }

    public int getHappiness() {
        return happiness;
    }

    public HashMap<Civilization, Resource> getTrades() {
        return trades;
    }

    public Technology getWorkingOn() {
        return workingOn;
    }

    public HashMap<Technology, Integer> getTechnologyEarnedPercent() {
        return technologyEarnedPercent;
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void updateCountOfUnitWin (Civilization civilization, int count) {
        winsInUnitsWar.replace(civilization, count);
    }
    public void updateCountOfUnitLose (Civilization civilization, int count) {
        lossesInUnitsWar.replace(civilization, count);
    }
    public Integer getCountOfWins (Civilization civilization) {
        return winsInUnitsWar.get(civilization);
    }
    public Integer getCountOfLosses (Civilization civilization) {
        return lossesInUnitsWar.get(civilization);
    }
    public void addCivilizationToWinsUnit (Civilization civilization) {
        winsInUnitsWar.put(civilization, 0);
    }
    public void addCivilizationToLossesUnit (Civilization civilization) {
        lossesInUnitsWar.put(civilization, 0);
    }

    public HashMap<Civilization, Integer> getWinsInUnitsWar() {
        return winsInUnitsWar;
    }

    public HashMap<Civilization, Integer> getLossesInUnitsWar() {
        return lossesInUnitsWar;
    }

    public int getPoint(){//set and get
        this.point = 0;
        //every city adds 15
        point += cities.size();
        //every tile adds 5 point
        //every unit adds 10 points;
        for(City city : cities){
            for(Tile tile : city.getTiles()){
                point += 10 * tile.getUnits().size();//for units
                point += 5;//for tile
            }
        }
        //each science adds 2 points
        point += 2 * science;
        //TODO... building points
        return point;
    }
}
