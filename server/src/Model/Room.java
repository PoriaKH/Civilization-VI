package Model;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Room {
    public static Socket creatorSocket;
    public ArrayList<Socket> sockets = new ArrayList<>();

    public Member creator;

    public Stage stage;
    public BorderPane root;
    public Scene scene;

    public void RoomConstructor(Stage stage,Scene scene,BorderPane root,Member member){
        this.stage = stage;
        this.scene = scene;
        this.root = root;
        this.creator = member;
    }
}

