package View;

import Controller.PlayGameMenuController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CityPanel {
    public static URL cityPanelURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene cityPanelScene;

    private static HashMap<Button,Integer> buttonStringHashMap = new HashMap<>();
    private static ArrayList<Button> buttons = new ArrayList<>();
    private static ArrayList<HBox> hBoxes = new ArrayList<>();


    public void start() throws IOException {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        StringBuilder text = playGameMenuController.cityPanel(InfoPanel.tiles,InfoPanel.civilizations,InfoPanel.currentCivilization);
        String note = text.toString();

        String[] notes = note.split("\n");

        int index = 0,counter = 0;
        for(String str : notes){
            if(index == 0){
                index++;
                continue;
            }
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            Text text1 = new Text(str);
            text1.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(255, 0, 0);-fx-effect: innershadow( three-pass-box , rgba(0,255,0,0.93), 6, 0.0 , 0 , 2 );");
            /*
            -fx-font-size: 22;
    -fx-font-weight: bold;
    -fx-text-fill: rgb(255, 0, 0);
    -fx-effect: innershadow( three-pass-box , rgba(86, 255, 86, 0.56), 6, 0.0 , 0 , 2 );
             */
            hBox.getChildren().add(text1);
            Text temp = new Text("                              ");
            hBox.getChildren().add(temp);
            Button button = new Button("Page");
            button.setStyle("-fx-background-color: #ddd1e5;");
            buttons.add(button);
            buttonStringHashMap.put(button,counter);
            hBox.getChildren().add(button);
            hBoxes.add(hBox);
            vBox.getChildren().add(hBox);
            counter++;
        }

        BorderPane root = FXMLLoader.load(cityPanelURL);
        root.setCenter(vBox);

        for(Button button : buttons){
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        buttonClicked(button);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        cityPanelScene = new Scene(root);
        stage.setScene(cityPanelScene);
        stage.show();
    }

    public void buttonClicked(Button button) throws IOException {
        int index = buttonStringHashMap.get(button);
        CityPage.city = InfoPanel.currentCivilization.getCities().get(index);
        CityPage.cityPanelScene = cityPanelScene;
        CityPage.stage = stage;
        new CityPage().start();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }
}
