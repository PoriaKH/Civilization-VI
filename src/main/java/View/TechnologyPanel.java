package View;

import Model.Tile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TechnologyPanel {
    public static Stage stage;
    public static Scene gameMenuScene;
    public Scene technologyPanelScene;
    public static URL technologyPanelURL;

    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(technologyPanelURL);
        technologyPanelScene = new Scene(borderPane);
        stage.setScene(technologyPanelScene);
        stage.show();
    }

    public void moveToTechnologyTree(MouseEvent mouseEvent) throws IOException {
        TechnologyTree.technologyPanelScene = technologyPanelScene;
        TechnologyTree.stage = stage;
        new TechnologyTree().initializeTechnologyTree();
    }

    public void moveToResearchInfo(MouseEvent mouseEvent) throws IOException {
        ResearchInformation.technologyPanelScene = technologyPanelScene;
        ResearchInformation.stage = stage;
        new ResearchInformation().start();
    }

    public void back(MouseEvent mouseEvent) {
        stage.setScene(gameMenuScene);
    }
}
