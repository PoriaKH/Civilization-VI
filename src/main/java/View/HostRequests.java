package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static View.MainMenu.lobbyURL;

public class HostRequests {
    public Pane root;
    public Stage stage;
    public Scene scene;

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(lobbyURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
