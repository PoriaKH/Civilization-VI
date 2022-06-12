package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BuildingsPage {
    public static URL buildingPageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene buildingPageScene;

    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(buildingPageURL);
        buildingPageScene = new Scene(borderPane);
        stage.setScene(buildingPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }
}
