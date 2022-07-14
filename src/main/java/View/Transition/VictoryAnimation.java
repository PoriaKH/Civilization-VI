package View.Transition;

import View.MainMenu;
import javafx.animation.Transition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VictoryAnimation extends Transition {
    public static URL winingTransitionURL;
    public static Stage stage;
    private Rectangle rectangle;
    public static URL mainMenuFxmlURL;
    public VictoryAnimation(){
        rectangle = new Rectangle(1280, 720);
        setCycleCount(1);
        setCycleDuration(Duration.millis(2000));
        Pane pane = new Pane();
        pane.getChildren().add(rectangle);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
    @Override
    protected void interpolate(double frac) {
        int frame = (int) Math.floor(frac * 26);
        String url = winingTransitionURL.toExternalForm() + frame + ".png";
        rectangle.setFill(new ImagePattern(new Image(url)));
    }
}
