package View;

import Controller.PlayGameMenuController;
import Model.Citizen;
import Model.City;
import Model.Civilization;
import Model.Tile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class CityPage {
    public static URL flag1URL;
    public static URL flag2URL;
    public static URL flag3URL;
    public static URL flag4URL;
    public static URL flag5URL;

    public static City city;

    public static URL cityPageURL;
    public static Scene cityPanelScene;
    public static Stage stage;

    public Scene cityPageScene;

    private ArrayList<ComboBox<Integer>> comboBoxes = new ArrayList<>();
    private ArrayList<Integer> tileNumbers = new ArrayList<>();

    public void start() throws IOException {



        int index = 0;
        for(Civilization civilization : InfoPanel.civilizations){
            if(Objects.equals(InfoPanel.currentCivilization.getName(), civilization.getName()))
                break;
            index++;
        }
        URL chosenFlag;

        if(index == 0)
            chosenFlag = flag1URL;
        else if(index == 1)
            chosenFlag = flag2URL;
        else if(index == 2)
            chosenFlag = flag3URL;
        else if(index == 3)
            chosenFlag = flag4URL;
        else
            chosenFlag = flag5URL;

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(100,100);
        rectangle.setFill(new ImagePattern(new Image(String.valueOf(chosenFlag))));
        vBox.getChildren().add(rectangle);
        Text tempText1 = new Text(" ");
        Text tempText2 = new Text(" ");
        Text tempText3 = new Text(" ");
        vBox.getChildren().add(tempText1);
        vBox.getChildren().add(tempText2);
        int pop = 0;
        for(Tile tile : city.getTiles()){
            if(tile.getCitizen() != null){
                pop++;
            }
        }
        Label population = new Label("Population : " + pop);
        population.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        Label gold = new Label("Gold : " + city.getGold());
        gold.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        Label food = new Label("Food : " + city.getFood());
        food.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        Label production = new Label("Production : " + city.getProduction());
        production.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        Label science = new Label("Science : " + city.getSciencePerTurn());
        science.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        Label defenceStr = new Label("DefenceStrength : " + city.getDefenceStrength());
        defenceStr.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b\"");
        StringBuilder resource = new StringBuilder("");
        for(Tile tile : city.getTiles()){
            if(tile.getResource() != null){
                resource.append(tile.getResource().getName());
                resource.append(",");
            }
        }
        Label resources = new Label("Resources : " + resource);
        resources.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(240,255,0);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");


        vBox.getChildren().add(population);
        vBox.getChildren().add(gold);
        vBox.getChildren().add(food);
        vBox.getChildren().add(production);
        vBox.getChildren().add(science);
        vBox.getChildren().add(defenceStr);
        vBox.getChildren().add(resources);
        vBox.getChildren().add(tempText3);

        Label label = new Label("Select the tiles that you want to work on :");
        label.setStyle("-fx-font-size: 22;-fx-font-weight: bold;-fx-text-fill: rgb(8,250,24);-fx-effect: innershadow( three-pass-box , rgba(162,154,21,0.8), 6, 0.0 , 0 , 2 );-fx-background-color: #242f1b");
        vBox.getChildren().add(label);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        for(int i = 0; i < city.getCitizens().size(); i++){
            ComboBox<Integer> comboBox = new ComboBox<>();
            for(Tile tile : city.getTiles()){
                comboBox.getItems().add(tile.getTileNumber());
            }
            comboBoxes.add(comboBox);
            hBox.getChildren().add(comboBox);
            tileNumbers.add(-1);
        }

        for(ComboBox<Integer> comboBox : comboBoxes){
            int indx = 0;
            for(ComboBox<Integer> comboBox1 : comboBoxes){
                if(comboBox1 == comboBox)
                    break;
                indx++;
            }
            int finalIndx = indx;
            comboBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    comboClicked(event, finalIndx,tileNumbers);
                }
            });
        }
        vBox.getChildren().add(hBox);
        Button button = new Button("Work");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    workClicked();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        vBox.getChildren().add(button);
        BorderPane root = FXMLLoader.load(cityPageURL);
        root.setCenter(vBox);

        cityPageScene = new Scene(root);
        stage.setScene(cityPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new CityPanel().start();
    }
    public void comboClicked(ActionEvent event,int index,ArrayList<Integer> tileNumbers){
        int selected = comboBoxes.get(index).getSelectionModel().getSelectedItem();
        tileNumbers.set(index,selected);
    }
    public void workClicked() throws IOException {
        for(Integer integer : tileNumbers){
            if(integer == -1){
                showAlert("you must fill all the blanks !");
                return;
            }
        }
        for(int i = 0; i < tileNumbers.size(); i++){
            for(int j = 0; j < tileNumbers.size(); j++){
                if(j == i)
                    continue;
                if(Objects.equals(tileNumbers.get(i), tileNumbers.get(j))){
                    showAlert("tile numbers can't be the same !");
                    return;
                }
            }
        }
        ArrayList<Citizen> citizens = city.getCitizens();
        for(Tile tile : city.getTiles()){
            if(tile.getCitizen() != null){
                tile.setCitizen(null);
            }
        }
        int counter = 0;
        for(Integer integer : tileNumbers){
            InfoPanel.tiles.get(integer).setCitizen(citizens.get(counter));
            citizens.get(counter).setTile(InfoPanel.tiles.get(integer));
            counter++;
        }
        new CityPanel().start();
    }
    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("result :");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
