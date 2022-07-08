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

public class EconomicalReview {
    public static URL economicalPageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene economicalPageScene;

    public void start() throws IOException {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        Label label = new Label("Economical Review");
        label.setFont(new Font(25));
        vBox.getChildren().add(label);
        Text temp = new Text(" ");
        Text temp2 = new Text(" ");
        vBox.getChildren().add(temp);
        vBox.getChildren().add(temp2);

        String text = new PlayGameMenuController().economicalReview(InfoPanel.currentCivilization).toString();
        String[] notes = text.split("\n");
        for(int i = 0; i < notes.length; i++){
            Label text1 = new Label(notes[i]);
            text1.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
            vBox.getChildren().add(text1);
        }

        BorderPane root = FXMLLoader.load(economicalPageURL);
        root.setCenter(vBox);

        economicalPageScene = new Scene(root);
        stage.setScene(economicalPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }
}
