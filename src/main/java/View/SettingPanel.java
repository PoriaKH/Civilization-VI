package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SettingPanel {
    public static URL settingPanelURL;
    public static MediaPlayer mediaPlayer;
    public static Scene gameScene;
    public static Stage stage;

    public void run() throws IOException {
        BorderPane borderPane = FXMLLoader.load(settingPanelURL);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
    }
    public void mute(MouseEvent mouseEvent) {
        mediaPlayer.pause();
    }

    public void unmute(MouseEvent mouseEvent) {
        mediaPlayer.play();
    }

    public void back(MouseEvent mouseEvent) {
        stage.setScene(gameScene);
    }
}
