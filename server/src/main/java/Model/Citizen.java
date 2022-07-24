package Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Citizen {
    private Tile tile;
    @Expose
    public int tileNumber;

    public Citizen(Tile tile){
        this.tile = tile;
        this.tileNumber = tile.getTileNumber();
        tile.setCitizen(this);
    }

    public Tile getTile () {
        return this.tile;
    }

    public static ArrayList<Citizen> copyListOfCitizens(City city, City city1, GameGroup gameGroup) {
        ArrayList<Citizen> citizensServer = city1.getCitizens();
        ArrayList<Citizen> citizensClient = new ArrayList<>();
        for (Citizen citizen : citizensServer) {
            citizen.setTile(gameGroup.tiles.get(citizen.getTileNumber()));
            citizensClient.add(citizen);
        }
        return citizensClient;
    }


    private static Tile getCitizenTile(Tile tile, GameGroup gameGroup) {
        for (Tile tile1 : gameGroup.tiles) {
            if (tile1.equals(tile)) return tile1;
        }
        return null;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        tile.setCitizen(this);
    }

    public int getTileNumber() {
        return tileNumber;
    }
}
