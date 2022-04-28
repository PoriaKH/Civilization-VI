package Model;

import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;

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
    private ArrayList<Warrior> warriors;
    private ArrayList<Civilian> civilians;

    private Technology workingOn;//if == null -> have to choose
    private HashMap<Technology, Integer> technologyEarnedPercent;

    public Civilization(Member member, City capital){
        this.warriors = new ArrayList<>();
        this.civilians = new ArrayList<>();
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
    public void addWarrior(Warrior warrior){
        this.warriors.add(warrior);
    }
    public void addCivilian(Civilian civilian){
        this.civilians.add(civilian);
    }
}
