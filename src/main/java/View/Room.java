package View;

import Controller.PlayGameMenuController;
import Model.*;
import Model.FunctionsGson.GameGroupData;
import Model.Units.Unit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static View.CreateHost.*;
import static View.Lobby.createHostURL;
import static View.MainMenu.lobbyURL;
import static View.ProfileMenu.loggedInMember;

public class Room {
    public boolean amIKicked = false;
    public static boolean isMyTurn = false;

    public boolean isCreator = false;
    public GsonRoom gsonRoom;

    public ArrayList<Button> kickButtons = new ArrayList<>();
    public HashMap<Button,String> buttonStringHashMap = new HashMap<>();
    public PlayGameMenuController playGameMenuController = new PlayGameMenuController();

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

                         /*while (true) {
                             String txt = dataInputStream.readUTF();
                             Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
                             GameGroupData gameGroupData = gson2.fromJson(txt, GameGroupData.class);
                             loadExtras(gameGroupData);
                             copyCivilizations(gameGroupData.civilizations);
                             copyTiles(gameGroupData.tiles);
                             Civilization civilization = getCivilization(gameGroupData.civilizations);
                             isMyTurn = civilization.isMyTurn;
                             if (isMyTurn) {
                                String result = gameGroupData.result;
                                showResult(result);
                             }
                         }*/
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        hBox.getChildren().add(startButton);
        hBox.setSpacing(15);
        root.setBottom(hBox);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        deleteCivilization(serverCivilizations);
        for (int i = 0; i < PlayGameMenu.civilizations.size(); i++) {
            PlayGameMenu.civilizations.get(i).copyFieldsOfCivilizations(serverCivilizations.get(i));
        }
    }

    private void deleteCivilization(ArrayList<Civilization> serverCivilizations) {
        boolean doesCivExist = false;
        for (int i = 0; i < PlayGameMenu.civilizations.size(); i++) {
            for (int i1 = 0; i1 < serverCivilizations.size(); i1++) {
                if (serverCivilizations.get(i1).equals(PlayGameMenu.civilizations.get(i))) {
                    doesCivExist = true;
                    break;
                }
            }
            if (doesCivExist) {
                doesCivExist = false;
            }
            else {
                PlayGameMenu.civilizations.remove(i);
                i--;
            }
        }
    }

    private void copyTiles (ArrayList<Tile> serverTiles) {
        for (int i = 0; i < PlayGameMenu.tiles.size(); i++) {
            PlayGameMenu.tiles.get(i).copyFieldsOfTile(serverTiles.get(i), getAllUnits(serverTiles));
        }
    }

    private ArrayList<Unit> getAllUnits(ArrayList<Tile> serverTiles) {

    }

    public void removeRoom() throws IOException {
        Gson gson = new GsonBuilder().create();
        String send = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF(send);
        dataOutputStream.flush();
    }
    public void refreshThePage(VBox vBox,Event event) throws IOException {
        kickButtons = new ArrayList<>();
        buttonStringHashMap = new HashMap<>();
        try {
            setAmIKicked();
            setGsonRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    } catch (IOException e) {
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
