package View;

import Model.GameSocket;
import Model.GsonRoom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import static View.MainMenu.lobbyURL;
import static View.MainMenu.loggedInMember;

public class CreateHost {
    public static Socket socket;
    public static String host;
    public static DataOutputStream dataOutputStream;
    public static DataInputStream dataInputStream;
    public static URL roomURL;

    public Pane root;
    public Stage stage;
    public Scene scene;
//    @FXML
//    public TextField names;

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(lobbyURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createClicked(MouseEvent mouseEvent) throws IOException {

        Room room = new Room();
        room.RoomConstructor(stage,scene,(BorderPane) root,loggedInMember);
        room.isCreator = true;

        GameSocket gameSocket = new GameSocket(host,socket.getPort(),socket.getLocalPort());
        GsonRoom gsonRoom = new GsonRoom(gameSocket,loggedInMember);

        Gson gson = new GsonBuilder().create();
        String str = gson.toJson(gsonRoom);
        dataOutputStream.writeUTF(str);
        dataOutputStream.flush();

        room.run(mouseEvent);

//        root = FXMLLoader.load(roomURL);
//        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}
