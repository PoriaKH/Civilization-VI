package Model.FunctionsGson;

import Model.Civilization;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CheatGson {
    // request
    @Expose
    public int amount;
    @Expose
    public Civilization civilization;
    // result
    @Expose
    public String message;
    @Expose
    public ArrayList<Tile> tiles;
    @Expose
    public ArrayList<Civilization> civilizations;
}
