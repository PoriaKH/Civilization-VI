package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TradePage {
    public static URL tradePageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene tradePageScene;



    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(tradePageURL);
        tradePageScene = new Scene(borderPane);
        stage.setScene(tradePageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }

    public void sendRequestClicked(MouseEvent mouseEvent) throws IOException {
        SendTradeRequest.infoPanelScene = infoPanelScene;
        SendTradeRequest.stage = stage;
        new SendTradeRequest().start();
    }

    public void tradeRequestsClicked(MouseEvent mouseEvent) throws IOException {
        TradeRequests.infoPanelScene = infoPanelScene;
        TradeRequests.stage = stage;
        new TradeRequests().start();
    }
}
