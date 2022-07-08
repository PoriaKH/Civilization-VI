package Model;

import java.io.Serializable;

public class Citizen {
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
