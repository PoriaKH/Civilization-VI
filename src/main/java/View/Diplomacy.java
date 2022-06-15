package View;

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
    private Civilization selectedCiv;

    public void start() throws IOException {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Label label = new Label("choose the civilization that you want to be your allie");
        vBox.getChildren().add(label);
        vBox.getChildren().add(civilizationCombo);
        Button button = new Button("Send Friendly Request");
        vBox.getChildren().add(button);

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
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(selectedCiv == null){
                    showAlert("you must choose the civilization first");
                }
                for(Civilization tempCiv : selectedCiv.getFriendlyRequests()){
                    if(tempCiv == InfoPanel.currentCivilization) {
                        showAlert("you have already sent this request");
                        break;
                    }
                }
                for(Civilization tempCiv : selectedCiv.getFriends()){
                    if(tempCiv == InfoPanel.currentCivilization){
                        showAlert("this civilization is already your allie");
                        break;
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
    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("result :");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
