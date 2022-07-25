package View;

import Model.Civilization;
import Model.FunctionsGson.RequestAnswerGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        label.setStyle("-fx-font-size: 35;-fx-font-weight: bold;-fx-text-fill: rgb(255,235,0);-fx-effect: innershadow( three-pass-box , rgba(255,252,77,0.8), 6, 0.0 , 0 , 2 );");
        label.setFont(new Font(25));
        vBox.getChildren().add(label);

        for(Civilization civilization : InfoPanel.currentCivilization.getFriendlyRequests()){
            HBox hBox = new HBox();
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            Label text = new Label(civilization.getName() + " : ");
            text.setStyle("-fx-font-size: 19;-fx-font-weight: bold;-fx-text-fill: rgb(62,255,2);-fx-effect: innershadow( three-pass-box , rgba(21,250,13,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
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
                        try {
                            acceptClicked(button);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        try {
                            rejectClicked(button);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        root.setCenter(vBox);

        diplomaticRequestsScene = new Scene(root);
        stage.setScene(diplomaticRequestsScene);
        stage.show();
    }

    public void acceptClicked(Button button) throws IOException {
        RequestAnswerGson requestAnswerGson = new RequestAnswerGson();
        requestAnswerGson.civilization = InfoPanel.currentCivilization;
        requestAnswerGson.civilizationName = buttonCivilizationHashMap.get(button).getName();
        requestAnswerGson.member = InfoPanel.currentCivilization.getMember();

        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(requestAnswerGson);

        CreateHost.dataOutputStream.writeUTF("acceptRequest " + request);
        CreateHost.dataOutputStream.flush();

        //InfoPanel.currentCivilization.acceptFriendlyRequest(buttonCivilizationHashMap.get(button));

        removeRequest(button);
    }
    public void rejectClicked(Button button) throws IOException {
        RequestAnswerGson requestAnswerGson = new RequestAnswerGson();
        requestAnswerGson.civilization = InfoPanel.currentCivilization;
        requestAnswerGson.civilizationName = buttonCivilizationHashMap.get(button).getName();
        requestAnswerGson.member = InfoPanel.currentCivilization.getMember();

        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(requestAnswerGson);

        CreateHost.dataOutputStream.writeUTF("declineRequest " + request);
        CreateHost.dataOutputStream.flush();

        //InfoPanel.currentCivilization.denyFriendlyRequest(buttonCivilizationHashMap.get(button));

        removeRequest(button);
    }
    public void removeRequest(Button button){
        vBox.getChildren().remove(buttonHBoxHashMap.get(button));
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new Messages().start();
    }
}
