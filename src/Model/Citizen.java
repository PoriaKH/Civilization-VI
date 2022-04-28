package Model;

public class Citizen {
    private Tile tile;

    public Citizen(Tile tile){
        this.tile = tile;
        tile.setCitizen(this);
    }
}
