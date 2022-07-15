package Controller;

import Model.*;
import Model.FunctionsGson.GameGroupData;
import Model.FunctionsGson.MapCreatorGson;
import Model.FunctionsGson.UnitBehaviourGson;
import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;

public class PlayGameMenuController {
    public static int turn;
    {
        turn = 0;
    }

    public synchronized void mapCreator(int numOfCivilizations, ArrayList<Member> members, ArrayList<Socket> sockets) throws IOException {//tik
        int numOfTiles = 72;
        ArrayList<Tile> map = new ArrayList<>();
        float x0 = 300;
        float y0 = 300;

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

        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        MapCreatorGson mapCreatorGson = new MapCreatorGson(numOfCivilizations, members);
        mapCreatorGson.map = map;
        String response = gson.toJson("mapCreator " + mapCreatorGson);

        for (Socket socket : sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
        }
    }
    public void cheatIncreaseGold(Civilization civilization, int amount, GameGroup gameGroup) throws IOException {
        ArrayList<Civilization> civilizations = gameGroup.civilizations;
        Civilization serverCiv = null;
        for (Civilization civ : civilizations) {
            if (civ.equals(civilization)) {
                serverCiv = civ;
                break;
            }
        }
        serverCiv.setGold(amount);
        for (Socket socket : gameGroup.sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            GameGroupData gameGroupData = new GameGroupData(civilizations, gameGroup.tiles);
            gameGroupData.result = "cheat code activated successfully";
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            dataOutputStream.writeUTF(gson.toJson(gameGroupData));
            dataOutputStream.flush();
        }
    }
    public void cheatIncreaseFood(Civilization civilization,int amount, GameGroup gameGroup) throws IOException {
        ArrayList<Civilization> civilizations = gameGroup.civilizations;
        Civilization serverCiv = null;
        for (Civilization civ : civilizations) {
            if (civ.equals(civilization)) {
                serverCiv = civ;
                break;
            }
        }
        for(City city : serverCiv.getCities()){
            city.setTotalFood(amount);
        }
        for (Socket socket : gameGroup.sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            GameGroupData gameGroupData = new GameGroupData(civilizations, gameGroup.tiles);
            gameGroupData.result = "cheat code activated successfully";
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            dataOutputStream.writeUTF(gson.toJson(gameGroupData));
            dataOutputStream.flush();
        }
    }
    public void cheatIncreaseTechnology(Civilization civilization,int amount, GameGroup gameGroup) throws IOException {
        ArrayList<Civilization> civilizations = gameGroup.civilizations;
        Civilization serverCiv = null;
        for (Civilization civ : civilizations) {
            if (civ.equals(civilization)) {
                serverCiv = civ;
                break;
            }
        }
        serverCiv.setScience(amount);
        for (Socket socket : gameGroup.sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            GameGroupData gameGroupData = new GameGroupData(civilizations, gameGroup.tiles);
            gameGroupData.result = "cheat code activated successfully";
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            dataOutputStream.writeUTF(gson.toJson(gameGroupData));
            dataOutputStream.flush();
        }
    }
    public void cheatIncreaseHappiness(Civilization civilization, int amount, GameGroup gameGroup) throws IOException {
        ArrayList<Civilization> civilizations = gameGroup.civilizations;
        Civilization serverCiv = null;
        for (Civilization civ : civilizations) {
            if (civ.equals(civilization)) {
                serverCiv = civ;
                break;
            }
        }
        serverCiv.setHappiness(amount);
        for (Socket socket : gameGroup.sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            GameGroupData gameGroupData = new GameGroupData(civilizations, gameGroup.tiles);
            gameGroupData.result = "cheat code activated successfully";
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            dataOutputStream.writeUTF(gson.toJson(gameGroupData));
            dataOutputStream.flush();
        }
    }
    public void cheatTeleportUnit (Unit unit, int numberOfDestination,  Civilization civilization, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        String str;
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if (numberOfDestination < 0 || numberOfDestination > 71) {
            gameGroupData.result = "number of destination is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Unit unitServer = getUnitServer(gameGroup.tiles, unit);
        Tile origin = unitServer.getOrigin();
        Tile destination = gameGroup.tiles.get(numberOfDestination);

        if (unitServer == null) {
            gameGroupData.result = "there is no unit with this name !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unitServer.getIsOnSleep()|| unitServer.isOnBoost() || unitServer.isOnBoostTillRecover() || unitServer.isOnWarFooting()) {
            gameGroupData.result = "this unit is not active !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unitServer.getCivilization().getName().equals(civilization.getName())) {
            gameGroupData.result = "this unit is for another civilization !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unitServer.getPath().size() != 0) {
            gameGroupData.result = "this unit has another path !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        ArrayList<Unit> unitsDestination = destination.getUnits();
        for (int i = 0; i < unitsDestination.size(); i++) {
            if (unitsDestination.get(i).isCivilian() == unitServer.isCivilian()) {
                gameGroupData.result = "there is another unit with this type in the tile !";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }
        }
        origin.removeUnit(unitServer);
        destination.addUnit(unitServer);
        unitServer.setOrigin(destination);
        unitServer.setHasOrdered(true);
        gameGroupData.result = "unit teleported to destination !";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    // get Unit in tiles of server
    private Unit getUnitServer(ArrayList<Tile> tiles, Unit localUnit) {
        for (Tile tile : tiles) {
            for (Unit unit : tile.getUnits()) {
                if (unit.equals(localUnit)) return unit;
            }
        }
        return null;
    }

    public ArrayList<Civilization> initializeCivilizations(int numOfCivilizations, ArrayList<Tile> map, ArrayList<Member> members){
        ArrayList<Civilization> civilizations = new ArrayList<>();
        for(int i = 0; i < numOfCivilizations; i++){
            if(i == 0){
                Member member1 = members.get(0);
                City city1 = new City(map.get(7), map);
                civilizations.add(new Civilization(member1, city1));
            }
            else if(i == 1){
                Member member2 = members.get(1);
                City city2 = new City(map.get(48), map);
                civilizations.add(new Civilization(member2, city2));
            }
            else if(i == 2){
                Member member3 = members.get(2);
                City city3 = new City(map.get(62), map);
                civilizations.add(new Civilization(member3, city3));
            }
            else if(i == 3){
                Member member4 = members.get(3);
                City city4 = new City(map.get(45), map);
                civilizations.add(new Civilization(member4, city4));
            }
            else if(i == 4){
                Member member5 = members.get(4);
                City city5 = new City(map.get(30), map);
                civilizations.add(new Civilization(member5, city5));
            }
        }
        return civilizations;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String YELLOW = "\u001B[33m";// --> dessert
    public static final String DARK_GREEN = "\u001b[32m";// --> meadow
    public static final String LIGHT_GREEN = "\u001b[32;1m";// --> plain
    public static final String BLUE = "\u001B[34m";// --> ocean
    public static final String BROWN = "\u001B[34m";// --> mountain
    public static final String PURPLE = "\u001B[35m";// --> tundra
    public static final String SNOW = "\u001B[37m";// --> ice
    public static final String CYAN = "\033[0;36m";// --> hill
    public static final String BACKGROUND_BLUE = "\u001b[34m";// --> river
    public String[] setTileColors(ArrayList<Integer> tileStatusOfCivilization, ArrayList<Tile> map, HashMap<Integer, Tile> zeroStatusTilesCivilisation, String[] oldTileColors){
        String[] tileColors = new String[73];
        for (int i = 0; i < map.size(); i++) {
            if (tileStatusOfCivilization.get(i) == -1)
                tileColors[i]  = BLACK;
            else if (tileStatusOfCivilization.get(i) == 1){
                if (map.get(i).isDesert())
                    tileColors[i] = YELLOW;
                else if (map.get(i).isMeadow())
                    tileColors[i] = DARK_GREEN;
                else if (map.get(i).isPlain())
                    tileColors[i] = LIGHT_GREEN;
                else if (map.get(i).isOcean())
                    tileColors[i] = BLUE;
                else if (map.get(i).isMountain())
                    tileColors[i] = BROWN;
                else if (map.get(i).isTundra())
                    tileColors[i] = PURPLE;
                else if (map.get(i).isSnow())
                    tileColors[i] = SNOW;
                else if (map.get(i).isHill())
                    tileColors[i] = CYAN;
            }
//            else {
//                if (zeroStatusTilesCivilisation.containsValue(map.get(i)))
//                    tileColors[i] = oldTileColors[i];
//            }
        }
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Map.Entry<Integer, Tile> key : zeroStatusTilesCivilisation.entrySet())
            tiles.add(key.getValue());
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).isDesert())
                tileColors[tiles.get(i).getTileNumber()] = YELLOW;
            else if (tiles.get(i).isMeadow())
                tileColors[tiles.get(i).getTileNumber()] = DARK_GREEN;
            else if (tiles.get(i).isPlain())
                tileColors[tiles.get(i).getTileNumber()] = LIGHT_GREEN;
            else if (tiles.get(i).isOcean())
                tileColors[tiles.get(i).getTileNumber()] = BLUE;
            else if (tiles.get(i).isMountain())
                tileColors[tiles.get(i).getTileNumber()] = BROWN;
            else if (tiles.get(i).isTundra())
                tileColors[tiles.get(i).getTileNumber()] = PURPLE;
            else if (tiles.get(i).isSnow())
                tileColors[tiles.get(i).getTileNumber()] = SNOW;
            else if (tiles.get(i).isHill())
                tileColors[tiles.get(i).getTileNumber()] = CYAN;
        }
        tileColors[72] = BACKGROUND_BLUE;
        return tileColors;
    }
    public String[] setTileType(ArrayList<Tile> map, String tilecolors[], HashMap<Integer, Tile> zeroStatusTilesCivilisation, ArrayList<Integer> tileStatusOfCivilization) {
        String tileType[] = new String[72];
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getAttribute() == null || tilecolors[i] == BLACK || tileStatusOfCivilization.get(map.get(i).getTileNumber()) == -1)
                tileType[i] = "\u2588";
            else if (map.get(i).getAttribute().isIce())
                tileType[i] = "i";
            else if (map.get(i).getAttribute().isMarsh())
                tileType[i] = "m";
            else if (map.get(i).getAttribute().isJungle())
                tileType[i] = "j";
            else if (map.get(i).getAttribute().isPlat())
                tileType[i] = "p";
            else if (map.get(i).getAttribute().isOasis())
                tileType[i] = "v";
            else if (map.get(i).getAttribute().isRainForest())
                tileType[i] = "r";
            else
                tileType[i] = "\u2588";
        }
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Map.Entry<Integer, Tile> key : zeroStatusTilesCivilisation.entrySet())
            tiles.add(key.getValue());
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getAttribute() == null || tilecolors[i] == BLACK)
                tileType[tiles.get(i).getTileNumber()] = "\u2588";
            else if (tiles.get(i).getAttribute().isIce())
                tileType[tiles.get(i).getTileNumber()] = "i";
            else if (tiles.get(i).getAttribute().isMarsh())
                tileType[tiles.get(i).getTileNumber()] = "m";
            else if (tiles.get(i).getAttribute().isJungle())
                tileType[tiles.get(i).getTileNumber()] = "j";
            else if (tiles.get(i).getAttribute().isPlat())
                tileType[tiles.get(i).getTileNumber()] = "p";
            else if (tiles.get(i).getAttribute().isOasis())
                tileType[tiles.get(i).getTileNumber()] = "v";
            else if (tiles.get(i).getAttribute().isRainForest())
                tileType[tiles.get(i).getTileNumber()] = "r";
            else
                tileType[tiles.get(i).getTileNumber()] = "\u2588";
        }
        return tileType;
    }
    public String[] unitMaker(ArrayList<Tile> map, int index, HashMap<Integer, Tile> zeroStatusTilesCivilisation, ArrayList<Integer> tileStatusOfCivilization){
        String unit1[] = new String[72];
        for (int i = 0; i < 72; i++)
            unit1[i] = "\u2588" + "\u2588";
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getUnits().size() > 0) {
                if (map.get(i).getUnits().size() == 1 && index == 1){
                    unit1[i] = "\u2588" + "\u2588";
                }
                else {
                    Unit unit = map.get(i).getUnits().get(index);
                    if (unit.isCivilian())
                        unit1[i] = "C";
                    else
                        unit1[i] = "W";
                    unit1[i] += unit.getCivilization().getFirstLetterOfName();
                }
            }
            if (tileStatusOfCivilization.get(map.get(i).getTileNumber()) == -1)
                unit1[i] = "\u2588" + "\u2588";
        }
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Map.Entry<Integer, Tile> key : zeroStatusTilesCivilisation.entrySet())
            tiles.add(key.getValue());
        for (int i = 0; i < tiles.size(); i++){
            if (tiles.get(i).getUnits().size() > 0) {
                if (tiles.get(i).getUnits().size() == 1 && index == 1){
                    unit1[tiles.get(i).getTileNumber()] = "\u2588" + "\u2588";
                }
                else {
                    Unit unit = tiles.get(i).getUnits().get(index);
                    if (unit.isCivilian())
                        unit1[tiles.get(i).getTileNumber()] = "C";
                    else
                        unit1[tiles.get(i).getTileNumber()] = "W";
                    unit1[tiles.get(i).getTileNumber()] += unit.getCivilization().getFirstLetterOfName();
                }
            }
        }
        return unit1;
    }
    public String[] cvMaker(ArrayList<Tile> map, Civilization civilization){
        String cv[] = new String[72];
        for (int i = 0; i < 72; i++)
            cv[i] = "\u2588";
        ArrayList<City> cities = civilization.getCities();
        ArrayList<Tile> cvTiles = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int j = 0; j < tiles.size(); j++)
                cvTiles.add(tiles.get(j));
        }
        for (int i = 0; i < cvTiles.size(); i++) {
            cv[cvTiles.get(i).getTileNumber()] = civilization.getFirstLetterOfName();
        }
        return cv;
    }
    public String[] cityCenterMaker(ArrayList<Tile> map, Civilization civilization){
        String cityCenter[] = new String[72];
        for (int i = 0; i < 72; i++)
            cityCenter[i] = "\u2588";
        ArrayList<City> cities = civilization.getCities();
        for (City city : cities)
            cityCenter[city.getCenterTile().getTileNumber()] = "*";
        return cityCenter;
    }
    public String[] showMap(String ANSI_COLORS[], String number[], String types[], String unit1[], String unit2[], String cv[], String cityCenter[]){
        char block = '\u2588';
        String block5 = " \\" + block + block + block + block + block + block + block + block + block + block + "/";
        String block6 = "  \\" + block + block + block + block + block + block + block + block + "/";
        String block7 = "   \\" + block + block + block + block + block + block + "/";
        String[] map = new String[77];
        map[0] = ANSI_COLORS[0] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[11] + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "   " + ANSI_COLORS[22] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[33] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[44] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[55] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[66] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[1] = ANSI_COLORS[0] + "  /" + block + block + block + cityCenter[0] + cv[0] + block + block + block + "\\" + "  " +  ANSI_COLORS[11] + "  /" + block + block + block + cityCenter[11] + cv[11] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[22] + "  /" + block + block + block + cityCenter[22] + cv[22] + block + block + block + "\\" + "  " + ANSI_COLORS[33] + "  /" + block + block + block + cityCenter[33] + cv[33] + block + block + block + "\\" + "  " + ANSI_COLORS[44] + "  /" + block + block + block + cityCenter[44] + cv[44] + block + block + block + "\\" + "  " + ANSI_COLORS[55] + "  /" + block + block + block + cityCenter[55] + cv[55] + block + block + block + "\\" + "  " + ANSI_COLORS[66] + "  /" + block + block + block + cityCenter[66] + cv[66] + block + block + block + "\\" + ANSI_RESET;
        map[2] = ANSI_COLORS[0] + " /" + block + block + unit1[0] + block + block + unit2[0] + block + block + "\\" + " " +  ANSI_COLORS[11] + " /" + block + block + unit1[11] + block + block + unit2[11] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[22] + " /" + block + block + unit1[22] + block + block + unit2[22] + block + block + "\\" + " " + ANSI_COLORS[33] + " /" + block + block + unit1[33] + block + block + unit2[33] + block + block + "\\" + " " + ANSI_COLORS[44] + " /" + block + block + unit1[44] + block + block + unit2[44] + block + block + "\\" + " " + ANSI_COLORS[55] + " /" + block + block + unit1[55] + block + block + unit2[55] + block + block + "\\" + " " + ANSI_COLORS[66] + " /" + block + block + unit1[66] + block + block + unit2[66] + block + block + "\\" + ANSI_RESET;
        map[3] = ANSI_COLORS[0] + "|" + block + block + block + block + number[0] + block + types[0] + block + block + block + block + "|" +  ANSI_COLORS[11] + "|" + block + block + block + block + number[11] + block + types[11] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[22] +  "|" + block + block + block + block + number[22] + block + types[22] + block + block + block + block + "|" + ANSI_COLORS[33] + "|" + block + block + block + block + number[33] + block + types[33] + block + block + block + block + "|" + ANSI_COLORS[44] + "|" + block + block + block + block + number[44] + block + types[44] + block + block + block + block + "|" + ANSI_COLORS[55] +"|" + block + block + block + block + number[55] + block + types[55] + block + block + block + block + "|" + ANSI_COLORS[66] + "|" + block + block + block + block + number[66] + block + types[66] + block + block + block + block + "|" + ANSI_RESET;
        map[4] = ANSI_COLORS[0] + block5 + " " +  ANSI_COLORS[11] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[22] + block5 + " " + ANSI_COLORS[33] + block5 + " " + ANSI_COLORS[44] + block5 + " " + ANSI_COLORS[55] + block5 + " " + ANSI_COLORS[66] + block5 + ANSI_RESET;
        map[5] = ANSI_COLORS[0] + block6 + "  " +  ANSI_COLORS[11] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[22] + block6 + "  " + ANSI_COLORS[33] + block6 + "  " + ANSI_COLORS[44] + block6 + "  " + ANSI_COLORS[55] + block6 + "  " + ANSI_COLORS[66] + block6 + ANSI_RESET;
        map[6] = ANSI_COLORS[0] + block7 + "   " +  ANSI_COLORS[11] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[22] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[33] + block7 + "   " + ANSI_COLORS[44] + block7 + "   " + ANSI_COLORS[55] + block7 + "   " + ANSI_COLORS[66] + block7 + ANSI_RESET;

        map[7] = ANSI_COLORS[6] + "       " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[17] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[39] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[50] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[61] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[8] = ANSI_COLORS[6] + "       " + "  /" + block + block + block + cityCenter[6] + cv[6] + block + block + block + "\\" + ANSI_COLORS[17] + "  " + "  /" + block + block + block + cityCenter[17] + cv[17] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] + "  " + "  /" + block + block + block + cityCenter[28] + cv[28] + block + block + block + "\\" + ANSI_COLORS[39] + "  " + "  /" + block + block + block + cityCenter[39] + cv[39] + block + block + block + "\\" + ANSI_COLORS[50] + "  " + "  /" + block + block + block + cityCenter[50] + cv[50] + block + block + block + "\\" + ANSI_COLORS[61] + "  " + "  /" + block + block + block + cityCenter[61] + cv[61] + block + block + block + "\\" + ANSI_RESET;
        map[9] = ANSI_COLORS[6] + "       " + " /" + block + block + unit1[6] + block + block + unit2[6] + block + block + "\\" + ANSI_COLORS[17] + " " + " /" + block + block + unit1[17] + block + block + unit2[17] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  ANSI_COLORS[28] +  " " + " /" + block + block + unit1[28] + block + block + unit2[28] + block + block + "\\" + ANSI_COLORS[39] + " " + " /" + block + block + unit1[39] + block + block + unit2[39] + block + block + "\\" + ANSI_COLORS[50] + " " + " /" + block + block + unit1[50] + block + block + unit2[50] + block + block + "\\" + ANSI_COLORS[61] + " " + " /" + block + block + unit1[61] + block + block + unit2[61] + block + block + "\\" + ANSI_RESET;
        map[10] = ANSI_COLORS[6] + "       " + "|" + block + block + block + block + number[6] + block + types[6] + block + block + block + block + "|" + ANSI_COLORS[17] + "|" + block + block + block + block + number[17] + block + types[17] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] +  "|" + block + block + block + block + number[28] + block + types[28] + block + block + block + block + "|" + ANSI_COLORS[39] + "|" + block + block + block + block + number[39] + block + types[39] + block + block + block + block + "|" + ANSI_COLORS[50] + "|" + block + block + block + block + number[50] + block + types[50] + block + block + block + block + "|" + ANSI_COLORS[61] + "|" + block + block + block + block + number[61] + block + types[61] + block + block + block + block + "|" + ANSI_RESET;
        map[11] = ANSI_COLORS[6] + "       " + block5 + ANSI_COLORS[17] + " " + block5 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] +  " " + block5 + ANSI_COLORS[39] + " " + block5 + ANSI_COLORS[50] + " " + block5 +  ANSI_COLORS[61] + " " + block5 + ANSI_RESET;
        map[12] = ANSI_COLORS[6] + "       " + block6 + ANSI_COLORS[17] + "  " + block6 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] + "  " + block6 + ANSI_COLORS[39] + "  " + block6 + ANSI_COLORS[50] + "  " + block6 + ANSI_COLORS[61] + "  " + block6 + ANSI_RESET;
        map[13] = ANSI_COLORS[6] + "       " + block7 + ANSI_COLORS[17] + "   " + block7 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[28] +  "   " + block7 + ANSI_COLORS[39] + "   " + block7 + ANSI_COLORS[50] + "   " + block7 + ANSI_COLORS[61] + "   " + block7 + ANSI_RESET;

        map[14] = ANSI_COLORS[1] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[12] + "   /" + block + block + block + block + block + block + "\\" + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[23] + "/" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[34] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[45] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[56] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[67] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[15] = ANSI_COLORS[1] + "  /" + block + block + block + cityCenter[1] + cv[1] + block + block + block + "\\" + "  " +  ANSI_COLORS[12] + "  /" + block + block + block + cityCenter[12] + cv[12] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[23] + "  /" + block + block + block + cityCenter[23] + cv[23] + block + block + block + "\\" + "  " + ANSI_COLORS[34] + "  /" + block + block + block + cityCenter[34] + cv[34] + block + block + block + "\\" + "  " + ANSI_COLORS[45] + "  /" + block + block + block + cityCenter[45] + cv[45] + block + block + block + "\\" + "  " + ANSI_COLORS[56] + "  /" + block + block + block + cityCenter[56] + cv[56] + block + block + block + "\\" + "  " + ANSI_COLORS[67] + "  /" + block + block + block + cityCenter[67] + cv[67] + block + block + block + "\\" + ANSI_RESET;
        map[16] = ANSI_COLORS[1] + " /" + block + block + unit1[1] + block + block + unit2[1] + block + block + "\\" + " " +  ANSI_COLORS[12] + " /" + block + block + unit1[12] + block + block + unit2[12] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[23] + " /" + block + block + unit1[23] + block + block + unit2[23] + block + block + "\\" + " " + ANSI_COLORS[34] + " /" + block + block + unit1[34] + block + block + unit2[34] + block + block + "\\" + " " + ANSI_COLORS[45] + " /" + block + block + unit1[45] + block + block + unit2[45] + block + block + "\\" + " " + ANSI_COLORS[56] + " /" + block + block + unit1[56] + block + block + unit2[56] + block + block + "\\" + " " + ANSI_COLORS[67] + " /" + block + block + unit1[67] + block + block + unit2[67] + block + block + "\\" + ANSI_RESET;
        map[17] = ANSI_COLORS[1] + "|" + block + block + block + block + number[1] + block + types[1] + block + block + block + block + "|" +  ANSI_COLORS[12] + "|" + block + block + block + block + number[12] + block + types[12] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[23] +  "|" + block + block + block + block + number[23] + block + types[23] + block + block + block + block + "|" + ANSI_COLORS[34] + "|" + block + block + block + block + number[34] + block + types[34] + block + block + block + block + "|" + ANSI_COLORS[45] + "|" + block + block + block + block + number[45] + block + types[45] + block + block + block + block + "|" + ANSI_COLORS[56] + "|" + block + block + block + block + number[56] + block + types[56] + block + block + block + block + "|" + ANSI_COLORS[67] + "|" + block + block + block + block + number[67] + block + types[67] + block + block + block + block + "|" + ANSI_RESET;
        map[18] = ANSI_COLORS[1] + block5 + " " +  ANSI_COLORS[12] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[23] + block5 + " " + ANSI_COLORS[34] + block5 + " " + ANSI_COLORS[45] + block5 + " " + ANSI_COLORS[56] + block5 + " " + ANSI_COLORS[67] + block5 + ANSI_RESET;
        map[19] = ANSI_COLORS[1] + block6 + "  " +  ANSI_COLORS[12] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[23] + block6 + "  " + ANSI_COLORS[34] + block6 + "  " + ANSI_COLORS[45] + block6 + "  " + ANSI_COLORS[56] + block6 + "  " + ANSI_COLORS[67] + block6 + ANSI_RESET;
        map[20] = ANSI_COLORS[1] + block7 + "   " +  ANSI_COLORS[12] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[23] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[34] + block7 + "   " + ANSI_COLORS[45] + block7 + "   " + ANSI_COLORS[56] + block7 + "   " + ANSI_COLORS[67] + block7 + ANSI_RESET;

        map[21] = ANSI_COLORS[7] + "       " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[18] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[40] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[51] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[62] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[22] = ANSI_COLORS[7] + "       " + "  /" + block + block + block + cityCenter[7] + cv[7] + block + block + block + "\\" + ANSI_COLORS[18] + "  " + "  /" + block + block + block + cityCenter[18] + cv[18] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] + "  " + "  /" + block + block + block + cityCenter[29] + cv[29] + block + block + block + "\\" + ANSI_COLORS[40] + "  " + "  /" + block + block + block + cityCenter[40] + cv[40] + block + block + block + "\\" + ANSI_COLORS[51] + "  " + "  /" + block + block + block + cityCenter[51] + cv[51] + block + block + block + "\\" + ANSI_COLORS[62] + "  " + "  /" + block + block + block + cityCenter[62] + cv[62] + block + block + block + "\\" + ANSI_RESET;
        map[23] = ANSI_COLORS[7] + "       " + " /" + block + block + unit1[7] + block + block + unit2[7] + block + block + "\\" + ANSI_COLORS[18] + " " + " /" + block + block + unit1[18] + block + block + unit2[18] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] +  " " + " /" + block + block + unit1[29] + block + block + unit2[29] + block + block + "\\" + ANSI_COLORS[40] + " " + " /" + block + block + unit1[40] + block + block + unit2[40] + block + block + "\\" + ANSI_COLORS[51] + " " + " /" + block + block + unit1[51] + block + block + unit2[51] + block + block + "\\" + ANSI_COLORS[62] + " " + " /" + block + block + unit1[62] + block + block + unit2[62] + block + block + "\\" + ANSI_RESET;
        map[24] = ANSI_COLORS[7] + "       " + "|" + block + block + block + block + number[7] + block + types[7] + block + block + block + block + "|" + ANSI_COLORS[18] + "|" + block + block + block + block + number[18] + block + types[18] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] +  "|" + block + block + block + block + number[29] + block + types[29] + block + block + block + block + "|" + ANSI_COLORS[40] + "|" + block + block + block + block + number[40] + block + types[40] + block + block + block + block + "|" + ANSI_COLORS[51] + "|" + block + block + block + block + number[51] + block + types[51] + block + block + block + block + "|" + ANSI_COLORS[62] + "|" + block + block + block + block + number[62] + block + types[62] + block + block + block + block + "|" + ANSI_RESET;
        map[25] = ANSI_COLORS[7] + "       " + block5 + ANSI_COLORS[18] + " " + block5 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] +  " " + block5 + ANSI_COLORS[40] + " " + block5 + ANSI_COLORS[51] + " " + block5 +  ANSI_COLORS[62] + " " + block5 + ANSI_RESET;
        map[26] = ANSI_COLORS[7] + "       " + block6 + ANSI_COLORS[18] + "  " + block6 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] + "  " + block6 + ANSI_COLORS[40] + "  " + block6 + ANSI_COLORS[51] + "  " + block6 + ANSI_COLORS[62] + "  " + block6 + ANSI_RESET;
        map[27] = ANSI_COLORS[7] + "       " + block7 + ANSI_COLORS[18] + "   " + block7 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[29] +  "   " + block7 + ANSI_COLORS[40] + "   " + block7 + ANSI_COLORS[51] + "   " + block7 + ANSI_COLORS[62] + "   " + block7 + ANSI_RESET;

        map[28] = ANSI_COLORS[2] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[13] + "   /" + block + block + block + block + block + block + "\\" + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[24] + "/" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[35] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[46] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[57] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[68] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[29] = ANSI_COLORS[2] + "  /" + block + block + block + cityCenter[2] + cv[2] + block + block + block + "\\" + "  " +  ANSI_COLORS[13] + "  /" + block + block + block + cityCenter[13] + cv[13] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[24] + "  /" + block + block + block + cityCenter[24] + cv[24] + block + block + block + "\\" + "  " + ANSI_COLORS[35] + "  /" + block + block + block + cityCenter[35] + cv[35] + block + block + block + "\\" + "  " + ANSI_COLORS[46] + "  /" + block + block + block + cityCenter[46] + cv[46] + block + block + block + "\\" + "  " + ANSI_COLORS[57] + "  /" + block + block + block + cityCenter[57] + cv[57] + block + block + block + "\\" + "  " + ANSI_COLORS[68] + "  /" + block + block + block + cityCenter[68] + cv[68] + block + block + block + "\\" + ANSI_RESET;
        map[30] = ANSI_COLORS[2] + " /" + block + block + unit1[2] + block + block + unit2[2] + block + block + "\\" + " " +  ANSI_COLORS[13] + " /" + block + block + unit1[13] + block + block + unit2[13] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[24] + " /" + block + block + unit1[24] + block + block + unit2[24] + block + block + "\\" + " " + ANSI_COLORS[35] + " /" + block + block + unit1[35] + block + block + unit2[35] + block + block + "\\" + " " + ANSI_COLORS[46] + " /" + block + block + unit1[46] + block + block + unit2[46] + block + block + "\\" + " " + ANSI_COLORS[57] + " /" + block + block + unit1[57] + block + block + unit2[57] + block + block + "\\" + " " + ANSI_COLORS[68] + " /" + block + block + unit1[68] + block + block + unit2[68] + block + block + "\\" + ANSI_RESET;
        map[31] = ANSI_COLORS[2] + "|" + block + block + block + block + number[2] + block + types[2] + block + block + block + block + "|" +  ANSI_COLORS[13] + "|" + block + block + block + block + number[13] + block + types[13] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[24] +  "|" + block + block + block + block + number[24] + block + types[24] + block + block + block + block + "|" + ANSI_COLORS[35] + "|" + block + block + block + block + number[35] + block + types[35] + block + block + block + block + "|" + ANSI_COLORS[46] + "|" + block + block + block + block + number[46] + block + types[46] + block + block + block + block + "|" + ANSI_COLORS[57] + "|" + block + block + block + block + number[57] + block + types[57] + block + block + block + block + "|" + ANSI_COLORS[68] + "|" + block + block + block + block + number[68] + block + types[68] + block + block + block + block + "|" + ANSI_RESET;
        map[32] = ANSI_COLORS[2] + block5 + " " +  ANSI_COLORS[13] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[24] + block5 + " " + ANSI_COLORS[35] + block5 + " " + ANSI_COLORS[46] + block5 + " " + ANSI_COLORS[57] + block5 + " " + ANSI_COLORS[68] + block5 + ANSI_RESET;
        map[33] = ANSI_COLORS[2] + block6 + "  " +  ANSI_COLORS[13] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[24] + block6 + "  " + ANSI_COLORS[35] + block6 + "  " + ANSI_COLORS[46] + block6 + "  " + ANSI_COLORS[57] + block6 + "  " + ANSI_COLORS[68] + block6 + ANSI_RESET;
        map[34] = ANSI_COLORS[2] + block7 + "   " +  ANSI_COLORS[13] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[24] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[35] + block7 + "   " + ANSI_COLORS[46] + block7 + "   " + ANSI_COLORS[57] + block7 + "   " + ANSI_COLORS[68] + block7 + ANSI_RESET;

        map[35] = ANSI_COLORS[8] + "       " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[19] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[41] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[52] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[63] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[36] = ANSI_COLORS[8] + "       " + "  /" + block + block + block + cityCenter[8] + cv[8] + block + block + block + "\\" + ANSI_COLORS[19] + "  " + "  /" + block + block + block + cityCenter[19] + cv[19] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] + "  " + "  /" + block + block + block + cityCenter[30] + cv[30] + block + block + block + "\\" + ANSI_COLORS[41] + "  " + "  /" + block + block + block + cityCenter[41] + cv[41] + block + block + block + "\\" + ANSI_COLORS[52] + "  " + "  /" + block + block + block + cityCenter[52] + cv[52] + block + block + block + "\\" + ANSI_COLORS[63] + "  " + "  /" + block + block + block + cityCenter[63] + cv[63] + block + block + block + "\\" + ANSI_RESET;
        map[37] = ANSI_COLORS[8] + "       " + " /" + block + block + unit1[8] + block + block + unit2[8] + block + block + "\\" + ANSI_COLORS[19] + " " + " /" + block + block + unit1[19] + block + block + unit2[19] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] +  " " + " /" + block + block + unit1[30] + block + block + unit2[30] + block + block + "\\" + ANSI_COLORS[41] + " " + " /" + block + block + unit1[41] + block + block + unit2[41] + block + block + "\\" + ANSI_COLORS[52] + " " + " /" + block + block + unit1[52] + block + block + unit2[52] + block + block + "\\" + ANSI_COLORS[63] + " " + " /" + block + block + unit1[63] + block + block + unit2[63] + block + block + "\\" + ANSI_RESET;
        map[38] = ANSI_COLORS[8] + "       " + "|" + block + block + block + block + number[8] + block + types[8] + block + block + block + block + "|" + ANSI_COLORS[19] + "|" + block + block + block + block + number[19] + block + types[19] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] +  "|" + block + block + block + block + number[30] + block + types[30] + block + block + block + block + "|" + ANSI_COLORS[41] + "|" + block + block + block + block + number[41] + block + types[41] + block + block + block + block + "|" + ANSI_COLORS[52] + "|" + block + block + block + block + number[52] + block + types[52] + block + block + block + block + "|" + ANSI_COLORS[63] + "|" + block + block + block + block + number[63] + block + types[63] + block + block + block + block + "|" + ANSI_RESET;
        map[39] = ANSI_COLORS[8] + "       " + block5 + ANSI_COLORS[19] + " " + block5 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] +  " " + block5 + ANSI_COLORS[41] + " " + block5 + ANSI_COLORS[52] + " " + block5 +  ANSI_COLORS[63] + " " + block5 + ANSI_RESET;
        map[40] = ANSI_COLORS[8] + "       " + block6 + ANSI_COLORS[19] + "  " + block6 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] + "  " + block6 + ANSI_COLORS[41] + "  " + block6 + ANSI_COLORS[52] + "  " + block6 + ANSI_COLORS[63] + "  " + block6 + ANSI_RESET;
        map[41] = ANSI_COLORS[8] + "       " + block7 + ANSI_COLORS[19] + "   " + block7 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[30] +  "   " + block7 + ANSI_COLORS[41] + "   " + block7 + ANSI_COLORS[52] + "   " + block7 + ANSI_COLORS[63] + "   " + block7 + ANSI_RESET;

        map[42] = ANSI_COLORS[3] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[14] + "   /" + block + block + block + block + block + block + "\\" + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[25] + "/" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[36] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[47] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[58] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[69] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[43] = ANSI_COLORS[3] + "  /" + block + block + block + cityCenter[3] + cv[3] + block + block + block + "\\" + "  " +  ANSI_COLORS[14] + "  /" + block + block + block + cityCenter[14] + cv[14] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[25] + "  /" + block + block + block + cityCenter[25] + cv[25] + block + block + block + "\\" + "  " + ANSI_COLORS[36] + "  /" + block + block + block + cityCenter[36] + cv[36] + block + block + block + "\\" + "  " + ANSI_COLORS[47] + "  /" + block + block + block + cityCenter[47] + cv[47] + block + block + block + "\\" + "  " + ANSI_COLORS[58] + "  /" + block + block + block + cityCenter[58] + cv[58] + block + block + block + "\\" + "  " + ANSI_COLORS[69] + "  /" + block + block + block + cityCenter[69] + cv[69] + block + block + block + "\\" + ANSI_RESET;
        map[44] = ANSI_COLORS[3] + " /" + block + block + unit1[3] + block + block + unit2[3] + block + block + "\\" + " " +  ANSI_COLORS[14] + " /" + block + block + unit1[14] + block + block + unit2[14] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[25] + " /" + block + block + unit1[25] + block + block + unit2[25] + block + block + "\\" + " " + ANSI_COLORS[36] + " /" + block + block + unit1[36] + block + block + unit2[36] + block + block + "\\" + " " + ANSI_COLORS[47] + " /" + block + block + unit1[47] + block + block + unit2[47] + block + block + "\\" + " " + ANSI_COLORS[58] + " /" + block + block + unit1[58] + block + block + unit2[58] + block + block + "\\" + " " + ANSI_COLORS[69] + " /" + block + block + unit1[69] + block + block + unit2[69] + block + block + "\\" + ANSI_RESET;
        map[45] = ANSI_COLORS[3] + "|" + block + block + block + block + number[3] + block + types[3] + block + block + block + block + "|" +  ANSI_COLORS[14] + "|" + block + block + block + block + number[14] + block + types[14] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[25] +  "|" + block + block + block + block + number[25] + block + types[25] + block + block + block + block + "|" + ANSI_COLORS[36] + "|" + block + block + block + block + number[36] + block + types[36] + block + block + block + block + "|" + ANSI_COLORS[47] + "|" + block + block + block + block + number[47] + block + types[47] + block + block + block + block + "|" + ANSI_COLORS[58] + "|" + block + block + block + block + number[58] + block + types[58] + block + block + block + block + "|" + ANSI_COLORS[69] + "|" + block + block + block + block + number[69] + block + types[69] + block + block + block + block + "|" + ANSI_RESET;
        map[46] = ANSI_COLORS[3] + block5 + " " +  ANSI_COLORS[14] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[25] + block5 + " " + ANSI_COLORS[36] + block5 + " " + ANSI_COLORS[47] + block5 + " " + ANSI_COLORS[58] + block5 + " " + ANSI_COLORS[69] + block5 + ANSI_RESET;
        map[47] = ANSI_COLORS[3] + block6 + "  " +  ANSI_COLORS[14] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[25] + block6 + "  " + ANSI_COLORS[36] + block6 + "  " + ANSI_COLORS[47] + block6 + "  " + ANSI_COLORS[58] + block6 + "  " + ANSI_COLORS[69] + block6 + ANSI_RESET;
        map[48] = ANSI_COLORS[3] + block7 + "   " +  ANSI_COLORS[14] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[25] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[36] + block7 + "   " + ANSI_COLORS[47] + block7 + "   " + ANSI_COLORS[58] + block7 + "   " + ANSI_COLORS[69] + block7 + ANSI_RESET;

        map[49] = ANSI_COLORS[9] + "       " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[20] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[42] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[53] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[64] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[50] = ANSI_COLORS[9] + "       " + "  /" + block + block + block + cityCenter[9] + cv[9] + block + block + block + "\\" + ANSI_COLORS[20] + "  " + "  /" + block + block + block + cityCenter[20] + cv[20] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] + "  " + "  /" + block + block + block + cityCenter[31] + cv[31] + block + block + block + "\\" + ANSI_COLORS[42] + "  " + "  /" + block + block + block + cityCenter[42] + cv[42] + block + block + block + "\\" + ANSI_COLORS[53] + "  " + "  /" + block + block + block + cityCenter[53] + cv[53] + block + block + block + "\\" + ANSI_COLORS[64] + "  " + "  /" + block + block + block + cityCenter[64] + cv[64] + block + block + block + "\\" + ANSI_RESET;
        map[51] = ANSI_COLORS[9] + "       " + " /" + block + block + unit1[9] + block + block + unit2[9] + block + block + "\\" + ANSI_COLORS[20] + " " + " /" + block + block + unit1[20] + block + block + unit2[20] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] +  " " + " /" + block + block + unit1[31] + block + block + unit2[31] + block + block + "\\" + ANSI_COLORS[42] + " " + " /" + block + block + unit1[42] + block + block + unit2[42] + block + block + "\\" + ANSI_COLORS[53] + " " + " /" + block + block + unit1[53] + block + block + unit2[53] + block + block + "\\" + ANSI_COLORS[64] + " " + " /" + block + block + unit1[64] + block + block + unit2[64] + block + block + "\\" + ANSI_RESET;
        map[52] = ANSI_COLORS[9] + "       " + "|" + block + block + block + block + number[9] + block + types[9] + block + block + block + block + "|" + ANSI_COLORS[20] + "|" + block + block + block + block + number[20] + block + types[20] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] +  "|" + block + block + block + block + number[31] + block + types[31] + block + block + block + block + "|" + ANSI_COLORS[42] + "|" + block + block + block + block + number[42] + block + types[42] + block + block + block + block + "|" + ANSI_COLORS[53] + "|" + block + block + block + block + number[53] + block + types[53] + block + block + block + block + "|" + ANSI_COLORS[64] + "|" + block + block + block + block + number[64] + block + types[64] + block + block + block + block + "|" + ANSI_RESET;
        map[53] = ANSI_COLORS[9] + "       " + block5 + ANSI_COLORS[20] + " " + block5 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] +  " " + block5 + ANSI_COLORS[42] + " " + block5 + ANSI_COLORS[53] + " " + block5 +  ANSI_COLORS[64] + " " + block5 + ANSI_RESET;
        map[54] = ANSI_COLORS[9] + "       " + block6 + ANSI_COLORS[20] + "  " + block6 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] + "  " + block6 + ANSI_COLORS[42] + "  " + block6 + ANSI_COLORS[53] + "  " + block6 + ANSI_COLORS[64] + "  " + block6 + ANSI_RESET;
        map[55] = ANSI_COLORS[9] + "       " + block7 + ANSI_COLORS[20] + "   " + block7 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[31] +  "   " + block7 + ANSI_COLORS[42] + "   " + block7 + ANSI_COLORS[53] + "   " + block7 + ANSI_COLORS[64] + "   " + block7 + ANSI_RESET;

        map[56] = ANSI_COLORS[4] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[15] + "   /" + block + block + block + block + block + block + "\\" + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[26] + "/" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[37] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[48] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[59] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[70] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[57] = ANSI_COLORS[4] + "  /" + block + block + block + cityCenter[4] + cv[4] + block + block + block + "\\" + "  " +  ANSI_COLORS[15] + "  /" + block + block + block + cityCenter[15] + cv[15] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[26] + "  /" + block + block + block + cityCenter[26] + cv[26] + block + block + block + "\\" + "  " + ANSI_COLORS[37] + "  /" + block + block + block + cityCenter[37] + cv[37] + block + block + block + "\\" + "  " + ANSI_COLORS[48] + "  /" + block + block + block + cityCenter[48] + cv[48] + block + block + block + "\\" + "  " + ANSI_COLORS[59] + "  /" + block + block + block + cityCenter[59] + cv[59] + block + block + block + "\\" + "  " + ANSI_COLORS[70] + "  /" + block + block + block + cityCenter[70] + cv[70] + block + block + block + "\\" + ANSI_RESET;
        map[58] = ANSI_COLORS[4] + " /" + block + block + unit1[4] + block + block + unit2[4] + block + block + "\\" + " " +  ANSI_COLORS[15] + " /" + block + block + unit1[15] + block + block + unit2[15] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[26] + " /" + block + block + unit1[26] + block + block + unit2[26] + block + block + "\\" + " " + ANSI_COLORS[37] + " /" + block + block + unit1[37] + block + block + unit2[37] + block + block + "\\" + " " + ANSI_COLORS[48] + " /" + block + block + unit1[48] + block + block + unit2[48] + block + block + "\\" + " " + ANSI_COLORS[59] + " /" + block + block + unit1[59] + block + block + unit2[59] + block + block + "\\" + " " + ANSI_COLORS[70] + " /" + block + block + unit1[70] + block + block + unit2[70] + block + block + "\\" + ANSI_RESET;
        map[59] = ANSI_COLORS[4] + "|" + block + block + block + block + number[4] + block + types[4] + block + block + block + block + "|" +  ANSI_COLORS[15] + "|" + block + block + block + block + number[15] + block + types[15] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[26] +  "|" + block + block + block + block + number[26] + block + types[26] + block + block + block + block + "|" + ANSI_COLORS[37] + "|" + block + block + block + block + number[37] + block + types[37] + block + block + block + block + "|" + ANSI_COLORS[48] + "|" + block + block + block + block + number[48] + block + types[48] + block + block + block + block + "|" + ANSI_COLORS[59] + "|" + block + block + block + block + number[59] + block + types[59] + block + block + block + block + "|" + ANSI_COLORS[70] + "|" + block + block + block + block + number[70] + block + types[70] + block + block + block + block + "|" + ANSI_RESET;
        map[60] = ANSI_COLORS[4] + block5 + " " +  ANSI_COLORS[15] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[26] + block5 + " " + ANSI_COLORS[37] + block5 + " " + ANSI_COLORS[48] + block5 + " " + ANSI_COLORS[59] + block5 + " " + ANSI_COLORS[70] + block5 + ANSI_RESET;
        map[61] = ANSI_COLORS[4] + block6 + "  " +  ANSI_COLORS[15] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[26] + block6 + "  " + ANSI_COLORS[37] + block6 + "  " + ANSI_COLORS[48] + block6 + "  " + ANSI_COLORS[59] + block6 + "  " + ANSI_COLORS[70] + block6 + ANSI_RESET;
        map[62] = ANSI_COLORS[4] + block7 + "   " +  ANSI_COLORS[15] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[26] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[37] + block7 + "   " + ANSI_COLORS[48] + block7 + "   " + ANSI_COLORS[59] + block7 + "   " + ANSI_COLORS[70] + block7 + ANSI_RESET;

        map[63] = ANSI_COLORS[10] + "       " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[21] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[43] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[54] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_COLORS[65] + "   " + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[64] = ANSI_COLORS[10] + "       " + "  /" + block + block + block + cityCenter[10] + cv[10] + block + block + block + "\\" + ANSI_COLORS[21] + "  " + "  /" + block + block + block + cityCenter[21] + cv[21] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] + "  " + "  /" + block + block + block + cityCenter[32] + cv[32] + block + block + block + "\\" + ANSI_COLORS[43] + "  " + "  /" + block + block + block + cityCenter[43] + cv[43] + block + block + block + "\\" + ANSI_COLORS[54] + "  " + "  /" + block + block + block + cityCenter[54] + cv[54] + block + block + block + "\\" + ANSI_COLORS[65] + "  " + "  /" + block + block + block + cityCenter[65] + cv[65] + block + block + block + "\\" + ANSI_RESET;
        map[65] = ANSI_COLORS[10] + "       " + " /" + block + block + unit1[10] + block + block + unit2[10] + block + block + "\\" + ANSI_COLORS[21] + " " + " /" + block + block + unit1[21] + block + block + unit2[21] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] +  " " + " /" + block + block + unit1[32] + block + block + unit2[32] + block + block + "\\" + ANSI_COLORS[43] + " " + " /" + block + block + unit1[43] + block + block + unit2[43] + block + block + "\\" + ANSI_COLORS[54] + " " + " /" + block + block + unit1[54] + block + block + unit2[54] + block + block + "\\" + ANSI_COLORS[65] + " " + " /" + block + block + unit1[65] + block + block + unit2[65] + block + block + "\\" + ANSI_RESET;
        map[66] = ANSI_COLORS[10] + "       " + "|" + block + block + block + block + number[10] + block + types[10] + block + block + block + block + "|" + ANSI_COLORS[21] + "|" + block + block + block + block + number[21] + block + types[21] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] +  "|" + block + block + block + block + number[32] + block + types[32] + block + block + block + block + "|" + ANSI_COLORS[43] + "|" + block + block + block + block + number[43] + block + types[43] + block + block + block + block + "|" + ANSI_COLORS[54] + "|" + block + block + block + block + number[54] + block + types[54] + block + block + block + block + "|" + ANSI_COLORS[65] + "|" + block + block + block + block + number[65] + block + types[65] + block + block + block + block + "|" + ANSI_RESET;
        map[67] = ANSI_COLORS[10] + "       " + block5 + ANSI_COLORS[21] + " " + block5 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] +  " " + block5 + ANSI_COLORS[43] + " " + block5 + ANSI_COLORS[54] + " " + block5 +  ANSI_COLORS[65] + " " + block5 + ANSI_RESET;
        map[68] = ANSI_COLORS[10] + "       " + block6 + ANSI_COLORS[21] + "  " + block6 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] + "  " + block6 + ANSI_COLORS[43] + "  " + block6 + ANSI_COLORS[54] + "  " + block6 + ANSI_COLORS[65] + "  " + block6 + ANSI_RESET;
        map[69] = ANSI_COLORS[10] + "       " + block7 + ANSI_COLORS[21] + "   " + block7 + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[32] +  "   " + block7 + ANSI_COLORS[43] + "   " + block7 + ANSI_COLORS[54] + "   " + block7 + ANSI_COLORS[65] + "   " + block7 + ANSI_RESET;

        map[70] = ANSI_COLORS[5] + "   /" + block + block + block + block + block + block + "\\" + "   " +  ANSI_COLORS[16] + "   /" + block + block + block + block + block + block + "\\" + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[27] + "/" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[38] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[49] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[60] + "   /" + block + block + block + block + block + block + "\\" + "   " + ANSI_COLORS[71] + "   /" + block + block + block + block + block + block + "\\" + ANSI_RESET;
        map[71] = ANSI_COLORS[5] + "  /" + block + block + block + cityCenter[5] + cv[5] + block + block + block + "\\" + "  " +  ANSI_COLORS[16] + "  /" + block + block + block + cityCenter[16] + cv[16] + block + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[27] + "  /" + block + block + block + cityCenter[27] + cv[27] + block + block + block + "\\" + "  " + ANSI_COLORS[38] + "  /" + block + block + block + cityCenter[38] + cv[38] + block + block + block + "\\" + "  " + ANSI_COLORS[49] + "  /" + block + block + block + cityCenter[49] + cv[49] + block + block + block + "\\" + "  " + ANSI_COLORS[60] + "  /" + block + block + block + cityCenter[60] + cv[60] + block + block + block + "\\" + "  " + ANSI_COLORS[71] + "  /" + block + block + block + cityCenter[71] + cv[71] + block + block + block + "\\" + ANSI_RESET;
        map[72] = ANSI_COLORS[5] + " /" + block + block + unit1[5] + block + block + unit2[5] + block + block + "\\" + " " +  ANSI_COLORS[16] + " /" + block + block + unit1[16] + block + block + unit2[16] + block + block + "\\" + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[27] + " /" + block + block + unit1[27] + block + block + unit2[27] + block + block + "\\" + " " + ANSI_COLORS[38] + " /" + block + block + unit1[38] + block + block + unit2[38] + block + block + "\\" + " " + ANSI_COLORS[49] + " /" + block + block + unit1[49] + block + block + unit2[49] + block + block + "\\" + " " + ANSI_COLORS[60] + " /" + block + block + unit1[60] + block + block + unit2[60] + block + block + "\\" + " " + ANSI_COLORS[71] + " /" + block + block + unit1[71] + block + block + unit2[71] + block + block + "\\" + ANSI_RESET;
        map[73] = ANSI_COLORS[5] + "|" + block + block + block + block + number[5] + block + types[5] + block + block + block + block + "|" +  ANSI_COLORS[16] + "|" + block + block + block + block + number[16] + block + types[16] + block + block + block + block + "|" + ANSI_COLORS[72] + block + ANSI_RESET + ANSI_COLORS[27] +  "|" + block + block + block + block + number[27] + block + types[27] + block + block + block + block + "|" + ANSI_COLORS[38] + "|" + block + block + block + block + number[38] + block + types[38] + block + block + block + block + "|" + ANSI_COLORS[49] + "|" + block + block + block + block + number[49] + block + types[49] + block + block + block + block + "|" + ANSI_COLORS[60] + "|" + block + block + block + block + number[60] + block + types[60] + block + block + block + block + "|" + ANSI_COLORS[71] + "|" + block + block + block + block + number[71] + block + types[71] + block + block + block + block + "|" + ANSI_RESET;
        map[74] = ANSI_COLORS[5] + block5 + " " +  ANSI_COLORS[16] + block5 + ANSI_COLORS[72] + block + ANSI_RESET +  " " + ANSI_COLORS[27] + block5 + " " + ANSI_COLORS[38] + block5 + " " + ANSI_COLORS[49] + block5 + " " + ANSI_COLORS[60] + block5 + " " + ANSI_COLORS[71] + block5 + ANSI_RESET;
        map[75] = ANSI_COLORS[5] + block6 + "  " +  ANSI_COLORS[16] + block6 + ANSI_COLORS[72] + block + ANSI_RESET + "  " + ANSI_COLORS[27] + block6 + "  " + ANSI_COLORS[38] + block6 + "  " + ANSI_COLORS[49] + block6 + "  " + ANSI_COLORS[60] + block6 + "  " + ANSI_COLORS[71] + block6 + ANSI_RESET;
        map[76] = ANSI_COLORS[5] + block7 + "   " +  ANSI_COLORS[16] + block7 + " " + ANSI_COLORS[72] + block + block + block + block + block + block + ANSI_RESET + ANSI_COLORS[27] + "\\" + block + block + block + block + block + block + "/" + "   " + ANSI_COLORS[38] + block7 + "   " + ANSI_COLORS[49] + block7 + "   " + ANSI_COLORS[60] + block7 + "   " + ANSI_COLORS[71] + block7 + ANSI_RESET;

        return map;
    }
    // if distance between two tile center is (rad3 * radius) they're neighbor
    private boolean isCityNeighbor(float x1, float y1, float x2, float y2, float radius){
        double distance = Math.sqrt(Math.pow((double)x2 - (double)x1, 2) + Math.pow((double)y2 - (double) y1, 2));
        if (distance < 1.1 * (double)radius * Math.sqrt(3))
            return true;
        return false;
    }
    private boolean isUnitNeighbor(float x1, float y1, float x2, float y2, float radius){
        double distance = Math.sqrt(Math.pow((double) x2 - (double) x1, 2) + Math.pow((double) y2 - (double) y1, 2));
        if (1.5 * radius * Math.sqrt(3) < distance && distance < 2.5 * radius * Math.sqrt(3))
            return true;
        return false;
    }
    // 1 -> vazeh, -1 -> fog
    public ArrayList<Integer> statusChecker(Civilization civilization, ArrayList<Tile> map){
        ArrayList<Integer> civilizationTiles  = new ArrayList<>();
        for (int i = 0; i < 72; i++)
            civilizationTiles.add(-1);
        ArrayList<City> cities = civilization.getCities();
        boolean check = false;
        for (int i = 0; i < map.size(); i++) {
            check = false;
            for (int j = 0; j < cities.size(); j++) {
                ArrayList<Tile> cityTiles = cities.get(j).getTiles();
                for (int k = 0; k < cityTiles.size(); k++) {
                    if (cityTiles.get(k).getUnits().size() == 0 && isCityNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())) {
                        civilizationTiles.set(i, 1);
                        check = true;
                        break;
                    }
                    if (cityTiles.get(k).getUnits().size() > 0 && isUnitNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())
                            && !cityTiles.get(k).isBlocker()) {
                        civilizationTiles.set(i, 1);
                        check = true;
                        break;
                    }
                    if (cityTiles.get(k).getUnits().size() > 0 && isCityNeighbor(cityTiles.get(k).getX(), cityTiles.get(k).getY(), map.get(i).getX(), map.get(i).getY(), cityTiles.get(k).getRadius())
                            && !cityTiles.get(k).isBlocker()) {
                        for (int l = 0; l < map.size(); l++)
                            if (2 * map.get(l).getTileNumber() == cityTiles.get(k).getTileNumber() + map.get(i).getTileNumber() && map.get(l).isBlocker()){
                                civilizationTiles.set(i, -1);
                                check = true;
                                break;
                            }
                        if (check)
                            break;
                        civilizationTiles.set(i, 1);
                        check = true;
                        break;
                    }
                }
                if (check)
                    break;
            }
        }
        ArrayList<Unit> allUnits = new ArrayList<>();
        for (int i = 0; i < 72; i++) {
            ArrayList<Unit> tileUnits = map.get(i).getUnits();
            for (int j = 0; j < tileUnits.size(); j++) {
                if (tileUnits.get(j).getCivilization() == civilization)
                    allUnits.add(tileUnits.get(j));
            }
        }
        for (int i = 0; i < map.size(); i++) {
            check = false;
            for (int l = 0; l < allUnits.size(); l++) {
                if (isUnitNeighbor(allUnits.get(l).getOrigin().getX(), allUnits.get(l).getOrigin().getY(), map.get(i).getX(), map.get(i).getY(), map.get(i).getRadius())) {
                    for (int z = 0; z < map.size(); z++)
                        if (2 * map.get(z).getTileNumber() == allUnits.get(l).getOrigin().getTileNumber() + map.get(i).getTileNumber() && map.get(z).isBlocker()) {
                            civilizationTiles.set(i, -1);
                            check = true;
                            break;
                        }
                    if (!check){
                        civilizationTiles.set(i, 1);
                        break;
                    }
                }
                if (isCityNeighbor(allUnits.get(l).getOrigin().getX(), allUnits.get(l).getOrigin().getY(), map.get(i).getX(), map.get(i).getY(), map.get(i).getRadius()))
                    civilizationTiles.set(i, 1);
            }
        }
        return civilizationTiles;
    }
    // -1 -> fog, 0  -> moshakhas, 1 -> vazeh
    public ArrayList<Integer> statusComparator(ArrayList<Integer> old, ArrayList<Integer> now, HashMap<Integer, Tile> zeroStatusTiles, ArrayList<Tile> map){
        //TODO... if(now == fog of war && old == vazeh -> now = moshakhas)
        //TODO... return now;
        ArrayList<Integer> finalTileStatus = new ArrayList<>();
        for (int i = 0; i < 72; i++)
            finalTileStatus.add(-1);
        for (int i = 0; i < old.size(); i++) {
            if (now.get(i) == 1)
                finalTileStatus.set(i, 1);
            else if (now.get(i) == -1 && old.get(i) == 1) {
                finalTileStatus.set(i, 0);
                boolean exist = false;
                for (int j = 0; j < zeroStatusTiles.size(); j++) {
                    if (zeroStatusTiles.containsKey(i)) {
                        zeroStatusTiles.replace(i, map.get(i));
                        exist = true;
                        break;
                    }
                }
                if (!exist)
                    zeroStatusTiles.put(i, map.get(i));
            }
        }
        return finalTileStatus;
    }

/*    public StringBuilder researchInformation(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Technology> allTechnologies = civilization.getTechnologies();
        stringBuilder.append("technologies that have been learnt:\n");
        for (Technology technology : allTechnologies)
            stringBuilder.append(technology.getName() + "\n");
        HashMap<Technology, Integer> technologyEarnedPercent = civilization.getTechnologyEarnedPercent();
        stringBuilder.append("technologies that you haven't been learnt completely:\n");
        if (technologyEarnedPercent.size() == 0){
            stringBuilder.append("nothing\n");
            return stringBuilder;
        }
        for (Map.Entry<Technology, Integer> technology: technologyEarnedPercent.entrySet())
            stringBuilder.append(technology.getKey().getName() + "\trounds left: " + technology.getValue().toString() + "\n");
        return stringBuilder;
    }*/
    /*// return name of current unit
    public String getUnitsName (Unit unit) {
        if (unit.isCivilian()) {
            if (((Civilian)unit).isWorker()) {
                return "worker";
            }
            else {
                return "settler";
            }
        }
        else {
            if (((Warrior)unit).isTank()) {
                return "tank";
            }
            else if (((Warrior)unit).isPanzer()) {
                return "panzer";
            }
            else if (((Warrior)unit).isWarrior()) {
                return "warrior";
            }
            else if (((Warrior)unit).isInfantry()) {
                return "infantry";
            }
            else if (((Warrior)unit).isArtillery()) {
                return "artillery";
            }
            else if (((Warrior)unit).isArcher()) {
                return "archer";
            }
            else if (((Warrior)unit).isChariotArcher()) {
                return "chariot archer";
            }
            else if (((Warrior)unit).isScout()) {
                return "scout";
            }
            else if (((Warrior)unit).isSpearman()) {
                return "spearman";
            }
            else if (((Warrior)unit).isCatapult()) {
                return "catapult";
            }
            else if (((Warrior)unit).isHorseMan()) {
                return "horseman";
            }
            else if (((Warrior)unit).isSwordsMan()) {
                return "swordsman";
            }
            else if (((Warrior)unit).isCrossbowMan()) {
                return "crossbowman";
            }
            else if (((Warrior)unit).isKnight()) {
                return "knight";
            }
            else if (((Warrior)unit).isLongswordMan()) {
                return "longsword man";
            }
            else if (((Warrior)unit).isPikeMan()) {
                return "pike man";
            }
            else if (((Warrior)unit).isTrebuchet()) {
                return "trebuchet";
            }
            else if (((Warrior)unit).isCanon()) {
                return "canon";
            }
            else if (((Warrior)unit).isCavalry()) {
                return "cavalry";
            }
            else if (((Warrior)unit).isLancer()) {
                return "lancer";
            }
            else if (((Warrior)unit).isMusketMan()) {
                return "musket man";
            }
            else if (((Warrior)unit).isRifleMan()) {
                return "rifle man";
            }
            else if (((Warrior)unit).isAntiTankGun()) {
                return "anti tank gun";
            }
        }
        return "";
    }*/
    /*public StringBuilder unitPanel(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> unitsOfTile = map.get(i).getUnits();
            for (int i1 = 0; i1 < unitsOfTile.size(); i1++) {
                if (unitsOfTile.get(i1).getCivilization().equals(civilization)) {
                    String name = getUnitsName(unitsOfTile.get(i1));
                    stringBuilder.append("unit " + name +" mp : "+unitsOfTile.get(i1).getMp()+ " health : " + unitsOfTile.get(i1).getHealth() + " on tile number: " + i + "\n");
                }
            }
        }
        return stringBuilder;
    }*/
/*    public StringBuilder cityPanel(ArrayList<Tile> map,ArrayList<Civilization> civilizations,Civilization playingCivilization){
        StringBuilder stringBuilder = new StringBuilder("");//"Civilization name" :
        //                             Capital : tile numbers
        //                             City 2  : tile numbers
        //                                      ...
        //                             City n  : tile numbers

        for(Civilization tempCivilization : civilizations) {
            if (tempCivilization == playingCivilization) {
                stringBuilder.append(tempCivilization.getMember().getNickname()).append(" :\nCapital : ");
                City capital = tempCivilization.getCapital();
                for (Tile tile : capital.getTiles()) {
                    stringBuilder.append(tile.getTileNumber()).append(" ");
                }
                stringBuilder.append("\n");
                for (int i = 0; i < tempCivilization.getCities().size(); i++) {
                    City tempCity = tempCivilization.getCities().get(i);
                    if (tempCity != tempCivilization.getCapital()) {
                        stringBuilder.append("City ").append(i + 1).append("  : ");
                        for (Tile tile : tempCity.getTiles()) {
                            stringBuilder.append(tile.getTileNumber()).append(" ");
                        }
                        stringBuilder.append("\n");
                    }
                }
            }
        }
        return stringBuilder;
    }*/
    /*public String diplomaticInformation(Civilization civilization){
        int point = civilization.getPoint();

        return "your point is : " + point;
    }*/
    public String sendFriendlyRequestDiplomatic(Civilization civilization,ArrayList<Civilization> civilizations,String name){
        if(Objects.equals(name, civilization.getMember().getNickname()))
            return "cant send request to yourself";

        for(Civilization destCivilization : civilizations){
            if(Objects.equals(destCivilization.getMember().getNickname(), name)){
                for(Civilization tempCiv : destCivilization.getFriendlyRequests()){
                    if(tempCiv == civilization) {
                        return "you have already sent this request";
                    }
                }
                for(Civilization tempCiv : destCivilization.getFriends()){
                    if(tempCiv == civilization){
                        return "this civilization is already your allie";
                    }
                }
                destCivilization.getFriendlyRequests().add(civilization);
                return "your request has been sent successfully";
            }
        }
        return "there is no civilization with this name";
    }
   /* public StringBuilder showMessages(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder("");
        for(String string : civilization.getMessages()){
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder;
    }*/
    public StringBuilder showFriendlyRequests(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 1;
        for(Civilization tempCivilization : civilization.getFriendlyRequests()){
            stringBuilder.append(i).append(" : ").append(tempCivilization.getMember().getNickname()).append("\n");
            i++;
        }
        return stringBuilder;
    }
    public String acceptFriendlyRequest(Civilization civilization,String name){
        for(Civilization tempCivilization : civilization.getFriendlyRequests()){
            if(Objects.equals(tempCivilization.getMember().getNickname(), name)){
                civilization.acceptFriendlyRequest(tempCivilization);
                return "you accepted the request";
            }
        }
        return "there is no friendly request with this name";
    }
    public String denyFriendlyRequest(Civilization civilization,String name){
        for(Civilization tempCivilization : civilization.getFriendlyRequests()){
            if(Objects.equals(tempCivilization.getMember().getNickname(), name)){
                civilization.denyFriendlyRequest(tempCivilization);
                return "you denied the request";
            }
        }
        return "there is no friendly request with this name";
    }
    public String breakTheOath(Civilization civilization,String name){//this will cut the friendship between you and your allie
        for(Civilization tempCivilization : civilization.getFriends()){
            if(Objects.equals(tempCivilization.getMember().getNickname(), name)){
                civilization.breakTheOath(tempCivilization);
                return "you broke the the oath !";
            }
        }
        return "you don't have any allie with this name";
    }
/*    public StringBuilder victoryImprovement(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Civilization, Integer> wins = civilization.getWinsInUnitsWar();
        HashMap<Civilization, Integer> losses = civilization.getLossesInUnitsWar();
        stringBuilder.append("wins :" + "\n");
        for(Map.Entry<Civilization, Integer> entry : wins.entrySet()) {
            stringBuilder.append("Civilization : " + entry.getKey().getMember().getUsername() + " number of wins : " + entry.getValue() + "\n");
        }
        stringBuilder.append("losses :" + "\n");
        for(Map.Entry<Civilization, Integer> entry : losses.entrySet()) {
            stringBuilder.append("Civilization : " + entry.getKey().getMember().getUsername() + " number of losses : " + entry.getValue() + "\n");
        }
        return stringBuilder;
    }*/
/*    public StringBuilder demographics(ArrayList<Civilization> civilizations,ArrayList<Tile> map){   //Jamiat shenasi
        StringBuilder stringBuilder = new StringBuilder("");
        int[] sortFlag = new int[civilizations.size()];
        Civilization chosenCivilization = null;
        int index = 0;

        int Number = 1;
        for(int i = 0; i < civilizations.size(); i++){
            boolean theFlag = true;
            for(int j = 0; j < civilizations.size(); j++){
                if(sortFlag[j] == 1)
                    continue;
                if(theFlag) {
                    chosenCivilization = civilizations.get(j);
                    theFlag = false;
                }
                Civilization tempCivilization = civilizations.get(j);
                if(tempCivilization.getPoint() > chosenCivilization.getPoint()){
                    chosenCivilization = tempCivilization;
                    index = j;
                }
            }
            sortFlag[index] = 1;
            int numOfTiles = 0;
            for(City city : chosenCivilization.getCities()){
                for(Tile tile : city.getTiles()){
                    numOfTiles++;
                }
            }
            int numOfUnits = 0;
            for(Tile tile : map){
                for(Unit unit : tile.getUnits()){
                    if(unit.getCivilization() == chosenCivilization)
                        numOfUnits++;
                }
            }
            stringBuilder.append(chosenCivilization.getMember().getNickname()).append(" : \n");
            stringBuilder.append("Rank : ").append(Number).append("\n");
            stringBuilder.append("Points : ").append(chosenCivilization.getPoint()).append("\n");
            stringBuilder.append("Number of cities : ").append(chosenCivilization.getCities().size()).append("\n");
            stringBuilder.append("Number of tiles : ").append(numOfTiles).append("\n");
            stringBuilder.append("Gold : ").append(chosenCivilization.getGold()).append("\n");
            stringBuilder.append("Number of units : ").append(numOfUnits).append("\n");
            stringBuilder.append("--------------------\n");

            Number++;
        }

        return stringBuilder;
    }*/
/*    public StringBuilder generalUnitReview(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> unitsOfTile = map.get(i).getUnits();
            for (int i1 = 0; i1 < unitsOfTile.size(); i1++) {
                if (unitsOfTile.get(i1).getCivilization().equals(civilization)) {
                    String name = getUnitsName(unitsOfTile.get(i1));
                    String move ;
                    if (unitsOfTile.get(i1).getPath().size() == 0) {
                        move = "unit doesn't any path !";
                    }
                    else {
                        move = "unit has path";
                    }
                    stringBuilder.append("unit " + name + " movement : "+ move + " health : " + unitsOfTile.get(i1).getHealth() + " tile : " + i);
                    if (unitsOfTile.get(i1).isCivilian()) {
                        stringBuilder.append(" damage : N/A" + "\n");
                    }
                    else {
                        stringBuilder.append(" damage: " + ((Warrior)unitsOfTile.get(i1)).getDamage() +
                                " range: " + ((Warrior)unitsOfTile.get(i1)).getRange() + " range damage: " +
                                ((Warrior)unitsOfTile.get(i1)).getRangedCombatDamage() + "\n");
                    }
                }
            }
        }
        return stringBuilder;
    }*/
/*    public StringBuilder roadsInfo (ArrayList<Tile> map) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("tiles with road : ");
        StringBuilder stringBuilderRoad = new StringBuilder("");
        StringBuilder stringBuilderRail = new StringBuilder("");
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).isDoesHaveRoad()) {
                stringBuilderRoad.append(i + ", ");
            }
            if (map.get(i).isDoesHaveRailWay()) {
                stringBuilderRail.append(i + ", ");
            }
        }
        stringBuilderRoad.append("\n");
        stringBuilderRail.append("\n");
        stringBuilderRoad.append(stringBuilderRail);
        stringBuilder.append(stringBuilderRoad);
        return stringBuilder;
    }*/
/*
    public StringBuilder economicalReview(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Number of cities : ").append(civilization.getCities().size()).append("\n-----------------------").append("\n");
        for(int i = 0; i < civilization.getCities().size(); i++){
            City city = civilization.getCities().get(i);
            stringBuilder.append("City ").append(i).append(" :\n");
            stringBuilder.append("Population : ").append(city.getCitizens().size()).append("\n");
            stringBuilder.append("Defence Strength : ").append(city.getDefenceStrength()).append("\n");
            stringBuilder.append("Food per Turn : ").append(city.getFood()).append("\n");
            stringBuilder.append("Science per Turn : ").append(city.getSciencePerTurn()).append("\n");
            stringBuilder.append("Gold per Turn : ").append(city.getGold()).append("\n");
            stringBuilder.append("Production per Turn : ").append(city.getProduction()).append("\n");
            HashMap<Unit,Integer> unit = city.getCenterTile().getTurnForUnitMaking();
            for(Map.Entry<Unit,Integer> entry : unit.entrySet()) {
                String name = getUnitsName(entry.getKey());
                stringBuilder.append(name + ": turns => " + entry.getValue() + "\n");
            }
            //TODO...  buildings duration to create
            stringBuilder.append("-----------------------\n");
        }

        return stringBuilder;
    }*/
   /* public StringBuilder diplomaticReview(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("your friends :\n");
        for(Civilization tempCiv : civilization.getFriends()){
            stringBuilder.append(tempCiv.getName()).append("\n");
        }
        return stringBuilder;
    }*/
    //TODO for next phase ...
    /*
    public StringBuilder tradeHistory(Civilization civilization,ArrayList<Tile> map){
        StringBuilder stringBuilder;

        return stringBuilder;
    }
    public String tradeResource(Civilization civilization1, Civilization civilization2, Tile originTile, Resource originResource,Resource neededResource,ArrayList<Tile> map){
        String str;

        return str;
    }
    */
    // finds all  the neighbours of a node (tile)
    public void findAllNeighbours(Node[] graph) {
        int column = 0;
        int counter = 0;
        for (int i = 0; i < graph.length; i++) {
            if (column % 2 == 0 && counter == 6) {
                counter = 0;
                column++;
            }
            if (column % 2 != 0 && counter == 5) {
                counter = 0;
                column++;
            }
            if (i - 1 >= 0 && counter != 0) {
                graph[i].neighbours.add(graph[i - 1]);
            }
            if ((counter != 5 && column % 2 == 0) || (counter != 4 && column % 2 != 0)) {
                graph[i].neighbours.add(graph[i + 1]);
            }
            if (i - 6 >= 0 && (counter != 0 || column % 2 != 0)) {
                graph[i].neighbours.add(graph[i - 6]);
            }
            if (i - 5 >= 0 && counter != 5) {
                graph[i].neighbours.add(graph[i - 5]);
            }
            if (i + 6 <= 71 && counter != 5) {
                graph[i].neighbours.add(graph[i + 6]);
            }
            if (i + 5 <= 71 && (counter != 0 || column % 2 != 0)) {
                graph[i].neighbours.add(graph[i + 5]);
            }
            counter++;
        }
    }

    // set distance of two node (tile) based on destination mp.
    public int distanceOfTwoNode(Node node) {
        Tile tile = node.tile;
        if (tile.isMountain() || tile.isOcean() || (tile.getAttribute() != null && tile.getAttribute().isIce())) {
            return 1000000;
        }
        return tile.getMpCost();
    }
    // chase an algorithm based on graphs to find the shortest way.
    public void findThePath (HashMap<Node, Node> previousNode, HashMap<Node, Integer> distanceFromNode, ArrayList<Node> unreached, Node destinationNode,ArrayList<Tile> map) {
        while (unreached.size() > 0) {
            Node minimumBranch;
            int index = 0;
            int min = 1000000;
            for (int i = 0; i < unreached.size(); i++) {
                if (distanceFromNode.get(unreached.get(i)) < min) {
                    index = i;
                    min = distanceFromNode.get(unreached.get(i));
                }
            }
            minimumBranch = unreached.get(index);

            if (minimumBranch.equals(destinationNode)) break;

            unreached.remove(index);


            for (int i = 0; i < minimumBranch.neighbours.size(); ++i) {
                Node neighbourOfBranch = minimumBranch.neighbours.get(i);
                int mpCost = distanceFromNode.get(minimumBranch) + distanceOfTwoNode(neighbourOfBranch);
                if (mpCost < distanceFromNode.get(neighbourOfBranch)) {
                    distanceFromNode.replace(neighbourOfBranch, mpCost);
                    previousNode.replace(neighbourOfBranch, minimumBranch);
                }
            }
        }
    }
    // find the shortest way from origin to destination based on mp.
    public void findTheShortestPath (Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map, Unit unit) {
        for (int i1 = 0; i1 < unit.getPath().size(); i1++) {
            unit.getPath().remove(i1);
        }
        Node[] graph = new Node[72];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node();
            graph[i].tile = map.get(i);
        }
        findAllNeighbours (graph);
        HashMap<Node, Integer> distanceFromNode = new HashMap<>();
        HashMap<Node, Node> previousNode = new HashMap<>();
        ArrayList<Node> unreached = new ArrayList<>();

        int originIndex = getTileIndex(origin, map);
        int destinationIndex = getTileIndex(destination, map);

        Node originNode = graph[originIndex];
        Node destinationNode = graph[destinationIndex];

        distanceFromNode.put(originNode, 0);
        previousNode.put(originNode, null);

        for (int i = 0; i < graph.length; i++) {
            if (!graph[i].equals(originNode)) {
                distanceFromNode.put(graph[i] ,1000000);
                previousNode.put(graph[i], null);
            }
            unreached.add(graph[i]);
        }
        findThePath(previousNode, distanceFromNode, unreached, destinationNode, map);

        if (previousNode.get(destinationNode) == null) {
            for (int i1 = 0; i1 < unit.getPath().size(); i1++) {
                unit.getPath().remove(i1);
            }
            return;
        }

        ArrayList<Node> path = new ArrayList<>();
        Node currentNode = destinationNode;
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = previousNode.get(currentNode);
        }

        Collections.reverse(path);
        unit.setPath(path);
    }
    // create parameters like unit or origin or destination for moveUnit function
    public void preMoveUnit (Unit unit, int numberOfDestination, Civilization civilization, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if (numberOfDestination < 0 || numberOfDestination > 71) {
            gameGroupData.result = "number of destination tile is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilization)) {
            gameGroupData.result = "this unit is not for your civilization";
            try {
                sendMessageToAllClients(gameGroup, gameGroupData);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        Unit serverUnit = getUnitServer(gameGroupData.tiles, unit);
        Tile origin = serverUnit.getOrigin();
        Tile destination = gameGroupData.tiles.get(numberOfDestination);

        if (serverUnit != null && serverUnit.getPath().size() != 0) {
            gameGroupData.result = "this unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (serverUnit != null && serverUnit.isCivilian() && ((Civilian)serverUnit).getWorkingTile() != null) {
            gameGroupData.result = "this civilian is working on something !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        gameGroupData.result = moveUnit(getServerCivilization(civilization, gameGroupData.civilizations), origin, destination, gameGroupData.tiles, serverUnit);
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    private void sendMessageToAllClients(GameGroup gameGroup, GameGroupData gameGroupData) throws IOException {
        ArrayList<Socket> sockets = gameGroup.sockets;
        for (Socket socket : sockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            String respond = gson.toJson(gameGroupData);
            dataOutputStream.writeUTF(respond);
            dataOutputStream.flush();
        }
    }

    private Civilization getServerCivilization(Civilization civilization, ArrayList<Civilization> civilizations) {
        for (Civilization civilization2 : civilizations) {
            if (civilization2.equals(civilization)) return civilization2;
        }
        return null;
    }

    //return a unit from specific tile
    public Unit getUnitInTile (ArrayList<Unit> units, String unitName) {
        for (int i = 0; i < units.size(); i++) {
            if (unitName.equals("archer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isArcher()) {
                    return units.get(i);
                }
            } else if (unitName.equals("chariot archer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isChariotArcher()) {
                    return units.get(i);
                }
            } else if (unitName.equals("scout") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isScout()) {
                    return units.get(i);
                }
            } else if (unitName.equals("settler") && units.get(i).isCivilian()) {
                if (((Civilian) units.get(i)).isSettler()) {
                    return units.get(i);
                }
            } else if (unitName.equals("worker") && units.get(i).isCivilian()) {
                if (((Civilian) units.get(i)).isWorker()) {
                    return units.get(i);
                }
            } else if (unitName.equals("spearman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isSpearman()) {
                    return units.get(i);
                }
            } else if (unitName.equals("warrior") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isWarrior()) {
                    return units.get(i);
                }
            } else if (unitName.equals("catapult") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCatapult()) {
                    return units.get(i);
                }
            } else if (unitName.equals("horseman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isHorseMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("swordsman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isSwordsMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("crossbowman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCrossbowMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("knight") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isKnight()) {
                    return units.get(i);
                }
            } else if (unitName.equals("longswordsman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isLongswordMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("pikeman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isPikeMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("trebuchet") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isTrebuchet()) {
                    return units.get(i);
                }
            } else if (unitName.equals("canon") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCanon()) {
                    return units.get(i);
                }
            } else if (unitName.equals("cavalry") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isCavalry()) {
                    return units.get(i);
                }
            } else if (unitName.equals("lancer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isLancer()) {
                    return units.get(i);
                }
            } else if (unitName.equals("musketman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isMusketMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("rifleman") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isRifleMan()) {
                    return units.get(i);
                }
            } else if (unitName.equals("anti-tank gun") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isAntiTankGun()) {
                    return units.get(i);
                }
            } else if (unitName.equals("artillery") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isArtillery()) {
                    return units.get(i);
                }
            } else if (unitName.equals("infantry") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isInfantry()) {
                    return units.get(i);
                }
            } else if (unitName.equals("panzer") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isPanzer()) {
                    return units.get(i);
                }
            } else if (unitName.equals("tank") && !units.get(i).isCivilian()) {
                if (((Warrior) units.get(i)).isTank()) {
                    return units.get(i);
                }
            }
        }
        return null;
    }
    // check the road for units
    public boolean checkPath (Unit unit) {
        ArrayList<Node> nodes = unit.getPath();
        for (int i = 1; i < nodes.size(); i++) {
            ArrayList<Unit> units = nodes.get(i).tile.getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if ((!units.get(i1).isCivilian() &&
                        ((!unit.isCivilian()) || !units.get(i1).getCivilization().equals(unit.getCivilization()))) ||
                        (units.get(i1).isCivilian() && unit.isCivilian())){
                    return true;
                }
            }
        }
        return false;
    }
    // return the index of specific tile
    public int getTileIndex (Tile tile, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).equals(tile)) {
                return i;
            }
        }
        return 0;
    }
    // check the way for river
    public boolean isRiverOnWay (Tile origin, Tile destination, ArrayList<Tile> map) {
        int originIndex = getTileIndex(origin, map);
        int destinationIndex = getTileIndex(destination, map);
        if ((originIndex <= 21 && originIndex >= 17) && (destinationIndex >= 22 && destinationIndex <= 27)) {
            return true;
        }
        if ((destinationIndex <= 21 && destinationIndex >= 17) && (originIndex >= 22 && originIndex <= 27)) {
            return true;
        }
        return false;
    }

    // check the technology's name in civilization array of technology if it contains return true
    public boolean isTechnologyAvailable (Civilization civilization, String techName) {
        ArrayList<Technology> technologies = civilization.getTechnologies();
        for (int i = 0; i < technologies.size(); i++) {
            if (technologies.get(i).getName().toLowerCase().equals(techName)) return true;
        }
        return false;
    }
    // check origin and destination tiles , if both have same type of way(rail/road) return true
    public boolean isThereRoadOrRail (Tile origin, Tile destination) {
        if (origin.isDoesHaveRoad() && destination.isDoesHaveRoad() &&
                !origin.isRoadDamaged() && !destination.isRoadDamaged())
            return true;
        if (origin.isDoesHaveRailWay() && destination.isDoesHaveRailWay() &&
                !origin.isRailDamaged() && !destination.isRailDamaged()) return true;
        return false;
    }
    // reset the mp of your civilization units
    public void addMpEveryTurn(Civilization civilization, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> units = map.get(i).getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if (units.get(i1).getCivilization().equals(civilization)) {
                    units.get(i1).setMp(units.get(i1).getConstantMP());
                }
            }
        }
    }

    public int mpOfAttribute (Attribute attribute) {
        if (attribute == null) return 0;
        return attribute.getMpCost();
    }

    public String moveUnit (Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map, Unit unit){
        String str;
        if (unit == null) {
            str = "there is no unit with this name !";
            return str;
        }
        if (destination == null || origin == null) {
            str = "there is no origin/destination";
            return str;
        }
        if (unit.getIsOnSleep() || unit.isOnBoost() || unit.isOnBoostTillRecover() || unit.isOnWarFooting()) {
            str = "this unit is not active !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (destination.isMountain() || destination.isOcean() ||  (destination.getAttribute() != null && destination.getAttribute().isIce())) {
            str = "destination is unreachable !";
            return str;
        }
        if (unit.getPath().size() == 0) {
            findTheShortestPath(civilization, origin, destination, map, unit);
        }
        if (unit.getPath().size() == 0) {
            str = "there is no way to the destination !";
            return str;
        }
        if (checkPath(unit) || isSameUnitOnMakingProgress(destination, unit)) {
            unit.setOrigin(unit.getPath().get(0).tile);
            unit.setDestination(null);
            unit.getPath().clear();
            str = "there is another civilization on the way !";
            return str;
        }
        unit.setHasOrdered(true);
        unit.setOrigin(origin);
        unit.setDestination(destination);
        int i = 0;
        while (true) {
            if (unit.getPath().size() == 1) {
                unit.getPath().clear();
                unit.setDestination(null);
                str = "unit reached the destination !";
                break;
            }

            Tile originTile = unit.getPath().get(i).tile;
            Tile destinationTile = unit.getPath().get(i + 1).tile;


            if (unit.getMp() >= 1) {
                originTile.removeUnit(unit);
                destinationTile.addUnit(unit);
                unit.setOrigin(destinationTile);

                int newMP;

                if (!isRiverOnWay(originTile, destinationTile, map)) {
                    if (unit.getMp() >= destinationTile.getMpCost() + mpOfAttribute(destinationTile.getAttribute())) {
                        if (isThereRoadOrRail(originTile, destinationTile)) {
                            newMP = unit.getMp() - (destinationTile.getMpCost() + mpOfAttribute(destinationTile.getAttribute())) / 2;
                        }
                        else {
                            newMP = unit.getMp() - (destinationTile.getMpCost() + mpOfAttribute(destinationTile.getAttribute()));
                        }
                    }
                    else {
                        newMP = 0;
                    }
                }

                else {
                    if (isThereRoadOrRail(originTile, destinationTile)) {
                        if (isTechnologyAvailable(civilization, "construction")) {
                            newMP = unit.getMp() - (destinationTile.getMpCost() + mpOfAttribute(destinationTile.getAttribute())) / 2;
                        }
                        else {
                            newMP = unit.getMp() - (destinationTile.getMpCost() + mpOfAttribute(destinationTile.getAttribute())) / 2 + 1;
                        }
                    }
                    else {
                        newMP = 0;
                    }
                }
                if (newMP < 0) newMP = 0;
                unit.getPath().remove(i);
                unit.setMp(newMP);
            }

            else {
                str = "unit mp isn't enough, wait until next turn !";
                break;
            }
        }
        return str;
    }
    // more than one turn moving function for units of playing civilization
    public void moveUnitWithMovesLeft (Civilization playingCivilization, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> units = map.get(i).getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if (units.get(i1).getCivilization().equals(playingCivilization) && units.get(i1).getPath().size() != 0 ) {
                    moveUnit(playingCivilization, units.get(i1).getOrigin(), units.get(i1).getDestination(), map, units.get(i1));
                }
            }
        }
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
            Resource resource = tiles.get(i).getResource();

            if (warrior.isArcher()) return true;
            else if (warrior.isChariotArcher()) {
                if (resource.isHorse()) return true;
            }
            else if (warrior.isScout()) return true;
            else if (warrior.isSpearman()) return true;
            else if (warrior.isWarrior()) return true;

            else if (warrior.isCatapult()) {
                if (resource.isMetal()) return true;
            }
            else if (warrior.isHorseMan()) {
                if (resource.isHorse()) return true;
            }
            else if (warrior.isSwordsMan()) {
                if (resource.isMetal()) return true;
            }
            else if (warrior.isCrossbowMan()) return true;
            else if (warrior.isKnight()) {
                if (resource.isHorse()) return true;
            }
            else if (warrior.isLongswordMan()) {
                if (resource.isMetal()) return true;
            }
            else if (warrior.isPikeMan()) return true;
            else if (warrior.isTrebuchet()) {
                if (resource.isMetal()) return true;
            }
            else if (warrior.isCanon()) return true;
            else if (warrior.isCavalry()) {
                if (resource.isHorse()) return true;
            }
            else if (warrior.isLancer()) {
                if (resource.isHorse()) return true;
            }
            else if (warrior.isMusketMan()) return true;
            else if (warrior.isRifleMan()) return true;
            else if (warrior.isAntiTankGun()) return true;
            else if (warrior.isArtillery()) return true;
            else if (warrior.isInfantry()) return true;
            else if (warrior.isPanzer()) return true;
            else if (warrior.isTank()) return true;
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
    // return a city that contains specific tile
    public City findTile (int index, ArrayList<Tile> map, Civilization civilization) {
        Tile tile = map.get(index);
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int i1 = 0; i1 < tiles.size(); i1++) {
                if (tiles.get(i1).equals(tile)) {
                    return cities.get(i);
                }
            }
        }
        return null;
    }
    // it makes parameters for unit maker such as unit or city
    public void preUnitMaker (String unitName, int index, Civilization civilization, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if (index < 0 || index > 71) {
            gameGroupData.result =  "number of origin tile is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        City city = findTile(index, gameGroupData.tiles, civilizationServer);

        if (city == null) {
            gameGroupData.result =  "there is no city !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Unit unit = makeUnit(civilizationServer, city.getCenterTile(), gameGroupData.tiles, unitName);
        if (unit == null) {
            gameGroupData.result = "there is no unit with this name !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        int turn = unit.getDuration();
        gameGroupData.result = createUnit(civilizationServer, city, unit, gameGroupData.tiles, turn);
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    public Unit makeUnit (Civilization civilization, Tile tile, ArrayList<Tile> map, String unitName) {
        if (unitName.equals("archer")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 70, false
                    , 0, 4, 2, 6, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("chariot archer")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 4, 4, 1, 60, false
                    , 0, 3, 2, 6, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("scout")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 25, false
                    , 0, 4, -1, -1, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("settler")) {
            Civilian civilian = new Civilian(civilization, tile, 10, 2, 2, 1, 89, true, false, true);
            return civilian;
        }
        else if (unitName.equals("worker")) {
            Civilian civilian = new Civilian(civilization, tile, 10, 2, 2, 1, 70, true, true, false);
            return civilian;
        }
        else if (unitName.equals("spearman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 50, false
                    , 0, 7, -1, -1, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("warrior")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 40, false
                    , 0, 6, -1, -1, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("catapult")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 100, false
                    , 0, 4, 2, 14, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("horseman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 4, 4, 1, 80, false
                    , 0, 12, -1, -1, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("swordsman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 2, 80, false
                    , 0, 11, -1, -1, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("crossbowman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 2, 120, false
                    , 0, 6, 2, 12, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("knight")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 3, 3, 1, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("longswordsman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 3, 3, 3, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("pikeman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 1, 100, false
                    , 0, 10, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("trebuchet")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 3, 170, false
                    , 0, 6, 2, 20, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("canon")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 2, 250, false
                    , 0, 10, 2, 26, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("cavalry")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 3, 3, 2, 260, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("lancer")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 4, 4, 2, 220, false
                    , 0, 22, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("musketman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 3, 120, false
                    , 0, 16, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("rifleman")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 4, 200, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("anti-tank gun")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 6, 300, false
                    , 0, 32, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false);
            return warrior;
        }
        else if (unitName.equals("artillery")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 5, 420, false
                    , 0, 16, 32, 3, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false);
            return warrior;
        }
        else if (unitName.equals("infantry")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 2, 2, 4, 300, false
                    , 0, 36, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false);
            return warrior;
        }
        else if (unitName.equals("panzer")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 5, 5, 3, 450, false
                    , 0, 60, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false);
            return warrior;
        }
        else if (unitName.equals("tank")) {
            Warrior warrior = new Warrior(civilization, tile, 10, 4, 4, 8, 450, false
                    , 0, 50, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true);
            return warrior;
        }
        return null;
    }
    // every turn check city center for making new turn
    public void checkForUnitMaking (Civilization civilization) {
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
            HashMap<Unit, Integer> units = cities.get(i).getCenterTile().getTurnForUnitMaking();
            for (Map.Entry<Unit, Integer> entry : units.entrySet()) {
                int turn = entry.getValue() - 1;
                if (turn == 0) {
                    cities.get(i).getCenterTile().addUnit(entry.getKey());
                    cities.get(i).getCenterTile().removeUnitFromMakingProgress(entry.getKey());
                }
                else {
                    cities.get(i).getCenterTile().setTurnForUnit(entry.getKey(), turn);
                }
            }
        }
    }

    public boolean isSameUnitOnMakingProgress (Tile tile, Unit unit) {
        HashMap<Unit, Integer> turns = tile.getTurnForUnitMaking();
        for(Map.Entry<Unit,Integer> entry : turns.entrySet()) {
            if (unit.isCivilian() == entry.getKey().isCivilian()) return true;
        }
        return false;
    }

    public String createUnit(Civilization civilization, City city, Unit unit,ArrayList<Tile> map, int turn){
        String str;

        if (unit == null) {
            str = "this unit name doesn't exist!";
            return str;
        }

        if (city == null) {
            str = "this tile does not belong to your cities!";
            return str;
        }

        if (isSameUnitOnMakingProgress(city.getCenterTile(), unit)) {
            str = "this tile is making same type of unit !";
            return str;
        }

        if (!unit.isCivilian() && !isTechnologyAvailableForUnit (unit, civilization)) {
            str = "you don't have necessary technology!";
            return str;
        }

        if (!unit.isCivilian() && !isResourceAvailableForUnit (unit, city)) {
            str = "you don't have necessary resource!";
            return str;
        }

        Tile centerTile = city.getCenterTile();
        if (!unit.isCivilian() && isUnitWarrior (centerTile)) {
            str = "there is a military unit!";
            return str;
        }

        if (unit.isCivilian() && isUnitCivilian (centerTile)) {
            str = "there is a civilian unit!";
            return str;
        }

        centerTile.addUnitToMakingProgress(unit, turn);
        str = "unit will be created soon !";
        return str;
    }
    public String purchaseUnit(Civilization civilization, ArrayList<Tile> map, Matcher matcher){
        matcher.find();
        String unitName = matcher.group("unitName");
        int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
        City city = this.findTile(tileNumber, map, civilization);
        Unit unit;
        if (unitName.equals("settler")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 1, 89, true, false, true);
            unit = civilian;
        }
        else if (unitName.equals("worker")) {
            Civilian civilian = new Civilian(civilization, city.getCenterTile(), 10, 2, 2, 1, 70, true, true, false);
            unit = civilian;
        }
        else if (unitName.equals("chariot archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 1, 60, false
                    , 0, 3, 2, 6, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("archer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 70, false
                    , 0, 4, 2, 6, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("scout")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 25, false
                    , 0, 4, -1, -1, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit =  warrior;
        }
        else if (unitName.equals("catapult")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 100, false
                    , 0, 4, 2, 14, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("warrior")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 40, false
                    , 0, 6, -1, -1, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("spearman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 50, false
                    , 0, 7, -1, -1, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("horseman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 1, 80, false
                    , 0, 12, -1, -1, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("swordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 2, 80, false
                    , 0, 11, -1, -1, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("crossbowman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 2, 120, false
                    , 0, 6, 2, 12, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("knight")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 1, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("longswordsman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 3, 150, false
                    , 0, 18, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("pikeman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 1, 100, false
                    , 0, 10, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("trebuchet")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 3, 170, false
                    , 0, 6, 2, 20, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("canon")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 2, 250, false
                    , 0, 10, 2, 26, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("cavalry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 3, 3, 2, 260, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("lancer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 2, 220, false
                    , 0, 22, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true, false, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("rifleman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 4, 200, false
                    , 0, 25, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, true,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("anti-tank gun")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 6, 300, false
                    , 0, 32, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    true, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("infantry")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 4, 300, false
                    , 0, 36, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, true, false, false);
            unit = warrior;
        }
        else if (unitName.equals("musketman")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 3, 120, false
                    , 0, 16, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, true, false,
                    false, false, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("artillery")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 2, 2, 5, 420, false
                    , 0, 16, 32, 3, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, true, false, false, false);
            unit = warrior;
        }
        else if (unitName.equals("panzer")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 5, 5, 3, 450, false
                    , 0, 60, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, true, false);
            unit = warrior;
        }
        else if (unitName.equals("tank")) {
            Warrior warrior = new Warrior(civilization, city.getCenterTile(), 10, 4, 4, 8, 450, false
                    , 0, 50, -1, -1, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false,
                    false, false, false, false, true);
            unit = warrior;
        }
        else
            return "no unit with this name exists!";
        return this.createUnit(civilization, city, unit, map, 1);
    }

    public void createCity(Civilization civilization, int tileNumber,ArrayList<Tile> map, ArrayList<Civilization> civilizations, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if(tileNumber < 0 || tileNumber >= 72) {
            gameGroupData.result = "invalid tile number";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        for(Tile tile : gameGroupData.tiles){
            if(tile.getTileNumber() == tileNumber){
                for(Unit unit : tile.getUnits()){
                    if(unit.getCivilization().equals(civilizationServer)){
                        if(unit.isCivilian()){
                            Civilian civilian = (Civilian) unit;
                            if(civilian.isSettler()){
                                if(checkNeighboursForCreateCity(tile, gameGroupData.tiles, gameGroupData.civilizations)){
                                    while(tile.getUnits().size() > 0) {
                                        tile.getUnits().remove(0);
                                    }
                                    City city1 = new City(tile, gameGroupData.tiles);
                                    civilizationServer.getCities().add(city1);
                                    gameGroupData.result = "city has been created successfully";
                                    sendMessageToAllClients(gameGroup, gameGroupData);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        gameGroupData.result = "you can't create city here";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public boolean checkNeighboursForCreateCity(Tile tile, ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(Tile tempTile : map){
            if(tempTile == tile){
                if(tile.getUnits().size() != 1)
                    return false;
            }
            else if(areTilesNeighbour(tile,tempTile)){
                if(tempTile.getUnits().size() > 0)
                    return false;
                if(tempTile.getImprovements().size() > 0)
                    return false;
                if(tempTile.getRailRoads().size() > 0)
                    return false;
                if(tempTile.getRoads().size() > 0)
                    return false;
                if(doesTileBelongToAnyCivilization(tempTile,map,civilizations))
                    return false;
            }
        }
        return true;
    }
    public boolean areTilesNeighbour(Tile tile1, Tile tile2){
        double distance = (double)Math.sqrt(Math.pow(tile1.getX() - tile2.getX(), 2) + Math.pow(tile1.getY() - tile2.getY(), 2));
        if(distance < 1.1 * tile1.getRadius() * Math.sqrt(3))
            return true;

        return false;
    }
    // return a warrior unit from specific tile
    public Unit getWarriorUnit (int index, ArrayList<Tile> map) {
        ArrayList<Unit> units = map.get(index).getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (!units.get(i).isCivilian()) return units.get(i);
        }
        return null;
    }
    // get all indexes that are between attackers and defenders
    public void getAllIndexes(int originIndex, int destinationIndex, ArrayList<Integer> indexOfTiles) {
        if (originIndex < destinationIndex) {
            int delta = destinationIndex - originIndex;
            int growth = 0;
            if (getColumn(originIndex) == getColumn(destinationIndex)) {
                growth = 1;
                if (originIndex == 5 || originIndex == 16 || originIndex == 27 || originIndex == 38 ||
                        originIndex == 49 || originIndex == 60 || originIndex == 71) {
                    return;
                }
            } else if (delta % 5 == 0) {
                growth = 5;
            } else if (delta % 6 == 0) {
                growth = 6;
            }
            else if (delta % 11 == 0) {
                growth = 11;
            }
            for (int i = originIndex; i <= destinationIndex; i += growth) {
                indexOfTiles.add(i);
            }
        } else {
            int delta = originIndex - destinationIndex;
            int growth = 0;
            if (getColumn(originIndex) == getColumn(destinationIndex)) {
                growth = 1;
                if (originIndex == 0 || originIndex == 11 || originIndex == 22 || originIndex == 33 ||
                        originIndex == 44 || originIndex == 55 || originIndex == 66) {
                    return;
                }
            } else if (delta % 5 == 0) {
                growth = 5;
            } else if (delta % 6 == 0) {
                growth = 6;
            }
            else if (delta % 11 == 0) {
                growth = 11;
            }
            for (int i = originIndex; i >= destinationIndex; i -= growth) {
                indexOfTiles.add(i);
            }
        }
    }
    // if blockers block attackers vision return true
    public boolean checkTheBlocks (ArrayList<Tile> map, ArrayList<Integer> indexOfTiles) {
        for (int i = 1; i < indexOfTiles.size() - 1; i++) {
            if (map.get(indexOfTiles.get(i)).isOcean() || map.get(indexOfTiles.get(i)).isMountain() ||
                    map.get(indexOfTiles.get(i)).isHill()) return true;
        }
        return false;
    }
    // is attacker range enough for distance ?
    public boolean isRangeEnough(Warrior warrior, ArrayList<Integer> indexOfTiles) {
        int distance = indexOfTiles.size() - 1;
        if (warrior.getRange() == -1 && distance > 1) return false;
        if (warrior.getRange() != -1 && distance > warrior.getRange()) return false;
        return true;
    }
    // return civilian unit from specific tile
    public Unit getCivilianUnit (int index, ArrayList<Tile> map) {
        ArrayList<Unit> units = map.get(index).getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isCivilian()) return units.get(i);
        }
        return null;
    }
    // remove a civilization from friends list
    public void addToEnemy (Civilization civilization, Civilization enemy) {
        ArrayList<Civilization> friends = civilization.getFriends();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(enemy)) {
                civilization.removeFriend (enemy);
                enemy.removeFriend (civilization);
                break;
            }
        }
    }
    // if civilization2 is friend return true
    public boolean isFriend(Civilization civilization1, Civilization civilization2) {
        ArrayList<Civilization> friends = civilization1.getFriends();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(civilization2)) return true;
        }
        return false;
    }
    public void sendMessageToDefender (Unit defender, Unit attacker) {
        defender.getCivilization().addMessage("civilization :" + attacker.getCivilization() +
                "attacked you at turn : " + turn);
    }

    // prepare some parameters and return some string
    public void preAttackTile (Unit attacker, int destinationIndex , Civilization civilization, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if (destinationIndex < 0 || destinationIndex > 71) {
            gameGroupData.result = "number of destination tile is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        Unit attackerServer = getUnitServer(gameGroupData.tiles, attacker);
        int originIndex = getTileIndex(attackerServer.getOrigin(), gameGroupData.tiles);
        Unit defender = getWarriorUnit(destinationIndex, gameGroupData.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (attackerServer == null) {
            gameGroupData.result = "your unit is not military !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!attackerServer.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this is not your unit !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (attackerServer.getPath().size() != 0) {
            gameGroupData.result = "this unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (defender.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "you can't attack your own unit !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (attackerServer.getIsOnSleep() || attackerServer.isOnBoost() || attackerServer.isOnBoostTillRecover() || attackerServer.isOnWarFooting()) {
            gameGroupData.result = "this unit is not active !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Warrior) attackerServer).getRange() != -1) {
            gameGroupData.result = "this unit is not set up for range attack !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        ArrayList<Integer> indexOfTiles = new ArrayList<>();
        getAllIndexes(originIndex, destinationIndex, indexOfTiles);
        if (indexOfTiles.size() == 0) {
            gameGroupData.result = "this distance is too long for attack !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!isRangeEnough((Warrior) attackerServer, indexOfTiles)) {
            gameGroupData.result = "unit 's range is not enough !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (checkTheBlocks(gameGroupData.tiles, indexOfTiles)) {
            gameGroupData.result = "your unit vision is blocked !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (defender != null && isFriend(civilizationServer, defender.getCivilization())) {
            addToEnemy(civilizationServer, defender.getCivilization());
        }
        attackerServer.setHasOrdered(true);
        if (defender == null) {
            defender = getCivilianUnit(destinationIndex, gameGroupData.tiles);
            if (defender == null) {
                gameGroupData.result = "there is no unit on destination !";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }

            sendMessageToDefender(defender, attackerServer);

            defender.setCivilization(civilizationServer);
            if (((Warrior) attackerServer).getRange() == -1) {
                attackerServer.setOrigin(gameGroupData.tiles.get(destinationIndex));
                gameGroupData.tiles.get(destinationIndex).addUnit(attackerServer);
                gameGroupData.tiles.get(originIndex).removeUnit(attackerServer);
            }
            gameGroupData.result = "you captured civilians of enemy !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Warrior) attackerServer).getRange() == -1) {
            gameGroupData.result = attackTileFromGround(civilizationServer, attackerServer, defender, originIndex, destinationIndex, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
        } else {
            gameGroupData.result = attackTileFromAir(civilizationServer, attackerServer, defender, originIndex, destinationIndex, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
        }
    }
    // if a city contain that tile , return the city
    public City getCityFromTile (Tile tile, ArrayList<Tile> map, ArrayList<Civilization> civilizations) {
        for (Civilization civilization : civilizations) {
            for (City city : civilization.getCities()) {
                for (Tile tile1 : city.getTiles()) {
                    if (tile1.equals(tile)) return city;
                }
            }
        }
        return null;
    }
    // if city is for your civilization return true
    public boolean isCityForCivilization (City city, Civilization civilization) {
        for (City city1 : civilization.getCities()) {
            if (city.equals(city1)) return true;
        }
        return false;
    }
    // return the civilization of city
    public Civilization getCivilizationFromCity(City city, ArrayList<Civilization> civilizations) {
        for (Civilization civilization : civilizations) {
            for (City city1 : civilization.getCities()) {
                if (city.equals(city1)) return civilization;
            }
        }
        return null;
    }

    public int getColumn (int index) {
        if (0 <= index && index <= 5) return 0;
        else if (6 <= index && index <= 10) return 1;
        else if (11 <= index && index <= 16) return 2;
        else if (17 <= index && index <= 21) return 3;
        else if (22 <= index && index <= 27) return 4;
        else if (28 <= index && index <= 32) return 5;
        else if (33 <= index && index <= 38) return 6;
        else if (39 <= index && index <= 43) return 7;
        else if (44 <= index && index <= 49) return 8;
        else if (50 <= index && index <= 54) return 9;
        else if (55 <= index && index <= 60) return 10;
        else if (61 <= index && index <= 65) return 11;
        else if (66 <= index && index <= 71) return 12;
        return 0;
    }

    public boolean checkDistance(Unit unit, int origin, int destination) {
        int range = ((Warrior)unit).getRange();
        int columnO = getColumn(origin);
        int columnD = getColumn(destination);
        int delta = 0;
        if (columnD > columnO) {
            delta = columnD - columnO;
        }
        else{
            delta = columnO - columnD;
        }
        if (range == -1 && delta - 1 <= 1) return  true;
        else if (range > 0 && delta - 1 <= range) return true;
        return false;
    }

    public void preAttackCity (Unit attacker, int destinationIndex,  Civilization civilization, ArrayList<Tile> map, ArrayList<Civilization> civilizations, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        if (destinationIndex < 0 || destinationIndex > 71) {
            gameGroupData.result = "number of destination tile is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        Unit attackerServer = getUnitServer(gameGroupData.tiles, attacker);
        City defenderCity = getCityFromTile(gameGroupData.tiles.get(destinationIndex), gameGroupData.tiles, gameGroupData.civilizations);
        int originIndex = getTileIndex(attackerServer.getOrigin(), gameGroupData.tiles);

        if (attackerServer == null) {
            gameGroupData.result = "your unit is not military !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!attackerServer.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this is not your unit !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (attackerServer.getPath().size() != 0) {
            gameGroupData.result = "this unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (defenderCity == null) {
            gameGroupData.result = "this tile is not for any city !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (isCityForCivilization(defenderCity, civilizationServer)) {
            gameGroupData.result = "this city is for your civilization !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (attackerServer.getIsOnSleep() || attackerServer.isOnBoost() || attackerServer.isOnBoostTillRecover() || attackerServer.isOnWarFooting()) {
            gameGroupData.result = "this unit is not active !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Warrior) attackerServer).getRange() != -1) {
            gameGroupData.result = "this unit is not set up for range attack !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!checkDistance(attackerServer, originIndex, getTileIndex(defenderCity.getCenterTile(), gameGroupData.tiles))) {
            gameGroupData.result = "this distance is too long for attack !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Civilization defenderCivilization = getCivilizationFromCity(defenderCity, gameGroupData.civilizations);
        attackerServer.setHasOrdered(true);

        if (((Warrior) attackerServer).getRange() == -1) {
            gameGroupData.result = attackCityFromGround(civilizationServer, attackerServer, defenderCity, originIndex, gameGroupData.tiles, defenderCivilization);
            sendMessageToAllClients(gameGroup, gameGroupData);
        } else {
            gameGroupData.result = attackCityFromAir(civilizationServer, attackerServer, defenderCity, originIndex, gameGroupData.tiles, defenderCivilization);
            sendMessageToAllClients(gameGroup, gameGroupData);
        }
    }
    public String attackCityFromGround(Civilization civilization,Unit attacker, City defenderCity, int originIndex, ArrayList<Tile>map, Civilization defenderCivilization) {
        String str = "";
        int powerOfAttacker = ((Warrior)attacker).getDamage();
        int healthOfAttacker = ((Warrior)attacker).getHealth();
        powerOfAttacker = powerOfAttacker * healthOfAttacker / 10;
        if (civilization.getHappiness() < 0) {
            powerOfAttacker = powerOfAttacker - powerOfAttacker / 4;
        }
        int powerOfDefender = defenderCity.getDefenceStrength();
        int healthOfDefender = defenderCity.getDamagePoint();

        healthOfAttacker = healthOfAttacker - powerOfDefender;
        healthOfDefender = healthOfDefender - powerOfAttacker;

        if (healthOfDefender <= 0 && healthOfAttacker > 0) {
            ArrayList<Tile> tiles = defenderCity.getTiles();
            for (int i = 0; i < tiles.size(); i++) {
                tiles.get(i).getUnits().clear();
                tiles.get(i).removeAllUnitFromMakingProgress();
                tiles.get(i).removeRoadsMakingProgress();
            }
            defenderCivilization.removeCity(defenderCity);
            civilization.addCity(defenderCity);
            defenderCity.setDamagePoint(20);
            attacker.setHealth(healthOfAttacker);
            map.get(originIndex).removeUnit(attacker);
            defenderCity.getCenterTile().addUnit(attacker);
            attacker.setOrigin(defenderCity.getCenterTile());
            changeCapital(defenderCivilization);
            str = "your unit conquered the city !";
        }
        else if (healthOfDefender > 0 && healthOfAttacker <= 0) {
            defenderCity.setDamagePoint(healthOfDefender);
            map.get(originIndex).removeUnit(attacker);
            attacker = null;
            str = "your unit died !";
        }
        else if (healthOfAttacker <= 0 && healthOfDefender <= 0) {
            ArrayList<Tile> tiles = defenderCity.getTiles();
            for (int i = 0; i < tiles.size(); i++) {
                tiles.get(i).getUnits().clear();
                tiles.get(i).removeAllUnitFromMakingProgress();
                tiles.get(i).removeRoadsMakingProgress();
            }
            defenderCity.setDamagePoint(1);
            map.get(originIndex).removeUnit(attacker);
            attacker = null;
            str = "your unit died and the city became ruin !";
        }
        else if (healthOfAttacker > 0 && healthOfDefender > 0) {
            defenderCity.setDamagePoint(healthOfDefender);
            attacker.setHealth(healthOfAttacker);
            str = "the war is not over !";
        }
        return str;
    }

    private void changeCapital(Civilization civilization) {
        for (int i = 0; i < civilization.getCities().size(); i++) {
             civilization.setCapital(civilization.getCities().get(i));
        }
    }

    public String attackCityFromAir(Civilization civilization,Unit attacker, City defenderCity, int originIndex, ArrayList<Tile>map, Civilization defenderCivilization) {
        String str = "";
        int powerOfAttacker = ((Warrior)attacker).getRangedCombatDamage();
        int healthOfAttacker = ((Warrior)attacker).getHealth();
        powerOfAttacker = powerOfAttacker * healthOfAttacker / 10;
        if (civilization.getHappiness() < 0) {
            powerOfAttacker = powerOfAttacker - powerOfAttacker / 4;
        }
        int powerOfDefender = defenderCity.getDefenceStrength();
        int healthOfDefender = defenderCity.getDamagePoint();

        healthOfAttacker = healthOfAttacker - powerOfDefender;
        healthOfDefender = healthOfDefender - powerOfAttacker;

        if (healthOfDefender <= 0 && healthOfAttacker > 0) {
            defenderCity.setDamagePoint(1);
            attacker.setHealth(healthOfAttacker);
            str = "city damage point is 1 !";
        }
        else if (healthOfDefender > 0 && healthOfAttacker <= 0) {
            defenderCity.setDamagePoint(healthOfDefender);
            map.get(originIndex).removeUnit(attacker);
            attacker = null;
            str = "your unit died !";
        }
        else if (healthOfAttacker <= 0 && healthOfDefender <= 0) {
            defenderCity.setDamagePoint(1);
            map.get(originIndex).removeUnit(attacker);
            attacker = null;
            str = "your unit died and the city damage point is 1 !";
        }
        else if (healthOfAttacker > 0 && healthOfDefender > 0) {
            defenderCity.setDamagePoint(healthOfDefender);
            attacker.setHealth(healthOfAttacker);
            str = "the war is not over !";
        }
        return str;
    }

    public int attributeCombatChange (Attribute attribute) {
        if (attribute == null) return 0;
        return attribute.getCombatChange();
    }

    public String attackTileFromGround(Civilization civilization, Unit attacker, Unit defender, int originIndex, int destinationIndex,ArrayList<Tile> map){
        String str = "";
        int combatChange = map.get(destinationIndex).getCombatChange() + attributeCombatChange(map.get(destinationIndex).getAttribute());
        int powerOfAttacker = ((Warrior)attacker).getDamage();
        int healthOfAttacker = ((Warrior)attacker).getHealth();
        powerOfAttacker = powerOfAttacker * healthOfAttacker / 10;
        if (civilization.getHappiness() < 0) {
            powerOfAttacker = powerOfAttacker - powerOfAttacker / 4;
        }
        int powerOfDefender = ((Warrior)defender).getDamage();
        int healthOfDefender = ((Warrior)defender).getHealth();
        powerOfDefender = powerOfDefender * healthOfDefender / 10;
        powerOfDefender = powerOfDefender + powerOfDefender * combatChange / 100;
        if (defender.getCivilization().getHappiness() < 0) {
            powerOfDefender = powerOfDefender - powerOfDefender / 4;
        }

        healthOfAttacker = healthOfAttacker - powerOfDefender;
        healthOfDefender = healthOfDefender - powerOfAttacker;

        attacker.setHealth(healthOfAttacker);
        defender.setHealth(healthOfDefender);

        if (healthOfDefender <= 0 && healthOfAttacker > 0) {
            attacker.setOrigin(map.get(destinationIndex));
            attacker.setMp(0);
            int count1 = civilization.getCountOfWins(defender.getCivilization());
            count1 ++;
            int count2 = defender.getCivilization().getCountOfLosses(civilization);
            count2 ++;
            civilization.updateCountOfUnitWin(defender.getCivilization(), count1);
            defender.getCivilization().updateCountOfUnitLose(civilization, count2);
            int xp = ((Warrior) attacker).getXp();
            xp ++;
            ((Warrior) attacker).setXp(xp);
            map.get(originIndex).removeUnit(attacker);
            map.get(destinationIndex).removeUnit(defender);
            map.get(destinationIndex).addUnit(attacker);
            attacker.setOrigin(map.get(destinationIndex));
            str = "you won this attack !";
            defender = null;
        }
        else if (healthOfDefender > 0 && healthOfAttacker <= 0) {
            defender.setOrigin(map.get(originIndex));
            defender.setMp(0);
            int count1 = civilization.getCountOfLosses(defender.getCivilization());
            count1 ++;
            int count2 = defender.getCivilization().getCountOfWins(civilization);
            count2 ++;
            civilization.updateCountOfUnitLose(defender.getCivilization(), count1);
            defender.getCivilization().updateCountOfUnitWin(civilization, count2);
            int xp = ((Warrior) defender).getXp();
            xp ++;
            ((Warrior) defender).setXp(xp);
            map.get(originIndex).removeUnit(attacker);
            map.get(destinationIndex).removeUnit(defender);
            map.get(originIndex).addUnit(defender);
            defender.setOrigin(map.get(originIndex));
            str = "you lost this attack !";
            attacker = null;
        }
        else if (healthOfAttacker <= 0 && healthOfDefender <= 0) {
            map.get(originIndex).removeUnit(attacker);
            map.get(destinationIndex).removeUnit(defender);
            attacker = null;
            defender = null;
            str = "your unit died !";
        }
        else if (healthOfAttacker > 0 && healthOfDefender > 0) {
            int xp1 = ((Warrior) attacker).getXp();
            xp1 ++;
            ((Warrior) attacker).setXp(xp1);
            int xp2 = ((Warrior) defender).getXp();
            xp2 ++;
            ((Warrior) defender).setXp(xp2);
            str = "nobody died !";
        }
        return str;
    }
    public String attackTileFromAir(Civilization civilization, Unit attacker, Unit defender, int originIndex, int destinationIndex,ArrayList<Tile> map){
        String str;

        int powerOfAttacker = ((Warrior)attacker).getRangedCombatDamage();
        int healthOfAttacker = ((Warrior)attacker).getHealth();
        powerOfAttacker = powerOfAttacker * healthOfAttacker / 10;
        if (civilization.getHappiness() < 0) {
            powerOfAttacker = powerOfAttacker - powerOfAttacker / 4;
        }

        int healthOfDefender = ((Warrior)defender).getHealth();

        healthOfDefender = healthOfDefender - powerOfAttacker;
        defender.setHealth(healthOfDefender);
        if (healthOfDefender <= 0) {
            int xp1 = ((Warrior) attacker).getXp();
            xp1 ++;
            ((Warrior) attacker).setXp(xp1);
            int count1 = civilization.getCountOfWins(defender.getCivilization());
            count1 ++;
            int count2 = defender.getCivilization().getCountOfLosses(civilization);
            count2 ++;
            civilization.updateCountOfUnitWin(defender.getCivilization(), count1);
            defender.getCivilization().updateCountOfUnitLose(civilization, count2);
            map.get(destinationIndex).removeUnit(defender);
            str = "you won the attack !";
            defender = null;
        }
        else {
            int xp1 = ((Warrior) attacker).getXp();
            xp1 ++;
            ((Warrior) attacker).setXp(xp1);
            int xp2 = ((Warrior) defender).getXp();
            xp2 ++;
            ((Warrior) defender).setXp(xp2);
            str = "nobody died !";
        }
        return str;
    }
    // makes parameters for unit behaviours functions
    public void preUnitBehaviour (Unit unit, Civilization civilization, ArrayList<Tile> map, String command, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Unit unitServer = getUnitServer(gameGroupData.tiles, unit);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (!unitServer.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this unit is not for your civilization";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (command.equals("sleep")) {
            gameGroupData.result = sleepUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("alert")) {
            gameGroupData.result = WarFootingUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("fortify")) {
            gameGroupData.result = boostUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("heal")) {
            gameGroupData.result = boostTillRecoverUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("deploy")) {
            gameGroupData.result = deploymentUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("range")) {
            gameGroupData.result = readyForRangedBattleUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("wake")) {
            gameGroupData.result = wakeUpUnit(civilizationServer, unitServer, gameGroupData.tiles);
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("delete")) {
            gameGroupData.result = deleteUnit(civilizationServer, unitServer,
                    gameGroupData.tiles, unitServer.getOrigin());
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        else if (command.equals("recover")) {
            gameGroupData.result = recoverUnit(civilizationServer, unitServer,
                    gameGroupData.tiles, unitServer.getOrigin());
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
    }

    public String sleepUnit(Civilization civilization, Unit unit, ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }

        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }

        unit.setOnSleep(true);
        str = "selected unit is sleeping";
        return str;
    }
    public String WarFootingUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }

        unit.setOnWarFooting(true);
        str = "this unit is on standby !";
        return str;
    }
    public String boostUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;

        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
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
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
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
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }

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
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }

        unit.setOnDeployment(true);
        str = "the unit is deployed in city !";
        return str;
    }
    public String readyForRangedBattleUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.isCivilian()) {
            str = "this unit isn't trooper !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }
        ((Warrior)unit).setReadyForRangedBattle(true);
        str = "the unit is ready for ranged battle !";
        return str;
    }
    public void lootTile(Civilization civilization, int tileNumber, int destinationTileNumber, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (tileNumber != destinationTileNumber) {
            gameGroupData.result = "you should move your unit first";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        ArrayList<Unit> allUnits = gameGroupData.tiles.get(tileNumber).getUnits();
        if (allUnits.size() == 0) {
            gameGroupData.result = "there is no unit in this tile";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        boolean isThereAnyRelatedUnit = false;
        for (Unit unit : allUnits)
            if (unit.getCivilization().equals(civilizationServer)) {
                isThereAnyRelatedUnit = true;
                break;
            }
        if (!isThereAnyRelatedUnit) {
            gameGroupData.result = "units in this tile doesn't belong to you";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        Unit lootUnit = null;
        for (Unit unit : allUnits)
            if (!unit.isCivilian()) {
                lootUnit = unit;
                break;
            }
        if (lootUnit == null) {
            gameGroupData.result = "only warriors can loot a tile";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        Tile tile = gameGroupData.tiles.get(destinationTileNumber);
        tile.Loot();
        gameGroupData.result = "tile has been looted successfully";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public String cancelCommand(Civilization civilization, boolean isCivilian,ArrayList<Tile> map, Tile tile){
        String str;
        Unit unit = tile.getUnitInUnitMakingProgress(isCivilian);
        if (unit == null) {
            str = "this type of unit is not on unit making progress !";
            return str;
        }
        tile.removeUnitFromMakingProgress(unit);
        str = "unit making has been canceled !";
        return str;
    }
    public String wakeUpUnit(Civilization civilization, Unit unit,ArrayList<Tile> map){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }

        unit.setOnSleep(false);
        unit.setOnBoost(false);
        unit.setOnBoostTillRecover(false);
        unit.setOnWarFooting(false);
        str = "selected unit is active";
        return str;
    }
    public String deleteUnit(Civilization civilization, Unit unit,ArrayList<Tile> map, Tile tile){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        tile.removeUnit(unit);
        str = "the unit deleted successfully !";
        return str;
    }

    public boolean tileIsForCity (Civilization civilization, Tile tile) {
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int i1 = 0; i1 < tiles.size(); i1++) {
                if (tiles.get(i1).equals(tile)) return true;
            }
        }
        return false;
    }
    public String recoverUnit(Civilization civilization, Unit unit,ArrayList<Tile> map, Tile tile){
        String str;
        if (unit == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (!unit.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (unit.getHealth() == 10) {
            str = "this unit is fully healthy !";
            return str;
        }
        if (unit.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }

        int health = unit.getHealth();
        if (tileIsForCity(civilization, tile)) {
            health += 3;
            if (health > 10) health = 10;
        }
        else {
            health += 1;
            if (health > 10) health = 10;
        }
        unit.setHealth(health);
        str = "unit health increased !";
        return str;
    }
    public String preLockCitizen(Matcher matcher,Civilization civilization, ArrayList<Tile> map){
        matcher.find();
        int originTileNumber = Integer.parseInt(matcher.group("origin"));
        int destinationTileNumber = Integer.parseInt(matcher.group("destination"));
        if(originTileNumber >= 72 || originTileNumber < 0 || destinationTileNumber >= 72 || destinationTileNumber < 0)
            return "invalid number";
        if(originTileNumber == destinationTileNumber)
            return "numbers are equal";

        Tile origin = map.get(originTileNumber);
        Tile destination = map.get(destinationTileNumber);
        return lockCitizen(civilization,origin,destination,map);
    }
    public String lockCitizen(Civilization civilization, Tile origin, Tile destination,ArrayList<Tile> map){//move citizen from origin to destination
        for(City city : civilization.getCities()){
            for(Tile tile1 : city.getTiles()){
                if(tile1 == origin){
                    for(Tile tile2 : city.getTiles()){
                        if(tile2 == destination){
                            if(tile2.getCitizen() == null){
                                if(tile1.getCitizen() != null){
                                    tile2.setCitizen(tile1.getCitizen());
                                    tile1.setCitizen(null);
                                    return "citizen has been locked successfully";
                                }
                                return "origin tile doesn't have any citizen !";
                            }
                            return "destination tile already has a citizen !";
                        }
                    }
                    return "tiles do not belong to one city !";
                }
            }
        }
        return "tiles do not belong to your civilization !";
    }
    public String prePurchaseTile(Matcher matcher, Civilization civilization, ArrayList<Tile> map,ArrayList<Civilization> civilizations){
        matcher.find();
        int tileNumber = Integer.parseInt(matcher.group("tile"));
        if(tileNumber < 0 || tileNumber >= 72)
            return "invalid number";

        Tile tile = map.get(tileNumber);
        return purchaseTile(civilization,tile,map,civilizations);
    }
    public String purchaseTile(Civilization civilization, Tile tile,ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(City city : civilization.getCities()){
            for(Tile tempTile : city.getTiles()){
                if(areTilesNeighbour(tile,tempTile)){
                    if(tile == tempTile)
                        return "this tile is already yours";
                    if(!doesTileBelongToAnyCivilization(tile,map,civilizations)){
                        if(tile.getUnits().size() == 0 && tile.getImprovements().size() == 0){
                            if(civilization.getGold() >= 50){
                                civilization.addGold(-50);
                                city.getTiles().add(tile);
                                return "purchase tile was successful";
                            }
                            return "you don't have enough gold";
                        }
                    }
                    return "you can't purchase this tile";
                }
            }
        }
        return "this tile isn't neighbour with any of your cities";
    }
    public boolean doesTileBelongToAnyCivilization(Tile tile, ArrayList<Tile> map, ArrayList<Civilization> civilizations){
        for(Civilization civilization : civilizations){
            for(City city : civilization.getCities()){
                for(Tile tempTile : city.getTiles()){
                    if(tile == tempTile)
                        return true;//it belongs
                }
            }
        }
        return false;//it doesn't
    }
/*    public StringBuilder showTechnologyMenu(Civilization civilization){
        ArrayList<Technology> allTechnologies = civilization.getTechnologies();
        ArrayList<String> technologyNames = new ArrayList<>();
        technologyNames.add("Agriculture");
        technologyNames.add("AnimalHusbandry");
        technologyNames.add("Archery");
        technologyNames.add("BronzeWorking");
        technologyNames.add("Calendar");
        technologyNames.add("Masonry");
        technologyNames.add("Mining");
        technologyNames.add("Pottery");
        technologyNames.add("TheWheel");
        technologyNames.add("Trapping");
        technologyNames.add("Writing");
        technologyNames.add("Construction");
        technologyNames.add("HorsebackRiding");
        technologyNames.add("IronWorking");
        technologyNames.add("Mathematics");
        technologyNames.add("Philosophy");
        technologyNames.add("Chivalry");
        technologyNames.add("CivilService");
        technologyNames.add("Currency");
        technologyNames.add("Education");
        technologyNames.add("Engineering");
        technologyNames.add("Machinery");
        technologyNames.add("MetalCasting");
        technologyNames.add("Physics");
        technologyNames.add("Steel");
        technologyNames.add("Theology");
        technologyNames.add("Acoustics");
        technologyNames.add("Archaeology");
        technologyNames.add("Banking");
        technologyNames.add("Chemistry");
        technologyNames.add("Economics");
        technologyNames.add("Fertilizer");
        technologyNames.add("Gunpowder");
        technologyNames.add("Metallurgy");
        technologyNames.add("MilitaryScience");
        technologyNames.add("PrintingPress");
        technologyNames.add("Rifling");
        technologyNames.add("ScientificTheory");
        technologyNames.add("Biology");
        technologyNames.add("Combustion");
        technologyNames.add("Dynamite");
        technologyNames.add("Electricity");
        technologyNames.add("Radio");
        technologyNames.add("Railroad");
        technologyNames.add("ReplaceableParts");
        technologyNames.add("Parts");
        technologyNames.add("SteamPower");
        technologyNames.add("Telegraph");
        ArrayList<String> possibleTechnologies = new ArrayList<>();
        for (int i = 0; i < technologyNames.size(); i++)
            if (hasPrerequisiteTechs(allTechnologies, technologyNames.get(i)))
                possibleTechnologies.add(technologyNames.get(i));
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Technology, Integer> technologyEarnedPercent = civilization.getTechnologyEarnedPercent();
        stringBuilder.append("technologies that you haven't been learnt completely:\n");
        if (technologyEarnedPercent.size() == 0)
            stringBuilder.append("nothing\n");
        else {
            for (Map.Entry<Technology, Integer> technology : technologyEarnedPercent.entrySet()) {
                stringBuilder.append(technology.getKey().getName() + "\trounds left: " + technology.getValue().toString() + "\n");
            }
        }
        stringBuilder.append("technologies that you have its prerequisite techs:\n");
        if (possibleTechnologies.size() == 0){
            stringBuilder.append("nothing\n");
            return stringBuilder;
        }
        for (int i = 0; i < possibleTechnologies.size(); i++)
            stringBuilder.append(possibleTechnologies.get(i) + "\n");
        return stringBuilder;
    }*/
    public Technology preChooseTechnologyToLearn(String name){
        if (name.equals("Agriculture")) {
            Technology technology = new Technology(true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("AnimalHusbandry")) {
            Technology technology = new Technology(false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Archery")) {
            Technology technology = new Technology(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("BronzeWorking")) {
            Technology technology = new Technology(false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Calendar")) {
            Technology technology = new Technology(false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Masonry")) {
            Technology technology = new Technology(false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Mining")) {
            Technology technology = new Technology(false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Pottery")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("TheWheel")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Trapping")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Writing")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Construction")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("HorsebackRiding")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("IronWorking")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Mathematics")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Philosophy")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Chivalry")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("CivilService")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Currency")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Education")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Engineering")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Machinery")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("MetalCasting")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Physics")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Steel")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Theology")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Acoustics")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Archaeology")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Banking")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Chemistry")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Economics")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Fertilizer")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Gunpowder")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Metallurgy")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("MilitaryScience")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("PrintingPress")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Rifling")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("ScientificTheory")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Biology")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Combustion")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Dynamite")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Electricity")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Radio")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
            return technology;
        }
        else if (name.equals("Railroad")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false);
            return technology;
        }
        else if (name.equals("ReplaceableParts")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false);
            return technology;
        }
        else if (name.equals("SteamPower")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
            return technology;
        }
        else if (name.equals("Telegraph")) {
            Technology technology = new Technology(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
            return technology;
        }
        return null;
    }
    public boolean hasPrerequisiteTechs(ArrayList<Technology> allTechnologies, String name){
        for (Technology technology : allTechnologies)
            if (technology.getName().equals(name))
                return false;
        if (name.equals("Agriculture"))
            return true;
        else if (name.equals("AnimalHusbandry")) {
            for (Technology technology : allTechnologies)
                if (technology.isAgriculture())
                    return true;
            return false;
        }
        else if (name.equals("Archery")) {
            for (Technology technology : allTechnologies)
                if (technology.isAgriculture())
                    return true;
            return false;
        }
        else if (name.equals("BronzeWorking")) {
            for (Technology technology : allTechnologies)
                if (technology.isMining())
                    return true;
            return false;
        }
        else if (name.equals("Calendar")) {
            for (Technology technology : allTechnologies)
                if (technology.isPottery())
                    return true;
            return false;
        }
        else if (name.equals("Masonry")) {
            for (Technology technology : allTechnologies)
                if (technology.isMining())
                    return true;
            return false;
        }
        else if (name.equals("Mining")) {
            for (Technology technology : allTechnologies)
                if (technology.isAgriculture())
                    return true;
            return false;
        }
        else if (name.equals("Pottery")) {
            for (Technology technology : allTechnologies)
                if (technology.isAgriculture())
                    return true;
            return false;
        }
        else if (name.equals("TheWheel")) {
            for (Technology technology : allTechnologies)
                if (technology.isAnimalHusbandry())
                    return true;
            return false;
        }
        else if (name.equals("Trapping")) {
            for (Technology technology : allTechnologies)
                if (technology.isAnimalHusbandry())
                    return true;
            return false;
        }
        else if (name.equals("Writing")) {
            for (Technology technology : allTechnologies)
                if (technology.isPottery())
                    return true;
            return false;
        }
        else if (name.equals("Construction")) {
            for (Technology technology : allTechnologies)
                if (technology.isMasonry())
                    return true;
            return false;
        }
        else if (name.equals("HorsebackRiding")) {
            for (Technology technology : allTechnologies)
                if (technology.isTheWheel())
                    return true;
            return false;
        }
        else if (name.equals("IronWorking")) {
            for (Technology technology : allTechnologies)
                if (technology.isBronzeWorking())
                    return true;
            return false;
        }
        else if (name.equals("Mathematics")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isTheWheel()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isArchery()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Philosophy")) {
            for (Technology technology : allTechnologies)
                if (technology.isWriting())
                    return true;
            return false;
        }
        else if (name.equals("Chivalry")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isCivilService()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isHorsebackRiding()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isCurrency()) {
                    x++;
                    break;
                }
            if (x == 3)
                return true;
            return false;
        }
        else if (name.equals("CivilService")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isPhilosophy()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isTrapping()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Currency")) {
            for (Technology technology : allTechnologies)
                if (technology.isMathematics())
                    return true;
            return false;
        }
        else if (name.equals("Education")) {
            for (Technology technology : allTechnologies)
                if (technology.isTheology())
                    return true;
            return false;
        }
        else if (name.equals("Engineering")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isMathematics()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isConstruction()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Machinery")) {
            for (Technology technology : allTechnologies)
                if (technology.isEngineering())
                    return true;
            return false;
        }
        else if (name.equals("MetalCasting")) {
            for (Technology technology : allTechnologies)
                if (technology.isIronWorking())
                    return true;
            return false;
        }
        else if (name.equals("Physics")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isEngineering()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isMetalCasting()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Steel")) {
            for (Technology technology : allTechnologies)
                if (technology.isMetalCasting())
                    return true;
            return false;
        }
        else if (name.equals("Theology")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isCalendar()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isPhilosophy()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Acoustics")) {
            for (Technology technology : allTechnologies)
                if (technology.isEducation())
                    return true;
            return false;
        }
        else if (name.equals("Archaeology")) {
            for (Technology technology : allTechnologies)
                if (technology.isAcoustics())
                    return true;
            return false;
        }
        else if (name.equals("Banking")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isEducation()){
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isChivalry()){
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Chemistry")) {
            for (Technology technology : allTechnologies)
                if (technology.isGunpowder())
                    return true;
            return false;
        }
        else if (name.equals("Economics")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isBanking()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isPrintingPress()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Fertilizer")) {
            for (Technology technology : allTechnologies)
                if (technology.isChemistry())
                    return true;
            return false;
        }
        else if (name.equals("Gunpowder")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isPhysics()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isSteel()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Metallurgy")) {
            for (Technology technology : allTechnologies)
                if (technology.isGunpowder())
                    return true;
            return false;
        }
        else if (name.equals("MilitaryScience")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isEconomics()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isChemistry()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("PrintingPress")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isMachinery()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isPhysics()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Rifling")) {
            for (Technology technology : allTechnologies)
                if (technology.isMetallurgy())
                    return true;
            return false;
        }
        else if (name.equals("ScientificTheory")) {
            for (Technology technology : allTechnologies)
                if (technology.isAcoustics())
                    return true;
            return false;
        }
        else if (name.equals("Biology")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isArchaeology()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isScientificTheory()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Combustion")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isReplaceableParts()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isRailroad()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isDynamite()) {
                    x++;
                    break;
                }
            if (x == 3)
                return true;
            return false;
        }
        else if (name.equals("Dynamite")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isFertilizer()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isRifling()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Electricity")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isBiology()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isSteamPower()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Radio")) {
            for (Technology technology : allTechnologies)
                if (technology.isElectricity())
                    return true;
            return false;
        }
        else if (name.equals("Railroad")) {
            for (Technology technology : allTechnologies)
                if (technology.isSteamPower())
                    return true;
            return false;
        }
        else if (name.equals("ReplaceableParts")) {
            for (Technology technology : allTechnologies)
                if (technology.isSteamPower())
                    return true;
            return false;
        }
        else if (name.equals("SteamPower")) {
            int x = 0;
            for (Technology technology : allTechnologies)
                if (technology.isScientificTheory()) {
                    x++;
                    break;
                }
            for (Technology technology : allTechnologies)
                if (technology.isMilitaryScience()) {
                    x++;
                    break;
                }
            if (x == 2)
                return true;
            return false;
        }
        else if (name.equals("Telegraph")) {
            for (Technology technology : allTechnologies)
                if (technology.isElectricity())
                    return true;
            return false;
        }
        return false;
    }
    public void chooseTechnologyToLearn(Civilization civilization, String technologyName, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Technology technology = preChooseTechnologyToLearn(technologyName);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        if (technology == null) {
            gameGroupData.result = "no technology with this name exists";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
//        if (civilization.getScience() < technology.getCost())
//            return "you don't have the needed amount of science";

        ArrayList<Technology> allTechnologies = civilizationServer.getTechnologies();
        for (Technology technology1 : allTechnologies)
            if (technology1.getName().equals(technologyName)) {
                gameGroupData.result = "you already have this technology";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }
        if (!hasPrerequisiteTechs(allTechnologies, technologyName)) {
            gameGroupData.result = "you don't have the prerequisite techs to learn this technology";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (civilizationServer.isLearningTechnology()) {
            gameGroupData.result = "you are learning a technology";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (technology.getCost() > 99) {
            civilizationServer.addToTechnologyEarnedPercent(technology, (int) (technology.getCost() / 100) + 2);
            civilizationServer.setSciencePerTurn((int) (technology.getCost() / 100) + 2);
        }
        else {
            civilizationServer.addToTechnologyEarnedPercent(technology, (int) (technology.getCost() / 10) - 1);
            civilizationServer.setSciencePerTurn((int) (technology.getCost() / 10) - 1);
        }

        civilizationServer.setIsLearningTechnology(true);
        gameGroupData.result = "technology has been added to the learning technologies";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    public void changeTechnologyToLearn(Civilization civilization, String technologyName, GameGroup gameGroup) throws IOException {
        Technology technology = preChooseTechnologyToLearn(technologyName);
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (technology == null) {
            gameGroupData.result = "no technology with this name exists";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        civilizationServer.setScience(technology.getCost());
        ArrayList<Technology> allTechnologies = civilizationServer.getTechnologies();

        for (Technology technology1 : allTechnologies)
            if (technology1.getName().equals(technologyName)) {
                gameGroupData.result = "you already have this technology";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }
        if (!hasPrerequisiteTechs(allTechnologies, technologyName)) {
            gameGroupData.result = "you don't have the prerequisite techs to learn this technology";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (technology.getCost() > 99) {
            civilizationServer.addToTechnologyEarnedPercent(technology, (int) (technology.getCost() / 100) + 2);
            civilizationServer.setSciencePerTurn((int) (technology.getCost() / 100) + 2);
        }
        else {
            civilizationServer.addToTechnologyEarnedPercent(technology, (int) (technology.getCost() / 10) - 2);
            civilizationServer.setSciencePerTurn((int) (technology.getCost() / 10) - 1);
        }
        gameGroupData.result = "technology has been changed successfully";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    public String workOnTile(Civilization civilization, int cityNumber, int tileNumber, int tileUnitNumber, ArrayList<Tile> map){
        if (tileNumber != tileUnitNumber || map.get(tileNumber).getCitizen() == null)
            return "you should move your citizen to this tile first";
        City city = civilization.getCities().get(cityNumber);
        ArrayList<Tile> cityTiles = city.getTiles();
        Tile chosenTile = map.get(tileNumber);
        boolean isInRange = false;
        for (int i = 0; i < cityTiles.size(); i++) {
            if (cityTiles.get(i).equals(chosenTile)){
                isInRange = true;
                break;
            }
            else{
                float x1 = cityTiles.get(i).getX();
                float y1 = cityTiles.get(i).getY();
                float x2 = chosenTile.getX();
                float y2 = chosenTile.getY();
                //9rad3
                if (Math.pow(2, (x2 - x1)) + Math.pow(2, (y2 - y1)) <= 243){
                    isInRange = true;
                    break;
                }
            }
        }
        if (isInRange) {
            chosenTile.getCitizen().setTile(chosenTile);
            return "citizen is set to work on chosen tile";
        }
        else
            return "this tile isn't your city tiles or city neighbors";
    }
    public void createImprovement(Civilization civilization, int tileUnitNumber, int tileNumber, String improvementName, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        ArrayList<Unit> allUnits = gameGroupData.tiles.get(tileUnitNumber).getUnits();

        if (tileUnitNumber != tileNumber) {
            gameGroupData.result = "you should move your unit to this tile first";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (allUnits.size() == 0) {
            gameGroupData.result = "there is no unit in this tile";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        boolean isThereAnyRelatedUnit = false;
        Unit creatorUnit = null;
        for (Unit unit : allUnits)
            if (unit.getCivilization().equals(civilizationServer)) {
                isThereAnyRelatedUnit = true;
                creatorUnit = unit;
                break;
            }
        if (!isThereAnyRelatedUnit) {
            gameGroupData.result = "units in this tile doesn't belong to you";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!creatorUnit.isCivilian()) {
            gameGroupData.result = "only workers can work on improvements";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Civilian civilian = (Civilian) creatorUnit;
        if (civilian.isWorker()) {
            Tile tile = gameGroupData.tiles.get(tileNumber);
            ArrayList<Technology> techs = civilizationServer.getTechnologies();
            ArrayList<String> technologies = new ArrayList<>();
            for (int i = 0; i < techs.size(); i++)
                technologies.add(techs.get(i).getName());
            if (improvementName.equals("camp")) {//camp duration = 5
                if ((tile.getAttribute() != null && tile.getAttribute().isJungle()) || tile.isTundra() || tile.isHill() || tile.isDesert()) {
                    if (technologies.contains("Trapping")) {
                        Improvement improvement = new Improvement(true, false, false, false, false, false, false, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 5);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "camp can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("farm")) {
                if (tile.getAttribute() != null && tile.getAttribute().isRainForest()) {
                    if (technologies.contains("Mining")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 10);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else if (tile.getAttribute() != null && tile.getAttribute().isJungle()) {
                    if (technologies.contains("BronzeWorking")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 13);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else if (tile.getAttribute() != null && tile.getAttribute().isMarsh()) {
                    if (technologies.contains("Masonry")) {
                        Improvement improvement = new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 12);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "farm can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("lumberMill")) {     //duration = 7
                if (tile.getAttribute() != null && tile.getAttribute().isJungle()) {
                    if (technologies.contains("Construction")) {
                        Improvement improvement = new Improvement(false, false, true, false, false, false, false, false, false, 0, 1, 0);
                        tile.addToImprovementEarnedPercent(improvement, 7);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "lumberMill can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("mine")) {       //duration = 14
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isSnow() || tile.isHill() || (tile.getAttribute() != null && tile.getAttribute().isJungle()) || (tile.getAttribute() != null && tile.getAttribute().isRainForest()) || (tile.getAttribute() != null && tile.getAttribute().isMarsh())) {
                    if (technologies.contains("Mining")) {
                        Improvement improvement = new Improvement(false, false, false, true, false, false, false, false, false, 0, 1, 0);
                        tile.addToImprovementEarnedPercent(improvement, 14);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "mine can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("paddock")) {        //duration = 8
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isHill()) {
                    Improvement improvement = new Improvement(false, false, false, false, true, false, false, false, false, 0, 0, 0);
                    tile.addToImprovementEarnedPercent(improvement, 8);
                } else {
                    gameGroupData.result = "paddock can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("agriculture")) {
                if (tile.isPlain() || tile.isMeadow() || (tile.getAttribute() != null && tile.getAttribute().isJungle()) || (tile.getAttribute() != null && tile.getAttribute().isRainForest()) || (tile.getAttribute() != null && tile.getAttribute().isMarsh()) || (tile.getAttribute() != null && tile.getAttribute().isPlat())) {
                    if (technologies.contains("Calendar")) {        //duration = 5
                        Improvement improvement = new Improvement(false, false, false, false, false, true, false, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 5);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "agriculture can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("stoneMine")) {      //duration = 15
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isHill()) {
                    if (technologies.contains("Masonry")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, true, false, false, 0, 0, 0);
                        tile.addToImprovementEarnedPercent(improvement, 15);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "stoneMine can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("tradingPost")) {        //duration = 10
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra()) {
                    if (technologies.contains("Trapping")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, false, true, false, 0, 0, 1);
                        tile.addToImprovementEarnedPercent(improvement, 10);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "tradingPost can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else if (improvementName.equals("laboratory")) {     //duration = 20
                //plain, dessert, meadow, tundra, snow
                if (tile.isPlain() || tile.isDesert() || tile.isMeadow() || tile.isTundra() || tile.isSnow()) {
                    if (technologies.contains("Engineering")) {
                        Improvement improvement = new Improvement(false, false, false, false, false, false, false, false, true, 0, 2, 0);
                        tile.addToImprovementEarnedPercent(improvement, 20);
                    } else {
                        gameGroupData.result = "you don't have the prerequisite technology";
                        sendMessageToAllClients(gameGroup, gameGroupData);
                        return;
                    }
                } else {
                    gameGroupData.result = "laboratory can't be build in this tile";
                    sendMessageToAllClients(gameGroup, gameGroupData);
                    return;
                }
            } else {
                gameGroupData.result = "no improvement with this name exists!";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }
            civilian.setWorkingTile(tile);
            gameGroupData.result = "improvement created successfully";
            sendMessageToAllClients(gameGroup, gameGroupData);
        }
        else {
            gameGroupData.result = "only workers can work on improvements";
            sendMessageToAllClients(gameGroup, gameGroupData);
        }
    }


    public StringBuilder showImprovements(ArrayList<Tile> map){
        StringBuilder panel = new StringBuilder();
        ArrayList<String> improvementPanel = new ArrayList<>();
        for (int i = 0; i < map.size(); i++)
            if (map.get(i).getImprovements().size() != 0)
                for (int j = 0; j < map.get(i).getImprovements().size(); j++)
                    improvementPanel.add(i + "\t" + map.get(i).getImprovements().get(j).getName() + "\n");
        for (int i = 0; i < improvementPanel.size(); i++)
            panel.append(improvementPanel.get(i));
        return panel;
    }
    // after every turn check for road or rail making in your civilization,,, if work is making ->true if it is removing->false
    public void consumeTurnForRoadMaking (Civilization civilization, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Unit> units = map.get(i).getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if (units.get(i1).getCivilization().equals(civilization) && units.get(i1).isCivilian()) {
                    if (((Civilian) units.get(i1)).isWorker() && map.get(i).sizeOfHashMapRoad() != 0) {
                        int newTurn = map.get(i).getNumberOfTurnsRoad(units.get(i1)) - 1;
                        if (newTurn == 0) {
                            map.get(i).removeWorkerFromRoad(units.get(i1));
                            ((Civilian) units.get(i1)).setWorkingTile(null);
                            if (map.get(i).isDoesHaveRoad()) {
                                map.get(i).setDoesHaveRoad(false);
                            }
                            else {
                                map.get(i).setDoesHaveRoad(true);
                            }

                            if (map.get(i).isRoadDamaged()) {
                                map.get(i).setRoadDamaged(false);
                            }
                        } else {
                            map.get(i).setNewNumberForTurnRoad(units.get(i1), newTurn);
                        }
                    }
                    if (((Civilian) units.get(i1)).isWorker() && map.get(i).sizeOfHashMapRail() != 0) {
                        int newTurn = map.get(i).getNumberOfTurnsRail(units.get(i1)) - 1;
                        if (newTurn == 0) {
                            map.get(i).removeWorkerFromRail(units.get(i1));
                            ((Civilian) units.get(i1)).setWorkingTile(null);
                            if (map.get(i).isDoesHaveRailWay()) {
                                map.get(i).setDoesHaveRailWay(false);
                            }
                            else {
                                map.get(i).setDoesHaveRailWay(true);
                            }
                            if (map.get(i).isRailDamaged()) {
                                map.get(i).setRailDamaged(false);
                            }
                        } else {
                            map.get(i).setNewNumberForTurnRail(units.get(i1), newTurn);
                        }
                    }
                }
            }
        }
    }

    public Unit getWorker (Tile tile) {
        ArrayList<Unit> units = tile.getUnits();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isCivilian()) {
                return units.get(i);
            }
        }
        return null;
    }
    public void createRoad(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (tileServer.isDoesHaveRoad()) {
            gameGroupData.result = "there is already a road on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRoad(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the road will be ready in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    private Tile getTileServer(Tile tile, ArrayList<Tile> tiles) {
        for (Tile tile1 : tiles) {
            if (tile.equals(tile1)) return tile1;
        }
        return null;
    }

    public void createRailRoad(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (tileServer.isDoesHaveRailWay()) {
            gameGroupData.result = "there is already a rail way on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRail(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the rail way will be ready in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public Improvement preRemoveImprovement(String improvementName){
        if (improvementName.equals("camp"))
            return new Improvement(true, false, false, false, false, false, false, false, false, 0, 0, 0);
        else if (improvementName.equals("farm"))
            return new Improvement(false, true, false, false, false, false, false, false, false, 1, 0, 0);
        else if (improvementName.equals("lumberMill"))
            return new Improvement(false, false, true, false, false, false, false, false, false, 0, 1, 0);
        else if (improvementName.equals("mine"))
            return new Improvement(false, false, false, true, false, false, false, false, false, 0, 1, 0);
        else if (improvementName.equals("paddock"))
            return new Improvement(false, false, false, false, true, false, false, false, false, 0, 0, 0);
        else if (improvementName.equals("agriculture"))
            return new Improvement(false, false, false, false, false, true, false, false, false, 0, 0, 0);
        else if (improvementName.equals("stoneMine"))
            return new Improvement(false, false, false, false, false, false, true, false, false, 0, 0, 0);
        else if (improvementName.equals("tradingPost"))
            return new Improvement(false, false, false, false, false, false, false, true, false, 0, 0, 1);
        else if (improvementName.equals("laboratory"))
            return new Improvement(false, false, false, false, false, false, false, false, true, 0, 2, 0);
        else
            return null;
    }
    public void removeImprovement(Civilization civilization, Improvement improvement, int tileNumber ,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        ArrayList<City> cities = civilizationServer.getCities();
        ArrayList<Tile> cityTiles = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<Tile> tiles = cities.get(i).getTiles();
            for (int j = 0; j < tiles.size(); j++)
                cityTiles.add(tiles.get(j));
        }
        Tile tile = gameGroupData.tiles.get(tileNumber);
        boolean isOurs = false;
        for (int i = 0; i < cityTiles.size(); i++) {
            if (cityTiles.get(i).equals(tile)) {
                isOurs = true;
                break;
            }
        }
        if (!isOurs) {
            gameGroupData.result = "this tile doesn't belong to your civilization";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        ArrayList<Improvement> improvements = tile.getImprovements();
        for (int i = 0; i < improvements.size(); i++)
            if (improvements.get(i).getName().equals(improvement.getName())){
                improvements.remove(i);
                tile.setImprovements(improvements);
                gameGroupData.result = "improvement deleted successfully";
                sendMessageToAllClients(gameGroup, gameGroupData);
                return;
            }
        gameGroupData.result = "no such improvement exists!";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    public void removeRoad(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!tileServer.isDoesHaveRoad()) {
            gameGroupData.result = "there is no road on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRoad(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the road will be removed in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public void removeRailRoad(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!tileServer.isDoesHaveRailWay()) {
            gameGroupData.result = "there is no rail way on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRail(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the rail way will be removed in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public String cancelImprovementOnProcess(Civilization civilization, Tile tile){
        if (tile.getWorkingOnImprovement() == null)
            return "this tile isn't working on any improvement";
        tile.cancelImprovementOnProcess();
        return "Improvement canceled successfully";
    }
    public void repairRoad(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!tileServer.isDoesHaveRoad()) {
            gameGroupData.result = "there is no road way on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (tileServer.isDoesHaveRoad() && !tileServer.isRoadDamaged()) {
            gameGroupData.result = "this road doesn't need repair!";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRoad(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the road way will be repaired in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public void repairRail(Civilization civilization, Tile tile,ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Tile tileServer = getTileServer(tile, gameGroupData.tiles);
        Unit unit = getWorker(tileServer);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);

        if (unit == null) {
            gameGroupData.result = "this tile doesn't have any worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!unit.getCivilization().equals(civilizationServer)) {
            gameGroupData.result = "this worker does not belong to you !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (unit.getPath().size() != 0) {
            gameGroupData.result = "unit is on moving !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!((Civilian)unit).isWorker()) {
            gameGroupData.result = "this unit is not worker !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (!tileServer.isDoesHaveRailWay()) {
            gameGroupData.result = "there is no rail way on this tile !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (tileServer.isDoesHaveRailWay() && !tileServer.isRailDamaged()) {
            gameGroupData.result = "this rail road doesn't need repair!";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        if (((Civilian)unit).getWorkingTile() != null) {
            gameGroupData.result = "worker is working on something else !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }

        tileServer.assignWorkerToRail(unit, 3);
        ((Civilian)unit).setWorkingTile(tileServer);
        gameGroupData.result = "the rail way will be repaired in 3 turns";
        sendMessageToAllClients(gameGroup, gameGroupData);
    }
    public String repairImprovement(Civilization civilization, int tileUnitNumber, int tileNumber, ArrayList<Tile> map){
        ArrayList<Unit> allUnits = map.get(tileUnitNumber).getUnits();
        if (allUnits.size() == 0)
            return "there is no unit in this tile";
        boolean isThereAnyRelatedUnit = false;
        for (Unit unit : allUnits)
            if (unit.getCivilization() == civilization) {
                isThereAnyRelatedUnit = true;
                break;
            }
        if (!isThereAnyRelatedUnit)
            return "units in this tile doesn't belong to you";
        Unit repairUnit = null;
        Civilian civilian = null;
        for (Unit unit: allUnits) {
            if (!unit.isCivilian()){
                civilian = (Civilian) unit;
                if (civilian.isWorker())
                    repairUnit = unit;
            }
        }
        if (repairUnit == null)
            return "only workers can work on repairments";
        Tile tile = map.get(tileNumber);
        if (!tile.isWorking()) {
            civilian.setWorkingTile(tile);
            int repairNeedTurn = tile.getImprovements().size() * 3;
            tile.setRepairNeedImprovement(repairNeedTurn);
            tile.setIsOnRepair(true);
            return "repair Process has been started";
        }
        return "tile hasn't been looted or has been repaired completely";
    }
    //TODO... or not at all
    /*
    public String repairWholeTile(Civilization civilization,Civilian civilian, Tile tile,ArrayList<Tile> map){
        String str;

        return str;
    }
     */

    // get necessary parameters for update warrior
    public void preUpgradeUnit (Unit oldUnit, String newUnitName, int index, Civilization civilization, ArrayList<Tile> map, GameGroup gameGroup) throws IOException {
        GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
        Civilization civilizationServer = getServerCivilization(civilization, gameGroupData.civilizations);
        Unit oldUnitServer = getUnitServer(gameGroupData.tiles, oldUnit);
        if (index < 0 || index > 71) {
            gameGroupData.result = "number of tile is invalid !";
            sendMessageToAllClients(gameGroup, gameGroupData);
            return;
        }
        Unit newUnit = makeUnit(civilizationServer, gameGroupData.tiles.get(index), gameGroupData.tiles, newUnitName);
        City city = findTile(index, gameGroupData.tiles, civilizationServer);
        gameGroupData.result = updateWarrior(civilizationServer, oldUnitServer, newUnit, gameGroupData.tiles, gameGroupData.tiles.get(index), city);
        sendMessageToAllClients(gameGroup, gameGroupData);
    }

    public String updateWarrior(Civilization civilization, Unit warrior, Unit newWarrior,ArrayList<Tile> map, Tile tile, City city){
        String str;
        if (warrior == null) {
            str = "there is no unit with this name in selected tile !";
            return str;
        }
        if (newWarrior == null) {
            str = "unit name is not correct !";
            return str;
        }
        if (!warrior.getCivilization().equals(civilization)) {
            str = "this unit is for another civilization !";
            return str;
        }
        if (warrior.getPath().size() != 0) {
            str = "unit is on moving !";
            return str;
        }
        if (warrior.isCivilian() || newWarrior.isCivilian()) {
            str = "you can't upgrade a civilian unit !";
            return str;
        }
        if (!isTechnologyAvailableForUnit(newWarrior, civilization)) {
            str = "your civilization doesn't have necessary technology !";
            return str;
        }
        if (city == null) {
            str = "this tile does not belong to your cities!";
            return str;
        }
        if (!isResourceAvailableForUnit(newWarrior, city)) {
            str = "your city doesn't have necessary resource !";
            return str;
        }
        newWarrior.setX(warrior.getX());
        newWarrior.setY(warrior.getY());
        tile.removeUnit(warrior);
        tile.addUnit2(newWarrior);
        str = "unit upgraded successfully !";
        return str;
    }
    public StringBuilder showCurrentScore(ArrayList<Civilization> civilizations,ArrayList<Tile> map){
        StringBuilder stringBuilder = new StringBuilder("");
        int[] sortFlag = new int[civilizations.size()];
        Civilization chosenCivilization = null;
        int index = 0;

        int Number = 1;
        for(int i = 0; i < civilizations.size(); i++){
            boolean theFlag = true;
            for(int j = 0; j < civilizations.size(); j++){
                if(sortFlag[j] == 1)
                    continue;
                if(theFlag) {
                    chosenCivilization = civilizations.get(j);
                    theFlag = false;
                }
                Civilization tempCivilization = civilizations.get(j);
                if(tempCivilization.getPoint() > chosenCivilization.getPoint()){
                    chosenCivilization = tempCivilization;
                    index = j;
                }
            }
            sortFlag[index] = 1;
            int numOfTiles = 0;
            for(City city : chosenCivilization.getCities()){
                for(Tile tile : city.getTiles()){
                    numOfTiles++;
                }
            }
            int numOfUnits = 0;
            for(Tile tile : map){
                for(Unit unit : tile.getUnits()){
                    if(unit.getCivilization() == chosenCivilization)
                        numOfUnits++;
                }
            }
            stringBuilder.append(chosenCivilization.getMember().getNickname()).append(" : \n");
            stringBuilder.append("Rank : ").append(Number).append("\n");
            stringBuilder.append("Points : ").append(chosenCivilization.getPoint()).append("\n");
            stringBuilder.append("----------\n");
            Number++;
        }

        return stringBuilder;
    }
    public StringBuilder showCitizens(Civilization civilization){
        StringBuilder stringBuilder = new StringBuilder("");
        for(City city : civilization.getCities()){
            for(Tile tile : city.getTiles()){
                if(tile.getCitizen() != null)
                    stringBuilder.append(tile.getTileNumber()).append(" ");
            }
        }
        return stringBuilder;
    }
    //TODO
    /*
    public boolean winCheck(){

    }
     */
    public String nextTurn(Civilization civilization, ArrayList<Tile> map){
        //unit actions check
        int tileNumber = unitActionsNextTurnCheck(civilization,map);
        if(tileNumber != -1)
            return "order unit in tile number : " + tileNumber;
        /*if (civilization.getWorkingOnTechnology() == null)
            return "choose a technology to learn";*/
//-----------------------------------------------------------------------------------

        improveImprovementsNextTurn(map);
        checkForUnitMaking(civilization);
        consumeTurnForRoadMaking(civilization,map);
        addMpEveryTurn(civilization,map);
        moveUnitWithMovesLeft(civilization,map);
        increaseGoldCivilizationNextTurn(civilization,map);
        increaseFoodCitiesNextTurn(civilization,map);
        increaseProductionCitiesNextTurn(civilization,map);
        increasePopulationNextTurn(civilization,map);
        reduceRepairNeedImprovementTurnNextTurn(map);
        resetHasOrdered(civilization,map);
        civilization.reduceTechnologyRound();
        increaseCityDamagePoint(civilization);


        //TODO...  also complete historyInformation and showProductionsInProcess
        return "done";
    }
    public void increasePopulationNextTurn(Civilization civilization,ArrayList<Tile> map){
        if(civilization.getHappiness() < 0)
            return;

        for(City city : civilization.getCities()){
            if(city.getTotalFood() >= 5){
                for(Tile tile : city.getTiles()){
                    if(tile.getCitizen() == null){
                        Citizen citizen = new Citizen(tile);
                        civilization.setHappiness(-1);
                        break;
                    }
                }
            }
        }
    }
    public int unitActionsNextTurnCheck(Civilization civilization,ArrayList<Tile> map){
        for(Tile tile : map){
            for(Unit unit : tile.getUnits()){
                if(unit.getCivilization() == civilization){
                    if(!unit.getIsOnSleep()){
                        if(!unit.isCivilian() && !unit.getHasOrdered()){
                            return tile.getTileNumber();
                        }
                    }
                }
            }
        }
        return -1;
    }
    public void resetHasOrdered(Civilization civilization, ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            Tile tile = map.get(i);
            ArrayList<Unit> units = tile.getUnits();
            for (int i1 = 0; i1 < units.size(); i1++) {
                if(units.get(i1).getCivilization() == civilization){
                    if(!units.get(i1).getIsOnSleep()){
                        if(!units.get(i1).isCivilian() && !units.get(i1).getHasOrdered() && units.get(i1).getPath().size() == 0){
                            units.get(i1).setHasOrdered(false);
                        }
                    }
                }
            }
        }
    }
    public void improveImprovementsNextTurn(ArrayList<Tile> map){
        for (Tile tile : map)
            tile.reduceImprovementRound();
    }
    public void reduceRepairNeedImprovementTurnNextTurn(ArrayList<Tile> map){
        for (Tile tile: map)
            tile.reduceRepairNeedImprovementTurn();
    }
    public void increaseGoldCivilizationNextTurn(Civilization civilization,ArrayList<Tile> map){
        int finalAsset = 0;
        for(City city : civilization.getCities()){
            finalAsset += city.getGold();
        }
        for(Tile tile : map){
            for(Unit unit : tile.getUnits()){
                if(unit.getCivilization() == civilization){
                    if(!unit.isCivilian()){
                        finalAsset--;
                    }
                }
            }
        }
        //TODO... Buildings cost
        civilization.setGold(finalAsset);
    }
    public void increaseFoodCitiesNextTurn(Civilization civilization,ArrayList<Tile> map){
        for(City city : civilization.getCities()){
            int finalAsset = 0;
            finalAsset += city.getFood();
            finalAsset -= (int) (city.getCitizens().size() / 2);
            city.setTotalFood(finalAsset);
        }
    }
    public void increaseProductionCitiesNextTurn(Civilization civilization,ArrayList<Tile> map){
        for(City city : civilization.getCities()){
            int finalAsset = 0;
            finalAsset += city.getProduction();
            city.setProduction(finalAsset);
        }
    }
    // increase damage point of your cities by 1 every turn
    public void increaseCityDamagePoint (Civilization civilization) {
        ArrayList<City> cities = civilization.getCities();
        for (int i = 0; i < cities.size(); i++) {
            int newDamagePoint = cities.get(i).getDamagePoint() + 1;
            if (newDamagePoint > 20) newDamagePoint = 20;
            cities.get(i).setDamagePoint(newDamagePoint);
        }
    }
    public void deleteLosers (Civilization civilization, ArrayList<Civilization> civilizations) {
        for (int i = 0; i < civilizations.size(); i++) {
            if (civilizations.get(i).getCities().size() == 0) {
                civilizations.remove(i);
                i--;
            }
        }
    }
    public boolean findWinner (Civilization civilization, ArrayList<Civilization> civilizations) {
        if (civilizations.size() == 1) {
            int point = civilization.getPoint() + 500;
            civilization.getMember().setScore(point);
            return true;
        }
        return false;
    }
    public void loadOriginTileForUnit (ArrayList<Tile> map) {
        for (int i = 0; i < map.size(); i++) {
            for (int i1 = 0; i1 < map.get(i).getUnits().size(); i1++) {
                map.get(i).getUnits().get(i1).setOrigin(map.get(i));
            }
        }
    }
    public void loadTileForCitizen (ArrayList<Tile> map) {
        for (Tile tile : map) {
            tile.getCitizen().setTile(tile);
        }
    }
    public void loadTileForBuilding (ArrayList<Tile> map) {
        for (Tile tile : map) {
            tile.getBuilding().setTile(tile);
        }
    }
    public void loadCivilizationForBuilding (ArrayList<Civilization> civilizations) {
        for (Civilization civilization : civilizations) {
            for (City city : civilization.getCities()) {
                for (Tile tile : city.getTiles()) {
                    tile.getBuilding().setCivilization(civilization);
                }
            }
        }
    }
}
