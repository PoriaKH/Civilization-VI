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

public class SystemMessages {
    public static URL systemMessagesURL;
    public static Scene messagesScene;
    public static Stage stage;

    public Scene systemMessageScene;

    public void start() throws IOException {

        Label label = new Label("Messages");
        label.setStyle("-fx-font-size: 35;-fx-font-weight: bold;-fx-text-fill: rgb(255,235,0);-fx-effect: innershadow( three-pass-box , rgba(255,252,77,0.8), 6, 0.0 , 0 , 2 );");
        label.setFont(new Font(27));
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(label);

        BorderPane root = FXMLLoader.load(systemMessagesURL);

        root.setCenter(vBox);

        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        String text = playGameMenuController.showMessages(InfoPanel.currentCivilization).toString();

        String[] notes = text.split("\n");
        for(int i = 0; i < notes.length; i++){
            Label text1 = new Label(notes[i]);
            text1.setStyle("-fx-font-size: 19;-fx-font-weight: bold;-fx-text-fill: rgb(62,255,2);-fx-effect: innershadow( three-pass-box , rgba(21,250,13,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
            vBox.getChildren().add(text1);
        }

        systemMessageScene = new Scene(root);
        stage.setScene(systemMessageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Messages().start();
    }
}
