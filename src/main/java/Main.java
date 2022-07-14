import Controller.PlayGameMenuController;
import Model.ClientThread;
import Model.GameSocket;
import Model.Tile;
import Model.Units.Unit;
import View.*;
import View.Transition.VictoryAnimation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class Main extends Application {
    public static ClientThread clientThread = new ClientThread();
    public static Socket socket;
    public static String host = "localhost";
    public static DataOutputStream dataOutputStream;
    public static DataInputStream dataInputStream;
    static {
        try {
            socket = new Socket(host,8888);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        Hosts.gameSocket = new GameSocket(host,socket.getPort(),socket.getLocalPort());
        CreateHost.dataOutputStream = dataOutputStream;
        CreateHost.dataInputStream = dataInputStream;
        CreateHost.socket = socket;
        CreateHost.host = host;
        clientThread.dataInputStream = CreateHost.dataInputStream;
        Room.creatorSocket = socket;
        UnitPanel.playGameMenuController = new PlayGameMenuController();
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
        Tile.dessert = new URL(Main.class.getResource("pictures/dessert.png").toExternalForm());
        Tile.hill = new URL(Main.class.getResource("pictures/hill.png").toExternalForm());
        Tile.ice = new URL(Main.class.getResource("pictures/ice.png").toExternalForm());
        Tile.jungle = new URL(Main.class.getResource("pictures/jungle.png").toExternalForm());
        Tile.meadow = new URL(Main.class.getResource("pictures/meadow.png").toExternalForm());
        Tile.mountain = new URL(Main.class.getResource("pictures/mountain.png").toExternalForm());
        Tile.plain = new URL(Main.class.getResource("pictures/plain.png").toExternalForm());
        Tile.rainforest = new URL(Main.class.getResource("pictures/rainforest.png").toExternalForm());
        Tile.snow = new URL(Main.class.getResource("pictures/snow.png").toExternalForm());
        Tile.tundra = new URL(Main.class.getResource("pictures/tundra.png").toExternalForm());
        Tile.fogOfWar = new URL(Main.class.getResource("pictures/fogOfWar.png").toExternalForm());
        Tile.marsh = new URL(Main.class.getResource("pictures/marsh.png").toExternalForm());
        Tile.ocean = new URL(Main.class.getResource("pictures/ocean.png").toExternalForm());

        Tile.banana = new URL(Main.class.getResource("pictures/banana.png").toExternalForm());
        Tile.coal = new URL(Main.class.getResource("pictures/coal.png").toExternalForm());
        Tile.color = new URL(Main.class.getResource("pictures/color.png").toExternalForm());
        Tile.cotton = new URL(Main.class.getResource("pictures/cotton.png").toExternalForm());
        Tile.cow = new URL(Main.class.getResource("pictures/cow.png").toExternalForm());
        Tile.fur = new URL(Main.class.getResource("pictures/fur.png").toExternalForm());
        Tile.gas = new URL(Main.class.getResource("pictures/gas.png").toExternalForm());
        Tile.gazelle = new URL(Main.class.getResource("pictures/gazelle.png").toExternalForm());
        Tile.gem = new URL(Main.class.getResource("pictures/gem.png").toExternalForm());
        Tile.golds = new URL(Main.class.getResource("pictures/golds.png").toExternalForm());
        Tile.horse = new URL(Main.class.getResource("pictures/horse.png").toExternalForm());
        Tile.marble = new URL(Main.class.getResource("pictures/marble.png").toExternalForm());
        Tile.metal = new URL(Main.class.getResource("pictures/metal.png").toExternalForm());
        Tile.sheep = new URL(Main.class.getResource("pictures/sheep.png").toExternalForm());
        Tile.silk = new URL(Main.class.getResource("pictures/silk.png").toExternalForm());
        Tile.silver = new URL(Main.class.getResource("pictures/silver.png").toExternalForm());
        Tile.sugar = new URL(Main.class.getResource("pictures/sugar.png").toExternalForm());
        Tile.tusk = new URL(Main.class.getResource("pictures/tusk.png").toExternalForm());
        Tile.wheat = new URL(Main.class.getResource("pictures/wheat.png").toExternalForm());

        Tile.agriculture = new URL(Main.class.getResource("pictures/agriculture.png").toExternalForm());
        Tile.camp = new URL(Main.class.getResource("pictures/camp.png").toExternalForm());
        Tile.farm = new URL(Main.class.getResource("pictures/farm.png").toExternalForm());
        Tile.laboratory = new URL(Main.class.getResource("pictures/laboratory.png").toExternalForm());
        Tile.lumberMill = new URL(Main.class.getResource("pictures/lumberMill.png").toExternalForm());
        Tile.mine = new URL(Main.class.getResource("pictures/mine.png").toExternalForm());
        Tile.paddock = new URL(Main.class.getResource("pictures/paddock.png").toExternalForm());
        Tile.stoneMine = new URL(Main.class.getResource("pictures/stoneMine.png").toExternalForm());
        Tile.tradingPost = new URL(Main.class.getResource("pictures/tradingPost.png").toExternalForm());

        Tile.ruinURL = new URL(Main.class.getResource("pictures/ruin.png").toExternalForm());

        TechnologyTree.AcousticsURL = new URL(Main.class.getResource("pictures/Acoustics.png").toExternalForm());
        TechnologyTree.AgricultureURL = new URL(Main.class.getResource("pictures/Agricultures.png").toExternalForm());
        TechnologyTree.AnimalHusbandryURL = new URL(Main.class.getResource("pictures/AnimalHusbandry.png").toExternalForm());
        TechnologyTree.ArchaeologyURL = new URL(Main.class.getResource("pictures/Archaeology.png").toExternalForm());
        TechnologyTree.ArcheryURL = new URL(Main.class.getResource("pictures/Archery.png").toExternalForm());
        TechnologyTree.BankingURL = new URL(Main.class.getResource("pictures/Banking.png").toExternalForm());
        TechnologyTree.BiologyURL = new URL(Main.class.getResource("pictures/Biology.png").toExternalForm());
        TechnologyTree.BronzeWorkingURL = new URL(Main.class.getResource("pictures/BronzeWorking.png").toExternalForm());
        TechnologyTree.CalendarURL = new URL(Main.class.getResource("pictures/Calendar.png").toExternalForm());
        TechnologyTree.ChemistryURL = new URL(Main.class.getResource("pictures/Chemistry.png").toExternalForm());
        TechnologyTree.ChivalryURL = new URL(Main.class.getResource("pictures/Chivalry.png").toExternalForm());
        TechnologyTree.CivilServiceURL = new URL(Main.class.getResource("pictures/CivilService.png").toExternalForm());
        TechnologyTree.CombustionURL = new URL(Main.class.getResource("pictures/Combustion.png").toExternalForm());
        TechnologyTree.ConstructionURL = new URL(Main.class.getResource("pictures/Construction.png").toExternalForm());
        TechnologyTree.CurrencyURL = new URL(Main.class.getResource("pictures/Currency.png").toExternalForm());
        TechnologyTree.DynamiteURL = new URL(Main.class.getResource("pictures/Dynamite.png").toExternalForm());
        TechnologyTree.EconomicsURL = new URL(Main.class.getResource("pictures/Economics.png").toExternalForm());
        TechnologyTree.EducationURL = new URL(Main.class.getResource("pictures/Education.png").toExternalForm());
        TechnologyTree.ElectricityURL = new URL(Main.class.getResource("pictures/Electricity.png").toExternalForm());
        TechnologyTree.EngineeringURL = new URL(Main.class.getResource("pictures/Engineering.png").toExternalForm());
        TechnologyTree.FertilizerURL = new URL(Main.class.getResource("pictures/Fertilizer.png").toExternalForm());
        TechnologyTree.GunpowderURL = new URL(Main.class.getResource("pictures/Gunpowder.png").toExternalForm());
        TechnologyTree.HorsebackRidingURL = new URL(Main.class.getResource("pictures/HorsebackRiding.png").toExternalForm());
        TechnologyTree.IronWorkingURL = new URL(Main.class.getResource("pictures/IronWorking.png").toExternalForm());
        TechnologyTree.MachineryURL = new URL(Main.class.getResource("pictures/Machinery.png").toExternalForm());
        TechnologyTree.MasonryURL = new URL(Main.class.getResource("pictures/Masonry.png").toExternalForm());
        TechnologyTree.MathematicsURL = new URL(Main.class.getResource("pictures/Mathematics.png").toExternalForm());
        TechnologyTree.MetalCastingURL = new URL(Main.class.getResource("pictures/MetalCasting.png").toExternalForm());
        TechnologyTree.MetallurgyURL = new URL(Main.class.getResource("pictures/Metallurgy.png").toExternalForm());
        TechnologyTree.MilitaryScienceURL = new URL(Main.class.getResource("pictures/MilitaryScience.png").toExternalForm());
        TechnologyTree.MiningURL = new URL(Main.class.getResource("pictures/Mining.png").toExternalForm());
        TechnologyTree.PhilosophyURL = new URL(Main.class.getResource("pictures/Philosophy.png").toExternalForm());
        TechnologyTree.PhysicsURL = new URL(Main.class.getResource("pictures/Physics.png").toExternalForm());
        TechnologyTree.PotteryURL = new URL(Main.class.getResource("pictures/Pottery.png").toExternalForm());
        TechnologyTree.PrintingPressURL = new URL(Main.class.getResource("pictures/PrintingPress.png").toExternalForm());
        TechnologyTree.RadioURL = new URL(Main.class.getResource("pictures/Radio.png").toExternalForm());
        TechnologyTree.RailroadURL = new URL(Main.class.getResource("pictures/Railroads.png").toExternalForm());
        TechnologyTree.ReplaceablePartsURL = new URL(Main.class.getResource("pictures/ReplaceableParts.png").toExternalForm());
        TechnologyTree.RiflingURL = new URL(Main.class.getResource("pictures/Rifling.png").toExternalForm());
        TechnologyTree.ScientificTheoryURL = new URL(Main.class.getResource("pictures/ScientificTheory.png").toExternalForm());
        TechnologyTree.SteamPowerURL = new URL(Main.class.getResource("pictures/SteamPower.png").toExternalForm());
        TechnologyTree.SteelURL = new URL(Main.class.getResource("pictures/Steel.png").toExternalForm());
        TechnologyTree.TelegraphURL = new URL(Main.class.getResource("pictures/Telegraph.png").toExternalForm());
        TechnologyTree.TheologyURL = new URL(Main.class.getResource("pictures/Theology.png").toExternalForm());
        TechnologyTree.TheWheelURL = new URL(Main.class.getResource("pictures/TheWheel.png").toExternalForm());
        TechnologyTree.TrappingURL = new URL(Main.class.getResource("pictures/Trapping.png").toExternalForm());
        TechnologyTree.WritingURL = new URL(Main.class.getResource("pictures/Writing.png").toExternalForm());

        TechnologyPanel.technologyPanelURL = new URL(Main.class.getResource("fxml/technologyPanel.fxml").toExternalForm());
        ResearchInformation.researchInformationURL = new URL(Main.class.getResource("fxml/researchInformation.fxml").toExternalForm());
        VictoryAnimation.winingTransitionURL = new URL(Main.class.getResource("pictures/victory").toExternalForm());
        VictoryAnimation.mainMenuFxmlURL = LoginMenu.mainMenuFxmlURL;

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
        Diplomatics.diplomaticsPageURL = new URL(Main.class.getResource("fxml/diplomatics.fxml").toExternalForm());
        DiplomaticReview.diplomaticReviewURL = new URL(Main.class.getResource("fxml/diplomaticReview.fxml").toExternalForm());
        DiplomaticInformation.diplomaticInfoURL = new URL(Main.class.getResource("fxml/diplomaticInformation.fxml").toExternalForm());
        Diplomacy.diplomacyURL = new URL(Main.class.getResource("fxml/diplomacy.fxml").toExternalForm());
        Messages.messagesURL = new URL(Main.class.getResource("fxml/messages.fxml").toExternalForm());
        SystemMessages.systemMessagesURL = new URL(Main.class.getResource("fxml/systemMessages.fxml").toExternalForm());
        DiplomaticRequests.diplomaticRequestsURL = new URL(Main.class.getResource("fxml/diplomaticRequests.fxml").toExternalForm());
        Demographics.demographicsPageURL = new URL(Main.class.getResource("fxml/demographics.fxml").toExternalForm());
        EconomicalReview.economicalPageURL = new URL(Main.class.getResource("fxml/economicalReview.fxml").toExternalForm());
        MainMenu.lobbyURL = new URL(Main.class.getResource("fxml/lobby.fxml").toExternalForm());
        Lobby.createHostURL = new URL(Main.class.getResource("fxml/createHost.fxml").toExternalForm());
        Lobby.hostsURL = new URL(Main.class.getResource("fxml/Hosts.fxml").toExternalForm());
        CreateHost.roomURL = new URL(Main.class.getResource("fxml/room.fxml").toExternalForm());
//        clientThread.start();
        dataOutputStream.writeUTF("hello world!");
        dataOutputStream.flush();

        Parent root = FXMLLoader.load(address_login_page);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
