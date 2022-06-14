package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SendTradeRequest {
    public static URL sendTradeRequestURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene sendTradeRequestScene;




    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(sendTradeRequestURL);
        sendTradeRequestScene = new Scene(borderPane);
        stage.setScene(sendTradeRequestScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) {
    }
}
