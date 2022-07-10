package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static View.MainMenu.lobbyURL;
import static View.MainMenu.loggedInMember;

public class CreateHost {
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
//        String[] args = names.getText().split(",");
//        for(int i = 0; i < args.length; i++){
//            System.out.println(args[i]);
//        }
        Room room = new Room();
        room.RoomConstructor(stage,scene,(BorderPane) root,loggedInMember);
        room.run(mouseEvent);

//        root = FXMLLoader.load(roomURL);
//        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}
