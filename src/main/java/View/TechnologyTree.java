package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TechnologyTree {
    public static PlayGameMenuController playGameMenuController;
    public static Civilization playingCivilization;
    public static Scene technologyPanelScene;
    public static Stage stage;
    public Scene scene;
    public Pane pane = new Pane();
    private Button back = new Button("back");
    private Label technologyLabel = new Label();
    private TextField technologyField = new TextField();
    private Button learn = new Button("learn");
    private Button change = new Button("change");
    private ScrollPane container = new ScrollPane();
    private VBox vBox = new VBox(95);
    private ArrayList<HBox> hBoxes = new ArrayList<>();
    public static URL AcousticsURL;
    public static URL AgricultureURL;
    public static URL AnimalHusbandryURL;
    public static URL ArchaeologyURL;
    public static URL ArcheryURL;
    public static URL BankingURL;
    public static URL BiologyURL;
    public static URL BronzeWorkingURL;
    public static URL CalendarURL;
    public static URL ChemistryURL;
    public static URL ChivalryURL;
    public static URL CivilServiceURL;
    public static URL CombustionURL;
    public static URL ConstructionURL;
    public static URL CurrencyURL;
    public static URL DynamiteURL;
    public static URL EconomicsURL;
    public static URL EducationURL;
    public static URL ElectricityURL;
    public static URL EngineeringURL;
    public static URL FertilizerURL;
    public static URL GunpowderURL;
    public static URL HorsebackRidingURL;
    public static URL IronWorkingURL;
    public static URL MachineryURL;
    public static URL MasonryURL;
    public static URL MathematicsURL;
    public static URL MetalCastingURL;
    public static URL MetallurgyURL;
    public static URL MilitaryScienceURL;
    public static URL MiningURL;
    public static URL PhilosophyURL;
    public static URL PhysicsURL;
    public static URL PotteryURL;
    public static URL PrintingPressURL;
    public static URL RadioURL;
    public static URL RailroadURL;
    public static URL ReplaceablePartsURL;
    public static URL RiflingURL;
    public static URL ScientificTheoryURL;
    public static URL SteamPowerURL;
    public static URL SteelURL;
    public static URL TelegraphURL;
    public static URL TheologyURL;
    public static URL TheWheelURL;
    public static URL TrappingURL;
    public static URL WritingURL;


    public void initializeTechnologyTree(){
        vBox.setAlignment(Pos.CENTER);
        back.setOnMouseClicked(ev ->{
            stage.setScene(technologyPanelScene);
        });
        back.setPrefSize(100, 30);
        learn.setOnMouseClicked(event -> {
            String technologyName = technologyField.getText();
            String result = playGameMenuController.chooseTechnologyToLearn(playingCivilization, technologyName);
            technologyLabel.setText(result);
        });
        learn.setPrefSize(100, 30);
        technologyField.setPrefWidth(500);
        technologyField.setMaxWidth(500);
        technologyField.setPromptText("enter a technology to learn or change the current technology");
        change.setOnMouseClicked(event -> {
            String technologyName = technologyField.getText();
            String result = playGameMenuController.changeTechnologyToLearn(playingCivilization, technologyName);
            technologyLabel.setText(result);
        });
        change.setPrefSize(100, 30);
        container.setPrefSize(1280, 720);
        container.setContent(vBox);
        vBox.getChildren().add(back);
        vBox.getChildren().add(technologyLabel);
        vBox.getChildren().add(technologyField);
        vBox.getChildren().add(learn);
        vBox.getChildren().add(change);
        initializeTechnologies();
        pane.getChildren().addAll(container);
        scene = new Scene(pane);
        stage.setScene(scene);
    }

    private void initializeTechnologies(){
        ArrayList<Rectangle> techs = new ArrayList<>();
        for (int j = 0; j < 47; j++) {
            techs.add(new Rectangle(188, 188));
        }
        int i = 0;
        techs.get(i++).setFill(new ImagePattern(new Image(AcousticsURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(AgricultureURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(AnimalHusbandryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ArchaeologyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ArcheryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(BankingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(BiologyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(BronzeWorkingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(CalendarURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ChemistryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ChivalryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(CivilServiceURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(CombustionURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ConstructionURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(CurrencyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(DynamiteURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(EconomicsURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(EducationURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ElectricityURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(EngineeringURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(FertilizerURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(GunpowderURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(HorsebackRidingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(IronWorkingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MachineryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MasonryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MathematicsURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MetalCastingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MetallurgyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MilitaryScienceURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(MiningURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(PhilosophyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(PhysicsURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(PotteryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(PrintingPressURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(RadioURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(RailroadURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ReplaceablePartsURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(RiflingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(ScientificTheoryURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(SteamPowerURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(SteelURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(TelegraphURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(TheologyURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(TheWheelURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(TrappingURL.toExternalForm())));
        techs.get(i++).setFill(new ImagePattern(new Image(WritingURL.toExternalForm())));
        ArrayList<HBox> hBoxes = new ArrayList<>();
        for (int j = 0; j < 8; j++)
            hBoxes.add(new HBox(27));
        for (int j = 0; j < 8; j++)
            for (int k = 0; k < 6; k++) {
                if (6 * j + k == 47)
                    break;
                hBoxes.get(j).getChildren().add(techs.get(6 * j + k));
            }

        techPopUp(techs);
        for (int j = 0; j < 8; j++)
            vBox.getChildren().add(hBoxes.get(j));
    }

    private void techPopUp(ArrayList<Rectangle> techs){
        ArrayList<Alert> alerts = new ArrayList<>();
        for (int i = 0; i < 47; i++) {
            alerts.add(new Alert(Alert.AlertType.INFORMATION));
            alerts.get(i).setHeaderText("technology's information:");
        }
        ArrayList<String> alertMessages = new ArrayList<>();
        alertMessages.add("cost:\n650\nPrerequisite Techs:\nEducation\nLeads to Techs:\nScientific Theory");
        alertMessages.add("cost:\n20\nPrerequisite Techs:\nNone\nLeads to Techs:\nPottery\nAnimal Husbandry\nArchery\nMining");
        alertMessages.add("cost:\n35\nPrerequisite Techs:\nAgriculture\nLeads to Techs:\nTrapping\nThe Wheel");
        alertMessages.add("cost:\n1300\nPrerequisite Techs:\nAcoustics\nLeads to Techs:\nBiology");
        alertMessages.add("cost:\n35\nPrerequisite Techs:\nAgriculture\nLeads to Techs:\nMathematics");
        alertMessages.add("cost:\n650\nPrerequisite Techs:\nEducation\nChivalry\nLeads to Techs:\nEconomics");
        alertMessages.add("cost:\n1680\nPrerequisite Techs:\nArchaeology\nScientific Theory\nLeads to Techs:\nElectricity");
        alertMessages.add("cost:\n55\nPrerequisite Techs:\nMining\nLeads to Techs:\nIron Working");
        alertMessages.add("cost:\n70\nPrerequisite Techs:\nPottery\nLeads to Techs:\nTheology");
        alertMessages.add("cost:\n900\nPrerequisite Techs:\nGunPowder\nLeads to Techs:\nMilitary Science\nFertilizer");
        alertMessages.add("cost:\n440\nPrerequisite Techs:\nCivil Service\nHorseback Riding\nCurrency\nLeads to Techs:\nBanking");
        alertMessages.add("cost:\n400\nPrerequisite Techs:\nPhilosophy\nTrapping\nLeads to Techs:\nChivalry");
        alertMessages.add("cost:\n2200\nPrerequisite Techs:\nReplaceable Parts\nRailroad\nDynamite\nLeads to Techs:\nNone");
        alertMessages.add("cost:\n100\nPrerequisite Techs:\nMasonry\nLeads to Techs:\nEngineering");
        alertMessages.add("cost:\n250\nPrerequisite Techs:\nMathematics\nLeads to Techs:\nChivalry");
        alertMessages.add("cost:\n1900\nPrerequisite Techs:\nFertilizer\nRifling\nLeads to Techs:\nCombustion");
        alertMessages.add("cost:\n900\nPrerequisite Techs:\nBanking\nPrinting Press\nLeads to Techs:\nMilitary Science");
        alertMessages.add("cost:\n440\nPrerequisite Techs:\nTheology\nLeads to Techs:\nAcoustics\nBanking");
        alertMessages.add("cost:\n1900\nPrerequisite Techs:\nBiology\nSteam Power\nLeads to Techs:\nTelegraph\nRadio");
        alertMessages.add("cost:\n250\nPrerequisite Techs:\nMathematics\nConstruction\nLeads to Techs:\nMachinery\nPhysics");
        alertMessages.add("cost:\n1300\nPrerequisite Techs:\nChemistry\nLeads to Techs:\nDynamite");
        alertMessages.add("cost:\n680\nPrerequisite Techs:\nPhysics\nSteel\nLeads to Techs:\nChemistry\nMetallurgy");
        alertMessages.add("cost:\n100\nPrerequisite Techs:\nThe Wheel\nLeads to Techs:\nChivalry");
        alertMessages.add("cost:\n150\nPrerequisite Techs:\nBronze Working\nLeads to Techs:\nMetal Casting");
        alertMessages.add("cost:\n440\nPrerequisite Techs:\nEngineering\nLeads to Techs:\nPrinting Press");
        alertMessages.add("cost:\n55\nPrerequisite Techs:\nMining\nLeads to Techs:\nConstruction");
        alertMessages.add("cost:\n100\nPrerequisite Techs:\nThe Wheel\nLeads to Techs:\nCurrency\nEngineering");
        alertMessages.add("cost:\n240\nPrerequisite Techs:\nIron Working\nLeads to Techs:\nPhysics\nSteel");
        alertMessages.add("cost:\n900\nPrerequisite Techs:\nGun Powder\nLeads to Techs:\nRifling");
        alertMessages.add("cost:\n1300\nPrerequisite Techs:\nEconomics\nChemistry\nLeads to Techs:\nSteam Power");
        alertMessages.add("cost:\n35\nPrerequisite Techs:\nAgriculture\nLeads to Techs:\nMasonry\nBronze Working");
        alertMessages.add("cost:\n100\nPrerequisite Techs:\nWriting\nLeads to Techs:\nTheology\nCivil Service");
        alertMessages.add("cost:\n440\nPrerequisite Techs:\nEngineering\nMetal Casting\nLeads to Techs:\nPrinting Press\nGunpowder");
        alertMessages.add("cost:\n35\nPrerequisite Techs:\nAgriculture\nLeads to Techs:\nCalendar\nWriting");
        alertMessages.add("cost:\n650\nPrerequisite Techs:\nMachinery\nPhysics\nLeads to Techs:\nEconomics");
        alertMessages.add("cost:\n2200\nPrerequisite Techs:\nElectricity\nLeads to Techs:\nNone");
        alertMessages.add("cost:\n1900\nPrerequisite Techs:\nSteam Power\nLeads to Techs:\nCombustion");
        alertMessages.add("cost:\n1900\nPrerequisite Techs:\nSteam Power\nLeads to Techs:\nCombustion");
        alertMessages.add("cost:\n1425\nPrerequisite Techs:\nMetallurgy\nLeads to Techs:\nDynamite");
        alertMessages.add("cost:\n1300\nPrerequisite Techs:\nAcoustics\nLeads to Techs:\nBiology\nSteam Power");
        alertMessages.add("cost:\n1680\nPrerequisite Techs:\nScientific Theory\nMilitary Science\nLeads to Techs:\nElectricity\nReplaceable Parts\nRailroad");
        alertMessages.add("cost:\n440\nPrerequisite Techs:\nMetal Casting\nLeads to Techs:\nGunpowder");
        alertMessages.add("cost:\n2200\nPrerequisite Techs:\nElectricity\nLeads to Techs:\nNone");
        alertMessages.add("cost:\n250\nPrerequisite Techs:\nCalendar\nPhilosophy\nLeads to Techs:\nEducation");
        alertMessages.add("cost:\n55\nPrerequisite Techs:\nAnimal Husbandry\nLeads to Techs:\nHorseback Riding\nMathematics");
        alertMessages.add("cost:\n55\nPrerequisite Techs:\nAnimal Husbandry\nLeads to Techs:\nCivil Service");
        alertMessages.add("cost:\n55\nPrerequisite Techs:\nPottery\nLeads to Techs:\nPhilosophy");
        for (int i = 0; i < 47; i++)
            alerts.get(i).setContentText(alertMessages.get(i));
        for (int i = 0; i < 47; i++) {
            int finalI = i;
            techs.get(i).setOnMouseClicked(event -> {
                alerts.get(finalI).showAndWait();
            });
        }
    }

}
