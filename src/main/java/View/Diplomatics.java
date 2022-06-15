package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Diplomatics {

    public static URL diplomaticsPageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene diplomaticsPageScene;

    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(diplomaticsPageURL);
        diplomaticsPageScene = new Scene(borderPane);
        stage.setScene(diplomaticsPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }

    public void diplomaticReviewClicked(MouseEvent mouseEvent) throws IOException {
        DiplomaticReview.diplomaticsScene = diplomaticsPageScene;
        DiplomaticReview.stage = stage;
        new DiplomaticReview().start();
    }

    public void diplomaticInformationClicked(MouseEvent mouseEvent) throws IOException {
        DiplomaticInformation.diplomaticScene = diplomaticsPageScene;
        DiplomaticInformation.stage = stage;
        new DiplomaticInformation().start();
    }

    public void diplomacyClicked(MouseEvent mouseEvent) throws IOException {
        Diplomacy.diplomaticsScene = diplomaticsPageScene;
        Diplomacy.stage = stage;
        new Diplomacy().start();
    }

    public void messagesClicked(MouseEvent mouseEvent) {
    }
}
