package View;

import Model.Member;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import static View.CreateHost.roomURL;
import static View.Lobby.createHostURL;

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

    public void run(MouseEvent mouseEvent) throws IOException {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Button backButton = new Button("back");
        backButton.setStyle("-fx-pref-height: 35;-fx-font-size: 16; -fx-pref-width: 350;-fx-border-radius: 5; -fx-background-color: #56d079;");
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    root = FXMLLoader.load(createHostURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
        vBox.getChildren().add(backButton);

        root = FXMLLoader.load(roomURL);
        root.setCenter(vBox);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
