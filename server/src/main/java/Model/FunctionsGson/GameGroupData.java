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

    public GameGroupData(ArrayList<Civilization> civilizations, ArrayList<Tile> tiles) {
        this.civilizations = civilizations;
        this.tiles = tiles;
    }
}
