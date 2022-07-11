package Model;

import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;
import com.google.gson.annotations.Expose;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tile extends Polygon {
    @Expose
    public static URL banana;
    @Expose
    public static URL coal;
    @Expose
    public static URL color;
    @Expose
    public static URL cotton;
    @Expose
    public static URL cow;
    @Expose
    public static URL fur;
    @Expose
    public static URL gas;
    @Expose
    public static URL gazelle;
    @Expose
    public static URL gem;
    @Expose
    public static URL golds;
    @Expose
    public static URL horse;
    @Expose
    public static URL marble;
    @Expose
    public static URL metal;
    @Expose
    public static URL sheep;
    @Expose
    public static URL silk;
    @Expose
    public static URL silver;
    @Expose
    public static URL sugar;
    @Expose
    public static URL tusk;
    @Expose
    public static URL wheat;
    @Expose
    public static URL dessert;
    @Expose
    public static URL fogOfWar;
    @Expose
    public static URL hill;
    @Expose
    public static URL ice;
    @Expose
    public static URL jungle;
    @Expose
    public static URL meadow;
    @Expose
    public static URL mountain;
    @Expose
    public static URL plain;
    @Expose
    public static URL rainforest;
    @Expose
    public static URL snow;
    @Expose
    public static URL tundra;
    @Expose
    public static URL marsh;
    @Expose
    public static URL ocean;
    @Expose
    public static URL building1URL;
    @Expose
    public static URL building2URL;
    @Expose
    public static URL building3URL;
    @Expose
    public static URL building4URL;
    @Expose
    public static URL building5URL;
    @Expose
    public static URL roadURL;
    @Expose
    public static URL railURL;

    // for panel changing needed
    @Expose
    public static Pane root;
    @Expose
    public static Scene scene;
    @Expose
    public static Stage stage;
    @Expose
    public static ArrayList<Tile> map;
    @Expose
    public static ArrayList<Civilization> civilizations;
    @Expose
    public float cameraSpeed = 30;
    @Expose
    private boolean isDesert;//Smooth
    @Expose
    private boolean isMeadow;//Alafzar          //Smooth
    @Expose
    private boolean isHill;//Tape               //2             //isBlocker
    @Expose
    private boolean isMountain;                 //NA            //isBlocker
    @Expose
    private boolean isOcean;                    //NA
    @Expose
    private boolean isPlain;                    //Smooth
    @Expose
    private boolean isSnow;                     //Smooth
    @Expose
    private boolean isTundra;                   //Smooth
    @Expose
    private boolean isBlocker;
    @Expose
    private int food;
    @Expose
    private int production;
    @Expose
    private int gold;
    @Expose
    private int combatChange;
    @Expose
    private int mpCost;
    @Expose
    private int tileNumber;
    @Expose
    private float x,y;
    @Expose
    private float radius;
    @Expose
    private double h;
    @Expose
    private Citizen citizen = null;
    @Expose
    private ArrayList<Unit> units;
    @Expose
    private Building building;
    @Expose
    private HashMap<Unit, Integer> turnForUnitMaking = new HashMap<>();
    @Expose
    private Resource resource;
    @Expose
    private Attribute attribute;
    @Expose
    private ArrayList<Improvement> improvements;
    @Expose
    private boolean isWorking;
    @Expose
    private boolean isOnRepair;
    @Expose
    private int repairNeedImprovement;
    @Expose
    private Rectangle road = new Rectangle(x - 160, y + 30, 40, 20);
    @Expose
    private Rectangle rail = new Rectangle(x - 160, y - 30, 40, 20);

    @Expose
    private ArrayList<Tile> roads;
    @Expose
    private ArrayList<Tile> railRoads;

    public Tile(int tileNumber, boolean isDesert, boolean isMeadow, boolean isHill, boolean isMountain, boolean isOcean, boolean isPlain, boolean isSnow, boolean isTundra, float x, float y){
        this.isWorking = false;
        this.isOnRepair = false;
        this.repairNeedImprovement = 0;
        this.roads = new ArrayList<>();
        this.railRoads = new ArrayList<>();
        this.units = new ArrayList<>();
        this.improvements = new ArrayList<>();
        this.isDesert = isDesert;
        this.isMeadow = isMeadow;
        this.isHill = isHill;
        this.isMountain = isMountain;
        this.isOcean = isOcean;
        this.isPlain = isPlain;
        this.isSnow = isSnow;
        this.isTundra = isTundra;
        this.isBlocker = false;
        if(isHill || isMountain)
            this.isBlocker = true;

        this.tileNumber = tileNumber;
        this.x = x;
        this.y = y;
        this.radius = 200;
        this.h = radius * Math.sqrt(3) / 2;

        this.food = 0;
        this.production = 0;
        this.gold = 0;
        this.combatChange = 0;
        this.mpCost = 0;

        if(tileNumber == 17 || tileNumber == 13 || tileNumber == 19 || tileNumber == 20 || tileNumber == 22){
            this.attribute = new Attribute(true,false,false,false,false,false);
        }
        //
        if(isDesert){
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null) {
                Random rand = new Random();
                int number = rand.nextInt(2);

                if (number == 1) {//Attribute exists
                    number = rand.nextInt(2);

                    if (number == 0) {//not Oasis
                        number = rand.nextInt(2);
                        if (number == 0) {//Ice
                            this.attribute = new Attribute(false, false, true, false, false, false);
                        } else {//Marsh
                            this.attribute = new Attribute(false, false, false, false, true, false);
                        }
                    } else {//Oasis
                        this.attribute = new Attribute(false, false, false, false, false, true);
                    }
                }
            }
            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(7);
                switch (number){
                    case 0:
                        this.resource = new Resource("Sheep");
                        break;
                    case 1:
                        this.resource = new Resource("Cotton");
                        break;
                    case 2:
                        this.resource = new Resource("Gem");
                        break;
                    case 3:
                        this.resource = new Resource("Gold");
                        break;
                    case 4:
                        this.resource = new Resource("Gas");
                        break;
                    case 5:
                        this.resource = new Resource("Marble");
                        break;
                    case 6:
                        this.resource = new Resource("Silver");
                        break;
                }
            }
        }
        else if(isMeadow){
            food += 2;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null) {
                Random rand = new Random();
                int number = rand.nextInt(2);

                if (number == 1) {//Attribute exists
                    number = rand.nextInt(2);
                    if (number == 0) {//RainForest
                        this.attribute = new Attribute(false, false, false, true, false, false);
                    } else {//Marsh
                        this.attribute = new Attribute(false, false, false, false, true, false);
                    }
                }
            }
            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(10);
                switch (number){
                    case 0:
                        this.resource = new Resource("Banana");
                        break;
                    case 1:
                        this.resource = new Resource("Cow");
                        break;
                    case 2:
                        this.resource = new Resource("Gazelle");
                        break;
                    case 3:
                        this.resource = new Resource("Sheep");
                        break;
                    case 4:
                        this.resource = new Resource("Cotton");
                        break;
                    case 5:
                        this.resource = new Resource("Color");
                        break;
                    case 6:
                        this.resource = new Resource("Fur");
                        break;
                    case 7:
                        this.resource = new Resource("Gold");
                        break;
                    case 8:
                        this.resource = new Resource("Marble");
                        break;
                    case 9:
                        this.resource = new Resource("Silk");
                        break;
                }
            }
        }
        else if(isHill){
            production += 2;
            combatChange += 25;
            mpCost += 2;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(2);
                    if(number == 1){//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                    else {//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                }
            }
            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(4);
                switch (number){
                    case 0:
                        this.resource = new Resource("Gazelle");
                        break;
                    case 1:
                        this.resource = new Resource("Sheep");
                        break;
                    case 2:
                        this.resource = new Resource("Gold");
                        break;
                    case 3:
                        this.resource = new Resource("Silver");
                        break;
                }
            }
        }
        else if(isMountain){
            mpCost = 100000000;
            this.attribute = new Attribute(false,true,false,false,false,false);
            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){
                this.resource = new Resource("Horse");
            }
        }
        else if(isOcean){
            mpCost = 100000000;
        }
        else if(isPlain){
            food += 1;
            production += 1;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(3);
                    if(number == 0){//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                    else if(number == 1){//RainForest
                        this.attribute = new Attribute(false,false,false,true,false,false);
                    }
                    else {//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                }
            }

            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(8);
                switch (number){
                    case 0:
                        this.resource = new Resource("Wheat");
                        break;
                    case 1:
                        this.resource = new Resource("Cotton");
                        break;
                    case 2:
                        this.resource = new Resource("Gem");
                        break;
                    case 3:
                        this.resource = new Resource("Gold");
                        break;
                    case 4:
                        this.resource = new Resource("Gas");
                        break;
                    case 5:
                        this.resource = new Resource("Tusk");
                        break;
                    case 6:
                        this.resource = new Resource("Marble");
                        break;
                    case 7:
                        this.resource = new Resource("Coal");
                        break;
                }
            }
        }
        else if(isSnow){
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){//Ice
                    this.attribute = new Attribute(false,false,true,false,false,false);
                }
            }

            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(2);
                switch (number){
                    case 0:
                        this.resource = new Resource("Sugar");
                        break;
                    case 1:
                        this.resource = new Resource("Metal");
                        break;
                }
            }
        }
        else if(isTundra){
            food += 1;
            combatChange -= 33;
            mpCost += 1;

            if(this.attribute == null){
                Random rand = new Random();
                int number = rand.nextInt(2);

                if(number == 1){
                    number = rand.nextInt(3);
                    if(number == 0){//Ice
                        this.attribute = new Attribute(false,false,true,false,false,false);
                    }
                    else if(number == 1){//RainForest
                        this.attribute = new Attribute(false,false,false,true,false,false);
                    }
                    else {//Marsh
                        this.attribute = new Attribute(false,false,false,false,true,false);
                    }
                }
            }
            Random random = new Random();
            int number = random.nextInt(3);
            if(number == 2){//Resource exists
                number = random.nextInt(2);
                switch (number){
                    case 0:
                        this.resource = new Resource("Fur");
                        break;
                    case 1:
                        this.resource = new Resource("Silver");
                        break;
                }
            }
        }
        //
        if(this.attribute != null) {
            this.food += this.attribute.getFood();
            this.production += this.attribute.getProduction();
            this.gold += this.attribute.getGold();
            this.combatChange += this.attribute.getCombatChange();
            this.mpCost += this.attribute.getMpCost();
            this.combatChange += this.attribute.getCombatChange();
        }
        if(this.resource != null){
            this.food += this.resource.getFood();
            this.gold += this.resource.getGold();
            this.production += this.resource.getProduction();
        }


        double x1,y1;
        double x2,y2;
        double x3,y3;
        double x4,y4;
        double x5,y5;
        double x6,y6;

        y1 = y - h;
        x1 = x - radius / 2;
        x2 = radius + x1;
        y2 = y1;
        x3 = radius / 2 + x2;
        y3 = radius * Math.sqrt(3) / 2 + y2;
        x4 = x2;
        y4 = radius * Math.sqrt(3) / 2 + y3;
        x5 = x1;
        y5 = y4;
        x6 = x1 - radius/2;
        y6 = y3;


        this.getPoints().addAll(new Double[]{
                x1, y1,
                x2, y2,
                x3, y3,
                x4, y4,
                x5, y5,
                x6, y6,
        });

        root.getChildren().add(this);
    }

    public void generatingTile(int status){
        if (status == -1){
            this.setFill(new ImagePattern(new Image(fogOfWar.toExternalForm())));
            return;
        }
        //land type
        if  (isDesert)
            this.setFill(new ImagePattern(new Image(dessert.toExternalForm())));
        else if (isHill)
            this.setFill(new ImagePattern(new Image(hill.toExternalForm())));
        else if (getAttribute() != null && getAttribute().isIce())
            this.setFill(new ImagePattern(new Image(ice.toExternalForm())));
        else if (getAttribute() != null && getAttribute().isJungle())
            this.setFill(new ImagePattern(new Image(jungle.toExternalForm())));
        else if (isMeadow)
            this.setFill(new ImagePattern(new Image(meadow.toExternalForm())));
        else if (isMountain)
            this.setFill(new ImagePattern(new Image(mountain.toExternalForm())));
        else if (isPlain)
            this.setFill(new ImagePattern(new Image(plain.toExternalForm())));
        else if (getAttribute() != null && getAttribute().isRainForest())
            this.setFill(new ImagePattern(new Image(rainforest.toExternalForm())));
        else if (isSnow)
            this.setFill(new ImagePattern(new Image(snow.toExternalForm())));
        else if (isTundra)
            this.setFill(new ImagePattern(new Image(tundra.toExternalForm())));
        else if (getAttribute() != null && getAttribute().isMarsh())
            this.setFill(new ImagePattern(new Image(marsh.toExternalForm())));
        else if (isOcean)
            this.setFill(new ImagePattern(new Image(ocean.toExternalForm())));

        //resources
        if (getResource() == null)
            return;
        double x1 = this.getX() + 30;
        double y1 = this.getY();
        resource.setX(x1);
        resource.setY(y1);
        resource.setWidth(40);
        resource.setHeight(40);
        if (resource.isBanana())
            resource.setFill(new ImagePattern(new Image(banana.toExternalForm())));
        else if (resource.isCoal())
            resource.setFill(new ImagePattern(new Image(coal.toExternalForm())));
        else if (resource.isColor())
            resource.setFill(new ImagePattern(new Image(color.toExternalForm())));
        else if (resource.isCotton())
            resource.setFill(new ImagePattern(new Image(cotton.toExternalForm())));
        else if (resource.isCow())
            resource.setFill(new ImagePattern(new Image(cow.toExternalForm())));
        else if (resource.isFur())
            resource.setFill(new ImagePattern(new Image(fur.toExternalForm())));
        else if (resource.isGas())
            resource.setFill(new ImagePattern(new Image(gas.toExternalForm())));
        else if (resource.isGazelle())
            resource.setFill(new ImagePattern(new Image(gazelle.toExternalForm())));
        else if (resource.isGem())
            resource.setFill(new ImagePattern(new Image(gem.toExternalForm())));
        else if (resource.isGold())
            resource.setFill(new ImagePattern(new Image(golds.toExternalForm())));
        else if (resource.isHorse())
            resource.setFill(new ImagePattern(new Image(horse.toExternalForm())));
        else if (resource.isMarble())
            resource.setFill(new ImagePattern(new Image(marble.toExternalForm())));
        else if (resource.isMetal())
            resource.setFill(new ImagePattern(new Image(metal.toExternalForm())));
        else if (resource.isSheep())
            resource.setFill(new ImagePattern(new Image(sheep.toExternalForm())));
        else if (resource.isSilk())
            resource.setFill(new ImagePattern(new Image(silk.toExternalForm())));
        else if (resource.isSilver())
            resource.setFill(new ImagePattern(new Image(silver.toExternalForm())));
        else if (resource.isSugar())
            resource.setFill(new ImagePattern(new Image(sugar.toExternalForm())));
        else if (resource.isTusk())
            resource.setFill(new ImagePattern(new Image(tusk.toExternalForm())));
        else if (resource.isWheat())
            resource.setFill(new ImagePattern(new Image(wheat.toExternalForm())));
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    private Improvement workingOnImprovement;//if == null -> null
    private HashMap<Improvement, Integer> improvementEarnedPercent = new HashMap<>();

    private boolean doesHaveRoad;
    private boolean doesHaveRailWay;
    private boolean isRoadDamaged; // if a unit attack to road/rail it is true
    private boolean isRailDamaged;
    public void setDesert(boolean desert) {
        isDesert = desert;
    }

    public boolean isRoadDamaged() {
        return isRoadDamaged;
    }

    public void setRoadDamaged(boolean roadDamaged) {
        isRoadDamaged = roadDamaged;
    }

    public boolean isRailDamaged() {
        return isRailDamaged;
    }

    public void setRailDamaged(boolean railDamaged) {
        isRailDamaged = railDamaged;
    }
    private HashMap<Unit, Integer> workingOnRoadUntilFinish = new HashMap<>();
    private HashMap<Unit, Integer> workingOnRailUntilFinish = new HashMap<>();

    public void assignWorkerToRoad (Unit unit, Integer turn) {
        workingOnRoadUntilFinish.put(unit, turn);
    }
    public void assignWorkerToRail (Unit unit, Integer turn) {
        workingOnRailUntilFinish.put(unit, turn);
    }
    public int sizeOfHashMapRoad () {
        return workingOnRoadUntilFinish.size();
    }
    public int sizeOfHashMapRail () {
        return workingOnRailUntilFinish.size();
    }

    public Integer getNumberOfTurnsRail (Unit unit) {
        return workingOnRailUntilFinish.get(unit);
    }
    public Integer getNumberOfTurnsRoad (Unit unit) {
        return workingOnRoadUntilFinish.get(unit);
    }
    public void setNewNumberForTurnRoad (Unit unit, Integer turn) {
        workingOnRoadUntilFinish.replace(unit, turn);
    }
    public void setNewNumberForTurnRail (Unit unit, Integer turn) {
        workingOnRailUntilFinish.replace(unit, turn);
    }
    public void removeWorkerFromRoad (Unit unit) {
        workingOnRoadUntilFinish.remove(unit);
    }

    public void setDoesHaveRoad(boolean doesHaveRoad) {
        if (doesHaveRoad) {
            Image image = new Image(roadURL.toExternalForm());
            ImagePattern imagePattern = new ImagePattern(image);
            road.setFill(imagePattern);
            root.getChildren().add(road);
        }
        else {
            root.getChildren().remove(road);
        }
        this.doesHaveRoad = doesHaveRoad;
    }

    public void setDoesHaveRailWay(boolean doesHaveRailWay) {
        if (doesHaveRailWay) {
            Image image = new Image(railURL.toExternalForm());
            ImagePattern imagePattern = new ImagePattern(image);
            rail.setFill(imagePattern);
            root.getChildren().add(rail);
        }
        else {
            root.getChildren().remove(rail);
        }
        this.doesHaveRailWay = doesHaveRailWay;
    }

    public void removeWorkerFromRail (Unit unit) {
        workingOnRailUntilFinish.remove(unit);
    }


    public Resource getResource() {
        return resource;
    }
    public void addResource(Resource resource){
        this.resource = resource;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addUnit (Unit unit) {
        if (units.size() == 0) {
            unit.setX(this.x + 20);
            unit.setY(this.y - h);
        }
        else {
            unit.setX(this.x + 60);
            unit.setY(this.y - h + 90);
        }
        root.getChildren().add(unit);
        units.add(unit);
    }
    public void addUnit2 (Unit unit) {
        root.getChildren().add(unit);
        units.add(unit);
    }

    public boolean isDesert() {
        return isDesert;
    }

    public boolean isMeadow() {
        return isMeadow;
    }

    public boolean isHill() {
        return isHill;
    }

    public boolean isMountain() {
        return isMountain;
    }

    public boolean isOcean() {
        return isOcean;
    }

    public boolean isPlain() {
        return isPlain;
    }

    public boolean isSnow() {
        return isSnow;
    }

    public boolean isTundra() {
        return isTundra;
    }

    public boolean isBlocker() {
        return isBlocker;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public int getCombatChange() {
        return combatChange;
    }

    public int getMpCost() {
        return mpCost;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public double getH() {
        return h;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public ArrayList<Improvement> getImprovements() {
        return improvements;
    }

    public Improvement getWorkingOnImprovement() {
        return workingOnImprovement;
    }

    public HashMap<Improvement, Integer> getImprovementEarnedPercent() {
        return improvementEarnedPercent;
    }

    public boolean isDoesHaveRoad() {
        return doesHaveRoad;
    }

    public boolean isDoesHaveRailWay() {
        return doesHaveRailWay;
    }

    public ArrayList<Tile> getRoads() {
        return roads;
    }
    public void addBuilding(Building building){
        this.building = building;

        building.getCivilization().setScience(building.getScience());
        building.getCivilization().setHappiness(building.getHappiness());
        for(City city : building.getCivilization().getCities()){
            for(Tile tile : city.getTiles()){
                for(Unit unit : tile.getUnits()){
                    if(!unit.isCivilian()){
                        Warrior warrior = (Warrior) unit;
                        warrior.increaseXp(building.getXp());
                    }
                }
            }
        }
        for(City city : building.getCivilization().getCities()){
            for(Tile tile : city.getTiles()){
                if(tile == building.getTile()){
                    city.setTotalFood(building.getFood());
                }
            }
        }
        double y1 = y - h;
        double x1 = x - radius / 2;
        building.setX(x1);
        building.setY(y1);
        building.setWidth(80);
        building.setHeight(140);

        if(building.isAncientEra)
            building.setFill(new ImagePattern(new Image(String.valueOf(building1URL))));
        else if(building.isClassicalEra)
            building.setFill(new ImagePattern(new Image(String.valueOf(building2URL))));
        else if(building.isMedievalEra)
            building.setFill(new ImagePattern(new Image(String.valueOf(building3URL))));
        else if(building.isRenaissanceEra)
            building.setFill(new ImagePattern(new Image(String.valueOf(building4URL))));
        else if(building.isIndustrialEra)
            building.setFill(new ImagePattern(new Image(String.valueOf(building5URL))));

        root.getChildren().add(building);
    }

    public ArrayList<Tile> getRailRoads() {
        return railRoads;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void removeUnit (Unit unit) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).equals(unit)) {
                root.getChildren().remove(units.get(i));
                units.remove(i);
                break;
            }
        }
    }
    public void addImprovement (Improvement improvement){
        this.improvements.add(improvement);
    }
    public void addToImprovementEarnedPercent(Improvement improvement, Integer roundLeft){
        if (!this.improvementEarnedPercent.containsKey(improvement))
            this.improvementEarnedPercent.put(improvement, roundLeft);
        this.workingOnImprovement = improvement;
    }
    public void reduceImprovementRound(){
        if (workingOnImprovement  == null)
            return;
        int roundLeft = this.improvementEarnedPercent.get(this.workingOnImprovement) - 1;
        if (roundLeft == 0) {
            this.improvementEarnedPercent.remove(this.workingOnImprovement);
            this.addImprovement(this.workingOnImprovement);
            this.food += workingOnImprovement.getFood();
            this.gold += workingOnImprovement.getGold();
            this.production += workingOnImprovement.getProduction();
            for (Unit unit : units)
                if (unit.isCivilian()){
                    Civilian civilian = (Civilian) unit;
                    if (civilian.isWorker()){
                        civilian.setWorkingTile(null);
                        break;
                    }
                }
            workingOnImprovement = null;
        }
        this.improvementEarnedPercent.replace(this.workingOnImprovement, roundLeft);
    }
    public void cancelImprovementOnProcess(){
        if (workingOnImprovement == null)
            return;
        workingOnImprovement = null;
    }

    public boolean isOnRepair() {
        return isOnRepair;
    }

    public void setIsOnRepair(boolean isOnRepair){
        this.isOnRepair = isOnRepair;
    }

    public void setImprovements (ArrayList<Improvement> improvements){
        this.improvements = improvements;
    }

    public boolean isWorking() {
        return isWorking;
    }
    public void Loot(){
        isWorking = false;
        for (Improvement improvement: improvements)
            improvement.setIsWorking(false);
    }

    public void setRepairNeedImprovement(int repairNeedImprovement) {
        this.repairNeedImprovement = repairNeedImprovement;
    }

    public void repairAllImprovements(){
        if (repairNeedImprovement == 0 && !isWorking){
            this.isWorking = true;
            this.isOnRepair = false;
            for (Improvement improvement: improvements) {
                improvement.setIsWorking(true);
            }
        }
    }

    public void reduceRepairNeedImprovementTurn(){
        if (!isWorking && isOnRepair) {
            setRepairNeedImprovement(this.repairNeedImprovement - 1);
            repairAllImprovements();
        }
    }
    public void setTurnForUnit (Unit unit, int turn) {
        turnForUnitMaking.replace(unit, turn);
    }
    public void removeUnitFromMakingProgress(Unit unit) {
        turnForUnitMaking.remove(unit);
    }
    public void addUnitToMakingProgress (Unit unit, int turn) {
        turnForUnitMaking.put(unit, turn);
    }

    public HashMap<Unit, Integer> getTurnForUnitMaking() {
        return turnForUnitMaking;
    }

    public Unit getUnitInUnitMakingProgress (boolean isCivilian) {
        for(Map.Entry<Unit, Integer> entry : turnForUnitMaking.entrySet()) {
            if (entry.getKey().isCivilian() == isCivilian) return entry.getKey();
        }
        return null;
    }
    public void removeAllUnitFromMakingProgress () {
        turnForUnitMaking.clear();
    }
    public void removeRoadsMakingProgress () {
        workingOnRoadUntilFinish.clear();
        workingOnRailUntilFinish.clear();
    }
    public Building getBuilding(){
        return this.building;
    }
    public void moveRight(){
        double x1,y1;
        double x2,y2;
        double x3,y3;
        double x4,y4;
        double x5,y5;
        double x6,y6;

        x += cameraSpeed;

        y1 = y - h;
        x1 = x - radius/2;

        x2 = radius + x1;
        y2 = y1;
        x3 = radius / 2 + x2;
        y3 = radius * Math.sqrt(3) / 2 + y2;
        x4 = x2;
        y4 = radius * Math.sqrt(3) / 2 + y3;
        x5 = x1;
        y5 = y4;
        x6 = x1 - radius/2;
        y6 = y3;

        this.getPoints().setAll(new Double[]{
                x1, y1,
                x2, y2,
                x3, y3,
                x4, y4,
                x5, y5,
                x6, y6,
        });

        if(building != null) {
            building.setX(x1);
            building.setY(y1);
        }
        for (int i = 0; i < units.size(); i++) {
            if (i == 0) {
                units.get(i).setX(this.x + 20);
                units.get(i).setY(this.y - h);
            }
            else {
                units.get(i).setX(this.x + 60);
                units.get(i).setY(this.y - h + 90);
            }
        }
        if (doesHaveRoad) {
            road.setX(this.x - 160);
            road.setY(this.y + 30);
        }
        if (doesHaveRailWay) {
            rail.setX(this.x - 160);
            rail.setY(this.y - 30);
        }
    }
    public void moveLeft(){
        double x1,y1;
        double x2,y2;
        double x3,y3;
        double x4,y4;
        double x5,y5;
        double x6,y6;

        x -= cameraSpeed;

        y1 = y - h;
        x1 = x - radius/2;

        x2 = radius + x1;
        y2 = y1;
        x3 = radius / 2 + x2;
        y3 = radius * Math.sqrt(3) / 2 + y2;
        x4 = x2;
        y4 = radius * Math.sqrt(3) / 2 + y3;
        x5 = x1;
        y5 = y4;
        x6 = x1 - radius/2;
        y6 = y3;

        this.getPoints().setAll(new Double[]{
                x1, y1,
                x2, y2,
                x3, y3,
                x4, y4,
                x5, y5,
                x6, y6,
        });
        if(building != null) {
            building.setX(x1);
            building.setY(y1);
        }
        for (int i = 0; i < units.size(); i++) {
            if (i == 0) {
                units.get(i).setX(this.x + 20);
                units.get(i).setY(this.y - h);
            }
            else {
                units.get(i).setX(this.x + 60);
                units.get(i).setY(this.y - h + 90);
            }
        }
        if (doesHaveRoad) {
            road.setX(this.x - 160);
            road.setY(this.y + 30);
        }
        if (doesHaveRailWay) {
            rail.setX(this.x - 160);
            rail.setY(this.y - 30);
        }
    }
    public void moveUp(){
        double x1,y1;
        double x2,y2;
        double x3,y3;
        double x4,y4;
        double x5,y5;
        double x6,y6;

        y -= cameraSpeed;

        y1 = y - h;
        x1 = x - radius/2;

        x2 = radius + x1;
        y2 = y1;
        x3 = radius / 2 + x2;
        y3 = radius * Math.sqrt(3) / 2 + y2;
        x4 = x2;
        y4 = radius * Math.sqrt(3) / 2 + y3;
        x5 = x1;
        y5 = y4;
        x6 = x1 - radius/2;
        y6 = y3;

        this.getPoints().setAll(new Double[]{
                x1, y1,
                x2, y2,
                x3, y3,
                x4, y4,
                x5, y5,
                x6, y6,
        });
        if(building != null) {
            building.setX(x1);
            building.setY(y1);
        }
        for (int i = 0; i < units.size(); i++) {
            if (i == 0) {
                units.get(i).setX(this.x + 20);
                units.get(i).setY(this.y - h);
            }
            else {
                units.get(i).setX(this.x + 60);
                units.get(i).setY(this.y - h + 90);
            }
        }
        if (doesHaveRoad) {
            road.setX(this.x - 160);
            road.setY(this.y + 30);
        }
        if (doesHaveRailWay) {
            rail.setX(this.x - 160);
            rail.setY(this.y - 30);
        }
    }
    public void moveDown(){
        double x1,y1;
        double x2,y2;
        double x3,y3;
        double x4,y4;
        double x5,y5;
        double x6,y6;

        y += cameraSpeed;

        y1 = y - h;
        x1 = x - radius/2;

        x2 = radius + x1;
        y2 = y1;
        x3 = radius / 2 + x2;
        y3 = radius * Math.sqrt(3) / 2 + y2;
        x4 = x2;
        y4 = radius * Math.sqrt(3) / 2 + y3;
        x5 = x1;
        y5 = y4;
        x6 = x1 - radius/2;
        y6 = y3;

        this.getPoints().setAll(new Double[]{
                x1, y1,
                x2, y2,
                x3, y3,
                x4, y4,
                x5, y5,
                x6, y6,
        });
        if(building != null) {
            building.setX(x1);
            building.setY(y1);
        }
        for (int i = 0; i < units.size(); i++) {
            if (i == 0) {
                units.get(i).setX(this.x + 20);
                units.get(i).setY(this.y - h);
            }
            else {
                units.get(i).setX(this.x + 60);
                units.get(i).setY(this.y - h + 90);
            }
        }
        if (doesHaveRoad) {
            road.setX(this.x - 160);
            road.setY(this.y + 30);
        }
        if (doesHaveRailWay) {
            rail.setX(this.x - 160);
            rail.setY(this.y - 30);
        }
    }
}