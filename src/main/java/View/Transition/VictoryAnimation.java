package View.Transition;

import View.MainMenu;
import javafx.animation.Transition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VictoryAnimation extends Transition {
    public static URL winingTransitionURL;
    public static Stage stage;
    private Rectangle rectangle;
    public static URL mainMenuFxmlURL;
    private Pane pane;
    private Scene scene;
    public VictoryAnimation(Pane root, Scene scene){
        rectangle = new Rectangle(1280, 720);
        setCycleCount(1);
        setCycleDuration(Duration.millis(5000));
        root.getChildren().removeAll();
        pane = root;
        pane.getChildren().add(rectangle);
        this.scene = scene;
        stage.setScene(scene);
        stage.show();
    }
    @Override
    protected void interpolate(double frac) {
        int frame = (int) Math.floor(frac * 26);
        String url = winingTransitionURL.toExternalForm() + frame + ".png";
        rectangle.setFill(new ImagePattern(new Image(url)));
        if (frame == 26) {
            try {
                pane = FXMLLoader.load(VictoryAnimation.mainMenuFxmlURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }
    }
}
