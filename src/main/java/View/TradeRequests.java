package View;

import Controller.PlayGameMenuController;
import Model.City;
import Model.Civilization;
import Model.FunctionsGson.ChangeFoodAmountGson;
import Model.FunctionsGson.ChangeGoldAmountGson;
import Model.FunctionsGson.ChangeResourceGson;
import Model.FunctionsGson.RejectMessageGson;
import Model.Resource;
import Model.Tile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
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


    public void start() throws IOException {

        vbox.setAlignment(Pos.CENTER);

        for(String text : InfoPanel.currentCivilization.getTrades()){
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);
            Label text1 = new Label(text);
            text1.setStyle("-fx-font-size: 19;-fx-font-weight: bold;-fx-text-fill: rgb(62,255,2);-fx-effect: innershadow( three-pass-box , rgba(21,250,13,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
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
                    try {
                        buttonClicked(button);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        tradeRequestsScene = new Scene(root);
        root.requestFocus();
        stage.setScene(tradeRequestsScene);
        stage.show();
    }

    public void buttonClicked(Button button) throws IOException {
        String regex = "(?<civilization>.*)- Need : (?<giveName>.*)\\((?<giveAmount>.*)\\) Payment : (?<needName>.*)\\((?<needAmount>.*)\\)";
        Matcher matcher = Pattern.compile(regex).matcher(buttonStringHashMap.get(button));
        matcher.find();

        if(Objects.equals(button.getText(), "Accept")){//Accept clicked

            String civilizationName = matcher.group("civilization");
            String giveName = matcher.group("giveName");
            String giveAmount = matcher.group("giveAmount");
            String needName = matcher.group("needName");
            String needAmount = matcher.group("needAmount");

            for(Civilization civilization : InfoPanel.civilizations){
                if(Objects.equals(civilization.getName(), civilizationName)){
                    if(Objects.equals(giveName, "Gold")){
                        int give = Integer.parseInt(giveAmount);
                        if(InfoPanel.currentCivilization.getGold() < give){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                        //else ...
                    }
                    else if(Objects.equals(giveName, "Food")){
                        int give = Integer.parseInt(giveAmount);
                        int totalFood = 0;
                        for(City city : InfoPanel.currentCivilization.getCities()){
                            totalFood += city.getTotalFood();
                        }
                        if(totalFood < give){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                        //else ...
                    }
                    else if(Objects.equals(giveName, "Resource")){
                        boolean flag = false;
                        for(City city : InfoPanel.currentCivilization.getCities()){
                            for(Tile tile : city.getTiles()){
                                if(tile.getResource() != null){
                                    if(Objects.equals(tile.getResource().getName(), giveAmount)){
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if(!flag){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                    }
                    //todo
                    if(Objects.equals(needName, "Gold")){
                        int need = Integer.parseInt(needAmount);
                        if(civilization.getGold() < need){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                        if(Objects.equals(giveName, "Gold")){
                            int give = Integer.parseInt(giveAmount);
                            InfoPanel.currentCivilization.setGold(need - give);
                            civilization.setGold(give - need);

                            ChangeGoldAmountGson changeGoldAmountGson = new ChangeGoldAmountGson();
                            changeGoldAmountGson.amount = need - give;
                            changeGoldAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            changeGoldAmountGson.member = InfoPanel.currentCivilization.getMember();
                            goldRequest("changeGold", changeGoldAmountGson);

                            changeGoldAmountGson.amount = give - need;
                            changeGoldAmountGson.civilizationName = civilization.getName();
                            goldRequest("changeGold", changeGoldAmountGson);

                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Food")){
                            int give = Integer.parseInt(giveAmount);
                            for(City city : civilization.getCities()){
                                city.setTotalFood(give / civilization.getCities().size());
                            }
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                city.setTotalFood(-give / civilization.getCities().size());
                            }
                            InfoPanel.currentCivilization.setGold(need);

                            ChangeFoodAmountGson changeFoodAmountGson = new ChangeFoodAmountGson();
                            changeFoodAmountGson.amount = give;
                            changeFoodAmountGson.civilizationName = civilization.getName();
                            changeFoodAmountGson.member = InfoPanel.currentCivilization.getMember();
                            foodRequest("changeFood", changeFoodAmountGson);

                            ChangeGoldAmountGson changeGoldAmountGson = new ChangeGoldAmountGson();
                            changeGoldAmountGson.amount = need;
                            changeGoldAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            goldRequest("changeGold", changeGoldAmountGson);

                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Resource")){
                            boolean flag = false;
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                for(Tile tile : city.getTiles()){
                                    if(tile.getResource() != null){
                                        if(Objects.equals(tile.getResource().getName(), giveAmount)){
                                            flag = true;
                                            for(City city1 : civilization.getCities()){
                                                for(Tile tile1 : city1.getTiles()){
                                                    if(tile1.getResource() == null) {
                                                        ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                        changeResourceGson.tileNumber = tile1.getTileNumber();
                                                        changeResourceGson.resourceName = tile.getResource().getName();
                                                        changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                        resourceRequest("changeResource", changeResourceGson);
                                                        tile1.addResource(new Resource(tile.getResource().getName()));
                                                        break;
                                                    }
                                                }
                                                tile.addResource(null);
                                                ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                changeResourceGson.tileNumber = tile.getTileNumber();
                                                changeResourceGson.resourceName = null;
                                                changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                resourceRequest("changeResource", changeResourceGson);

                                                InfoPanel.currentCivilization.setGold (need);
                                                ChangeGoldAmountGson changeGoldAmountGson = new ChangeGoldAmountGson();
                                                changeGoldAmountGson.amount = need;
                                                changeGoldAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                                                changeGoldAmountGson.member = InfoPanel.currentCivilization.getMember();
                                                goldRequest("changeGold", changeGoldAmountGson);
                                                civilization.setGold(-need);
                                                changeGoldAmountGson.amount = -need;
                                                changeGoldAmountGson.civilizationName = civilization.getName();
                                                goldRequest("changeGold", changeGoldAmountGson);

                                                removeRequest(button,true);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                            if(!flag){
                                transactionFailed();
                                removeRequest(button,true);
                                return;
                            }
                        }
                    }
                    //todo
                    else if(Objects.equals(needName, "Food")){
                        int need = Integer.parseInt(needAmount);
                        int totalFood = 0;
                        for(City city : civilization.getCities()){
                            totalFood += city.getTotalFood();
                        }
                        if(totalFood < need){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                        if(Objects.equals(giveName, "Gold")){
                            for(City city : civilization.getCities()){
                                city.setTotalFood(-need / civilization.getCities().size());
                            }
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                city.setTotalFood(need / civilization.getCities().size());
                            }
                            ChangeFoodAmountGson changeFoodAmountGson = new ChangeFoodAmountGson();
                            changeFoodAmountGson.amount = -need;
                            changeFoodAmountGson.civilizationName = civilization.getName();
                            changeFoodAmountGson.member = InfoPanel.currentCivilization.getMember();
                            foodRequest("changeFood", changeFoodAmountGson);

                            changeFoodAmountGson.amount = need;
                            changeFoodAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            foodRequest("changeFood", changeFoodAmountGson);

                            int give = Integer.parseInt(giveAmount);
                            InfoPanel.currentCivilization.setGold(-give);
                            civilization.setGold(give);
                            ChangeGoldAmountGson changeGoldAmountGson = new ChangeGoldAmountGson();
                            changeGoldAmountGson.amount = -give;
                            changeGoldAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            changeGoldAmountGson.member = InfoPanel.currentCivilization.getMember();
                            goldRequest("changeGold", changeGoldAmountGson);

                            changeGoldAmountGson.amount = give;
                            changeGoldAmountGson.civilizationName = civilization.getName();
                            goldRequest("changeGold", changeGoldAmountGson);

                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Food")){
                            int give = Integer.parseInt(giveAmount);

                            for(City city : civilization.getCities()){
                                city.setTotalFood(-need + give / civilization.getCities().size());
                            }
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                city.setTotalFood(need - give / civilization.getCities().size());
                            }

                            ChangeFoodAmountGson changeFoodAmountGson = new ChangeFoodAmountGson();
                            changeFoodAmountGson.amount = -need + give;
                            changeFoodAmountGson.civilizationName = civilization.getName();
                            changeFoodAmountGson.member = InfoPanel.currentCivilization.getMember();
                            foodRequest("changeFood", changeFoodAmountGson);

                            changeFoodAmountGson.amount = need - give;
                            changeFoodAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            foodRequest("changeFood", changeFoodAmountGson);

                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Resource")){
                            for(City city : civilization.getCities()){
                                city.setTotalFood(-need / civilization.getCities().size());
                            }
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                city.setTotalFood(need / civilization.getCities().size());
                            }

                            ChangeFoodAmountGson changeFoodAmountGson = new ChangeFoodAmountGson();
                            changeFoodAmountGson.amount = -need;
                            changeFoodAmountGson.civilizationName = civilization.getName();
                            changeFoodAmountGson.member = InfoPanel.currentCivilization.getMember();
                            foodRequest("changeFood", changeFoodAmountGson);

                            changeFoodAmountGson.amount = need;
                            changeFoodAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            foodRequest("changeFood", changeFoodAmountGson);

                            boolean flag = false;
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                for(Tile tile : city.getTiles()){
                                    if(tile.getResource() != null){
                                        if(Objects.equals(tile.getResource().getName(), giveAmount)){
                                            flag = true;
                                            for(City city1 : civilization.getCities()){
                                                for(Tile tile1 : city1.getTiles()){
                                                    if(tile1.getResource() == null) {
                                                        ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                        changeResourceGson.tileNumber = tile1.getTileNumber();
                                                        changeResourceGson.resourceName = tile.getResource().getName();
                                                        changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                        resourceRequest("changeResource", changeResourceGson);
                                                        tile1.addResource(new Resource(tile.getResource().getName()));
                                                        break;
                                                    }
                                                }
                                                tile.addResource(null);
                                                ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                changeResourceGson.tileNumber = tile.getTileNumber();
                                                changeResourceGson.resourceName = null;
                                                changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                resourceRequest("changeResource", changeResourceGson);
                                                removeRequest(button,true);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                            if(!flag){
                                transactionFailed();
                                removeRequest(button,true);
                                return;
                            }
                        }
                    }
                    //todo
                    else if(Objects.equals(needName, "Resource")){
                        boolean flag = false;
                        for(City city : civilization.getCities()){
                            for(Tile tile : city.getTiles()){
                                if(tile.getResource() != null){
                                    if(Objects.equals(tile.getResource().getName(), giveAmount)){
                                        flag = true;
                                        for(City city1 : InfoPanel.currentCivilization.getCities()){
                                            for(Tile tile1 : city1.getTiles()){
                                                if(tile1.getResource() == null) {
                                                    ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                    changeResourceGson.tileNumber = tile1.getTileNumber();
                                                    changeResourceGson.resourceName = tile.getResource().getName();
                                                    changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                    resourceRequest("changeResource", changeResourceGson);
                                                    tile1.addResource(new Resource(tile.getResource().getName()));
                                                    break;
                                                }
                                            }
                                            tile.addResource(null);
                                            ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                            changeResourceGson.tileNumber = tile.getTileNumber();
                                            changeResourceGson.resourceName = null;
                                            changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                            resourceRequest("changeResource", changeResourceGson);
                                            removeRequest(button,true);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        if(!flag){
                            transactionFailed();
                            removeRequest(button,true);
                            return;
                        }
                        if(Objects.equals(giveName, "Gold")){
                            int give = Integer.parseInt(giveAmount);
                            InfoPanel.currentCivilization.setGold(-give);

                            ChangeGoldAmountGson changeGoldAmountGson = new ChangeGoldAmountGson();
                            changeGoldAmountGson.amount = -give;
                            changeGoldAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            changeGoldAmountGson.member = InfoPanel.currentCivilization.getMember();
                            goldRequest("changeGold", changeGoldAmountGson);

                            changeGoldAmountGson.amount = give;
                            changeGoldAmountGson.civilizationName = civilization.getName();
                            goldRequest("changeGold", changeGoldAmountGson);

                            civilization.setGold(give);
                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Food")){
                            int give = Integer.parseInt(giveAmount);

                            for(City city : civilization.getCities()){
                                city.setTotalFood(give / civilization.getCities().size());
                            }
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                city.setTotalFood(-give / civilization.getCities().size());
                            }
                            ChangeFoodAmountGson changeFoodAmountGson = new ChangeFoodAmountGson();
                            changeFoodAmountGson.amount = give;
                            changeFoodAmountGson.civilizationName = civilization.getName();
                            changeFoodAmountGson.member = InfoPanel.currentCivilization.getMember();
                            foodRequest("changeFood", changeFoodAmountGson);

                            changeFoodAmountGson.amount = -give;
                            changeFoodAmountGson.civilizationName = InfoPanel.currentCivilization.getName();
                            foodRequest("changeFood", changeFoodAmountGson);

                            removeRequest(button,true);
                            return;
                        }
                        else if(Objects.equals(giveName, "Resource")){
                            boolean flag2 = false;
                            for(City city : InfoPanel.currentCivilization.getCities()){
                                for(Tile tile : city.getTiles()){
                                    if(tile.getResource() != null){
                                        if(Objects.equals(tile.getResource().getName(), giveAmount)){
                                            flag2 = true;
                                            for(City city1 : civilization.getCities()){
                                                for(Tile tile1 : city1.getTiles()){
                                                    if(tile1.getResource() == null) {
                                                        ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                        changeResourceGson.tileNumber = tile1.getTileNumber();
                                                        changeResourceGson.resourceName = tile.getResource().getName();
                                                        changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                        resourceRequest("changeResource", changeResourceGson);
                                                        tile1.addResource(new Resource(tile.getResource().getName()));
                                                        break;
                                                    }
                                                }
                                                tile.addResource(null);
                                                ChangeResourceGson changeResourceGson = new ChangeResourceGson();
                                                changeResourceGson.tileNumber = tile.getTileNumber();
                                                changeResourceGson.resourceName = null;
                                                changeResourceGson.member = InfoPanel.currentCivilization.getMember();
                                                resourceRequest("changeResource", changeResourceGson);
                                                removeRequest(button,true);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                            if(!flag2){
                                transactionFailed();
                                removeRequest(button,true);
                                return;
                            }
                        }
                    }
                }
            }
        }
        else {//Reject Clicked
            for(Civilization civilization : InfoPanel.civilizations){
                if(Objects.equals(civilization.getName(), matcher.group("civilization"))){
                    RejectMessageGson rejectMessageGson = new RejectMessageGson();
                    rejectMessageGson.civilization = civilization.getName();
                    rejectMessageGson.messageCivilization = InfoPanel.currentCivilization.getName();
                    rejectMessageGson.member = InfoPanel.currentCivilization.getMember();

                    Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
                    String request = gson.toJson(rejectMessageGson);

                    CreateHost.dataOutputStream.writeUTF("reject " + request);
                    CreateHost.dataOutputStream.flush();
/*
                    civilization.getMessages().add(PlayGameMenuController.turn + " : " + InfoPanel.currentCivilization.getName() + "- rejected your trade request !");
*/
                    break;
                }
            }
            removeRequest(button,false);
        }
    }
    public void transactionFailed(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("result :");
        alert.setContentText("transaction failed !");
        alert.showAndWait();
    }
    public void removeRequest(Button button,boolean accept){
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
                        if(!accept) {
                            buttons.remove(index - 1);
                            buttons.remove(index - 1);
                        }
                        else {
                            buttons.remove(index);
                            buttons.remove(index);
                        }
                        vbox.getChildren().remove(hBox);
                        InfoPanel.currentCivilization.getTrades().removeIf(text -> Objects.equals(text, buttonStringHashMap.get(button)));
                        return;
                    }
                }
                counter++;
            }
        }
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new TradePage().start();
    }

    public void goldRequest (String functionName, ChangeGoldAmountGson changeGoldAmountGson) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(changeGoldAmountGson);

        CreateHost.dataOutputStream.writeUTF(functionName + " " + request);
        CreateHost.dataOutputStream.flush();
    }

    public void foodRequest (String functionName, ChangeFoodAmountGson changeFoodAmountGson) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(changeFoodAmountGson);

        CreateHost.dataOutputStream.writeUTF(functionName + " " + request);
        CreateHost.dataOutputStream.flush();
    }

    public void resourceRequest (String functionName, ChangeResourceGson changeResourceGson) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(changeResourceGson);

        CreateHost.dataOutputStream.writeUTF(functionName + " " + request);
        CreateHost.dataOutputStream.flush();
    }
}
