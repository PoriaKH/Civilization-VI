package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeRequests {
    public static URL tradeRequestsURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene tradeRequestsScene;

    private static HashMap<Button,String> buttonStringHashMap = new HashMap<>();
    private static ArrayList<Button> buttons = new ArrayList<>();
    private static ArrayList<HBox> hBoxes = new ArrayList<>();



    public static VBox vbox = new VBox();

//    public void initialize(){
//        for(String text : InfoPanel.currentCivilization.getTrades()){
//            HBox hBox = new HBox();
//            hBox.setAlignment(Pos.CENTER);
//            hBox.setSpacing(10);
//            Text text1 = new Text(text);
//            hBox.getChildren().add(text1);
//            Button acceptButton = new Button("Accept");
//            Button rejectButton = new Button("Reject");
//            buttonStringHashMap.put(acceptButton,text);
//            buttonStringHashMap.put(rejectButton,text);
//            TradeRequests.buttons.add(acceptButton);
//            TradeRequests.buttons.add(rejectButton);
//            Text text2 = new Text("                                                                                ");
//            hBox.getChildren().add(text2);
//
//            hBox.getChildren().add(acceptButton);
//            hBox.getChildren().add(rejectButton);
//
//            hBoxes.add(hBox);
//            TradeRequests.vbox.getChildren().add(hBox);
//        }
//    }

    public void start() throws IOException {

        vbox.setAlignment(Pos.CENTER);

        for(String text : InfoPanel.currentCivilization.getTrades()){
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);
            Text text1 = new Text(text);
            hBox.getChildren().add(text1);
            Button acceptButton = new Button("Accept");
            Button rejectButton = new Button("Reject");
            buttonStringHashMap.put(acceptButton,text);
            buttonStringHashMap.put(rejectButton,text);
            TradeRequests.buttons.add(acceptButton);
            TradeRequests.buttons.add(rejectButton);
            Text text2 = new Text("                                                                                ");
            hBox.getChildren().add(text2);

            hBox.getChildren().add(acceptButton);
            hBox.getChildren().add(rejectButton);

            hBoxes.add(hBox);
            TradeRequests.vbox.getChildren().add(hBox);
        }

        BorderPane root = FXMLLoader.load(tradeRequestsURL);

        root.setCenter(vbox);

        for(Button button : buttons){
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    buttonClicked(button);
                }
            });
        }

        tradeRequestsScene = new Scene(root);
        root.requestFocus();
        stage.setScene(tradeRequestsScene);
        stage.show();
    }

    public void buttonClicked(Button button){
        String regex = "(?<civilization>.*)- Need : (?<giveName>.*)\\((?<giveAmount>.*)\\) Payment : (?<needName>.*)\\((?<needAmount>.*)\\)";
        Matcher matcher = Pattern.compile(regex).matcher(buttonStringHashMap.get(button));
        matcher.find();

        if(Objects.equals(button.getText(), "Accept")){//Accept clicked

        }
        else {//Reject Clicked
            for(Civilization civilization : InfoPanel.civilizations){
                if(Objects.equals(civilization.getName(), matcher.group("civilization"))){
                    civilization.getMessages().add(PlayGameMenuController.turn + " : " + InfoPanel.currentCivilization.getName() + "- rejected your trade request !");
                    break;
                }
            }
            for(HBox hBox : hBoxes){
                int counter = 0;
                for(Node node : hBox.getChildren()) {
                    if (counter != 0 && counter != 1) {
                        if ((Button) node == button) {
                            int index = 0;
                            for (Button button1 : buttons) {
                                if (button1 == button) {
                                    break;
                                }
                                index++;
                            }
                            buttons.remove(index - 1);
                            buttons.remove(index - 1);
                            vbox.getChildren().remove(hBox);
                            InfoPanel.currentCivilization.getTrades().removeIf(text -> Objects.equals(text, buttonStringHashMap.get(button)));
                            return;
                        }
                    }
                    counter++;
                }
            }
        }
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new TradePage().start();
    }
}
