package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Messages {
    public static URL messagesURL;
    public static Scene diplomaticsScene;
    public static Stage stage;

    public Scene messagesScene;

    public void start() throws IOException {
        BorderPane root = FXMLLoader.load(messagesURL);
        messagesScene = new Scene(root);
        stage.setScene(messagesScene);
        stage.show();
    }
    public void requestsClicked(MouseEvent mouseEvent) throws IOException {
        DiplomaticRequests.messagesScene = messagesScene;
        DiplomaticRequests.stage = stage;
        new DiplomaticRequests().start();
    }
    public void systemMessagesClicked(MouseEvent mouseEvent) throws IOException {
        SystemMessages.messagesScene = messagesScene;
        SystemMessages.stage = stage;
        new SystemMessages().start();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Diplomatics().start();
    }
}
