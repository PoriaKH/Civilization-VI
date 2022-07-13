package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TechnologyTree {
    public static PlayGameMenuController playGameMenuController;
    public static Civilization playingCivilization;
    public static URL technologyTreeURL;
    public static Scene technologyPanelScene;
    public static Stage stage;
    public Scene scene;
    public Pane pane = new Pane();
    private final Button back = new Button("back");
    private Label technologyLabel = new Label();
    private TextField technologyField = new TextField("enter a technology to learn or change the current technology");
    private Button learn = new Button("learn");
    private Button change = new Button("change");
    private ScrollPane container = new ScrollPane();
    private VBox vBox = new VBox(100);
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
            hBoxes.add(new HBox(30));
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 6; k++)
                hBoxes.get(j).getChildren().add(techs.get(j * k));
            vBox.getChildren().add(hBoxes.get(j));
        }
    }

}
