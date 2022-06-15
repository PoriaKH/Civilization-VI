package View;

import Model.Civilization;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
import java.util.Objects;

public class DiplomaticRequests {
    public static URL diplomaticRequestsURL;
    public static Scene messagesScene;
    public static Stage stage;

    public Scene diplomaticRequestsScene;

    private HashMap<Button,Civilization> buttonCivilizationHashMap = new HashMap<>();
    private HashMap<Button,HBox> buttonHBoxHashMap = new HashMap<>();

    private ArrayList<Button> buttons = new ArrayList<>();

    private ArrayList<HBox> hBoxes = new ArrayList<>();
    private VBox vBox = new VBox();

    public void start() throws IOException {


        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        Label label = new Label("Friendly Requests");
        label.setFont(new Font(25));
        vBox.getChildren().add(label);

        for(Civilization civilization : InfoPanel.currentCivilization.getFriendlyRequests()){
            HBox hBox = new HBox();
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            Text text = new Text(civilization.getName() + " : ");
            hBox.getChildren().add(text);
            Button accept = new Button("Accept");
            Button reject = new Button("Reject");
            buttons.add(accept);
            buttons.add(reject);
            hBox.getChildren().add(accept);
            hBox.getChildren().add(reject);
            buttonCivilizationHashMap.put(accept,civilization);
            buttonCivilizationHashMap.put(reject,civilization);
            buttonHBoxHashMap.put(accept,hBox);
            buttonHBoxHashMap.put(reject,hBox);
            vBox.getChildren().add(hBox);
            hBoxes.add(hBox);
        }

        BorderPane root = FXMLLoader.load(diplomaticRequestsURL);

        for(Button button : buttons){
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(Objects.equals(button.getText(), "Accept")){
                        acceptClicked(button);
                    }
                    else {
                        rejectClicked(button);
                    }
                }
            });
        }

        root.setCenter(vBox);

        diplomaticRequestsScene = new Scene(root);
        stage.setScene(diplomaticRequestsScene);
        stage.show();
    }

    public void acceptClicked(Button button) {
        InfoPanel.currentCivilization.acceptFriendlyRequest(buttonCivilizationHashMap.get(button));
        removeRequest(button);
    }
    public void rejectClicked(Button button){
        InfoPanel.currentCivilization.denyFriendlyRequest(buttonCivilizationHashMap.get(button));
        removeRequest(button);
    }
    public void removeRequest(Button button){
        vBox.getChildren().remove(buttonHBoxHashMap.get(button));
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Messages().start();
    }
}
