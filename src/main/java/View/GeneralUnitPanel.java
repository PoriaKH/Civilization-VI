package View;

import Controller.PlayGameMenuController;
import Model.City;
import Model.Tile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GeneralUnitPanel {
    public static URL generalUnitPanelURL;
    public static Scene infoPanelScene;
    public static Stage stage;
    public Scene scene;

    public void start() throws IOException {
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        GridPane gridPane = FXMLLoader.load(generalUnitPanelURL);

        Label label = new Label("General unit panel");
        gridPane.getChildren().add(label);

        Text text = new Text(playGameMenuController.
                generalUnitReview(InfoPanel.currentCivilization, InfoPanel.tiles).toString());
        text.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(Color.RED);
        Text text1 = new Text("hello there");
        gridPane.addRow(1, text);
        gridPane.addRow(2, text1);
        gridPane.setAlignment(Pos.CENTER);
        Button button = new Button("back");
        gridPane.addRow(3, button);
        gridPane.setVgap(10);

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

        scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}
