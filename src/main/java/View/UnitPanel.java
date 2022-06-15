package View;

import Controller.PlayGameMenuController;
import Model.Units.Unit;
import Model.Units.Warrior;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitPanel {
    public static URL untPanelURL;
    public static Scene infoPanelScene;
    public static Stage stage;
    public Scene scene;
    public static Unit unit;
    public static boolean doesEnteredFromInfoPanel;
    public TextField moveDes;
    public TextField attackTileDes;
    public TextField attackCityDes;
    public TextField roadDes;
    public TextField railDes;
    public TextField removeRailDes;
    public TextField removeRoadDes;
    public TextField repairRoadDes;
    public TextField repairRailDes;


    public void start () throws IOException {
        BorderPane borderPane = FXMLLoader.load(untPanelURL);
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }


    public void back(MouseEvent mouseEvent) throws IOException {
        if (doesEnteredFromInfoPanel) new InfoPanel().start();
        else stage.setScene(infoPanelScene);
    }

    public void sleepUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void alertUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void fortifyUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void healUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void deployUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void rangeUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void wakeUpUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void recoverUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void deleteUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void moveUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void attackCityUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void attackTileUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void createUnit(MouseEvent mouseEvent) {
    }

    public void createRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void createRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void removeRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void removeRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void repairRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }

    public void repairRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {

        }
    }
    public void showError () {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("wrong button/textField :");
        alert.setHeaderText("result :");
        alert.setContentText("this feature only works when you select a unit !");
        alert.showAndWait();
    }
}
