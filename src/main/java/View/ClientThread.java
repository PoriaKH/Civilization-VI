package View;

import Controller.PlayGameMenuController;
import Model.City;
import Model.Civilization;
import Model.FunctionsGson.GameGroupData;
import Model.FunctionsGson.OtherDataGson;
import Model.Tile;
import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static View.CreateHost.dataInputStream;
import static View.CreateHost.dataOutputStream;
import static View.MainMenu.lobbyURL;
import static View.ProfileMenu.loggedInMember;

public class ClientThread extends Thread{
    public PlayGameMenu playGameMenu;
    public Stage stage;
    public MouseEvent event;
    public PlayGameMenuController playGameMenuController;
    public boolean isGameReady = false;

// todo ... add condition if game is over , stop thread
    public ClientThread(Stage stage, MouseEvent event) {
        this.playGameMenu = new PlayGameMenu();
        this.stage = stage;
        this.event = event;
        playGameMenuController = new PlayGameMenuController();
    }

    @Override
    public void run() {
        while (true) {
            GameGroupData gameGroupData = new GameGroupData();
            OtherDataGson otherDataGson = new OtherDataGson();
            Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();

            while (true) {
                String txt = null;
                try {
                    txt = dataInputStream.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (txt.startsWith("civ ")) {
                    txt = txt.replace("civ ", "");
                    System.out.println(txt);
                    Civilization civilization = gson2.fromJson(txt, Civilization.class);
                    gameGroupData.civilizations.add(civilization);

                } else if (txt.startsWith("tile ")) {
                    txt = txt.replace("tile ", "");
                    Tile tile = gson2.fromJson(txt, Tile.class);
                    gameGroupData.tiles.add(tile);

                } else if (txt.startsWith("other ")) {
                    txt = txt.replace("other ", "");
                    System.out.println(txt);
                    otherDataGson = gson2.fromJson(txt, OtherDataGson.class);
                    setGameGroupData(gameGroupData, otherDataGson);
                    break;
                }
            }
            if (!gameGroupData.result.equals("newGame")) {
                copyTiles(gameGroupData.tiles);
                copyCivilizations(gameGroupData.civilizations);
                Civilization civilization = getCivilization(gameGroupData.civilizations);
                Room.isMyTurn = civilization.isMyTurn;
                if (Room.isMyTurn) {
                    PlayGameMenu.playingCivilization = civilization;
                    System.out.println(civilization.getName());
                    String result = gameGroupData.result;
                    showResult(result);
                }
            }
            else {
                playGameMenu = new PlayGameMenu();
                playGameMenu.stage = stage;
                try {
                    playGameMenu.root = FXMLLoader.load(GameMenu.gameMenuURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Tile.root = playGameMenu.root;
                Unit.playGameMenu = playGameMenu;
                startTiles(gameGroupData.tiles, getStatusChecker(gameGroupData));
                startCivilizations(gameGroupData.civilizations);
                Tile.map = PlayGameMenu.tiles;
                Tile.civilizations = PlayGameMenu.civilizations;
                loadExtras(gameGroupData);
                PlayGameMenu.playingCivilization = PlayGameMenu.civilizations.get(0);
                isGameReady = true;
            }
        }
    }

    private void setGameGroupData(GameGroupData gameGroupData,OtherDataGson otherDataGson) {
        gameGroupData.tileStatusOfCivilization1 = otherDataGson.tileStatusOfCivilization1;
        gameGroupData.tileStatusOfCivilization2 = otherDataGson.tileStatusOfCivilization2;
        gameGroupData.tileStatusOfCivilization3 = otherDataGson.tileStatusOfCivilization3;
        gameGroupData.tileStatusOfCivilization4 = otherDataGson.tileStatusOfCivilization4;
        gameGroupData.tileStatusOfCivilization5 = otherDataGson.tileStatusOfCivilization5;
        gameGroupData.index = otherDataGson.index;
        gameGroupData.result = otherDataGson.result;
    }

    private ArrayList<Integer> getStatusChecker(GameGroupData gameGroupData) {
        if (gameGroupData.index == 0) {
            return gameGroupData.tileStatusOfCivilization1;
        }
        else if (gameGroupData.index == 1) {
            return gameGroupData.tileStatusOfCivilization2;
        }
        else if (gameGroupData.index == 2) {
            return gameGroupData.tileStatusOfCivilization3;
        }
        else if (gameGroupData.index == 3) {
            return gameGroupData.tileStatusOfCivilization4;
        }
        else if (gameGroupData.index == 4) {
            return gameGroupData.tileStatusOfCivilization5;
        }
        return null;
    }

    private void startTiles(ArrayList<Tile> tiles, ArrayList<Integer> tileStatusOfCivilization) {
        ArrayList<Tile> map = new ArrayList<>();
        for (Tile tile : tiles) {
            Tile tileMap = new Tile(tile.getTileNumber(), tile.isDesert(), tile.isMeadow(), tile.isHill(), tile.isMountain(),
                    tile.isOcean(), tile.isPlain(), tile.isSnow(), tile.isTundra(), tile.getX(), tile.getY());
            map.add(tileMap);
        }
        for (int i = 0; i < map.size(); i++) {
            map.get(i).generatingTile(tileStatusOfCivilization.get(i));
        }
        PlayGameMenu.tiles = map;
    }

    private void startCivilizations(ArrayList<Civilization> serverCivilizations) {
        ArrayList<Civilization> civilizations = new ArrayList<>();
        for (Civilization serverCivilization : serverCivilizations) {
            City city = serverCivilization.getCities().get(0);
            city.setTiles(city.getCityTiles(serverCivilization.getCities().get(0).getTiles()));
            city.setCenterTile(city.getCenterForCity(serverCivilization.getCities().get(0).getCenterTile()));
            Civilization civilization = new Civilization(serverCivilization.getMember(), city);
            civilizations.add(civilization);
        }
        playGameMenuController.loadCivilizationForBuilding(civilizations);
        PlayGameMenu.civilizations = civilizations;
    }

    private void loadExtras(GameGroupData gameGroupData) {
        playGameMenuController.loadTileForCitizen(gameGroupData.tiles);
        playGameMenuController.loadTileForBuilding(gameGroupData.tiles);
        playGameMenuController.loadOriginTileForUnit(gameGroupData.tiles);
        playGameMenuController.loadCivilizationForBuilding(gameGroupData.civilizations);
    }

    private void showResult(String result) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("result :");
        alert.setHeaderText("result :");
        alert.setContentText(result);
        alert.showAndWait();
    }

    private Civilization getCivilization(ArrayList<Civilization> civilizations) {
        for (Civilization civilization : civilizations) {
            if (civilization.getMember().equals(loggedInMember)) return civilization;
        }
        return null;
    }

    private void copyCivilizations (ArrayList<Civilization> serverCivilizations) {
        PlayGameMenu.civilizations = deleteCivilization(serverCivilizations);
        for (int i = 0; i < PlayGameMenu.civilizations.size(); i++) {
            PlayGameMenu.civilizations.get(i).copyFieldsOfCivilizations(serverCivilizations.get(i));
        }
        playGameMenuController.loadCivilizationForBuilding(PlayGameMenu.civilizations);
    }

    private ArrayList<Civilization> deleteCivilization(ArrayList<Civilization> serverCivilizations) {
        ArrayList<Civilization> civilizations = new ArrayList<>();
        for (Civilization serverCivilization : serverCivilizations) {
            for (Civilization civilization : PlayGameMenu.civilizations) {
                if (civilization.equals(serverCivilization)) {
                    civilizations.add(civilization);
                    break;
                }
            }
        }
        return civilizations;
    }

    private void copyTiles (ArrayList<Tile> serverTiles) {
        ArrayList<Unit> units = getAllUnits(serverTiles);
        for (int i = 0; i < PlayGameMenu.tiles.size(); i++) {
            PlayGameMenu.tiles.get(i).copyFieldsOfTile(serverTiles.get(i), units);
        }
    }

    private ArrayList<Unit> getAllUnits(ArrayList<Tile> serverTiles) {
        ArrayList<Unit> allServerUnits = new ArrayList<>();
        for (Tile tile : PlayGameMenu.tiles) {
            tile.deleteUnits();
        }
        for (Tile serverTile : serverTiles) {
            allServerUnits.addAll(serverTile.getUnits());
        }
        ArrayList<Unit> allClientUnits = new ArrayList<>();
        for (Unit allServerUnit : allServerUnits) {
            if (!allServerUnit.isCivilian()) {
                Warrior warrior = new Warrior(Civilization.getCivilizationCopy(allServerUnit.getCivilization()),Tile.getClientTile(allServerUnit.getOrigin()),allServerUnit.getHealth(),allServerUnit.getConstantMP(),allServerUnit.getMp(),allServerUnit.getDuration(),allServerUnit.getGoldCost(),allServerUnit.isCivilian(),
                        ((Warrior)allServerUnit).getXp(),((Warrior)allServerUnit).getDamage(),((Warrior)allServerUnit).getRange(),((Warrior)allServerUnit).getRangedCombatDamage(),((Warrior)allServerUnit).isScout(),((Warrior)allServerUnit).isWarrior(),((Warrior)allServerUnit).isArcher(),((Warrior)allServerUnit).isChariotArcher(),
                        ((Warrior)allServerUnit).isSpearman(),((Warrior)allServerUnit).isCatapult(),((Warrior)allServerUnit).isHorseMan(),((Warrior)allServerUnit).isSwordsMan(),((Warrior)allServerUnit).isCrossbowMan(),((Warrior)allServerUnit).isKnight(),((Warrior)allServerUnit).isLongswordMan(),((Warrior)allServerUnit).isPikeMan(),((Warrior)allServerUnit).isTrebuchet(),
                        ((Warrior)allServerUnit).isCanon(),((Warrior)allServerUnit).isCavalry(),((Warrior)allServerUnit).isLancer(),((Warrior)allServerUnit).isMusketMan(),((Warrior)allServerUnit).isRifleMan(),((Warrior)allServerUnit).isAntiTankGun(),((Warrior)allServerUnit).isArtillery(),((Warrior)allServerUnit).isInfantry(),((Warrior)allServerUnit).isPanzer(),((Warrior)allServerUnit).isTank());
                allClientUnits.add(warrior);
            }
            else {
                Civilian civilian = new Civilian(Civilization.getCivilizationCopy(allServerUnit.getCivilization()),Tile.getClientTile(allServerUnit.getOrigin()),allServerUnit.getHealth(),allServerUnit.getConstantMP(),allServerUnit.getMp(),allServerUnit.getDuration(),allServerUnit.getGoldCost(),allServerUnit.isCivilian(),
                        ((Civilian)allServerUnit).isWorker(), ((Civilian)allServerUnit).isSettler());
                allClientUnits.add(civilian);
            }
        }
        return allClientUnits;
    }

    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("result :");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
