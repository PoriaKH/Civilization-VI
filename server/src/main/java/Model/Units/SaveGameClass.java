package Model.Units;

import Model.Civilization;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveGameClass {
//game data
   @Expose
   public ArrayList<Civilization> civilizations = new ArrayList<>();
   @Expose
   public ArrayList<Tile> tiles = new ArrayList<>();
//tiles
   @Expose
   public URL dessert;
   @Expose
   public URL fogOfWar;
   @Expose
   public URL hill;
   @Expose
   public URL ice;
   @Expose
   public URL jungle;
   @Expose
   public URL meadow;
   @Expose
   public URL mountain;
   @Expose
   public URL plain;
   @Expose
   public URL rainforest;
   @Expose
   public URL snow;
   @Expose
   public URL tundra;
   @Expose
   public URL marsh;
   @Expose
   public URL ocean;
   @Expose
   public URL building1URL;
   @Expose
   public URL building2URL;
   @Expose
   public URL building3URL;
   @Expose
   public URL building4URL;
   @Expose
   public URL building5URL;
   @Expose
   public URL roadURL;
   @Expose
   public URL railURL;
//units
   @Expose
   public HashMap<String, URL> unitsURL = new HashMap<>();
   @Expose
   public ArrayList<String> unitsName = new ArrayList<>();
}
