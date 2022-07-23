package View;

import Controller.PlayGameMenuController;
import Model.*;
import Model.FunctionsGson.CivilizationsGson;
import Model.FunctionsGson.GameGroupData;
import Model.FunctionsGson.MemberArray;
import Model.FunctionsGson.OtherDataGson;
import Model.Units.Civilian;
import Model.Units.Unit;
import Model.Units.Warrior;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static View.CreateHost.*;
import static View.MainMenu.lobbyURL;
import static View.ProfileMenu.loggedInMember;

public class Room {
    public boolean isGameStarted = false;
    public boolean amIKicked = false;
    public static boolean isMyTurn = false;

    public boolean isCreator = false;
    public GsonRoom gsonRoom;

    public ArrayList<Button> kickButtons = new ArrayList<>();
    public HashMap<Button,String> buttonStringHashMap = new HashMap<>();
    public PlayGameMenuController playGameMenuController = new PlayGameMenuController();
    public PlayGameMenu playGameMenu;
    public static Socket creatorSocket;

    public Member creator;

    public Stage stage;
    public BorderPane root;
    public Scene scene;

    public void RoomConstructor(Stage stage,Scene scene,BorderPane root,Member creator){
        this.stage = stage;
        this.scene = scene;
        this.root = root;
        this.creator = creator;
    }
    public void setAmIKicked() throws IOException {
        dataOutputStream.writeUTF("amIKicked");
        dataOutputStream.flush();
        String str = dataInputStream.readUTF();
        if(str.equals("true"))
            amIKicked = true;
    }
    public void setIsHostDisconnected(){

    }
    public void setGsonRoom() throws IOException {
        dataOutputStream.writeUTF("set gson room:" + creator.getNickname());
        dataOutputStream.flush();
        String str = dataInputStream.readUTF();
        if(str.equals("null")){
            this.gsonRoom = null;
            return;
        }
        Gson gson = new GsonBuilder().create();
        this.gsonRoom = gson.fromJson(str, GsonRoom.class);
    }
    public void run(MouseEvent mouseEvent) throws IOException {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 350;-fx-border-radius: 5; -fx-background-color: #56d079;");
        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    root = FXMLLoader.load(lobbyURL);
                    removeRoom();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
        if(gsonRoom != null) {
            for (String str : gsonRoom.nicknames) {
                Label label = new Label(str);
                label.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(8,250,24);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
                vBox.getChildren().add(label);
            }
        }
        Button refresh = new Button("refresh");
        refresh.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 350;-fx-border-radius: 5; -fx-background-color: #cf32dc;");
        refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    refreshThePage(vBox,event);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        listenForKickButtons(vBox);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().add(refresh);


        root = FXMLLoader.load(roomURL);
        root.setCenter(vBox);
        root.setTop(hBox2);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(exitButton);
        Button startButton = new Button("Start");
        startButton.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 350;-fx-border-radius: 5; -fx-background-color: #56d079;");
        if(!isCreator)
            startButton.setDisable(true);

        startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    refreshThePage(vBox,event);
                    if(gsonRoom.nicknames.size() > 5){
                        showAlert("capacity over limit !");
                    }
                    else if(gsonRoom.nicknames.size() == 1){
                        showAlert("the game must have more than one player to start !");
                    }
                    else {
                        //start the game...

                        Gson gson = new GsonBuilder().create();
                        GameSocketArray gameSocketArray = new GameSocketArray();
                        gameSocketArray.gameSockets = gsonRoom.sockets;
                        String str = gson.toJson(gameSocketArray);
                        dataOutputStream.writeUTF(str);
                        dataOutputStream.flush();
                        //TODO...Koochak add playGameMenu graphic

                        String res = dataInputStream.readUTF();
                        if(res.equals("give me members")){
                            Gson gson1 = new GsonBuilder().create();
                            String txt = gson1.toJson(gsonRoom);
                            dataOutputStream.writeUTF(txt);
                            dataOutputStream.flush();
                        }
                        else {
                            System.out.println("something went wrong! Client/Room/Line 169");
                        }


                        /*MemberArray memberArray = new MemberArray();
                        memberArray.members = gsonRoom.members;

                        Gson gson1 = new GsonBuilder().create();
                        String txt = gson1.toJson(memberArray);
                        dataOutputStream.writeUTF(txt);
                        dataOutputStream.flush();*/

//                        refreshThePage(vBox,event);

                       ClientThread clientThread = new ClientThread(stage, event);
                       clientThread.setDaemon(true);
                       clientThread.start();


                       while (true) {
                           Thread.sleep(1000);
                           if (clientThread.isGameReady()) {
                               clientThread.playGameMenu.clientThread = clientThread;
                                clientThread.playGameMenu.switchToGame(event);
                             break;
                           }
                        }

                        /*while (true) {
                             GameGroupData gameGroupData = new GameGroupData();
                             OtherDataGson otherDataGson = new OtherDataGson();
                             Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();

                            while (true) {
                                String txt = dataInputStream.readUTF();
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
                                 isMyTurn = civilization.isMyTurn;
                                 if (isMyTurn) {
                                     PlayGameMenu.playingCivilization = civilization;
                                     System.out.println(civilization.getName());
                                     String result = gameGroupData.result;
                                     showResult(result);
                                 }
                             }
                             else {
                                 playGameMenu = new PlayGameMenu();
                                 playGameMenu.stage = stage;
                                 playGameMenu.root = FXMLLoader.load(GameMenu.gameMenuURL);
                                 Tile.root = playGameMenu.root;
                                 Unit.playGameMenu = playGameMenu;
                                 startTiles(gameGroupData.tiles, getStatusChecker(gameGroupData));
                                 startCivilizations(gameGroupData.civilizations);
                                 Tile.map = PlayGameMenu.tiles;
                                 Tile.civilizations = PlayGameMenu.civilizations;
                                 loadExtras(gameGroupData);
                                 PlayGameMenu.playingCivilization = PlayGameMenu.civilizations.get(0);
                                 playGameMenu.switchToGame(event);
                             }
                         }*/
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Button guestButton = new Button("Guest Start");
        startButton.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 350;-fx-border-radius: 5; -fx-background-color: #56d079;");
        if (isCreator)
            guestButton.setDisable(true);

        guestButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                while (true) {
                    try {
                        String respond = dataInputStream.readUTF();
                        if (respond.equals("ok")) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                ClientThread clientThread = new ClientThread(stage, event);
                clientThread.setDaemon(true);
                clientThread.start();


                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (clientThread.isGameReady()) {
                        clientThread.playGameMenu.clientThread = clientThread;
                        try {
                            clientThread.playGameMenu.switchToGame(event);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        });



        hBox.getChildren().add(startButton);
        hBox.getChildren().add(guestButton);
        hBox.setSpacing(15);
        root.setBottom(hBox);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    private void showResult(String result, ClientThread clientThread) {
            clientThread.isNewResultAvailable = false;
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

    /*private void copyTiles (ArrayList<Tile> serverTiles) {
        ArrayList<Unit> units = getAllUnits(serverTiles);
        for (int i = 0; i < PlayGameMenu.tiles.size(); i++) {
            PlayGameMenu.tiles.get(i).copyFieldsOfTile(serverTiles.get(i), units, this);
        }
    }*/

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

    public void removeRoom() throws IOException {
        Gson gson = new GsonBuilder().create();
        String send = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF(send);
        dataOutputStream.flush();
    }
    public void refreshThePage(VBox vBox,Event event) throws IOException, InterruptedException {
        kickButtons = new ArrayList<>();
        buttonStringHashMap = new HashMap<>();
        try {
            setAmIKicked();
            setGsonRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*if(isGameStarted){
            //Start the game ...
            ClientThread clientThread = new ClientThread(stage, (MouseEvent) event);
            clientThread.setDaemon(true);
            clientThread.start();


            while (true) {
                Thread.sleep(1000);
                if (clientThread.isGameReady()) {
                    clientThread.playGameMenu.clientThread = clientThread;
                    clientThread.playGameMenu.switchToGame((MouseEvent) event);
                    break;
                }
            }*/

        if(amIKicked){
            root = FXMLLoader.load(lobbyURL);
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(gsonRoom != null) {
            while(vBox.getChildren().size() > 0){
                vBox.getChildren().remove(0);
            }
            for (String str : gsonRoom.nicknames) {
                Label label = new Label(str);
                label.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(8,250,24);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
                Button kick = new Button("kick");
                kick.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 50;-fx-border-radius: 5; -fx-background-color: #f10940;");
                kickButtons.add(kick);
                buttonStringHashMap.put(kick,str);
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(10);
                hBox.getChildren().add(label);
                if(isCreator && !Objects.equals(str, loggedInMember.getNickname())) {
                    hBox.getChildren().add(kick);
                }
                vBox.getChildren().add(hBox);
            }

        }
        else {
            root = FXMLLoader.load(lobbyURL);
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        listenForKickButtons(vBox);
    }
/*    public void setIsGameStarted() throws IOException {
        dataOutputStream.writeUTF("give me startedGameMembers");
        dataOutputStream.flush();
        String in = dataInputStream.readUTF();
        System.out.println("in =" + in);
        Gson gson = new GsonBuilder().create();
        MemberArray memberArray = gson.fromJson(in,MemberArray.class);
        for(Member member : memberArray.members){
            if(Objects.equals(member.getUsername(), loggedInMember.getUsername())){
                isGameStarted = true;
                break;
            }
        }
    }*/
    public void listenForKickButtons(VBox vBox){
        for(Button button : kickButtons){
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    String nick = buttonStringHashMap.get(button);
                    try {
                        dataOutputStream.writeUTF("kick:" + nick);
                        dataOutputStream.flush();
                        refreshThePage(vBox,event);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("result :");
        alert.setContentText(message);
        alert.showAndWait();
    }
}