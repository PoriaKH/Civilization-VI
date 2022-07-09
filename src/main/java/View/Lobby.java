package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Lobby {
    public static URL createHostURL;
    public static URL hostRequestsURL;

    public Pane root;
    public Stage stage;
    public Scene scene;

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(LoginMenu.mainMenuFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createHostClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(createHostURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void requestsClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(hostRequestsURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
