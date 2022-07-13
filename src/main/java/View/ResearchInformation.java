package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ResearchInformation {
    public static URL researchInformationURL;
    public static Scene technologyPanelScene;
    public static Stage stage;
    public Scene scene;

    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(researchInformationURL);
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
