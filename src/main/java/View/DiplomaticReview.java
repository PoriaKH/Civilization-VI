package View;

import Controller.PlayGameMenuController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
            Text text1 = new Text(str[i]);
            text1.setFont(new Font(18));
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
