package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Units.Unit;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UnitInformationPanel {
    public static Civilization playingCivilization;
    public static Stage stage;
    public Scene scene;
    public Pane pane = new Pane();
    public Text text = new Text();
    private Button back = new Button("back");
    private Label unitLabel = new Label();
    private ScrollPane container = new ScrollPane();
    private VBox vBox = new VBox(95);
    private ArrayList<HBox> hBoxes = new ArrayList<>();


    public void initializePanelTree(){
        text.setText("information about units");
        text.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 40));
        vBox.setAlignment(Pos.CENTER);
        back.setOnMouseClicked(ev ->{
            try {
                new InfoPanel().start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        back.setStyle("-fx-pref-width: 200;\n" +
                "    -fx-pref-height: 20;\n" +
                "    -fx-effect: dropshadow( one-pass-box , #d54444, 8 , 0.0 , 2 , 0 );\n" +
                "    -fx-font-style: italic;\n" +
                "    -fx-background-color:\n" +
                "            linear-gradient(from 0% 93% to 0% 100%, rgba(115, 42, 213, 0.83) 0%, #326dda 100%),\n" +
                "            #1a9bda,\n" +
                "            #31a3e0,\n" +
                "            radial-gradient(center 50% 50%, radius 100%, rgba(255, 84, 84, 0.7), #f11111);");
        back.setPrefSize(100, 30);
        container.setPrefSize(1280, 720);
        container.setContent(vBox);
        vBox.getChildren().add(text);
        vBox.getChildren().add(back);
        initializeUnits();
        pane.getChildren().addAll(container);
        scene = new Scene(pane);
        stage.setScene(scene);
    }

    private void initializeUnits(){
        ArrayList<Rectangle> unitsInfo = new ArrayList<>();
        for (int j = 0; j < Unit.unitsName.size(); j++) {
            unitsInfo.add(new Rectangle(120, 120));
        }
        int i = 0;
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Tank").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Panzer").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Warrior").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Infantry").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Artillery").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Archer").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Chariot Archer").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Scout").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Spearman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Catapult").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Horseman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Swordsman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Crossbowman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Knight").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Longswordsman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Pikeman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Trebuchet").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Cannon").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Cavalry").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Lancer").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Musketman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Rifleman").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Anti-Tank Gun").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Settler").toExternalForm())));
        unitsInfo.get(i++).setFill(new ImagePattern(new Image(Unit.unitsURL.get("Worker").toExternalForm())));

        ArrayList<HBox> hBoxes = new ArrayList<>();
        for (int j = 0; j < 7; j++)
            hBoxes.add(new HBox(250));
        for (int j = 0; j < 7; j++)
            for (int k = 0; k < 4; k++) {
                if (4 * j + k == 25)
                    break;
                hBoxes.get(j).getChildren().add(unitsInfo.get(4 * j + k));
            }

        unitsPopUp(unitsInfo);
        for (int j = 0; j < 7; j++)
            vBox.getChildren().add(hBoxes.get(j));
    }

    private void unitsPopUp(ArrayList<Rectangle> units){
        ArrayList<Alert> alerts = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            alerts.add(new Alert(Alert.AlertType.INFORMATION));
            alerts.get(i).setHeaderText("unit's information:");
        }
        ArrayList<String> alertMessages = new ArrayList<>();
        alertMessages.add("Tank\nMp: 4\nHealth: 10\nCost: 450\ndamage: 50\nTurn: 6");
        alertMessages.add("Panzer\nMp: 5\nHealth: 10\nCost: 450\ndamage: 60\nTurn: 5");
        alertMessages.add("Warrior\nMp: 4\nHealth: 10\nCost: 450\ndamage: 50\nTurn: 1");
        alertMessages.add("Infantry\nMp: 4\nHealth: 10\nCost: 450\ndamage: 50\nTurn: 4");
        alertMessages.add("Artillery\nMp: 2\nHealth: 12\nCost: 420\ndamage: 16\nTurn: 5\nRange");
        alertMessages.add("Archer\nMp: 2\nHealth: 4\nCost: 70\ndamage: 4\nTurn: 1\nRange");
        alertMessages.add("Chariot Archer\nMp: 4\nHealth: 4\nCost: 60\ndamage: 3\nTurn: 1\nRange");
        alertMessages.add("Scout\nMp: 2\nHealth: 10\nCost: 25\ndamage: 4\nTurn: 1");
        alertMessages.add("Spearman\nMp: 2\nHealth: 10\nCost: 25\ndamage: 4\nTurn: 1");
        alertMessages.add("Catapult\nMp: 2\nHealth: 6\nCost: 100\ndamage: 4\nTurn: 1\nRange");
        alertMessages.add("Horseman\nMp: 4\nHealth: 10\nCost: 80\ndamage: 12\nTurn: 1");
        alertMessages.add("Swordsman\nMp: 2\nHealth: 4\nCost: 80\ndamage: 11\nTurn: 2");
        alertMessages.add("Crossbowman\nMp: 2\nHealth: 4\nCost: 120\ndamage: 6\nTurn: 2\nRange");
        alertMessages.add("Knight\nMp: 3\nHealth: 8\nCost: 150\ndamage: 11\nTurn: 1");
        alertMessages.add("Longswordsman\nMp: 3\nHealth: 6\nCost: 150\ndamage: 18\nTurn: 3");
        alertMessages.add("Pikeman\nMp: 2\nHealth: 5\nCost: 100\ndamage: 10\nTurn: 1");
        alertMessages.add("Trebuchet\nMp: 2\nHealth: 9\nCost: 170\ndamage: 6\nTurn: 3\nRange");
        alertMessages.add("Canon\nMp: 2\nHealth: 8\nCost: 250\ndamage: 10\nTurn: 2\nRange");
        alertMessages.add("Cavalry\nMp: 2\nHealth: 4\nCost: 260\ndamage: 25\nTurn: 3");
        alertMessages.add("Lancer\nMp: 4\nHealth: 10\nCost: 220\ndamage: 22\nTurn: 2");
        alertMessages.add("Musketman\nMp: 2\nHealth: 5\nCost: 120\ndamage: 16\nTurn: 3");
        alertMessages.add("Rifleman\nMp: 2\nHealth: 5\nCost: 200\ndamage: 25\nTurn: 3");
        alertMessages.add("Anti-Tank Gun\nMp: 2\nHealth: 6\nCost: 300\ndamage: 32\nTurn: 6");
        alertMessages.add("Settler : Can found a new City\nMp: 2\nHealth: 2\nCost: 89\nTurn: 1");
        alertMessages.add("Worker : May create and repair land-based Improvements\nMp: 2\nHealth: 2\nCost: 70\nTurn: 1");

        for (int i = 0; i < 25; i++)
            alerts.get(i).setContentText(alertMessages.get(i));
        for (int i = 0; i < 25; i++) {
            int finalI = i;
            units.get(i).setOnMouseClicked(event -> {
                alerts.get(finalI).showAndWait();
            });
        }
    }
}
