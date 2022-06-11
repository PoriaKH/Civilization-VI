package View;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class InfoPanel {
    public static URL infoPanelURL;
    public void start (Stage stage, Scene gameMenuScene) throws IOException {
        BorderPane borderPane = FXMLLoader.load(infoPanelURL);
        Button backButton = new Button("Back");
        backButton.setAlignment(Pos.CENTER);

        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setScene(gameMenuScene);
            }
        });


        borderPane.setCenter(backButton);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
