package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TradeRequests {
    public static URL tradeRequestsURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene tradeRequestsScene;



    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(tradeRequestsURL);
        tradeRequestsScene = new Scene(borderPane);
        stage.setScene(tradeRequestsScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) {
    }
}
