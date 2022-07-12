package Model;

import com.google.gson.annotations.Expose;

import java.awt.*;
import java.io.Serializable;
import javafx.scene.shape.Rectangle;

public class Improvement extends Rectangle {
    @Expose
    private int food;
    @Expose
    private int production;
    @Expose
    private int gold;
    @Expose
    private boolean isWorking;//gharat nashode ast.(kharab nashode ast)
    @Expose
    private boolean isCamp;
    @Expose
    private boolean isFarm;
    @Expose
    private boolean isLumberMill;
    @Expose
    private boolean isMine;
    @Expose
    private boolean isPaddock;//CheraGah
    @Expose
    private boolean isAgriculture;
    @Expose
    private boolean isStoneMine;
    @Expose
    private boolean isTradingPost;
    @Expose
    private boolean isLaboratory;
    @Expose
    private String name;
    public Improvement(boolean isCamp, boolean isFarm, boolean isLumberMill, boolean isMine, boolean isPaddock,
                       boolean isAgriculture, boolean isStoneMine, boolean isTradingPost, boolean isLaboratory, int food, int production, int gold){
        this.isCamp = isCamp;
        if (isCamp)
            this.name = "Camp";
        this.isFarm = isFarm;
        if (isFarm)
            this.name = "Farm";
        this.isLumberMill = isLumberMill;
        if (isLumberMill)
            this.name = "LumberMill";
        this.isMine = isMine;
        if (isMine)
            this.name = "Mine";
        this.isPaddock = isPaddock;
        if (isPaddock)
            this.name = "Paddock";
        this.isAgriculture = isAgriculture;
        if (isAgriculture)
            this.name = "Agriculture";
        this.isStoneMine = isStoneMine;
        if (isStoneMine)
            this.name = "StoneMine";
        this.isTradingPost = isTradingPost;
        if (isTradingPost)
            this.name = "TradingPost";
        this.isLaboratory = isLaboratory;
        if (isLaboratory)
            this.name = "Laboratory";
        this.isWorking = true;
        this.food = food;
        this.production = production;
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public int getGold() {
        return gold;
    }

    public int getProduction() {
        return production;
    }

    public boolean isAgriculture() {
        return isAgriculture;
    }

    public boolean isCamp() {
        return isCamp;
    }

    public boolean isFarm() {
        return isFarm;
    }

    public boolean isLaboratory() {
        return isLaboratory;
    }

    public boolean isLumberMill() {
        return isLumberMill;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isPaddock() {
        return isPaddock;
    }

    public boolean isStoneMine() {
        return isStoneMine;
    }

    public boolean isTradingPost() {
        return isTradingPost;
    }

    public boolean isWorking() {
        return isWorking;
    }
    public void setIsWorking(boolean isWorking){
        this.isWorking = isWorking;
    }

    public String getName() {
        return name;
    }
}
