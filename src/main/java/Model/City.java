package Model;

import Model.Units.Unit;
import Model.Units.Warrior;
import View.PlayGameMenu;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class City {
    //perTurn
    @Expose
    private int gold;
    @Expose
    private int food;
    @Expose
    private int production;
    //perTurn
    @Expose
    private int totalFood;
    @Expose
    private ArrayList<Citizen> citizens;
    @Expose
    private Tile centerTile;
    @Expose
    private ArrayList<Tile> tiles;
    @Expose
    private int defenceStrength;
    @Expose
    private int damagePoint; // emtiaz zarbe har shahr
    @Expose
    private int sciencePerTurn;

    public City(Tile centerTile, ArrayList<Tile> map){
        this.totalFood = 5;
        this.centerTile = centerTile;
        citizens = new ArrayList<>();
        citizens.add(new Citizen(centerTile));

        tiles = new ArrayList<>();
        for(Tile tile : map){
            if(areTilesNeighbour(centerTile, tile)){
                tiles.add(tile);
            }
        }

        this.damagePoint = 20;
        this.gold = 0;
        this.sciencePerTurn = 0;
        this.defenceStrength = 0;
        this.food = 0;
        this.production = 0;

    }

    public City() {
    }

    public int getDamagePoint() {
        return damagePoint;
    }

    public void setDamagePoint(int damagePoint) {
        this.damagePoint = damagePoint;
    }

    public int getDefenceStrength(){//set and get
        this.defenceStrength = 0;
        //every tile adds +3 point
        this.defenceStrength += 3 * tiles.size();
        // add strength if city has hill
        int hillEffect = 0;
        //add units strength
        for(Tile tile : getTiles()){
            System.out.println("tile number : " + tile.getTileNumber());
            if(tile.getBuilding() != null){
                this.defenceStrength += tile.getBuilding().getDefence();
            }
            if (tile.isHill()) {
                hillEffect ++;
            }
            for(Unit unit : tile.getUnits()){
                if(!unit.isCivilian()){
                    Warrior warrior = (Warrior) unit;
                    this.defenceStrength += warrior.getDamage();
                    if (warrior.isOnDeployment()) this.defenceStrength ++;
                }
            }
        }
        return this.defenceStrength + hillEffect;
    }

    public int getSciencePerTurn() {//set and get
        this.sciencePerTurn = 0;
        //every citizen adds +10 point
        this.sciencePerTurn += 10 * citizens.size();

        return sciencePerTurn;
    }

    public int getGold(){//set and get
        this.gold = 0;
        for(Tile tile : tiles){
            if(tile.getBuilding() != null){
                this.gold += tile.getBuilding().getGold();
                this.gold -= tile.getBuilding().getMaintenance();
            }
            if(tile.getCitizen() != null){
                this.gold += tile.getGold();
            }
        }
        return this.gold;
    }
    public int getFood(){//set and get
        this.food = 0;
        for(Tile tile : tiles){
            if(tile.getBuilding() != null){
                this.food += tile.getBuilding().getFood();
            }
            if(tile.getCitizen() != null){
                this.food += tile.getFood();
            }
        }
        return this.food;
    }
    public int getProduction(){//set and get
        this.production = 0;
        for(Tile tile : tiles){
            if(tile.getBuilding() != null){
                this.production += tile.getBuilding().getProduction();
            }
            if(tile.getCitizen() != null){
                this.production += tile.getProduction();
            }
        }
        return this.production;
    }

    public boolean areTilesNeighbour(Tile tile1, Tile tile2){
        double distance = (double) Math.sqrt(Math.pow(tile1.getX() - tile2.getX(), 2) + Math.pow(tile1.getY() - tile2.getY(), 2));
        if(distance < 1.1 * tile1.getRadius() * Math.sqrt(3))
            return true;

        return false;
    }
    public Tile getCenterTile() {
        return centerTile;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Citizen> getCitizens() {
        return citizens;
    }

    public void setTotalFood(int amount){
        this.totalFood += amount;
    }

    public int getTotalFood(){
        return totalFood;
    }

    public void setProduction(int amount){
        production += amount;
    }

    public void addCitizen(Citizen citizen){
        this.citizens.add(citizen);
    }

    public boolean equals(City city) {
        if (this.centerTile.equals(city.getCenterTile())) return true;
        return false;
    }

    public void copyFieldsOfCity(City city) {
        this.gold = city.getGold();
        this.food = city.getFood();
        this.production = city.getProduction();
        this.totalFood = city.getTotalFood();
        this.citizens = Citizen.copyListOfCitizens(this, city);
        this.centerTile = getCenterForCity(city.getCenterTile());
        this.tiles = getCityTiles(city.getTiles());
        System.out.println("centerTile : " + this.centerTile.getTileNumber() + "  units : " + this.centerTile.getUnits());
        for (Tile tile : this.tiles) {
            System.out.println("tiles : " + tile.getTileNumber() + "  units : " + tile.getUnits() );
        }
        this.defenceStrength = city.getDefenceStrength2();
        this.damagePoint = city.getDamagePoint();
        this.sciencePerTurn = city.getSciencePerTurn();
    }

    public ArrayList<Tile> getCityTiles(ArrayList<Tile> tiles) {
        ArrayList<Tile> tilesCity = new ArrayList<>();
        for (Tile tile : PlayGameMenu.tiles) {
            for (Tile tile1 : tiles) {
                if (tile.equals(tile1)) {
                    tilesCity.add(tile);
                    break;
                }
            }
        }
        return tilesCity;
    }

    public Tile getCenterForCity(Tile centerTile) {
        for (Tile tile : PlayGameMenu.tiles) {
            if (tile.equals(centerTile)) return tile;
        }
        return null;
    }

    public ArrayList<City> copyCities(ArrayList<City> clientCities, ArrayList<City> serverCities) {
        ArrayList<City> answer = new ArrayList<>();
        ArrayList<City> newCities;
        newCities = newCities(clientCities, serverCities);
        for (City newCity : newCities) {
            City city = new City(getCenterForCity(newCity.getCenterTile()), PlayGameMenu.tiles);
            city.copyFieldsOfCity(newCity);
            answer.add(city);
        }
        newCities = updateCities(clientCities, serverCities);
        for (City newCity : newCities) {
            for (City clientCity : clientCities) {
                if (clientCity.equals(newCity)) {
                    clientCity.copyFieldsOfCity(newCity);
                    answer.add(clientCity);
                    break;
                }
            }
        }

        return answer;
    }

    public ArrayList<City> newCities(ArrayList<City> clientCities, ArrayList<City> serverCities) {
        ArrayList<City> cities = new ArrayList<>();
        boolean doesExist = false;
        for (City serverCity : serverCities) {
            for (City clientCity : clientCities) {
                if (serverCity.equals(clientCity)) {
                    doesExist = true;
                    break;
                }
            }
            if (doesExist) doesExist = false;
            else cities.add(serverCity);
        }
        return cities;
    }

    public ArrayList<City> updateCities(ArrayList<City> clientCities, ArrayList<City> serverCities) {
        ArrayList<City> cities = new ArrayList<>();
        for (City serverCity : serverCities) {
            for (City clientCity : clientCities) {
                if (serverCity.equals(clientCity)) {
                    cities.add(serverCity);
                    break;
                }
            }
        }
        return cities;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public void setCenterTile(Tile centerForCity) {
        this.centerTile = centerForCity;
    }

    public int getDefenceStrength2() {
        return this.defenceStrength;
    }
}
