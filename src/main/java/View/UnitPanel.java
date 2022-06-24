package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Tile;
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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitPanel {
    public static URL untPanelURL;
    public static Scene infoPanelScene;
    public static Stage stage;
    public Scene scene;
    public static Unit unit;
    public static Civilization playingCivilization;
    public static ArrayList<Tile> map;
    public static PlayGameMenuController playGameMenuController;
    public static ArrayList<Civilization> civilizations;
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
    public TextField unitName;
    public TextField tileNumber;


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
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "sleep");
            showNotification(string);
        }
    }

    private void showNotification(String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("result :");
        alert.setHeaderText("result :");
        alert.setContentText(string);
        alert.showAndWait();
    }

    public void alertUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "alert");
            showNotification(string);
        }
    }

    public void fortifyUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "fortify");
            showNotification(string);
        }
    }

    public void healUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "heal");
            showNotification(string);
        }
    }

    public void deployUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "deploy");
            showNotification(string);
        }
    }

    public void rangeUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "range");
            showNotification(string);
        }
    }

    public void wakeUpUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "wake");
            showNotification(string);
        }
    }

    public void recoverUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "recover");
            showNotification(string);
        }
    }

    public void deleteUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preUnitBehaviour(unit, playingCivilization, map, "delete");
            showNotification(string);
        }
    }

    public void moveUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
           String string = playGameMenuController.preMoveUnit(unit, Integer.parseInt(moveDes.getText()),
                   playingCivilization, map);
           showNotification(string);
        }
    }

    public void attackCityUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preAttackCity(unit,
                    Integer.parseInt(attackCityDes.getText()), playingCivilization, map, civilizations);
            showNotification(string);
        }
    }

    public void attackTileUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            String string = playGameMenuController.preAttackTile(unit, Integer.parseInt(attackTileDes.getText()),
                    playingCivilization, map);
            showNotification(string);
        }
    }

    public void createUnit(MouseEvent mouseEvent) {
        String string = playGameMenuController.preUnitMaker(unitName.getText(),
                Integer.parseInt(tileNumber.getText()), playingCivilization, map);
        showNotification(string);
    }

    public void createRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(roadDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.createRoad(playingCivilization, map.get(index), map);
            }
            showNotification(string);
        }
    }

    public void createRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(railDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.createRailRoad(playingCivilization, map.get(index), map);
            }
            showNotification(string);
        }
    }
    public void removeRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(removeRailDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.removeRailRoad(playingCivilization, map.get(index), map);
            }
            showNotification(string);
        }
    }

    public void removeRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(removeRoadDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.removeRoad(playingCivilization, map.get(index), map);
            }
            showNotification(string);
        }
    }

    public void repairRoadUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(repairRoadDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.repairRoad(playingCivilization, map.get(index), map);
            }
            showNotification(string);
        }
    }

    public void repairRailUnit(MouseEvent mouseEvent) {
        if (doesEnteredFromInfoPanel) {
            showError();
        }
        else {
            int index = Integer.parseInt(repairRailDes.getText());
            String string;
            if (index < 0 || index > 71) {
                string = "invalid number";
            }
            else {
                string = playGameMenuController.repairRail(playingCivilization, map.get(index), map);
            }
            showNotification(string);
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
