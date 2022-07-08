package Model;

import java.io.Serializable;

public class Resource {

    private String name;

    private boolean isLuxury = false;
    private boolean isStrategic = false;
    private boolean isBonus = false;

    private int food;
    private int production;
    private int gold;
//  ------------------------- bonus resources
    private boolean isBanana = false;
    private boolean isCow = false;
    private boolean isGazelle = false;
    private boolean isSheep = false;
    private boolean isWheat = false;
//    ------------------------ luxury resources
    private boolean isCotton = false;//panbe
    private boolean isColor = false;
    private boolean isFur = false;//Khaz
    private boolean isGem = false;
    private boolean isGold = false;
    private boolean isGas = false;//Bokhor
    private boolean isTusk = false;//Aj
    private boolean isMarble = false;//Marmar
    private boolean isSilk = false;
    private boolean isSilver = false;
    private boolean isSugar = false;
//    ------------------------ strategic resources
    private boolean isCoal = false;
    private boolean isHorse = false;
    private boolean isMetal = false;
//    ------------------------
    public Resource(String name){
        food = 0;
        production = 0;
        gold = 0;

        switch (name){
            case "Banana":
                isBonus = true;
                food = 1;
                isBanana = true;
                break;
            case "Cow":
                isBonus = true;
                food = 1;
                isCow = true;
                break;
            case "Gazelle":
                isBonus = true;
                food = 1;
                isGazelle = true;
                break;
            case "Sheep":
                isBonus = true;
                food = 1;
                isSheep = true;
                break;
            case "Wheat":
                isBonus = true;
                food = 1;
                isWheat = true;
                break;
            case "Cotton":
                isLuxury = true;
                gold = 2;
                isCotton = true;
                break;
            case "Color":
                isLuxury = true;
                gold = 2;
                isColor = true;
                break;
            case "Fur":
                isLuxury = true;
                gold = 2;
                isFur = true;
                break;
            case "Gem":
                isLuxury = true;
                gold = 2;
                isGem = true;
                break;
            case "Gold":
                isLuxury = true;
                gold = 2;
                isGold = true;
                break;
            case "Gas":
                isLuxury = true;
                gold = 2;
                isGas = true;
                break;
            case "Tusk":
                isLuxury = true;
                gold = 2;
                isTusk = true;
                break;
            case "Marble":
                isLuxury = true;
                gold = 2;
                isMarble = true;
                break;
            case "Silk":
                isLuxury = true;
                gold = 2;
                isSilk = true;
                break;
            case "Silver":
                isLuxury = true;
                gold = 2;
                isSilver = true;
                break;
            case "Sugar":
                isLuxury = true;
                gold = 2;
                isSugar = true;
                break;
            case "Coal":
                isStrategic = true;
                production = 1;
                isCoal = true;
                break;
            case "Horse":
                isStrategic = true;
                production = 1;
                isHorse = true;
                break;
            case "Metal":
                isStrategic = true;
                production = 1;
                isMetal = true;
                break;
        }
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public boolean isBanana() {
        return isBanana;
    }

    public boolean isCow() {
        return isCow;
    }

    public boolean isGazelle() {
        return isGazelle;
    }

    public boolean isShip() {
        return isSheep;
    }

    public boolean isWheat() {
        return isWheat;
    }

    public boolean isCoal() {
        return isCoal;
    }

    public boolean isHorse() {
        return isHorse;
    }


    public boolean isMetal() {
        return isMetal;
    }

    public boolean isCotton() {
        return isCotton;
    }

    public boolean isColor() {
        return isColor;
    }

    public boolean isFur() {
        return isFur;
    }

    public boolean isGem() {
        return isGem;
    }

    public boolean isGold() {
        return isGold;
    }

    public boolean isGas() {
        return isGas;
    }

    public boolean isTusk() {
        return isTusk;
    }

    public boolean isMarble() {
        return isMarble;
    }

    public boolean isSilk() {
        return isSilk;
    }

    public boolean isSilver() {
        return isSilver;
    }

    public boolean isSugar() {
        return isSugar;
    }

    public String getName() {
        return name;
    }

    public boolean isLuxury() {
        return isLuxury;
    }

    public boolean isStrategic() {
        return isStrategic;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public boolean isSheep() {
        return isSheep;
    }
}
