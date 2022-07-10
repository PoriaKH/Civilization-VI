package Model.Units;

import Model.Civilization;
import Model.Tile;
import com.google.gson.annotations.Expose;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.Serializable;
import java.net.URL;

public class Civilian extends Unit {
    @Expose
    private boolean isWorker;
    @Expose
    private boolean isSettler;
    @Expose
    private Tile workingTile; // tile e ke dare roosh kar mikone ro neshoon mide age null bashe mitoone move va ... kone

    public Tile getWorkingTile() {
        return workingTile;
    }

    public void setWorkingTile(Tile workingTile) {
        this.workingTile = workingTile;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public boolean isSettler() {
        return isSettler;
    }

    public void setSettler(boolean settler) {
        isSettler = settler;
    }

    public Civilian(Civilization civilization, Tile origin, int health, int MP, int mp, int duration, int goldCost, boolean isCivilian, boolean isWorker, boolean isSettler) {
        super(civilization, origin, health, MP, mp, duration, goldCost, isCivilian);
        this.isWorker = isWorker;
        this.isSettler = isSettler;
        Image image = new Image(getURL().toExternalForm());
        ImagePattern imagePattern = new ImagePattern(image);
        this.setFill(imagePattern);
    }
    public URL getURL () {
        if (this.isSettler) {
            return unitsURL.get("Settler");
        }
        return unitsURL.get("Worker");
    }
}
