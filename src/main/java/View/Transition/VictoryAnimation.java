package View.Transition;

import javafx.animation.Transition;
import javafx.scene.image.Image;
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
    public VictoryAnimation(){
        rectangle = new Rectangle(1280, 720);
        setCycleCount(1);
        setCycleDuration(Duration.millis(2000));
    }
    @Override
    protected void interpolate(double frac) {
        int frame = (int) Math.floor(frac * 26);
        String url = winingTransitionURL.toExternalForm() + frame + ".png";
        rectangle.setFill(new ImagePattern(new Image(url)));
    }
}
