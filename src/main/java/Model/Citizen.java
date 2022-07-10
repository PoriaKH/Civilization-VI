package Model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Citizen {
    @Expose
    private Tile tile;

    public Citizen(Tile tile){
        this.tile = tile;
        tile.setCitizen(this);
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        tile.setCitizen(this);
    }
}
