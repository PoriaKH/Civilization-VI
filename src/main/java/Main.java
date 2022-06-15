import Model.Tile;
import Model.Units.Unit;
import View.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        UnitPanel.untPanelURL = new URL(Main.class.getResource("fxml/unitPanel.fxml").toExternalForm());
        Tile.roadURL = new URL(Main.class.getResource("pictures/Road.png").toExternalForm());
        Tile.railURL = new URL(Main.class.getResource("pictures/Railroad.png").toExternalForm());
        CheatMenu.cheatMenuURL = new URL(Main.class.getResource("fxml/cheatMenu.fxml").toExternalForm());
        VictoryImprovement.victoryImprovementURL = new URL(Main.class.getResource("fxml/victoryImprovement.fxml").toExternalForm());
        GeneralUnitPanel.generalUnitPanelURL = new URL(Main.class.getResource("fxml/generalUnitPanel.fxml").toExternalForm());
        InfoPanel.infoPanelURL = new URL(Main.class.getResource("fxml/infoPanel.fxml").toExternalForm());
        LoginMenu.mainMenuFxmlURL = new URL(Main.class.getResource("fxml/mainMenu.fxml").toExternalForm());
        LoginMenu.registerMenuFxmlURL = new URL(Main.class.getResource("fxml/registerMenu.fxml").toExternalForm());
        RegisterMenu.loginMenuFxmlURL = new URL(Main.class.getResource("fxml/loginMenu.fxml").toExternalForm());
        MainMenu.scoreBoardFxmlURL = new URL(Main.class.getResource("fxml/scoreBoard.fxml").toExternalForm());
        MainMenu.gameMenuFxmlURL = new URL(Main.class.getResource("fxml/playGameMenu.fxml").toExternalForm());
        MainMenu.scoreBoardFxmlURL = new URL(Main.class.getResource("fxml/scoreBoard.fxml").toExternalForm());
        MainMenu.profileFxmlURL = new URL(Main.class.getResource("fxml/profileMenu.fxml").toExternalForm());
        ProfileMenu.mainMenuFxml = LoginMenu.mainMenuFxmlURL;
        ProfileMenu.profileMenuFxml = MainMenu.profileFxmlURL;
        ProfileMenu.changeNicknameFxml = new URL(Main.class.getResource("fxml/ChangeNickName.fxml").toExternalForm());
        ProfileMenu.changePasswordFxml = new URL(Main.class.getResource("fxml/ChangePassword.fxml").toExternalForm());
        ProfileMenu.changeProfilePicFxml = new URL(Main.class.getResource("fxml/ChangeProfilePicture.fxml").toExternalForm());
        ProfileMenu.firstPic = new URL(Main.class.getResource("pictures/0.png").toExternalForm());
        ProfileMenu.secondPic = new URL(Main.class.getResource("pictures/1.png").toExternalForm());
        ProfileMenu.thirdPic = new URL(Main.class.getResource("pictures/2.png").toExternalForm());
        ProfileMenu.forthPic = new URL(Main.class.getResource("pictures/3.png").toExternalForm());
        MainMenu.mainMenuSoundURL = new URL(Main.class.getResource("music/1.mp3").toExternalForm());
        ChatBox.chatCSS = new URL(Main.class.getResource("CSS/chatBox.css").toExternalForm());
        ChatBox.mainMenuFxmlURL = LoginMenu.mainMenuFxmlURL;
        PreChatBox.preChatFxmlURL = new URL(Main.class.getResource("fxml/PreChatBox.fxml").toExternalForm());
        PreChatBox.mainMenuFxmlURL = LoginMenu.mainMenuFxmlURL;
        GameMenu.gameMenuURL = new URL(Main.class.getResource("fxml/gameMenu.fxml").toExternalForm());
        ExamplePage.examplePageURL = new URL(Main.class.getResource("fxml/examplePage.fxml").toExternalForm());
        BuildingsPage.buildingPageURL = new URL(Main.class.getResource("fxml/buildingsPage.fxml").toExternalForm());
        Tile.building1URL = new URL(Main.class.getResource("pictures/building1.png").toExternalForm());
        Tile.building2URL = new URL(Main.class.getResource("pictures/building2.png").toExternalForm());
        Tile.building3URL = new URL(Main.class.getResource("pictures/building3.png").toExternalForm());
        Tile.building4URL = new URL(Main.class.getResource("pictures/building4.png").toExternalForm());
        Tile.building5URL = new URL(Main.class.getResource("pictures/building5.png").toExternalForm());
        URL address_login_page = new URL(Main.class.getResource("fxml/loginMenu.fxml").toExternalForm());
        Unit.setNames();
        for (int i = 0; i < Unit.unitsName.size(); i++) {
            URL url = new URL(Main.class.getResource("pictures/" + Unit.unitsName.get(i) + ".png").toExternalForm());
            Unit.unitsURL.put(Unit.unitsName.get(i), url);
        }
        TradePage.tradePageURL = new URL(Main.class.getResource("fxml/tradePage.fxml").toExternalForm());
        SendTradeRequest.sendTradeRequestURL = new URL(Main.class.getResource("fxml/sendTradeRequest.fxml").toExternalForm());
        TradeRequests.tradeRequestsURL = new URL(Main.class.getResource("fxml/tradeRequests.fxml").toExternalForm());
        CityPage.cityPageURL = new URL(Main.class.getResource("fxml/cityPage.fxml").toExternalForm());
        CityPanel.cityPanelURL = new URL(Main.class.getResource("fxml/cityPanel.fxml").toExternalForm());
        CityPage.flag1URL = new URL(Main.class.getResource("pictures/flags/1.png").toExternalForm());
        CityPage.flag2URL = new URL(Main.class.getResource("pictures/flags/2.png").toExternalForm());
        CityPage.flag3URL = new URL(Main.class.getResource("pictures/flags/3.png").toExternalForm());
        CityPage.flag4URL = new URL(Main.class.getResource("pictures/flags/4.png").toExternalForm());
        CityPage.flag5URL = new URL(Main.class.getResource("pictures/flags/5.png").toExternalForm());

        Parent root = FXMLLoader.load(address_login_page);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
