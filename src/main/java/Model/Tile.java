package Model;

import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;
import View.PlayGameMenu;
import com.google.gson.annotations.Expose;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tile extends Polygon {
    @Expose
    public static URL agriculture;
    @Expose
    public static URL camp;
    @Expose
    public static URL farm;
    @Expose
    public static URL laboratory;
    @Expose
    public static URL lumberMill;
    @Expose
    public static URL mine;
    @Expose
    public static URL paddock;
    @Expose
    public static URL stoneMine;
    @Expose
    public static URL tradingPost;
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
    @Expose
    public static URL ruinURL;

    // for panel changing needed
    @Expose
    public static Pane root;
    @Expose
    public static Scene scene;
    @Expose
    public static Stage stage;
    @Expose
    public Ruin ruin;
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
    private boolean ruinDiscovered;
    @Expose
    private boolean hasRuin;
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
        this.ruinDiscovered = false;
        this.hasRuin = false;
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
        double chance = Math.random();
        if (chance >= 0.33 && chance < 0.38 && !isOcean) {
            ruin = new Ruin();
            this.hasRuin = true;
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

        this.setOnMouseClicked(keyEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("tile's information:");
            alert.setContentText("tile number :  " + tileNumber + "\n" + "gold amount :  " + gold + "\n" + "food amount :  " + food + "\n" + "production amount :  " + production);
            alert.showAndWait();
        });

        root.getChildren().add(this);
    }

    public void generatingTile(int status){
        if (status == -1){
            this.setFill(new ImagePattern(new Image(fogOfWar.toExternalForm())));
            if (root.getChildren().contains(resource))
                resource.setVisible(false);
            if (improvements.size() > 0 && root.getChildren().contains(improvements.get(0)))
                improvements.get(0).setVisible(false);
            if (root.getChildren().contains(building))
                building.setVisible(false);
            if (root.getChildren().contains(ruin))
                ruin.setVisible(false);
            if (units.size() >= 1 && root.getChildren().contains(units.get(0)))
                units.get(0).setVisible(false);
            if (units.size() >= 2 && root.getChildren().contains(units.get(1)))
                units.get(1).setVisible(false);
            return;
        }
        if (root.getChildren().contains(resource))
            resource.setVisible(true);
        if (improvements.size() > 0 && root.getChildren().contains(improvements.get(0)))
            improvements.get(0).setVisible(true);
        if (root.getChildren().contains(ruin))
            ruin.setVisible(true);
        if (root.getChildren().contains(building))
            building.setVisible(true);
        if (units.size() >= 1 && root.getChildren().contains(units.get(0)))
            units.get(0).setVisible(true);
        if (units.size() >= 2 && root.getChildren().contains(units.get(1)))
            units.get(1).setVisible(true);
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
        if (getResource() != null) {
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
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
            if (!root.getChildren().contains(resource))
                root.getChildren().add(resource);
        }

        //improvement
        if (improvements.size() > 0) {
            double y22 = this.getY() + 30;
            double x22 = this.getX() + 30;
            improvements.get(0).setX(x22);
            improvements.get(0).setY(y22);
            if (improvements.get(0).isCamp())
                improvements.get(0).setFill(new ImagePattern(new Image(camp.toExternalForm())));
            else if (improvements.get(0).isFarm())
                improvements.get(0).setFill(new ImagePattern(new Image(farm.toExternalForm())));
            else if (improvements.get(0).isLumberMill())
                improvements.get(0).setFill(new ImagePattern(new Image(lumberMill.toExternalForm())));
            else if (improvements.get(0).isMine())
                improvements.get(0).setFill(new ImagePattern(new Image(mine.toExternalForm())));
            else if (improvements.get(0).isPaddock())
                improvements.get(0).setFill(new ImagePattern(new Image(paddock.toExternalForm())));
            else if (improvements.get(0).isAgriculture())
                improvements.get(0).setFill(new ImagePattern(new Image(agriculture.toExternalForm())));
            else if (improvements.get(0).isStoneMine())
                improvements.get(0).setFill(new ImagePattern(new Image(stoneMine.toExternalForm())));
            else if (improvements.get(0).isTradingPost())
                improvements.get(0).setFill(new ImagePattern(new Image(tradingPost.toExternalForm())));
            else if (improvements.get(0).isLaboratory())
                improvements.get(0).setFill(new ImagePattern(new Image(laboratory.toExternalForm())));
            if (!root.getChildren().contains(improvements.get(0)))
                root.getChildren().add(improvements.get(0));
        }

        //ruin
        if (hasRuin && !ruinDiscovered) {
            double y11 = this.getY();
            double x11 = this.getX();
            ruin.setVisible(true);
            ruin.setWidth(40);
            ruin.setHeight(40);
            ruin.setX(x11 - 10);
            ruin.setY(y11 - 10);
            ruin.setFill(new ImagePattern(new Image(ruinURL.toExternalForm())));
            if (!root.getChildren().contains(ruin))
                root.getChildren().add(ruin);
            if (units.size() > 0) {
                Unit unit = units.get(0);
                ArrayList<String> techNames = new ArrayList<>();
                for (Technology t : unit.getCivilization().getTechnologies())
                    techNames.add(t.getName());
                if (!techNames.contains(ruin.getFreeTechnology().getName()))
                    unit.getCivilization().addTechnology(ruin.getFreeTechnology());
                unit.getCivilization().addGold(ruin.getFreeGold());
                Tile citizenTile = unit.getCivilization().getCapital().getCenterTile();
                Citizen ruinCitizen = new Citizen(citizenTile);
                unit.getCivilization().getCapital().getCitizens().add(ruinCitizen);
                ruin.setVisible(false);
                ruinDiscovered = true;
                hasRuin = false;
            }
        }
    }
    private void removeRuinPicture(Ruin ruin) {
        if (this.units.size() > 0) {
            Unit unit = units.get(0);
            ArrayList<String> techNames = new ArrayList<>();
            for (Technology t : unit.getCivilization().getTechnologies())
                techNames.add(t.getName());
            if (!techNames.contains(ruin.getFreeTechnology().getName()))
                unit.getCivilization().addTechnology(ruin.getFreeTechnology());
            unit.getCivilization().addGold(ruin.getFreeGold());
            Tile citizenTile = unit.getCivilization().getCapital().getCenterTile();
            Citizen ruinCitizen = new Citizen(citizenTile);
            unit.getCivilization().getCapital().getCitizens().add(ruinCitizen);
            ruin.setVisible(false);
            ruinDiscovered = true;
            hasRuin = false;
        }
    }
    private void addRuinPicture(Ruin ruin2) {
        if (hasRuin && !ruinDiscovered) {
            double y11 = this.getY();
            double x11 = this.getX();
            ruin.setVisible(true);
            ruin.setWidth(40);
            ruin.setHeight(40);
            ruin.setX(x11 - 10);
            ruin.setY(y11 - 10);
            ruin.setFill(new ImagePattern(new Image(ruinURL.toExternalForm())));
            if (!root.getChildren().contains(ruin))
                root.getChildren().add(ruin);
        }
    }

    private void addAttributePicture(Attribute attribute2) {
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
    }

    private void addResourcePicture(Resource resource2) {
        if (getResource() != null) {
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
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
            if (!root.getChildren().contains(resource))
                root.getChildren().add(resource);
        }
    }


    public void setResource(Resource resource) {
        this.resource = resource;
    }
    @Expose
    private Improvement workingOnImprovement;//if == null -> null
    @Expose
    private HashMap<Improvement, Integer> improvementEarnedPercent = new HashMap<>();
    @Expose
    private boolean doesHaveRoad;
    @Expose
    private boolean doesHaveRailWay;
    @Expose
    private boolean isRoadDamaged; // if a unit attack to road/rail it is true
    @Expose
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
            Improvement improvement = improvements.get(0);
            improvement.setX(this.getX() + 50);
            improvement.setY(this.getY() + 30);
            improvement.setWidth(60);
            improvement.setHeight(60);
            if (improvement.getName().equals("agriculture"))
                improvement.setFill(new ImagePattern(new Image(agriculture.toExternalForm())));
            else if (improvement.getName().equals("camp"))
                improvement.setFill(new ImagePattern(new Image(camp.toExternalForm())));
            else if (improvement.getName().equals("farm"))
                improvement.setFill(new ImagePattern(new Image(farm.toExternalForm())));
            else if (improvement.getName().equals("laboratory"))
                improvement.setFill(new ImagePattern(new Image(laboratory.toExternalForm())));
            else if (improvement.getName().equals("lumberMill"))
                improvement.setFill(new ImagePattern(new Image(lumberMill.toExternalForm())));
            else if (improvement.getName().equals("mine"))
                improvement.setFill(new ImagePattern(new Image(mine.toExternalForm())));
            else if (improvement.getName().equals("paddock"))
                improvement.setFill(new ImagePattern(new Image(paddock.toExternalForm())));
            else if (improvement.getName().equals("stoneMine"))
                improvement.setFill(new ImagePattern(new Image(stoneMine.toExternalForm())));
            else if (improvement.getName().equals("tradingPost"))
                improvement.setFill(new ImagePattern(new Image(tradingPost.toExternalForm())));
            root.getChildren().add(improvement);
            workingOnImprovement = null;
        }
        this.improvementEarnedPercent.replace(this.workingOnImprovement, roundLeft);
    }
    private void addImprovementPicture(Improvement improvement) {
        improvement.setX(this.getX() + 50);
        improvement.setY(this.getY() + 30);
        improvement.setWidth(60);
        improvement.setHeight(60);
        if (improvement.getName().equals("agriculture"))
            improvement.setFill(new ImagePattern(new Image(agriculture.toExternalForm())));
        else if (improvement.getName().equals("camp"))
            improvement.setFill(new ImagePattern(new Image(camp.toExternalForm())));
        else if (improvement.getName().equals("farm"))
            improvement.setFill(new ImagePattern(new Image(farm.toExternalForm())));
        else if (improvement.getName().equals("laboratory"))
            improvement.setFill(new ImagePattern(new Image(laboratory.toExternalForm())));
        else if (improvement.getName().equals("lumberMill"))
            improvement.setFill(new ImagePattern(new Image(lumberMill.toExternalForm())));
        else if (improvement.getName().equals("mine"))
            improvement.setFill(new ImagePattern(new Image(mine.toExternalForm())));
        else if (improvement.getName().equals("paddock"))
            improvement.setFill(new ImagePattern(new Image(paddock.toExternalForm())));
        else if (improvement.getName().equals("stoneMine"))
            improvement.setFill(new ImagePattern(new Image(stoneMine.toExternalForm())));
        else if (improvement.getName().equals("tradingPost"))
            improvement.setFill(new ImagePattern(new Image(tradingPost.toExternalForm())));
        root.getChildren().add(improvement);
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

    public boolean isRuinDiscovered() {
        return ruinDiscovered;
    }

    public boolean isHasRuin() {
        return hasRuin;
    }

    public int getRepairNeedImprovement() {
        return repairNeedImprovement;
    }

    public Rectangle getRoad() {
        return road;
    }

    public Rectangle getRail() {
        return rail;
    }

    public HashMap<Unit, Integer> getWorkingOnRoadUntilFinish() {
        return workingOnRoadUntilFinish;
    }

    public HashMap<Unit, Integer> getWorkingOnRailUntilFinish() {
        return workingOnRailUntilFinish;
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
        if (resource != null){
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
        }
        if (ruin != null){
            ruin.setY(this.getY());
            ruin.setX(this.getX());
        }
        if (improvements.size() > 0){
            improvements.get(0).setX(this.getX() + 50);
            improvements.get(0).setY(this.getY() + 30);
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
        if (resource != null){
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
        }
        if (ruin != null){
            ruin.setY(this.getY());
            ruin.setX(this.getX());
        }
        if (improvements.size() > 0){
            improvements.get(0).setX(this.getX() + 50);
            improvements.get(0).setY(this.getY() + 30);
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
        if (resource != null){
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
        }
        if (ruin != null){
            ruin.setY(this.getY());
            ruin.setX(this.getX());
        }
        if (improvements.size() > 0){
            improvements.get(0).setX(this.getX() + 50);
            improvements.get(0).setY(this.getY() + 30);
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
        if (resource != null){
            double y11 = this.getY();
            double x11 = this.getX() + 70;
            resource.setX(x11);
            resource.setY(y11);
        }
        if (ruin != null){
            ruin.setY(this.getY());
            ruin.setX(this.getX());
        }
        if (improvements.size() > 0){
            improvements.get(0).setX(this.getX() + 50);
            improvements.get(0).setY(this.getY() + 30);
        }
    }

    public Ruin getRuin() {
        return ruin;
    }

    public boolean equals (Tile tile) {
        if (this.getX() == tile.getX() &&
                this.getY() == tile.getY()) return true;
        return false;
    }

    public void copyFieldsOfTile(Tile tile, ArrayList<Unit> allUnits) {
        // todo ... check classes that yall wrote
        this.ruin = getRuinCopy(tile.getRuin());
        this.cameraSpeed = 30;
        this.isDesert = tile.isDesert;
        this.isMeadow = tile.isMeadow;
        this.isHill = tile.isHill;
        this.isMountain = tile.isMountain;
        this.isOcean = tile.isOcean;
        this.isPlain = tile.isPlain;
        this.isSnow = tile.isSnow;
        this.isTundra = tile.isTundra;
        this.isBlocker = tile.isBlocker;
        this.ruinDiscovered = tile.ruinDiscovered;
        this.hasRuin = tile.hasRuin;
        this.food = tile.food;
        this.production = tile.production;
        this.gold = tile.getGold();
        this.combatChange = tile.getCombatChange();
        this.mpCost = tile.getMpCost();
        this.tileNumber = tile.getTileNumber();
        this.x = tile.getX();
        this.y = tile.getY();
        this.radius = tile.getRadius();
        this.h = tile.getH();
        this.citizen = getCitizenCopy(tile.getCitizen());
        getUnitsListCopy(this, allUnits);
        this.building = setBuildingCopy(tile.getBuilding());
        this.turnForUnitMaking = getTurnForUnitMakingListCopy(tile.getTurnForUnitMaking());
        this.resource = copyResource(tile.getResource());
        this.attribute = setAttributeCopy(tile.getAttribute());
        this.improvements = setImprovementCopy(tile.getImprovements());
        this.isWorking = tile.isWorking;
        this.isOnRepair = tile.isOnRepair;
        this.repairNeedImprovement = tile.getRepairNeedImprovement();
        this.roads = getRoadsTileCopy(tile.getRoads());
        this.railRoads = getRoadsTileCopy(tile.getRailRoads());
    }

    private Ruin getRuinCopy(Ruin ruin) {
        if (this.getRuin() == null && ruin != null) {
            Ruin ruin2 = ruin;
            addRuinPicture(ruin2);
            return ruin2;
        }
        else if (this.getRuin() != null && ruin != null) {
            this.getRuin().copyField(ruin);
            return this.getRuin();
        }
        else if (this.getRuin() != null && ruin == null) {
            removeRuinPicture(this.getRuin());
            return null;
        }
        return null;
    }

    private Attribute setAttributeCopy(Attribute attribute) {
        if (this.getAttribute() == null && attribute != null) {
            Attribute attribute2 = new Attribute(attribute.isPlat(), attribute.isJungle(), attribute.isIce(), attribute.isRainForest(), attribute.isMarsh(), attribute.isOasis());
            addAttributePicture(attribute2);
            return attribute2;
        }
        else if (this.getAttribute() != null && attribute != null) {
            this.getAttribute().copyFields(attribute);
            return this.getAttribute();
        }
        return null;
    }

    private Resource copyResource(Resource resource) {
        if (this.getResource() == null && resource != null) {
            Resource resource2 = new Resource(resource.getName());
            addResourcePicture(resource2);
            return resource2;
        }
        else if (this.getResource() != null && resource != null){
            this.getResource().copyFields(resource);
            return this.getResource();
        }
        return null;
    }

    private ArrayList<Improvement> setImprovementCopy(ArrayList<Improvement> improvements) {
        ArrayList<Improvement> improvements2 = new ArrayList<>();
        if (improvements.size() >= 1) {
            Improvement improvementTemp = improvements.get(0);
            if (this.getImprovements().get(0) == null && improvements.get(0) != null) {
                Improvement improvement = new Improvement(improvementTemp.isCamp(), improvementTemp.isFarm(), improvementTemp.isLumberMill(), improvementTemp.isMine(), improvementTemp.isPaddock(), improvementTemp.isAgriculture(),
                        improvementTemp.isStoneMine(), improvementTemp.isTradingPost(), improvementTemp.isLaboratory(), improvementTemp.getFood(), improvementTemp.getProduction(), improvementTemp.getGold());
                improvements2.add(improvement);
                addImprovementPicture(improvement);
            } else if (this.getImprovements().get(0) != null && improvements.get(0) != null) {
                this.getImprovements().get(0).copyFields(improvements.get(0));
                improvements2.add(improvements.get(0));
                return improvements2;
            }
        }
        return improvements2;
    }

    private ArrayList<Tile> getRoadsTileCopy(ArrayList<Tile> tiles) {
        ArrayList<Tile> clientTiles = new ArrayList<>();
        for (Tile tile : tiles) {
            clientTiles.add(getClientTile(tile));
        }
        return clientTiles;
    }

    private Building setBuildingCopy(Building building) {
        if (this.getBuilding() == null && building != null) {
            building.setTile(getClientTile(building.getTile()));
            getClientTile(building.getTile()).addBuilding(building);
            return building;
        }
        else {
            return this.getBuilding();
        }
    }

    private HashMap<Unit, Integer> getTurnForUnitMakingListCopy(HashMap<Unit, Integer> turnForUnitMaking) {
        HashMap<Unit,Integer> hashMap = new HashMap<>();
        for (Map.Entry<Unit,Integer> entry : turnForUnitMaking.entrySet()) {
            if (!entry.getKey().isCivilian()) {
                Warrior warrior = new Warrior(Civilization.getCivilizationCopy(entry.getKey().getCivilization()),Tile.getClientTile(entry.getKey().getOrigin()),entry.getKey().getHealth(),entry.getKey().getConstantMP(),entry.getKey().getMp(),entry.getKey().getDuration(),entry.getKey().getGoldCost(),entry.getKey().isCivilian(),
                        ((Warrior)entry.getKey()).getXp(),((Warrior)entry.getKey()).getDamage(),((Warrior)entry.getKey()).getRange(),((Warrior)entry.getKey()).getRangedCombatDamage(),((Warrior)entry.getKey()).isScout(),((Warrior)entry.getKey()).isWarrior(),((Warrior)entry.getKey()).isArcher(),((Warrior)entry.getKey()).isChariotArcher(),
                        ((Warrior)entry.getKey()).isSpearman(),((Warrior)entry.getKey()).isCatapult(),((Warrior)entry.getKey()).isHorseMan(),((Warrior)entry.getKey()).isSwordsMan(),((Warrior)entry.getKey()).isCrossbowMan(),((Warrior)entry.getKey()).isKnight(),((Warrior)entry.getKey()).isLongswordMan(),((Warrior)entry.getKey()).isPikeMan(),((Warrior)entry.getKey()).isTrebuchet(),
                        ((Warrior)entry.getKey()).isCanon(),((Warrior)entry.getKey()).isCavalry(),((Warrior)entry.getKey()).isLancer(),((Warrior)entry.getKey()).isMusketMan(),((Warrior)entry.getKey()).isRifleMan(),((Warrior)entry.getKey()).isAntiTankGun(),((Warrior)entry.getKey()).isArtillery(),((Warrior)entry.getKey()).isInfantry(),((Warrior)entry.getKey()).isPanzer(),((Warrior)entry.getKey()).isTank());
                hashMap.put(warrior, entry.getValue());
            }
            else {
                Civilian civilian = new Civilian(Civilization.getCivilizationCopy(entry.getKey().getCivilization()),Tile.getClientTile(entry.getKey().getOrigin()),entry.getKey().getHealth(),entry.getKey().getConstantMP(),entry.getKey().getMp(),entry.getKey().getDuration(),entry.getKey().getGoldCost(),entry.getKey().isCivilian(),
                        ((Civilian)entry.getKey()).isWorker(), ((Civilian)entry.getKey()).isSettler());
                hashMap.put(civilian, entry.getValue());
            }
        }
        return hashMap;
    }

    private void getUnitsListCopy(Tile tile, ArrayList<Unit> allUnits) {
        for (Unit allUnit : allUnits) {
            if (allUnit.getOrigin().equals(tile)) {
                tile.addUnit2(allUnit);
            }
        }
    }

    private Citizen getCitizenCopy(Citizen citizen) {
        for (Civilization civilization : PlayGameMenu.civilizations) {
            for (City city : civilization.getCities()) {
                for (Citizen cityCitizen : city.getCitizens()) {
                    if (cityCitizen.equals(citizen)) return cityCitizen;
                }
            }
        }
        return citizen;
    }

    public void deleteUnits () {
        for (Unit unit : units) {
            if (root.getChildren().contains(unit)) root.getChildren().remove(unit);
        }
        units.clear();
    }

    public static Tile getClientTile(Tile tile) {
        for (Tile tile2 : PlayGameMenu.tiles) {
            if (tile.equals(tile2)) return tile2;
        }
        return null;
    }
}