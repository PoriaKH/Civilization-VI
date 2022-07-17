package View;

import Controller.PlayGameMenuController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.font.FontFamily;

import java.io.IOException;
import java.net.URL;

public class VictoryImprovement {
    public static URL victoryImprovementURL;
    public static Scene infoPanelScene;
    public static Stage stage;
    public Scene victoryImprovementScene;

    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(victoryImprovementURL);
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        Label label = new Label("Victory improvement");
        borderPane.setTop(label);
        label.setAlignment(Pos.TOP_CENTER);
        label.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Text text = new Text(playGameMenuController.
                victoryImprovement(InfoPanel.currentCivilization, InfoPanel.tiles).toString());
        text.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, 30));
        text.setFill(Color.RED);
        borderPane.setCenter(text);

        Button button = new Button("back");
        borderPane.setBottom(button);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new InfoPanel().start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        victoryImprovementScene = new Scene(borderPane);
        stage.setScene(victoryImprovementScene);
        stage.show();
    }
}
