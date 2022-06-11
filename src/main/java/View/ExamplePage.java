package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ExamplePage {
    public static URL examplePageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene examplePageScene;

    public void start() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(examplePageURL);
        examplePageScene = new Scene(anchorPane);
        stage.setScene(examplePageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }
}
