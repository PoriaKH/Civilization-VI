package Model.Units;

import Model.Civilization;
import Model.Technology;
import Model.Tile;
import Model.Node;
import View.PlayGameMenu;
import View.Room;
import View.UnitPanel;
import com.google.gson.annotations.Expose;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Unit extends Rectangle {
    @Expose
    private Civilization civilization;

    private Tile origin;
    @Expose
    private int health;
    @Expose
    private int MP;   // it shows mp for a unit and its final.
    @Expose
    private int mp;  // it changes every time unit moves.
    @Expose
    private int duration;
    @Expose
    private int goldCost;
    @Expose
    private int movesLeft;
    // for nextTurn
    @Expose
    private boolean hasOrdered;
    @Expose
    private boolean isOnSleep;
    @Expose
    private boolean isCivilian;

    private Tile destination;//if == null -> null

    //URL
    @Expose
    public static HashMap<String, URL> unitsURL = new HashMap<>();
    @Expose
    public static ArrayList<String> unitsName = new ArrayList<>();
    @Expose
    private boolean isOnWarFooting;//Amade bash
    @Expose
    private boolean isOnBoost;
    @Expose
    private boolean isOnBoostTillRecover;
    @Expose
    public static PlayGameMenu playGameMenu;

    private ArrayList<Node> path = new ArrayList<>(); //the shortest way, it also contains origin and destination

    public Unit(Civilization civilization, Tile origin, int health, int MP, int mp, int duration, int goldCost, boolean isCivilian) {
        this.hasOrdered = false;
        if(isCivilian)
            hasOrdered = true;

        this.civilization = civilization;
        this.origin = origin;
        this.health = health;
        this.MP = MP;
        this.mp = mp;
        this.duration = duration;
        this.goldCost = goldCost;
        this.isCivilian = isCivilian;
        this.setWidth(80);
        this.setHeight(80);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Room.isMyTurn) {
                    if (!((Unit) event.getSource()).getCivilization().equals(PlayGameMenu.playingCivilization)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("selected unit :");
                        alert.setHeaderText("result :");
                        alert.setContentText("this unit is not for your civilization !");
                        alert.showAndWait();
                    } else {
                        UnitPanel.unit = (Unit) event.getSource();
                        UnitPanel.stage = Tile.stage;
                        UnitPanel.infoPanelScene = Tile.scene;
                        UnitPanel.doesEnteredFromInfoPanel = false;
                        UnitPanel.map = Tile.map;
                        UnitPanel.playingCivilization = PlayGameMenu.playingCivilization;
                        UnitPanel.civilizations = Tile.civilizations;
                        UnitPanel.playGameMenu = playGameMenu;
                        try {
                            new UnitPanel().start();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("illegal action");
                    alert.setHeaderText("result :");
                    alert.setContentText("it is not your turn");
                    alert.showAndWait();
                }
            }
        });
    }

    public static void setNames () {
        unitsName.add("Worker");
        unitsName.add("Warrior");
        unitsName.add("Trebuchet");
        unitsName.add("Tank");
        unitsName.add("Swordsman");
        unitsName.add("Spearman");
        unitsName.add("Settler");
        unitsName.add("Scout");
        unitsName.add("Rifleman");
        unitsName.add("Pikeman");
        unitsName.add("Panzer");
        unitsName.add("Musketman");
        unitsName.add("Longswordsman");
        unitsName.add("Knight");
        unitsName.add("Infantry");
        unitsName.add("Horseman");
        unitsName.add("Crossbowman");
        unitsName.add("Chariot Archer");
        unitsName.add("Cavalry");
        unitsName.add("Lancer");
        unitsName.add("Catapult");
        unitsName.add("Cannon");
        unitsName.add("Artillery");
        unitsName.add("Archer");
        unitsName.add("Anti-Tank Gun");
    }

    public boolean getHasOrdered() {
        return hasOrdered;
    }

    public boolean getIsOnSleep() {
        return isOnSleep;
    }

    public int getDuration() {
        return duration;
    }

    public int getConstantMP() {
        return MP;
    }

    public void setConstantMP(int MP) {
        this.MP = MP;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public Tile getOrigin() {
        return origin;
    }

    private boolean isOnDeployment;

    public boolean isOnSleep() {
        return isOnSleep;
    }

    public boolean isOnWarFooting() {
        return isOnWarFooting;
    }

    public boolean isOnBoost() {
        return isOnBoost;
    }

    public boolean isOnBoostTillRecover() {
        return isOnBoostTillRecover;
    }

    public boolean isOnDeployment() {
        return isOnDeployment;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public void setOnWarFooting(boolean onWarFooting) {
        isOnWarFooting = onWarFooting;
    }

    public void setOnBoostTillRecover(boolean onBoostTillRecover) {
        isOnBoostTillRecover = onBoostTillRecover;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setOnBoost(boolean onBoost) {
        isOnBoost = onBoost;
    }

    public boolean isCivilian() {
        return isCivilian;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setOnSleep(boolean onSleep) {
        isOnSleep = onSleep;
    }

    public void setOnDeployment(boolean onDeployment) {
        isOnDeployment = onDeployment;
    }

    public Tile getDestination() {
        return destination;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public boolean isHasOrdered() {
        return hasOrdered;
    }

    public void setHasOrdered(boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
    }

    public void setOrigin(Tile origin) {
        this.origin = origin;
    }

    public void setDestination(Tile destination) {
        this.destination = destination;
    }

    public boolean equals (Unit unit) {
        if (this.isCivilian == unit.isCivilian &&
                this.origin.equals(unit.origin)) return true;
        return false;
    }
}
