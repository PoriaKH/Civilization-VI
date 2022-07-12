package View;

import Model.GameSocket;
import Model.GsonRoom;
import Model.GsonRoomArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static View.CreateHost.dataInputStream;
import static View.CreateHost.dataOutputStream;
import static View.Lobby.hostsURL;
import static View.MainMenu.lobbyURL;
import static View.MainMenu.loggedInMember;

public class Hosts {
    public static GameSocket gameSocket;
    public static BorderPane root;
    public static Stage stage;
    public static Scene scene;

    public static void run(MouseEvent mouseEvent) throws IOException, InterruptedException {
        root = FXMLLoader.load(hostsURL);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        dataOutputStream.writeUTF("return hosts");
        dataOutputStream.flush();
        String str = dataInputStream.readUTF();
        Gson gson = new GsonBuilder().create();
        GsonRoomArray gsonRoomArray = gson.fromJson(str, GsonRoomArray.class);
        HashMap<Button, String> buttonStringHashMap = new HashMap<>();
        ArrayList<Button> buttons = new ArrayList<>();
        for (GsonRoom gsonRoom : gsonRoomArray.gsonRooms) {
            HBox hBox = new HBox();
            Label label = new Label(gsonRoom.creatorMember.getNickname());
            label.setStyle("-fx-font-size: 35;-fx-font-weight: bold;-fx-text-fill: rgb(255,235,0);-fx-effect: innershadow( three-pass-box , rgba(255,252,77,0.8), 6, 0.0 , 0 , 2 );");
            Button joinButton = new Button("join");
            buttonStringHashMap.put(joinButton, label.getText());
            buttons.add(joinButton);
            hBox.getChildren().add(label);
            hBox.getChildren().add(joinButton);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);
            vBox.getChildren().add(hBox);
        }

        for (Button button : buttons) {
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(buttonStringHashMap.get(button));
                    for (GsonRoom gsonRoom : gsonRoomArray.gsonRooms) {
                        if (Objects.equals(gsonRoom.creatorMember.getNickname(), buttonStringHashMap.get(button))) {
                            gsonRoom.nicknames.add(loggedInMember.getNickname());
                            gsonRoom.sockets.add(gameSocket);
                            //send request to server
                            try {
                                dataOutputStream.writeUTF("join request:" + gsonRoom.creatorMember.getNickname() + " " + loggedInMember.getNickname());
                                dataOutputStream.flush();


                                Room room = new Room();
                                room.RoomConstructor(stage, scene, root,gsonRoom.creatorMember);
                                room.setGsonRoom();

                                room.run(event);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }

        root.setCenter(vBox);

        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(lobbyURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
