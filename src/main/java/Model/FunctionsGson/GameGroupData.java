package Model.FunctionsGson;

import Model.Civilization;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class GameGroupData {
    @Expose
    public String result;
    @Expose
    public ArrayList<Civilization> civilizations = new ArrayList<>();
    @Expose
    public ArrayList<Tile> tiles = new ArrayList<>();
    @Expose
    public int index; // index socket ha .
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();
}
