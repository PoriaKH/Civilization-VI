package View;

import Model.Civilization;
import Model.Technology;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class SendTradeRequest {

    private ArrayList<String> resourceNames = new ArrayList<>();

    public static URL sendTradeRequestURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene sendTradeRequestScene;

    @FXML
    public Text finalMessage;
    @FXML
    public Text needError;
    @FXML
    public Text giveError;
    @FXML
    public Text civilizationError;
    @FXML
    public Button tradeButton;

    private int selectedCivilization = -1;
    private int selectedNeed = -1;
    private int selectedGive = -1;

    private String selectedCivilizationName;
    private String selectedNeedName;
    private String selectedGiveName;

    @FXML
    public ComboBox<String> civilizationCombo = new ComboBox<>();
    @FXML
    public ComboBox<String> needCombo = new ComboBox<>();
    @FXML
    public ComboBox<String> giveCombo = new ComboBox<>();
    @FXML
    public TextField needTextField;
    @FXML
    public TextField giveTextField;


    public void initialize(){
        for(Civilization civilization : InfoPanel.civilizations){
            if(civilization != InfoPanel.currentCivilization){
                civilizationCombo.getItems().add(civilization.getName());
            }
        }

        needCombo.getItems().add("Food");
        needCombo.getItems().add("Gold");
        needCombo.getItems().add("Resource");

        giveCombo.getItems().add("Food");
        giveCombo.getItems().add("Gold");
        giveCombo.getItems().add("Resource");

        resourceNames.add("Cotton");
        resourceNames.add("Color");
        resourceNames.add("Fur");
        resourceNames.add("Gem");
        resourceNames.add("Gold");
        resourceNames.add("Gas");
        resourceNames.add("Tusk");
        resourceNames.add("Marble");
        resourceNames.add("Silk");
        resourceNames.add("Silver");
        resourceNames.add("Sugar");

    }

    public void start() throws IOException {

        BorderPane root = FXMLLoader.load(sendTradeRequestURL);
        sendTradeRequestScene = new Scene(root);
        stage.setScene(sendTradeRequestScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new TradePage().start();
    }

    public void civilizationComboAction(ActionEvent event) {
        int selectedIndex = civilizationCombo.getSelectionModel().getSelectedIndex();
        selectedCivilization = selectedIndex;
    }

    public void needComboAction(ActionEvent event) {
        selectedNeed = needCombo.getSelectionModel().getSelectedIndex();
        switch (selectedNeed){
            case 0:
                selectedNeedName = "Food";
                needTextField.setPromptText("enter the amount of food");
                break;
            case 1:
                selectedNeedName = "Gold";
                needTextField.setPromptText("enter the amount of gold");
                break;
            case 2:
                selectedNeedName = "Resource";
                needTextField.setPromptText("enter the name of resource");
                break;
        }
    }

    public void giveComboAction(ActionEvent event) {
        selectedGive = giveCombo.getSelectionModel().getSelectedIndex();
        switch (selectedGive){
            case 0:
                selectedGiveName = "Food";
                giveTextField.setPromptText("enter the amount of food");
                break;
            case 1:
                selectedGiveName = "Gold";
                giveTextField.setPromptText("enter the amount of gold");
                break;
            case 2:
                selectedGiveName = "Resource";
                giveTextField.setPromptText("enter the name of resource");
                break;
        }
    }

    public void tradeClicked(MouseEvent mouseEvent) throws IOException {
        if(selectedCivilization == -1){
            civilizationError.setText("you must select this field");
            return;
        }
        civilizationError.setText("");
        if(selectedNeed == -1){
            needError.setText("you must select this field");
            return;
        }
        needError.setText("");
        if(selectedGive == -1){
            giveError.setText("you must select this field");
            return;
        }
        giveError.setText("");
        if(Objects.equals(needTextField.getText(), "")){
            needError.setText("you must fill in the blank");
            return;
        }
        needError.setText("");
        if(Objects.equals(giveTextField.getText(), "")){
            giveError.setText("you must fill in the blank");
            return;
        }
        giveError.setText("");
        if(selectedNeed != 2){
            if(!needTextField.getText().matches("\\d+")){
                needError.setText("this must be only number");
                return;
            }
        }
        needError.setText("");
        if(selectedNeed == 2){
            boolean flag = false;
            for(String name : resourceNames){
                if(Objects.equals(name, needTextField.getText())){
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                needError.setText("there is no luxury resource with this name");
            }
            return;
        }
        needError.setText("");
        if(selectedGive != 2){
            if(!giveTextField.getText().matches("\\d+")){
                giveError.setText("this must be only number");
                return;
            }
        }
        giveError.setText("");
        if(selectedGive == 2){
            boolean flag = false;
            for(String name : resourceNames){
                if(Objects.equals(name, giveTextField.getText())){
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                giveError.setText("there is no luxury resource with this name");
                return;
            }
        }

        civilizationError.setText("");
        needError.setText("");
        giveError.setText("");

        for(Civilization civilization : InfoPanel.civilizations){
            if(civilization == InfoPanel.civilizations.get(selectedCivilization)){
                civilization.getTrades().add(InfoPanel.currentCivilization.getName() + "- " + "Need : " + selectedNeedName + "(" + needTextField.getText() + ") Payment : " + selectedGiveName + "(" + giveTextField.getText() + ")");
                System.out.println(civilization.getTrades().get(civilization.getTrades().size() - 1));
            }
        }
        finalMessage.setText("your request has been sent successfully");

        new TradePage().start();
    }
}
