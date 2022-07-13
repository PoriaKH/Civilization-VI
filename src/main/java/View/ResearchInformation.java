package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import com.sun.javaws.security.AppContextUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ResearchInformation {
    public static URL researchInformationURL;
    public static PlayGameMenuController playGameMenuController;
    public static Civilization playingCivilization;
    public static Scene technologyPanelScene;
    public static Stage stage;
    public Scene scene;
    private BorderPane pane;
    private VBox vBox = new VBox(100);
    private Button back = new Button("back");

    public void start () throws IOException {
        pane = FXMLLoader.load(researchInformationURL);
        back.setOnMouseClicked(event -> {
            stage.setScene(technologyPanelScene);
        });
        StringBuilder info = playGameMenuController.researchInformation(playingCivilization);
        String completeLearnt = info.substring(0, info.indexOf("technologies that you haven't been learnt completely:\n"));
        String nonCompleteLearnt = info.substring(info.indexOf("technologies that you haven't been learnt completely:\n"), info.length());
        Text firstText = new Text(completeLearnt);
        Text secondText = new Text(nonCompleteLearnt);
        firstText.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(132,243,132);-fx-effect: innershadow( three-pass-box , rgb(171,11,38), 6, 0.0 , 0 , 2 );");
        secondText.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(132,243,132);-fx-effect: innershadow( three-pass-box , rgb(171,11,38), 6, 0.0 , 0 , 2 );");
        vBox.getChildren().add(firstText);
        vBox.getChildren().add(secondText);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(back);
        pane.setCenter(vBox);
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}
