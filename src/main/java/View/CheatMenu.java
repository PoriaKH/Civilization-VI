package View;

import Controller.PlayGameMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private final String regex = "\\d+";

    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(cheatMenuURL);
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    public Matcher getMatcher (String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    // TODO check if it is not number show error
    public void goldCheat(MouseEvent mouseEvent) throws IOException {
        String str = gold.getText();
        if (getMatcher(str).matches()) {
            int amount = Integer.parseInt(str);
            new PlayGameMenuController().cheatIncreaseGold(InfoPanel.currentCivilization, amount);
            if (doesEnteredFromInfoPanel) new InfoPanel().start();
            else stage.setScene(infoPanelScene);
        }
        else showError("gold");
    }

    public void foodCheat(MouseEvent mouseEvent) throws IOException {
        String str = food.getText();
        if (getMatcher(str).matches()) {
            int amount = Integer.parseInt(str);
            new PlayGameMenuController().cheatIncreaseFood(InfoPanel.currentCivilization, amount);
            if (doesEnteredFromInfoPanel) new InfoPanel().start();
            else stage.setScene(infoPanelScene);
        }
        else showError("food");
    }

    public void scienceCheat(MouseEvent mouseEvent) throws IOException {
        String str = science.getText();
        if (getMatcher(str).matches()) {
            int amount = Integer.parseInt(str);
            new PlayGameMenuController().cheatIncreaseTechnology(InfoPanel.currentCivilization, amount);
            if (doesEnteredFromInfoPanel) new InfoPanel().start();
            else stage.setScene(infoPanelScene);
        }
        else showError("science");
    }

    public void happinessCheat(MouseEvent mouseEvent) throws IOException {
        String str = happiness.getText();
        if (getMatcher(str).matches()) {
            int amount = Integer.parseInt(str);
            new PlayGameMenuController().cheatIncreaseHappiness(InfoPanel.currentCivilization, amount);
            if (doesEnteredFromInfoPanel) new InfoPanel().start();
            else stage.setScene(infoPanelScene);
        }
        else showError("happiness");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
        else stage.setScene(infoPanelScene);
    }

    public void showError (String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("wrong input");
        alert.setHeaderText("result :");
        alert.setContentText(string + " 's prompt text contains non-number character");
        alert.showAndWait();
    }
}
