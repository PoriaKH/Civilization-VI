package Controller;

import Model.*;
import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;

public class PlayGameMenuController {

    public ArrayList<Tile> mapCreator(int numOfCivilizations,ArrayList<Member> members){//tik
        int numOfTiles = 72;
        ArrayList<Tile> map = new ArrayList<>();
        float x0 = 10;
        float y0 = 10;

        Tile t0 = new Tile(0,false,false,false,true,false,false,false,false,x0,y0);
        float h = (float)t0.getH();
        float radius = t0.getRadius();

        map.add(t0);
        float x = x0;
        float y = y0 + 2 * h;
        map.add(new Tile(1,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(2,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(3,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(4,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(5,false,false,false,false,true,false,false,false,x,y));

        x = x0 + 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(6,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(7,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(8,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(9,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(10,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(11,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(12,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(13,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(14,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(15,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(16,false,false,false,false,false,false,true,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(17,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(18,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(19,false,false,true,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(20,false,false,false,false,false,true,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(21,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(22,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(23,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(24,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(25,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(26,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(27,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(28,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(29,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(30,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(31,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(32,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(33,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(34,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(35,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(36,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(37,false,false,false,false,true,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(38,false,false,false,false,true,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(39,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(40,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(41,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(42,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(43,false,false,false,false,false,false,true,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(44,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(45,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(46,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(47,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(48,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(49,true,false,false,false,false,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(50,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(51,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(52,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(53,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(54,true,false,false,false,false,false,false,false,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(55,false,false,false,false,false,false,true,false,x,y));
        y += 2 * h;
        map.add(new Tile(56,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(57,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(58,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(59,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(60,false,false,false,false,false,false,false,true,x,y));

        x += 3 * radius / 2;
        y = y0 + h;
        map.add(new Tile(61,false,true,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(62,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(63,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(64,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(65,false,false,false,false,false,false,false,true,x,y));

        x += 3 * radius / 2;
        y = y0;
        map.add(new Tile(66,false,false,false,true,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(67,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(68,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(69,true,false,false,false,false,false,false,false,x,y));
        y += 2 * h;
        map.add(new Tile(70,false,false,false,false,false,false,false,true,x,y));
        y += 2 * h;
        map.add(new Tile(71,false,false,false,true,false,false,false,false,x,y));


        return map;
    }
    public StringBuilder showMap(Civilization civilization,ArrayList<Tile> map){//tik
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public ArrayList<Integer> statusChecker(Civilization civilization,ArrayList<Tile> map){
        //TODO... return ArrayList<Integer> with 1 or -1(all fields)
    }
    public ArrayList<Integer> statusComparator(ArrayList<Integer> old, ArrayList<Integer> now){
        //TODO... if(now == fog of war && old == vazeh -> now = moshakhas)
        //TODO... return now;
    }

    public StringBuilder researchInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder unitPanel(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder cityPanel(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder diplomaticInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder victoryImprovement(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder demographics(Civilization civilization,ArrayList<Tile> map){   //Jamiat shenasi
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder historyInformation(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder generalUnitReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder economicalReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder diplomaticReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder tradeHistory(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public String tradeResource(Civilization civilization1, Civilization civilization2, Tile originTile, Resource originResource,Resource neededResource,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String moveUnit(Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }

    // check the necessary technologies for unit
    public boolean checkTechnology (ArrayList<Technology> technologies, String name) {
        for (int i = 0; i < technologies.size(); i++) {
            if (technologies.get(i).getName().equals(name)) return false;
        }
        return true;
    }
    public boolean isTechnologyAvailableForUnit (Unit unit, Civilization civilization) {
        Warrior warrior = (Warrior) unit;
        ArrayList<Technology> technologies = civilization.getTechnologies();
        if (warrior.isArcher()) {
            if (checkTechnology(technologies, "Archery")) return false;
        }
        else if (warrior.isChariotArcher()) {
            if (checkTechnology(technologies, "The Wheel")) return false;
        }
        else if (warrior.isScout()) return true;
        else if (warrior.isSpearman()) {
            if (checkTechnology(technologies, "Bronze Working")) return false;
        }
        else if (warrior.isWarrior()) return true;
        else if (warrior.isCatapult()) {
            if (checkTechnology(technologies, "Mathematics")) return false;
        }
        else if (warrior.isHorseMan()) {
            if (checkTechnology(technologies, "Horseback Riding")) return false;
        }
        else if (warrior.isSwordsMan()) {
            if (checkTechnology(technologies, "Iron Working")) return false;
        }
        else if (warrior.isCrossbowMan()) {
            if (checkTechnology(technologies, "Machinery")) return false;
        }
        else if (warrior.isKnight()) {
            if (checkTechnology(technologies, "Chivalry")) return false;
        }
        else if (warrior.isLongswordMan()) {
            if (checkTechnology(technologies, "Steel")) return false;
        }
        else if (warrior.isPikeMan()) {
            if (checkTechnology(technologies, "Civil Service")) return false;
        }
        else if (warrior.isTrebuchet()) {
            if (checkTechnology(technologies, "Physics")) return false;
        }
        else if (warrior.isCanon()) {
            if (checkTechnology(technologies, "Chemistry")) return false;
        }
        else if (warrior.isCavalry()) {
            if (checkTechnology(technologies, "Military Science")) return false;
        }
        else if (warrior.isLancer()) {
            if (checkTechnology(technologies, "Metallurgy")) return false;
        }
        else if (warrior.isMusketMan()) {
            if (checkTechnology(technologies, "Gunpowder")) return false;
        }
        else if (warrior.isRifleMan()) {
            if (checkTechnology(technologies, "Rifling")) return false;
        }
        else if (warrior.isAntiTankGun()) {
            if (checkTechnology(technologies, "Replaceable Parts")) return false;
        }
        else if (warrior.isArtillery()) {
            if (checkTechnology(technologies, "Dynamite")) return false;
        }
        else if (warrior.isInfantry()) {
            if (checkTechnology(technologies, "Replaceable Parts")) return false;
        }
        else if (warrior.isPanzer()) {
            if (checkTechnology(technologies, "Combustion")) return false;
        }
        else if (warrior.isTank()) {
            if (checkTechnology(technologies, "Combustion")) return false;
        }
        return true;
    }
    //check the necessary resources for unit
    public boolean isResourceAvailableForUnit (Unit unit, City city) {
        Warrior warrior = (Warrior) unit;
        ArrayList<Tile> tiles = city.getTiles();
        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Resource> resources = tiles.get(i).getResources();

            for (int i1 = 0; i1 < resources.size(); i1++) {
                if (warrior.isArcher()) return true;
                else if (warrior.isChariotArcher()) {
                    if (resources.get(i1).isHorse()) return true;
                }
                else if (warrior.isScout()) return true;
                else if (warrior.isSpearman()) return true;
                else if (warrior.isWarrior()) return true;

                else if (warrior.isCatapult()) {
                    if (resources.get(i1).isMetal()) return true;
                }
                else if (warrior.isHorseMan()) {
                    if (resources.get(i1).isHorse()) return true;
                }
                else if (warrior.isSwordsMan()) {
                    if (resources.get(i1).isMetal()) return true;
                }
                else if (warrior.isCrossbowMan()) return true;
                else if (warrior.isKnight()) {
                    if (resources.get(i1).isHorse()) return true;
                }
                else if (warrior.isLongswordMan()) {
                    if (resources.get(i1).isMetal()) return true;
                }
                else if (warrior.isPikeMan()) return true;
                else if (warrior.isTrebuchet()) {
                    if (resources.get(i1).isMetal()) return true;
                }
                else if (warrior.isCanon()) return true;
                else if (warrior.isCavalry()) {
                    if (resources.get(i1).isHorse()) return true;
                }
                else if (warrior.isLancer()) {
                    if (resources.get(i1).isHorse()) return true;
                }
                else if (warrior.isMusketMan()) return true;
                else if (warrior.isRifleMan()) return true;
                else if (warrior.isAntiTankGun()) return true;
                else if (warrior.isArtillery()) return true;
                else if (warrior.isInfantry()) return true;
                else if (warrior.isPanzer()) return true;
                else if (warrior.isTank()) return true;
            }
        }
        return false;
    }
    // if unit is a warrior return true
    public boolean isUnitWarrior (Tile cityCenter) {
        ArrayList<Unit> units = cityCenter.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (!units.get(i).isCivilian()) return true;
        }
        return false;
    }
    //if unit is a civilian return true
    public boolean isUnitCivilian (Tile cityCenter) {
        ArrayList<Unit> units = cityCenter.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isCivilian()) return true;
        }
        return false;
    }

    public String createUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map){
        String str;

        if (unit.getGoldCost() > city.getGold()) {
            str = "your gold is not enough !";
            return str;
        }

        if (!unit.isCivilian() && !isTechnologyAvailableForUnit (unit, civilization)) {
            str = "you don't have necessary technology !";
            return str;
        }

        if (!unit.isCivilian() && !isResourceAvailableForUnit (unit, city)) {
            str = "you don't have necessary resource !";
            return str;
        }

        Tile centerTile = city.getCenterTile();
        if (!unit.isCivilian() && isUnitWarrior (centerTile)) {
            str = "there is a military unit !";
            return str;
        }

        if (unit.isCivilian() && isUnitCivilian (centerTile)) {
            str = "there is a civilian unit !";
            return str;
        }

        centerTile.addUnit(unit);
        str = "unit created !";
        return str;
    }
    public String purchaseUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createCity(Civilization civilization, Civilian civilian,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String attackTile(Civilization civilization, Warrior warrior,Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }
    // sleepUnit, .... civilization baraye playeri hast ke alan dare dastor mide
    //TODO ... bayad function marboot be darkhast amaliat va royat doshman dar atraf baraye behavior ha piyade shavad
    public String sleepUnit(Civilization civilization, Unit unit, ArrayList<Tile> map, Tile selected){
        String str;

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }

        unit.setOnSleep(true);
        str = "selected unit is sleeping";
        return str;
    }
    public String WarFootingUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        unit.setOnWarFooting(true);
        str = "this unit is on standby !";
        return str;
    }
    public String boostUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        Warrior warrior = (Warrior) unit;
        int newDamage = warrior.getDamage() + 1;
        warrior.setDamage(newDamage);
        warrior.setOnBoost(true);
        str = "booster has been activated for this unit !";
        return str;
    }
    public String boostTillRecoverUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }

        Warrior warrior = (Warrior) unit;
        int newHealth = warrior.getHealth() + 1;
        warrior.setHealth(newHealth);
        warrior.setOnBoostTillRecover(true);
        str = "booster until full recovery has been activated for this unit !";
        return str;
    }

    //if unit tile is city center (tile) return true
    public boolean isTileCityCenter (Civilization civilization, Unit unit) {
        ArrayList<City> cities = civilization.getCities();
        Tile tile = unit.getOrigin();
        for (int i = 0; i < cities.size(); i++) {
            if (tile.equals(cities.get(i).getCenterTile())) return true;
        }
        return false;
    }
    public String deploymentUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (!isTileCityCenter(civilization, unit)) {
            str = "this unit isn't in the city !";
            return str;
        }

        unit.setOnDeployment(true);
        str = "the unit is deployed in city !";
        return str;
    }
    public String readyForRangedBattleUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        ((Warrior)unit).setReadyForRangedBattle(true);
        str = "the unit is ready for ranged battle !";
        return str;
    }
    public String lootTile(Civilization civilization, Warrior warrior, Tile destination,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String cancelCommand(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String wakeUpUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }

        unit.setOnSleep(false);
        str = "selected unit is awake";
        return str;
    }
    public String deleteUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String recoverUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String lockCitizen(Civilization civilization, Citizen citizen, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String unLockCitizen(Civilization civilization, Citizen citizen,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String purchaseTile(Civilization civilization, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public StringBuilder showProductionsInProcess(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public StringBuilder showTechnologyMenu(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public String chooseTechnologyToLearn(Civilization civilization, Technology technology,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String changeTechnologyToLearn(Civilization civilization, Technology newTechnology,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String workOnTile(Civilization civilization, City city, Citizen citizen,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createImprovement(Civilization civilization, Civilian civilian, Tile tile,Improvement improvement,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createRoad(Civilization civilization,Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String createRailRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeImprovement(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String removeRailRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String cancelImprovementOnProcess(Civilization civilization,Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairRoad(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairImprovement(Civilization civilization, Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String repairWholeTile(Civilization civilization,Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
    public String updateWarrior(Civilization civilization, Warrior warrior, Warrior newWarrior,ArrayList<Tile> map){
        String str;

        return str;
    }
    public StringBuilder showCurrentScore(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    //TODO
    /*
    public boolean winCheck(){

    }
     */
    public StringBuilder nextTurn(Civilization civilization){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
}
