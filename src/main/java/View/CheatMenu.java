package View;

import Controller.PlayGameMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CheatMenu {
    public static URL cheatMenuURL;
    public static Scene infoPanelScene;
    public static Stage stage;
    public Scene scene;
    public static boolean doesEnteredFromInfoPanel;
    public TextField gold;
    public TextField food;
    public TextField science;
    public TextField happiness;

    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(cheatMenuURL);
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    // TODO check if it is not number show error
    public void goldCheat(MouseEvent mouseEvent) throws IOException {
        int amount = Integer.parseInt(gold.getText());
        new PlayGameMenuController().cheatIncreaseGold(InfoPanel.currentCivilization, amount);
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
    }

    public void foodCheat(MouseEvent mouseEvent) throws IOException {
        int amount = Integer.parseInt(food.getText());
        new PlayGameMenuController().cheatIncreaseFood(InfoPanel.currentCivilization, amount);
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
    }

    public void scienceCheat(MouseEvent mouseEvent) throws IOException {
        int amount = Integer.parseInt(science.getText());
        new PlayGameMenuController().cheatIncreaseTechnology(InfoPanel.currentCivilization, amount);
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
    }

    public void happinessCheat(MouseEvent mouseEvent) throws IOException {
        int amount = Integer.parseInt(happiness.getText());
        new PlayGameMenuController().cheatIncreaseHappiness(InfoPanel.currentCivilization, amount);
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
    }
}
