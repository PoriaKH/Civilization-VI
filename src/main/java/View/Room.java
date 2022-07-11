package View;

import Model.GsonRoom;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
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
    public boolean isHostDisconnected = false;

    public boolean isCreator = false;
    public GsonRoom gsonRoom;

    public ArrayList<Button> kickButtons = new ArrayList<>();
    public HashMap<Button,String> buttonStringHashMap = new HashMap<>();

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
            System.out.println("true");
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

        hBox.getChildren().add(startButton);
        hBox.setSpacing(15);
        root.setBottom(hBox);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void removeRoom() throws IOException {
        Gson gson = new GsonBuilder().create();
        System.out.println("logged in :" + loggedInMember);
        String send = gson.toJson(loggedInMember);
        System.out.println(send);
        dataOutputStream.writeUTF(send);
        dataOutputStream.flush();
    }
    public void refreshThePage(VBox vBox,Event event) throws IOException {
        System.out.println("here1");
        kickButtons = new ArrayList<>();
        buttonStringHashMap = new HashMap<>();
        try {
            System.out.println("here2");
            setAmIKicked();
            System.out.println("here3");
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
            System.out.println("here4");
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
            System.out.println("here5");
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
                    System.out.println(nick);
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
}
