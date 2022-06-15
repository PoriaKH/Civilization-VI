package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Diplomacy {
    public static URL diplomacyURL;
    public static Scene diplomaticsScene;
    public static Stage stage;

    public Scene diplomacyScene;

    private ComboBox<Civilization> civilizationCombo = new ComboBox<>();
    private ComboBox<Civilization> breakOathCombo = new ComboBox<>();
    private Civilization selectedCiv;
    private Civilization selectedOathBreak;

    public void start() throws IOException {
        int allies = 0;
        for(Civilization civilization : InfoPanel.currentCivilization.getFriends()){
            breakOathCombo.getItems().add(civilization);
            allies++;
        }

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Label label = new Label("choose the civilization that you want to be your allie");
        label.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(220,0,255);-fx-effect: innershadow( three-pass-box , rgba(206,13,252,0.8), 6, 0.0 , 0 , 2 );");
        vBox.getChildren().add(label);
        vBox.getChildren().add(civilizationCombo);
        Button button = new Button("Send Friendly Request");
        button.setStyle("-fx-pref-height: 35;-fx-font-size: 16;-fx-pref-width: 350;-fx-border-radius: 5;-fx-background-color: #56d079;");
//        button.setStyle("-fx-pref-height: 35;-fx-font-size: 16;-fx-border-radius: 5;-fx-background-color: #56d079;");
        vBox.getChildren().add(button);

        if(allies > 0) {
            Text text = new Text(" ");
            vBox.getChildren().add(text);
            Label label1 = new Label("Break Oath");
            label1.setFont(new Font(20));
            vBox.getChildren().add(label1);
            vBox.getChildren().add(breakOathCombo);
        }
        Button button1 = new Button("break the oath");
        if(allies > 0){
            vBox.getChildren().add(button1);
        }
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    breakOathClicked();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for(Civilization civilization : InfoPanel.civilizations){
            if(civilization != InfoPanel.currentCivilization){
                civilizationCombo.getItems().add(civilization);
            }
        }
        civilizationCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedCiv = civilizationCombo.getSelectionModel().getSelectedItem();
            }
        });
        breakOathCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedOathBreak = breakOathCombo.getSelectionModel().getSelectedItem();
            }
        });
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(selectedCiv == null){
                    showAlert("you must choose the civilization first");
                    return;
                }
                for(Civilization tempCiv : selectedCiv.getFriendlyRequests()){
                    if(tempCiv == InfoPanel.currentCivilization) {
                        showAlert("you have already sent this request");
                        return;
                    }
                }
                for(Civilization tempCiv : selectedCiv.getFriends()){
                    if(tempCiv == InfoPanel.currentCivilization){
                        showAlert("this civilization is already your allie");
                        return;
                    }
                }
                selectedCiv.getFriendlyRequests().add(InfoPanel.currentCivilization);
                try {
                    new Diplomatics().start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        BorderPane root = FXMLLoader.load(diplomacyURL);

        root.setCenter(vBox);

        diplomacyScene = new Scene(root);
        stage.setScene(diplomacyScene);
        stage.show();
    }
    public void breakOathClicked() throws IOException {
        if(selectedOathBreak == null) {
            showAlert("you must choose the civilization you want to break oath with!");
            return;
        }

        InfoPanel.currentCivilization.breakTheOath(selectedOathBreak);
        new Diplomatics().start();
    }

    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
//        alert.setHeaderText("result :");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Diplomatics().start();
    }
}
