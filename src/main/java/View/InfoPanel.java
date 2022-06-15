package View;

import Model.Civilization;
import Model.Tile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class InfoPanel {
    public static Stage stage;
    public static Scene gameMenuScene;
    public Scene infoPanelScene;
    public static URL infoPanelURL;
    public static ArrayList<Tile> tiles;
    public static ArrayList<Civilization> civilizations;
    public static Civilization currentCivilization;

    public static Text goldAmount;
    public static Text happinessAmount;

    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(infoPanelURL);
        infoPanelScene = new Scene(borderPane);
        stage.setScene(infoPanelScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) {
        goldAmount.setText(" : " + currentCivilization.getGold());
        happinessAmount.setText(" : " + currentCivilization.getHappiness());
        stage.setScene(gameMenuScene);
    }

    public void exampleClicked(MouseEvent mouseEvent) throws IOException {
        ExamplePage.infoPanelScene = infoPanelScene;
        ExamplePage.stage = stage;
        new ExamplePage().start();
    }

    public void unitPanelClicked(MouseEvent mouseEvent) throws IOException {
        UnitPanel.infoPanelScene = infoPanelScene;
        UnitPanel.stage = stage;
        UnitPanel.doesEnteredFromInfoPanel = true;
        new UnitPanel().start();
    }

    public void victoryImprovementClicked(MouseEvent mouseEvent) throws IOException {
        VictoryImprovement.infoPanelScene = infoPanelScene;
        VictoryImprovement.stage = stage;
        new VictoryImprovement().start();
    }

    public void buildingsClicked(MouseEvent mouseEvent) throws IOException {
        BuildingsPage.infoPanelScene = infoPanelScene;
        BuildingsPage.stage = stage;
        new BuildingsPage().start();
    }

    public void cheatClicked(MouseEvent mouseEvent) throws IOException {
        CheatMenu.infoPanelScene = infoPanelScene;
        CheatMenu.stage = stage;
        CheatMenu.doesEnteredFromInfoPanel = true;
        new CheatMenu().start();
    }

    public void tradeClicked(MouseEvent mouseEvent) throws IOException {
        TradePage.infoPanelScene = infoPanelScene;
        TradePage.stage = stage;
        new TradePage().start();
    }

    public void generalUnitPanelClicked(MouseEvent mouseEvent) throws IOException {
        GeneralUnitPanel.infoPanelScene = infoPanelScene;
        GeneralUnitPanel.stage = stage;
        new GeneralUnitPanel().start();
    }

    public void cityPanelClicked(MouseEvent mouseEvent) throws IOException {
        CityPanel.infoPanelScene = infoPanelScene;
        CityPanel.stage = stage;
        new CityPanel().start();
    }

}
