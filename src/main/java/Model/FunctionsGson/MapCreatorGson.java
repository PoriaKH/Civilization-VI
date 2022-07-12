package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class MapCreatorGson {
    // parameters
    @Expose
    public int numOfCivilizations;
    @Expose
    public ArrayList<Member> members;

    // results
    @Expose
    public ArrayList<Tile> map;
    @Expose
    public ArrayList<Civilization> civilizations;

    public MapCreatorGson(String functionName, int numOfCivilizations, ArrayList<Member> members) {
        this.numOfCivilizations = numOfCivilizations;
        this.members = members;
    }
}


