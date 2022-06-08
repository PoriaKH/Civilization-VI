package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameMenu {
    public static URL gameMenuURL;
    Pane root = new Pane();
    public Scene scene;
    public Stage stage;
    public HBox bar = new HBox();
    public VBox vBox = new VBox();
    public Pane pane = new Pane();
    public ScrollPane container = new ScrollPane();

    public void run() throws IOException {
        root = FXMLLoader.load(gameMenuURL);
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
}
