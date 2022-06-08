package View;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

public class GameMenu {
    public static URL gameMenuURL;

    public Pane root = new Pane();
    public Scene scene;
    public Stage stage;


    public void run() throws IOException {
        Rectangle rectangle = new Rectangle(10,10,50,50);
        root.getChildren().add(rectangle);

        root.getChildren().get(0).setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String keyName = event.getCode().getName();
                if(Objects.equals(keyName, "Up")){
                }
                if(Objects.equals(keyName, "Down")){
                }
                if(Objects.equals(keyName, "Left")){
                    rectangle.setX(rectangle.getX() + 4);
                }
                if(Objects.equals(keyName, "Right")){
                    rectangle.setX(rectangle.getX() - 4);
                }
            }
        });

        stage = new Stage();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
}
