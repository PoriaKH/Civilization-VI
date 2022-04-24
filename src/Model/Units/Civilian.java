package Model.Units;

import Model.Civilization;
import Model.Tile;

public class Civilian extends Unit{
    private boolean isWorker;
    private boolean isSettler;

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
    }
}
