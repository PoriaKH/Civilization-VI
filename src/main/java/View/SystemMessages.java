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
            Text text1 = new Text(notes[i]);
            text1.setFont(new Font(18));
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
