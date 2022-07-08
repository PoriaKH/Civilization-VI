package View;

import Controller.PlayGameMenuController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class DiplomaticReview {
    public static URL diplomaticReviewURL;
    public static Scene diplomaticsScene;
    public static Stage stage;

    public Scene diplomaticReviewScene;

    public void start() throws IOException {

        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        String text = playGameMenuController.diplomaticReview(InfoPanel.currentCivilization).toString();

        String[] str = text.split("\n");
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        for(int i = 0; i < str.length; i++){
            Label text1 = new Label(str[i]);
            text1.setStyle("-fx-font-size: 27;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
            vBox.getChildren().add(text1);
        }

        BorderPane root = FXMLLoader.load(diplomaticReviewURL);
        root.setCenter(vBox);

        diplomaticReviewScene = new Scene(root);
        stage.setScene(diplomaticReviewScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Diplomatics().start();
    }
}
