package View;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class BuildingsPage {
    private int selected = -1;//  -1 means not selected

    public static URL buildingPageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene buildingPageScene;

    @FXML
    public Text gold;
    @FXML
    public TextField tileNumber;
    @FXML
    public Text message;

    @FXML
    public Button StockExchange;//34
    @FXML
    public Button MilitaryBase;//33
    @FXML
    public Button Hospital;//32
    @FXML
    public Button Factory;//31
    @FXML
    public Button BroadcastTower;//30
    @FXML
    public Button Arsenal;//29
    @FXML
    public Button Windmill;//28
    @FXML
    public Button Theater;//27
    @FXML
    public Button SatrapsCourt;//26
    @FXML
    public Button PublicSchool;//25
    @FXML
    public Button OperaHouse;//24
    @FXML
    public Button Museum;//23
    @FXML
    public Button MilitaryAcademy;//22
    @FXML
    public Button Bank;//21
    @FXML
    public Button Workshop;//20
    @FXML
    public Button University;//19
    @FXML
    public Button Monastery;//18
    @FXML
    public Button Mint;//17
    @FXML
    public Button Market;//16
    @FXML
    public Button Garden;//15
    @FXML
    public Button Forge;//14
    @FXML
    public Button Castle;//13
    @FXML
    public Button Temple;//12
    @FXML
    public Button Stable;//11
    @FXML
    public Button Courthouse;//10
    @FXML
    public Button Colosseum;//9
    @FXML
    public Button Circus;//8
    @FXML
    public Button BurialTomb;//7
    @FXML
    public Button Armory;//6
    @FXML
    public Button WaterMill;//5
    @FXML
    public Button Walls;//4
    @FXML
    public Button Monument;//3
    @FXML
    public Button Library;//2
    @FXML
    public Button Granary;//1
    @FXML
    public Button Barracks;//0

    public ArrayList<Button> buttons = new ArrayList<>();

    public void initialize(){
        gold.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 20));
        gold.setFill(new Color(1,0.68,0,1));
        gold.setText("Gold : " + String.valueOf(InfoPanel.currentCivilization.getGold()));

        buttons.add(Barracks);
        buttons.add(Granary);
        buttons.add(Library);
        buttons.add(Monument);
        buttons.add(Walls);
        buttons.add(WaterMill);
        buttons.add(Armory);
        buttons.add(BurialTomb);
        buttons.add(Circus);
        buttons.add(Colosseum);
        buttons.add(Courthouse);
        buttons.add(Stable);
        buttons.add(Temple);
        buttons.add(Castle);
        buttons.add(Forge);
        buttons.add(Garden);
        buttons.add(Market);
        buttons.add(Mint);
        buttons.add(Monastery);
        buttons.add(University);
        buttons.add(Workshop);
        buttons.add(Bank);
        buttons.add(MilitaryAcademy);
        buttons.add(Museum);
        buttons.add(OperaHouse);
        buttons.add(PublicSchool);
        buttons.add(SatrapsCourt);
        buttons.add(Theater);
        buttons.add(Windmill);
        buttons.add(Arsenal);
        buttons.add(BroadcastTower);
        buttons.add(Factory);
        buttons.add(Hospital);
        buttons.add(MilitaryBase);
        buttons.add(StockExchange);

        for(Button button : buttons){
            boolean technologyFlag = false;
            boolean goldFlag = false;
            Building building = new Building(button.getText(),null,null);
            if(building.getRequiredTechnology() == null)
                technologyFlag = true;
            if(building.getRequiredTechnology() != null){
                for(Technology technology : InfoPanel.currentCivilization.getTechnologies()){
                    if(Objects.equals(building.getRequiredTechnology().getName(), technology.getName())){
                        technologyFlag = true;
                        break;
                    }
                }
            }
            if(!technologyFlag){
                button.setTooltip(new Tooltip("you don't have the required technology ! (" + building.getRequiredTechnology().getName() + ")"));
                continue;
            }
            if(InfoPanel.currentCivilization.getGold() >= building.getCost()){
                goldFlag = true;
            }
            if(!goldFlag){
                button.setTooltip(new Tooltip("you don't have enough gold !"));
                continue;
            }
        }

    }

    public void start() throws IOException {
        BorderPane borderPane = FXMLLoader.load(buildingPageURL);
        buildingPageScene = new Scene(borderPane);
        stage.setScene(buildingPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }

    public void BarracksClicked(MouseEvent mouseEvent) {
        buildingClicked(0);
    }
    public void GranaryClicked(MouseEvent mouseEvent) {
        buildingClicked(1);
    }

    public void LibraryClicked(MouseEvent mouseEvent) {
        buildingClicked(2);
    }

    public void MonumentClicked(MouseEvent mouseEvent) {
        buildingClicked(3);
    }

    public void WallsClicked(MouseEvent mouseEvent) {
        buildingClicked(4);
    }

    public void WaterMillClicked(MouseEvent mouseEvent) {
        buildingClicked(5);
    }

    public void ArmoryClicked(MouseEvent mouseEvent) {
        buildingClicked(6);
    }

    public void BurialTombClicked(MouseEvent mouseEvent) {
        buildingClicked(7);
    }

    public void CircusClicked(MouseEvent mouseEvent) {
        buildingClicked(8);
    }

    public void ColosseumClicked(MouseEvent mouseEvent) {
        buildingClicked(9);
    }

    public void CourthouseClicked(MouseEvent mouseEvent) {
        buildingClicked(10);
    }

    public void StableClicked(MouseEvent mouseEvent) {
        buildingClicked(11);
    }

    public void TempleClicked(MouseEvent mouseEvent) {
        buildingClicked(12);
    }

    public void CastleClicked(MouseEvent mouseEvent) {
        buildingClicked(13);
    }

    public void ForgeClicked(MouseEvent mouseEvent) {
        buildingClicked(14);
    }

    public void GardenClicked(MouseEvent mouseEvent) {
        buildingClicked(15);
    }

    public void MarketClicked(MouseEvent mouseEvent) {
        buildingClicked(16);
    }

    public void MintClicked(MouseEvent mouseEvent) {
        buildingClicked(17);
    }

    public void MonasteryClicked(MouseEvent mouseEvent) {
        buildingClicked(18);
    }

    public void UniversityClicked(MouseEvent mouseEvent) {
        buildingClicked(19);
    }

    public void WorkshopClicked(MouseEvent mouseEvent) {
        buildingClicked(20);
    }

    public void BankClicked(MouseEvent mouseEvent) {
        buildingClicked(21);
    }

    public void MilitaryAcademyClicked(MouseEvent mouseEvent) {
        buildingClicked(22);
    }

    public void MuseumClicked(MouseEvent mouseEvent) {
        buildingClicked(23);
    }

    public void OperaHouseClicked(MouseEvent mouseEvent) {
        buildingClicked(24);
    }

    public void PublicSchoolClicked(MouseEvent mouseEvent) {
        buildingClicked(25);
    }

    public void SatrapsCourtClicked(MouseEvent mouseEvent) {
        buildingClicked(26);
    }

    public void TheaterClicked(MouseEvent mouseEvent) {
        buildingClicked(27);
    }

    public void WindmillClicked(MouseEvent mouseEvent) {
        buildingClicked(28);
    }

    public void ArsenalClicked(MouseEvent mouseEvent) {
        buildingClicked(29);
    }

    public void BroadcastTowerClicked(MouseEvent mouseEvent) {
        buildingClicked(30);
    }

    public void FactoryClicked(MouseEvent mouseEvent) {
        buildingClicked(31);
    }

    public void HospitalClicked(MouseEvent mouseEvent) {
        buildingClicked(32);
    }

    public void MilitaryBaseClicked(MouseEvent mouseEvent) {
        buildingClicked(33);
    }

    public void StockExchangeClicked(MouseEvent mouseEvent) {
        buildingClicked(34);
    }

    public void buildingClicked(int index) {
        if(selected != -1) {
            buttons.get(selected).setDisable(false);
            selected = -1;
        }

        if (buttons.get(index).getTooltip() == null) {
            selected = index;
            buttons.get(index).setDisable(true);
        }
    }

    public void purchaseClicked(MouseEvent mouseEvent) {
        if(selected == -1){
            message.setText("please first select a building");
            return;
        }
        else if(tileNumber == null){
            message.setText("invalid tile number");
            return;
        }
        else if(!tileNumber.getText().matches("\\d+")){
            message.setText("invalid tile number");
            return;
        }
        else if(Integer.parseInt(tileNumber.getText()) > 71){
            message.setText("invalid tile number");
            return;
        }
        else if(!doesTileBelongToCivilization(Integer.parseInt(tileNumber.getText()))){
            message.setText("this tile doesn't belong to your civilization !");
            return;
        }
        else if(doesBuildingAlreadyExists(Integer.parseInt(tileNumber.getText()))){
            message.setText("a building already exists in this tile");
        }
        else {
            Building building = new Building(buttons.get(selected).getText(),InfoPanel.currentCivilization,InfoPanel.tiles.get(Integer.parseInt(tileNumber.getText())));
            InfoPanel.currentCivilization.setGold(-building.getCost());
            InfoPanel.tiles.get(Integer.parseInt(tileNumber.getText())).addBuilding(building);
            buttons.get(selected).setDisable(false);
            selected = -1;
            gold.setText("Gold : " + String.valueOf(InfoPanel.currentCivilization.getGold()));
            message.setText("purchase successful !");
        }
    }

    private boolean doesBuildingAlreadyExists(int number) {
        for(Tile tile : InfoPanel.tiles){
            if(tile.getTileNumber() == number){
                if(tile.getBuilding() != null)
                    return true;
            }
        }
        return false;
    }

    private boolean doesTileBelongToCivilization(int number) {
        for(City city : InfoPanel.currentCivilization.getCities()){
            for(Tile tile : city.getTiles()){
                if(tile.getTileNumber() == number)
                    return true;
            }
        }
        return false;
    }
}
