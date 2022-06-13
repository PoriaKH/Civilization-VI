package Model;

import javafx.scene.shape.Rectangle;

public class Building extends Rectangle {
    private Civilization civilization;
    private Tile tile;

    private boolean isAncientEra = false;
    private boolean isClassicalEra = false;
    private boolean isMedievalEra = false;
    private boolean isRenaissanceEra = false;
    private boolean isIndustrialEra = false;


    private int cost;
    private int maintenance;//amount of gold required to pay as tax for each turn
    private Technology technologyRequired;//could be null

    private int gold;//will add to civilization(setGold)
    private int science;//will add to civilization(setScience)
    private int happiness;//will add to civilization(setHappiness)
    private int xp;//will add to all civilization Warrior units(increaseXp)
    private int food;//will add to city (setTotalFood)
    private int defence;//will add to city (setDefenceStrength)
    private int production;//will add to city(setProduction)

    public Building(String name,Civilization civilization,Tile tile){
        this.civilization = civilization;
        this.tile = tile;

        gold = 0;
        science = 0;
        food = 0;
        happiness = 0;
        defence = 0;
        xp = 0;
        production = 0;

        switch (name){
            case "Barracks":
                this.isAncientEra = true;
                this.cost = 80;
                this.maintenance = 1;
                this.technologyRequired = new Technology(false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.xp = 15;
                break;
            case "Granary":
                this.isAncientEra = true;
                this.cost = 100;
                this.maintenance = 1;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.food = 2;
                break;
            case "Library":
                this.isAncientEra = true;
                this.cost = 80;
                this.maintenance = 1;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.science = 1;
                break;
            case "Monument":
                this.isAncientEra = true;
                this.cost = 60;
                this.maintenance = 1;
                this.technologyRequired = null;
                break;
            case "Walls":
                this.isAncientEra = true;
                this.cost = 100;
                this.maintenance = 1;
                this.technologyRequired = new Technology(false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.defence = 5;
                break;
            case "Water Mill":
                this.isAncientEra = true;
                this.cost = 120;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.food = 2;
                break;
            case "Armory":
                this.isClassicalEra = true;
                this.cost = 130;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.xp = 15;
                break;
            case "Burial Tomb":
                this.isClassicalEra = true;
                this.cost = 120;
                this.maintenance = 0;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 2;
                break;
            case "Circus":
                this.isClassicalEra = true;
                this.cost = 150;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 3;
                break;
            case "Colosseum":
                this.isClassicalEra = true;
                this.cost = 150;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 4;
                break;
            case "Courthouse":
                this.isClassicalEra = true;
                this.cost = 200;
                this.maintenance = 5;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 6;
                break;
            case "Stable":
                this.isClassicalEra = true;
                this.cost = 100;
                this.maintenance = 1;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.production = 10;
                break;
            case "Temple":
                this.isClassicalEra = true;
                this.cost = 120;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                break;
            case "Castle":
                this.isMedievalEra = true;
                this.cost = 200;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.defence = 8;
                break;
            case "Forge":
                this.isMedievalEra = true;
                this.cost = 150;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.production = 7;
                break;
            case "Garden":
                this.isMedievalEra = true;
                this.cost = 120;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 7;
                break;
            case "Market":
            case "Mint":
                this.isMedievalEra = true;
                this.cost = 120;
                this.maintenance = 0;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.gold = 15;
                break;
            case "Monastery":
                this.isMedievalEra = true;
                this.cost = 120;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                break;
            case "University":
                this.isMedievalEra = true;
                this.cost = 200;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.science = 10;
                break;
            case "Workshop":
                this.isMedievalEra = true;
                this.cost = 100;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.production = 10;
                break;
            case "Bank":
                this.isRenaissanceEra = true;
                this.cost = 220;
                this.maintenance = 0;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.gold = 25;
                break;
            case "Military Academy":
                this.isRenaissanceEra = true;
                this.cost = 350;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.xp = 15;
                break;
            case "Museum":
                this.isRenaissanceEra = true;
                this.cost = 350;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 5;
                break;
            case "Opera House":
                this.isRenaissanceEra = true;
                this.cost = 220;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 5;
                break;
            case "Public School":
                this.isRenaissanceEra = true;
                this.cost = 350;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false);
                this.science = 10;
                break;
            case "Satrap’s Court":
                this.isRenaissanceEra = true;
                this.cost = 220;
                this.maintenance = 0;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.gold = 15;
                break;
            case "Theater":
                this.isRenaissanceEra = true;
                this.cost = 300;
                this.maintenance = 5;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false);
                this.happiness = 8;
                break;
            case "Windmill":
                this.isRenaissanceEra = true;
                this.cost = 180;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
                this.production = 10;
                break;
            case "Arsenal":
                this.isIndustrialEra = true;
                this.cost = 350;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false);
                this.production = 15;
                break;
            case "Broadcast Tower":
                this.isIndustrialEra = true;
                this.cost = 600;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false);
                this.happiness = 10;
                break;
            case "Factory":
                this.isIndustrialEra = true;
                this.cost = 300;
                this.maintenance = 3;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false);
                this.production = 20;
                break;
            case "Hospital":
                this.isIndustrialEra = true;
                this.cost = 400;
                this.maintenance = 2;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false);
                this.food = 15;
                break;
            case "Military Base":
                this.isIndustrialEra = true;
                this.cost = 450;
                this.maintenance = 4;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true);
                this.defence = 12;
                break;
            case "Stock Exchange":
                this.isIndustrialEra = true;
                this.cost = 650;
                this.maintenance = 0;
                this.technologyRequired = new Technology(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false);
                this.gold = 15;
                break;
        }
    }

    public Civilization getCivilization() {
        return civilization;
    }
    public Tile getTile(){
        return this.tile;
    }

    public int getGold() {
        return gold;
    }

    public int getScience() {
        return science;
    }

    public int getFood() {
        return food;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getDefence() {
        return defence;
    }

    public int getXp() {
        return xp;
    }

    public int getProduction() {
        return production;
    }

    public Technology getRequiredTechnology() {
        return technologyRequired;
    }

    public int getCost() {
        return cost;
    }
}
