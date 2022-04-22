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

    private Technology workingOn;//if == null -> have to choose
    private HashMap<Technology, Integer> technologyEarnedPercent;

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}

