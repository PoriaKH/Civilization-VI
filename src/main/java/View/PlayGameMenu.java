package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Member;
import Model.Tile;
import Model.Units.Civilian;
import Model.Units.SaveGameClass;
import Model.Units.Unit;
import Model.Units.Warrior;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.GameMenu.gameMenuURL;
import static View.MainMenu.gameMenuFxmlURL;
import static View.UnitPanel.playGameMenuController;

public class PlayGameMenu {

    public Pane root;

    public Stage stage;

    public Scene scene;

    public Button backButton;
    @FXML
    private TextField user1;
    @FXML
    private TextField user2;
    @FXML
    private TextField user3;
    @FXML
    private TextField user4;
    @FXML
    private Button autoSaveButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button newGameButton;

    private int playersCounter = 0;

    public static Civilization playingCivilization;


    public Text goldAmount;
    public Text happinessAmount;

    public void newGame(MouseEvent mouseEvent) throws IOException {
        ArrayList<Member> members = getMembers();
        ArrayList<Member> players = new ArrayList<>();
        boolean areUsersOk = true;
        for (int i = 0; i < 4; ++i) {
            if (i == 0) {
                if (!user1.getText().equals("")) {
                    Member member = getMember(user1.getText(), members);
                    if (member == null) showAlert(i);
                    else {
                        if (isUserRepetitive (member, players)) {
                            areUsersOk = false;
                            showRepetitiveAlert(i);
                        }
                        else players.add(member);
                    }
                }
            }
            else if (i == 1) {
                if (!user2.getText().equals("")) {
                    Member member = getMember(user2.getText(), members);
                    if (member == null) showAlert(i);
                    else {
                        if (isUserRepetitive (member, players)) {
                            areUsersOk = false;
                            showRepetitiveAlert(i);
                        }
                        else players.add(member);
                    }
                }
            }
            else if (i == 2) {
                if (!user3.getText().equals("")) {
                    Member member = getMember(user3.getText(), members);
                    if (member == null) showAlert(i);
                    else {
                        if (isUserRepetitive (member, players)) {
                            areUsersOk = false;
                            showRepetitiveAlert(i);
                        }
                        else players.add(member);
                    }
                }
            }
            else if (i == 3) {
                if (!user4.getText().equals("")) {
                    Member member = getMember(user4.getText(), members);
                    if (member == null) showAlert(i);
                    else {
                        if (isUserRepetitive (member, players)) {
                            areUsersOk = false;
                            showRepetitiveAlert(i);
                        }
                        else players.add(member);
                    }
                }
            }
        }
        if (players.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("empty rivals");
            alert.setHeaderText("result :");
            alert.setContentText("do you want to play with yourself :)");
            alert.showAndWait();
            return;
        }
        players.add(0, MainMenu.loggedInMember);
        if (areUsersOk) {
            MainMenu.mediaPlayer.stop();

            root = FXMLLoader.load(gameMenuURL);
            Tile.root = root;
            ArrayList<Tile> tiles = playGameMenuController.mapCreator(players.size(),players);
            Tile.map = tiles;
            ArrayList<Civilization> civilizations = playGameMenuController.initializeCivilizations(players.size(), tiles, players);
            Tile.civilizations = civilizations;
            playingCivilization = civilizations.get(0);
            ArrayList<Integer> status = playGameMenuController.statusChecker(playingCivilization, tiles);
            for (int i = 0; i < 72; i++)
                tiles.get(i).generatingTile(status.get(i));

            switchToGame(mouseEvent, tiles, civilizations);
        }
    }
    public void switchToGame(MouseEvent mouseEvent, ArrayList<Tile> tiles, ArrayList<Civilization> civilizations) throws IOException {
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();

        // Images for buttons and happiness and gold
        Image nextTurnImage = new Image(getClass().getResource("/pictures/Turn.png").toExternalForm());
        ImageView nextTurnImageView = new ImageView(nextTurnImage);
        nextTurnImageView.setFitHeight(26);
        nextTurnImageView.setPreserveRatio(true);

        Image goldImage = new Image(getClass().getResource("/pictures/Gold.png").toString());
        ImageView goldView = new ImageView(goldImage);
        goldView.setFitWidth(25);
        goldView.setFitHeight(25);
        goldAmount = new Text(" : " + playingCivilization.getGold());
        goldAmount.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 20));
        goldAmount.setFill(Color.RED);
        //making various space for vbox
        Text spacing1 = new Text("                         ");
        Text spacing2 = new Text("                                                                ");
        Text spacing3 = new Text("                           ");
        Text spacing4 = new Text("                           ");
        Text spacing5 = new Text("                           ");

        Image happinessImage = new Image(getClass().getResource("/pictures/Happiness.png").toString());
        ImageView happinessView = new ImageView(happinessImage);
        happinessView.setFitWidth(25);
        happinessView.setFitHeight(25);
        happinessAmount = new Text(" : " + playingCivilization.getHappiness());
        happinessAmount.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 20));
        happinessAmount.setFill(Color.RED);

        // civilization name text
        Text civName = new Text("civilization : " + playingCivilization.getName());
        civName.setFont(Font.font("Pristina", FontWeight.BOLD, FontPosture.REGULAR, 30));
        civName.setFill(Color.RED);
        // buttons
        Button infoPanelButton = new Button("info panel");
        infoPanelButton.setStyle( "-fx-pref-width: 150;\n" +
                "-fx-pref-height: 20;\n" +
                " -fx-effect: dropshadow( one-pass-box , #1a0bf1, 8 , 0.0 , 2 , 0 );\n" +
                "-fx-font-style: italic;\n" +
                "-fx-background-color: #a9a2a2;");


        Button technologyButton = new Button();
        technologyButton.setStyle("-fx-effect: dropshadow( one-pass-box , #7304bd, 8 , 0.0 , 2 , 0 );");
        technologyButton.setShape(new Circle(15));
        technologyButton.setMinSize(30, 30);
        technologyButton.setMaxSize(30, 30);

        Image imageTechnology = new Image(getClass().getResource("/pictures/Science.png").toString());
        ImageView technologyView = new ImageView(imageTechnology);
        technologyView.fitWidthProperty().bind(technologyButton.widthProperty());
        technologyView.fitHeightProperty().bind(technologyButton.heightProperty());
        technologyButton.setGraphic(technologyView);

        Button nextTurnButton = new Button();
        nextTurnButton.setShape(new Circle(20));
        nextTurnButton.setMinSize(40, 40);
        nextTurnButton.setMaxSize(40, 40);
        nextTurnButton.setGraphic(nextTurnImageView);

        // adding to vbox
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.getChildren().add(goldView);
        hBox.getChildren().add(goldAmount);
        hBox.getChildren().add(spacing1);
        hBox.getChildren().add(happinessView);
        hBox.getChildren().add(happinessAmount);
        hBox.getChildren().add(spacing2);
        hBox.getChildren().add(civName);
        hBox.getChildren().add(spacing3);
        hBox.getChildren().add(technologyButton);
        hBox.getChildren().add(spacing4);
        hBox.getChildren().add(infoPanelButton);
        hBox.getChildren().add(spacing5);
        hBox.getChildren().add(nextTurnButton);

        root.getChildren().add(hBox);

        // Event handlers
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("x = " + event.getX() + "  y = " + event.getY());
            }
        });
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String keyName = event.getCode().getName();
                if(Objects.equals(keyName, "Up")){
                    if(tiles.get(0).getY() <= 250) {
                        for (Tile tile : tiles) {
                            tile.moveDown();
                        }
                    }
                }
                if(Objects.equals(keyName, "Down")){
                    if(tiles.get(5).getY() >= 500) {
                        for (Tile tile : tiles) {
                            tile.moveUp();
                        }
                    }
                }
                if(Objects.equals(keyName, "Left")){
                    if(tiles.get(0).getX() <= 300) {
                        for (Tile tile : tiles) {
                            tile.moveRight();
                        }
                    }
                }
                if(Objects.equals(keyName, "Right")) {
                    if (tiles.get(66).getX() >= 1000) {
                        for (Tile tile : tiles) {
                            tile.moveLeft();
                        }
                    }
                }
                if (Objects.equals(keyName, "C")) {
                    CheatMenu.infoPanelScene = scene;
                    CheatMenu.stage = stage;
                    CheatMenu.doesEnteredFromInfoPanel = false;
                    try {
                        new CheatMenu().start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        infoPanelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    InfoPanel.goldAmount = goldAmount;
                    InfoPanel.happinessAmount = happinessAmount;
                    InfoPanel.stage = stage;
                    InfoPanel.gameMenuScene = scene;
                    InfoPanel.tiles = tiles;
                    InfoPanel.currentCivilization = playingCivilization;
                    InfoPanel.civilizations = civilizations;
                    new InfoPanel().start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //todo -> kian
        technologyButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        //TODO add technology condition
        nextTurnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String string = playGameMenuController.nextTurn(playingCivilization, tiles);
                if (!string.equals("done")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("next turn");
                    alert.setHeaderText("result :");
                    alert.setContentText(string);
                    alert.showAndWait();
                } else {
                    playGameMenuController.deleteLosers(playingCivilization, civilizations);
                    if (playGameMenuController.findWinner(playingCivilization, civilizations)) {
                        //TODO .... write array members in file -> pouria ***********
                        //TODO ... baraye datresi be barande civilization.get(0) okeye
                        //TODO .... list member ha ham hast age khsati kol file ro dobare benevisi
                        //TODO dat tabe fidnWinner emtaiza member barande ro ziad kardam
                        try {
                            increaseFileScore(playingCivilization);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //TODO .... graphic view for winner -> kian
                        try {
                            root = FXMLLoader.load(LoginMenu.mainMenuFxmlURL);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    PlayGameMenuController.turn ++;
                    playersCounter++;
                    if (playersCounter == civilizations.size()) {
                        playersCounter = 0;
                    }
                    playingCivilization = civilizations.get(playersCounter);
                    civName.setText("civilization : " + playingCivilization.getName());
                    goldAmount.setText(" : " + playingCivilization.getGold());
                    happinessAmount.setText(" : " + playingCivilization.getHappiness());
                    ArrayList<Integer> status = playGameMenuController.statusChecker(playingCivilization, tiles);
                    for (int i = 0; i < 72; i++)
                        tiles.get(i).generatingTile(status.get(i));
                }
            }
        });



        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,720);
        scene.getRoot().requestFocus();
        stage.setScene(scene);
        root.getChildren().get(0).requestFocus();

        Tile.stage = stage;
        Tile.scene = scene;

        stage.show();
    }
    public void increaseFileScore(Civilization civilization) throws IOException {
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");

            if(Objects.equals(fileUsername, civilization.getMember().getUsername())) {
                continue;
            }

            stringBuilder.append(line);
            stringBuilder.append("\n");

            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(stringBuilder));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Random rand = new Random();
        int upperbound = 4;
        int int_random = rand.nextInt(upperbound);

        int newScore = civilization.getMember().getScore() + 500;
        bufferedWriter.write(civilization.getMember().getUsername() + " " + civilization.getMember().getNickname() + " " + civilization.getMember().getPassword() + " " + newScore + " " + int_random + " " + dtf.format(now));
        bufferedWriter.newLine();


        bufferedWriter.close();
    }
    private void showRepetitiveAlert(int i) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("repetitive username number :" + (i + 1));
        alert.setHeaderText("result :");
        alert.setContentText("this username is repetitive !");
        alert.showAndWait();
    }

    private boolean isUserRepetitive(Member member, ArrayList<Member> players) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUsername().equals(member.getUsername())) return true;
        }
        if (MainMenu.loggedInMember.getUsername().equals(member.getUsername())) return true;
        return false;
    }

    private void showAlert(int i) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("wrong username" + (i + 1));
        alert.setHeaderText("result :");
        alert.setContentText("there is no username with this name");
        alert.showAndWait();
    }

    private Member getMember(String username, ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            if (username.equals(members.get(i).getUsername())) return members.get(i);
        }
        return null;
    }

    public void saveGameContinue(MouseEvent mouseEvent) throws IOException {
        SaveGameClass saveGameClass = loadGame();
        ArrayList<Civilization> civilizations = saveGameClass.civilizations;
        ArrayList<Tile> tiles = saveGameClass.tiles;
        loadURLs(saveGameClass);

        MainMenu.mediaPlayer.stop();
        root = FXMLLoader.load(gameMenuURL);
        Tile.root = root;
        Tile.map = tiles;
        Tile.civilizations = civilizations;
        playingCivilization = civilizations.get(0);

        ArrayList<Integer> status = playGameMenuController.statusChecker(playingCivilization, tiles);
        for (int i = 0; i < 72; i++)
            tiles.get(i).generatingTile(status.get(i));

        switchToGame(mouseEvent, tiles, civilizations);
    }

    private void loadURLs(SaveGameClass saveGameClass) {
        Tile.dessert = saveGameClass.dessert;
        Tile.fogOfWar = saveGameClass.fogOfWar;
        Tile.hill = saveGameClass.hill;
        Tile.ice = saveGameClass.ice;
        Tile.jungle = saveGameClass.jungle;
        Tile.meadow = saveGameClass.meadow;
        Tile.mountain = saveGameClass.mountain;
        Tile.plain = saveGameClass.plain;
        Tile.rainforest = saveGameClass.rainforest;
        Tile.snow = saveGameClass.snow;
        Tile.tundra = saveGameClass.tundra;
        Tile.marsh = saveGameClass.marsh;
        Tile.ocean = saveGameClass.ocean;
        Tile.building1URL = saveGameClass.building1URL;
        Tile.building2URL = saveGameClass.building2URL;
        Tile.building3URL = saveGameClass.building3URL;
        Tile.building4URL = saveGameClass.building4URL;
        Tile.building5URL = saveGameClass.building5URL;
        Tile.roadURL = saveGameClass.roadURL;
        Tile.railURL = saveGameClass.railURL;
        Unit.unitsURL = saveGameClass.unitsURL;
        Unit.unitsName = saveGameClass.unitsName;
    }

    public SaveGameClass loadGame () throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        File file = new File("saveGame.txt");

        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytes);

        String data = new String(bytes);
        System.out.println(data);
        SaveGameClass saveGameClass = gson.fromJson(data, SaveGameClass.class);
        for (Tile tile : saveGameClass.tiles) {
            System.out.println(tile.getTileNumber());
        }
        for (Civilization civilization : saveGameClass.civilizations) {
            System.out.println(civilization.getName());
        }
        return saveGameClass;
    }

    public void autoSaveGameContinue(MouseEvent mouseEvent) {
    }

    public void showAutoSaveInfo(MouseEvent mouseEvent) {
        Tooltip tooltip = new Tooltip("you can continue from last auto save !");
        autoSaveButton.setTooltip(tooltip);
    }

    public void showSaveInfo(MouseEvent mouseEvent) {
        Tooltip tooltip = new Tooltip("you can continue from where the game has been stopped !");
        saveButton.setTooltip(tooltip);
    }

    public void showStartGameInfo(MouseEvent mouseEvent) {
        Tooltip tooltip = new Tooltip("start a new game with maximum 4 user \n" +
                "enter their username from user 1 to user 4");
        newGameButton.setTooltip(tooltip);
    }

    private Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }

    public ArrayList<Member> getMembers () throws IOException {
        ArrayList<Member> members = new ArrayList<>();
        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        line = bufferedReader.readLine();
        while(line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");
            String filePassword = fileMatcher.group("password");
            int score = Integer.parseInt(fileMatcher.group("score"));
            int imageNumber = Integer.parseInt(fileMatcher.group("image"));
            String fileDate = fileMatcher.group("date");

            Member member = new Member(fileUsername, fileNickname, filePassword, score, imageNumber, fileDate);
            members.add(member);
            line = bufferedReader.readLine();
        }
        fileReader.close();
        return members;
    }

    public void backInfo(MouseEvent mouseEvent) {
        Tooltip tooltip = new Tooltip("back to main menu");
        backButton.setTooltip(tooltip);
    }

    public void backToMainMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(LoginMenu.mainMenuFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String YELLOW = "\u001B[33m";// --> dessert
    public static final String DARK_GREEN = "\u001b[32m";// --> midow
    public static final String LIGHT_GREEN = "\u001b[32;1m";// --> plain
    public static final String BLUE = "\u001B[34m";// --> ocean
    public static final String BROWN = "\u001B[34m";// --> mountain
    public static final String PURPLE = "\u001B[35m";// --> thundra
    public static final String ICY = "\u001B[37m";// --> ice
    public static final String CYAN = "\033[0;36m";// --> hill
    public static final String BACKGROUND_BLUE = "\u001b[34m";// --> river


    public Matcher matcher(String regex, String command){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }

    public void run(Scanner scan, int numOfCivilizations, ArrayList<Member> members){
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        String ANSI_COLORS[] = new String[73];
        ANSI_COLORS[0] = BROWN;
        ANSI_COLORS[1] = DARK_GREEN;
        ANSI_COLORS[2] = DARK_GREEN;
        ANSI_COLORS[3] = BLUE;
        ANSI_COLORS[4] = BLUE;
        ANSI_COLORS[5] = BLUE;
        ANSI_COLORS[6] = LIGHT_GREEN;
        ANSI_COLORS[7] = DARK_GREEN;
        ANSI_COLORS[8] = DARK_GREEN;
        ANSI_COLORS[9] = LIGHT_GREEN;
        ANSI_COLORS[10] = BLUE;
        ANSI_COLORS[11] = LIGHT_GREEN;
        ANSI_COLORS[12] = CYAN;
        ANSI_COLORS[13] = BROWN;
        ANSI_COLORS[14] = CYAN;
        ANSI_COLORS[15] = PURPLE;
        ANSI_COLORS[16] = ICY;
        ANSI_COLORS[17] = CYAN;
        ANSI_COLORS[18] = YELLOW;
        ANSI_COLORS[19] = CYAN;
        ANSI_COLORS[20] = LIGHT_GREEN;
        ANSI_COLORS[21] = BLUE;
        ANSI_COLORS[22] = PURPLE;
        ANSI_COLORS[23] = YELLOW;
        ANSI_COLORS[24] = YELLOW;
        ANSI_COLORS[25] = ICY;
        ANSI_COLORS[26] = ICY;
        ANSI_COLORS[27] = BLUE;
        ANSI_COLORS[28] = PURPLE;
        ANSI_COLORS[29] = YELLOW;
        ANSI_COLORS[30] = PURPLE;
        ANSI_COLORS[31] = ICY;
        ANSI_COLORS[32] = BLUE;
        ANSI_COLORS[33] = BROWN;
        ANSI_COLORS[34] = BROWN;
        ANSI_COLORS[35] = PURPLE;
        ANSI_COLORS[36] = YELLOW;
        ANSI_COLORS[37] = BLUE;
        ANSI_COLORS[38] = BLUE;
        ANSI_COLORS[39] = YELLOW;
        ANSI_COLORS[40] = YELLOW;
        ANSI_COLORS[41] = YELLOW;
        ANSI_COLORS[42] = PURPLE;
        ANSI_COLORS[43] = ICY;
        ANSI_COLORS[44] = PURPLE;
        ANSI_COLORS[45] = YELLOW;
        ANSI_COLORS[46] = YELLOW;
        ANSI_COLORS[47] = LIGHT_GREEN;
        ANSI_COLORS[48] = PURPLE;
        ANSI_COLORS[49] = YELLOW;
        ANSI_COLORS[50] = LIGHT_GREEN;
        ANSI_COLORS[51] = LIGHT_GREEN;
        ANSI_COLORS[52] = LIGHT_GREEN;
        ANSI_COLORS[53] = PURPLE;
        ANSI_COLORS[54] = YELLOW;
        ANSI_COLORS[55] = ICY;
        ANSI_COLORS[56] = LIGHT_GREEN;
        ANSI_COLORS[57] = LIGHT_GREEN;
        ANSI_COLORS[58] = LIGHT_GREEN;
        ANSI_COLORS[59] = YELLOW;
        ANSI_COLORS[60] = PURPLE;
        ANSI_COLORS[61] = LIGHT_GREEN;
        ANSI_COLORS[62] = YELLOW;
        ANSI_COLORS[63] = YELLOW;
        ANSI_COLORS[64] = YELLOW;
        ANSI_COLORS[65] = PURPLE;
        ANSI_COLORS[66] = BROWN;
        ANSI_COLORS[67] = YELLOW;
        ANSI_COLORS[68] = YELLOW;
        ANSI_COLORS[69] = YELLOW;
        ANSI_COLORS[70] = PURPLE;
        ANSI_COLORS[71] = BROWN;
        ANSI_COLORS[72] = BACKGROUND_BLUE;
        String number[] = {" 0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71"};
        String types[] = new String[72];
        String cv[] = new String[72];
        String unit1[] = new String[72];
        String unit2[] = new String[72];
        String cityCenter[] = new String[72];
        String mapString[] = new String[77];
        for (int i = 0; i < 72; i++){
            types[i] = "\u2588";
            unit1[i] = "\u2588" + "\u2588";
            unit2[i] = "\u2588" + "\u2588";
            cv[i] = "\u2588";
        }
        //jungle -> j, plat -> p, vahhe(oasis) -> v, marsh --> m, rainforest --> r, ice --> i
        types[0] = "j";
        types[13] = "p";
        types[17] = "p";
        types[19] = "p";
        types[20] = "p";
        types[22] = "p";
        types[33] = "j";
        types[34] = "j";
        types[66] = "j";
        types[71] = "j";
        ArrayList<Tile> map = new ArrayList<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation1 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation2 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation3 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation4 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation5 = new HashMap<>();
        map = playGameMenuController.mapCreator(numOfCivilizations,members);
        ArrayList<Civilization> civilizations = playGameMenuController.initializeCivilizations(numOfCivilizations, map, members);
        Civilization playingCivilization; // the civilization which is playing now
        int counter = 0; //count 0 to numOfCivilizations - 1
        playingCivilization = civilizations.get(counter);


        ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();
        //1 -> vazeh   0 -> moshakhas   -1 -> fog of war
        if (numOfCivilizations == 2) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
        }
        else if (numOfCivilizations == 3) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);
        }
        else if (numOfCivilizations == 4) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);
            tileStatusOfCivilization4 = playGameMenuController.statusChecker(civilizations.get(3), map);
        }
        else if (numOfCivilizations == 5){
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);///   ----> -1 , 1
            tileStatusOfCivilization4 = playGameMenuController.statusChecker(civilizations.get(3), map);
            tileStatusOfCivilization5 = playGameMenuController.statusChecker(civilizations.get(4), map);
        }
        //TODO... Calling statusChecker Function 3 times

        for (int i = 0; i < civilizations.size(); i++) {
            for (int i1 = 0; i1 < civilizations.size(); i1++) {
                if (i != i1) {
                    civilizations.get(i).addCivilizationToWinsUnit(civilizations.get(i1));
                    civilizations.get(i).addCivilizationToLossesUnit(civilizations.get(i1));
                }
            }
        }
        cv = playGameMenuController.cvMaker(map, playingCivilization);
        unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation1, tileStatusOfCivilization1);
        unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation1, tileStatusOfCivilization1);
        cityCenter = playGameMenuController.cityCenterMaker(map, playingCivilization);
        ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization1, map, zeroStatusTilesCivilisation1, ANSI_COLORS);
        mapString = playGameMenuController.showMap(ANSI_COLORS, number, types, unit1, unit2, cv, cityCenter);
        for (int i = 0; i < 77; i++)
            System.out.println(mapString[i]);

        String command;
        command = scan.nextLine();

        String showCurrentMenuRegex = "menu show-current";
        String createUnitRegex1 = "^create --unit (?<unitName>.+) tile --number (?<number>\\d+)$";
        String createUnitRegex2 = "^create tile --number (?<number>\\d+) --unit (?<unitName>.+)$";
        String moveUnitRegex1 = "^move --unit (?<unitName>.+) --path (?<numberO>\\d+) to (?<numberD>\\d+)$";
        String moveUnitRegex2 = "^move --path (?<numberO>\\d+) to (?<numberD>\\d+) --unit (?<unitName>.+)$";
        String sleepUnitRegex1 = "^sleep --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String sleepUnitRegex2 = "^sleep --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String alertUnitRegex1 = "^alert --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String alertUnitRegex2 = "^alert --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String fortifyRegex1 = "^fortify --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String fortifyRegex2 = "^fortify --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String healRegex1 = "^fortify heal --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String healRegex2 = "^fortify heal --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String deployRegex1 = "^deploy --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String deployRegex2 = "^deploy --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String rangedRegex1 = "^set up range --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String rangedRegex2 = "^set up range --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String wakeUpRegex1 = "^wake --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String wakeUpRegex2 = "^wake --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String createCityRegex = "create city (?<tile>\\d+)";
        String lockCitizenRegex = "lock citizen (?<origin>\\d+) (?<destination>\\d+)";//move citizen from origin to destination
        String purchaseTileRegex = "purchase tile (?<tile>\\d+)";
        String workOnTileRegex = "city (?<cityNumber>\\d+) unit in --tile (?<tileUnitNumber>\\d+) work on --tile (?<tileNumber>\\d+)";
        String createImprovementRegex = "create improvement (?<improvementName>.+) --tile (?<tileNumber>\\d+) unit in --tile (?<tileUnitNumber>\\d+)";
        String removeImprovementRegex = "remove improvement (?<improvementName>.+) --tile (?<tileNumber>\\d+)";
        String createRoadRegex = "^create road on --tile (?<number>\\d+)$";
        String createRailwayRegex = "^create rail way on --tile (?<number>\\d+)$";
        String removeRoadRegex = "^remove road on --tile (?<number>\\d+)$";
        String removeRailwayRegex = "^remove rail way on --tile (?<number>\\d+)$";
        String repairRoadRegex = "^repair road on --tile (?<number>\\d+)$";
        String repairRailRegex = "^repair rail on --tile (?<number>\\d+)$";
        String deleteUnitRegex1 = "^delete --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String deleteUnitRegex2 = "^delete --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String unitPanelRegex = "^unit panel$";
        String unitGeneralPanelRegex = "^unit general panel$";
        String victoryImprovementRegex = "^victory improvement$";
        String recoverUnitRegex1 = "^recover --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String recoverUnitRegex2 = "^recover --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String updateUnitRegex1 = "^update warrior --tile (?<number>\\d+) --oldUnit (?<oldUnitName>.+) --newUnit (?<newUnitName>.+)$";
        String updateUnitRegex2 = "^update warrior --tile (?<number>\\d+) --newUnit (?<newUnitName>.+) --oldUnit (?<oldUnitName>.+)$";
        String updateUnitRegex3 = "^update warrior --oldUnit (?<oldUnitName>.+) --tile (?<number>\\d+) --newUnit (?<newUnitName>.+)$";
        String updateUnitRegex4 = "^update warrior --oldUnit (?<oldUnitName>.+) --newUnit (?<newUnitName>.+) --tile (?<number>\\d+)$";
        String updateUnitRegex5 = "^update warrior --newUnit (?<newUnitName>.+) --tile (?<number>\\d+) --oldUnit (?<oldUnitName>.+)$";
        String updateUnitRegex6 = "^update warrior --newUnit (?<newUnitName>.+) --oldUnit (?<oldUnitName>.+) --tile (?<number>\\d+)$";
        String cityPanelRegex = "city panel";
        String economicalReviewRegex = "economical review";
        String demographicsRegex = "demographics";
        String showCurrentScoreRegex = "show score";
        String cheatIncreaseGoldRegex = "cheat increase gold (?<amount>\\d+)";
        String cheatIncreaseFoodRegex = "cheat increase food (?<amount>\\d+)";
        String cheatIncreaseTechnologyRegex = "cheat increase technology (?<amount>\\d+)";
        String cheatIncreaseHappinessRegex = "cheat increase happiness (?<amount>\\d+)";
        String cancelImprovementOnProcessRegex = "cancel improvement on tile (?<tileNumber> \\d+)";
        String showImprovementsRegex = "show improvements";
        String repairImprovementRegex = "repair improvements in tile (?<tileNumber>\\d+) unit in tile (?<unitTileNumber>\\d+)";
        String lootTileRegex = "loot --tile (?<lootTileNumber>\\d+) unit in --tile (?<tileUnitNumber>\\d+)";
        String chooseTechnologyToLearnRegex = "learn technology (?<technologyName>.+)";
        String changeTechnologyToLearnRegex = "change technology to learn (?<technologyName>.+)";
        String showTechnologyMenuRegex = "show technology menu";
        String researchInformationRegex = "show research information";
        String attackTileRegex1 = "attackTile --tile (?<origin>\\d+) to --tile (?<destination>\\d+)";
        String attackTileRegex2 = "attackTile to --tile (?<destination>\\d+) --tile (?<origin>\\d+)";
        String cancelCommandRegex = "cancel unit making on --tile (?<number>\\d+) --type (?<type>.+)";
        String cheatCodeMoveUnitRegex1 = "^cheat code move --unit (?<unitName>.+) --path (?<numberO>\\d+) to (?<numberD>\\d+)$";
        String cheatCodeMoveUnitRegex2 = "^cheat code move --path (?<numberO>\\d+) to (?<numberD>\\d+) --unit (?<unitName>.+)$";
        String diplomaticInformationRegex = "diplomatic information";
        String sendFriendlyRequestDiplomaticRegex = "send friendly request to (?<civilization>.*)";
        String showFriendlyRequestsRegex = "show friendly requests";
        String acceptFriendlyRequestRegex = "accept friendly request (?<name>.*)";
        String denyFriendlyRequestRegex = "deny friendly request (?<name>.*)";
        String breakOathRegex = "break oath with (?<name>.*)";
        String diplomaticReviewRegex = "diplomatic review";
        String attackCityRegex1 = "attackCity --tile (?<origin>\\d+) to --tile (?<destination>\\d+)";
        String attackCityRegex2 = "attackCity to --tile (?<destination>\\d+) --tile (?<origin>\\d+)";
        String showMessagesRegex = "show messages";
        String showRoadsRegex = "show ways";
        String showCitizensRegex = "show citizens";
        String nextTurnRegex = "next turn";
        while(!Objects.equals(command, "exit menu")) {
            boolean bool = true;



            //TODO... Calling functions using regex ( if(command.matches(regex) -> func(civ,map,...) )
            if (command.matches(createUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitMaker (matcher(createUnitRegex1, command), playingCivilization, map));
            }
            else if (command.matches(createUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitMaker (matcher(createUnitRegex2, command), playingCivilization, map));
            }
            else if (command.matches(moveUnitRegex1)) {
                System.out.println(playGameMenuController.preMoveUnit(matcher(moveUnitRegex1, command), playingCivilization, map));
            }
            else if (command.matches(moveUnitRegex2)) {
                System.out.println(playGameMenuController.preMoveUnit(matcher(moveUnitRegex2, command), playingCivilization, map));
            }
            else if (command.matches(sleepUnitRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(sleepUnitRegex1, command), playingCivilization, map, "sleep"));
            }
            else if (command.matches(sleepUnitRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(sleepUnitRegex2, command), playingCivilization, map, "sleep"));
            }
            else if (command.matches(alertUnitRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(alertUnitRegex1,command), playingCivilization, map, "alert"));
            }
            else if (command.matches(alertUnitRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(alertUnitRegex2,command), playingCivilization, map, "alert"));
            }
            else if (command.matches(fortifyRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(fortifyRegex1,command),playingCivilization,map,"fortify"));
            }
            else if (command.matches(showImprovementsRegex)){
                bool = false;
                System.out.println(playGameMenuController.showImprovements(map));
            }
            else if (command.matches(fortifyRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(fortifyRegex2,command),playingCivilization,map,"fortify"));
            }
            else if (command.matches(healRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(healRegex1,command),playingCivilization,map,"heal"));
            }
            else if (command.matches(healRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(healRegex2,command),playingCivilization,map,"heal"));
            }
            else if (command.matches(deployRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deployRegex1,command),playingCivilization,map,"deploy"));
            }
            else if (command.matches(deployRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deployRegex2,command),playingCivilization,map,"deploy"));
            }
            else if (command.matches(rangedRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(rangedRegex1,command),playingCivilization,map,"range"));
            }
            else if (command.matches(rangedRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(rangedRegex2,command),playingCivilization,map,"range"));
            }
            else if (command.matches(wakeUpRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(wakeUpRegex1,command),playingCivilization,map,"wake"));
            }
            else if (command.matches(wakeUpRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(wakeUpRegex2,command),playingCivilization,map,"wake"));
            }
            else if(command.matches(createCityRegex))
                System.out.println(playGameMenuController.preCreateCity(matcher(createCityRegex,command),playingCivilization,map,civilizations));
            else if(command.matches(lockCitizenRegex)) {
                bool = false;
                System.out.println(playGameMenuController.preLockCitizen(matcher(lockCitizenRegex, command), playingCivilization, map));
            }
            else if(command.matches(purchaseTileRegex))
                System.out.println(playGameMenuController.prePurchaseTile(matcher(purchaseTileRegex,command),playingCivilization,map,civilizations));
            else if (command.matches(createRoadRegex)) {
                Matcher matcher1 = matcher(createRoadRegex, command);
                matcher1.find();
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.createRoad(playingCivilization, map.get(index),map));
            }
            else if (command.matches(createRailwayRegex)) {
                Matcher matcher1 = matcher(createRailwayRegex, command);
                matcher1.find();
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.createRailRoad(playingCivilization, map.get(index),map));
            }
            else if (command.matches(removeRoadRegex)) {
                Matcher matcher1 = matcher(removeRoadRegex, command);
                matcher1.find();
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.removeRoad(playingCivilization, map.get(index),map));
            }
            else if (command.matches(removeRailwayRegex)) {
                Matcher matcher1 = matcher(removeRailwayRegex, command);
                matcher1.find();
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.removeRailRoad(playingCivilization, map.get(index),map));
            }
            else if (command.matches(repairRoadRegex)) {
                Matcher matcher1 = matcher(repairRoadRegex, command);
                matcher1.find();
                bool = false;
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.repairRoad(playingCivilization,map.get(index),map));
            }
            else if (command.matches(repairRailRegex)) {
                Matcher matcher1 = matcher(repairRailRegex, command);
                matcher1.find();
                bool = false;
                int index = Integer.parseInt(matcher1.group("number"));
                if (index < 0 || index > 71) {
                    System.out.println("number of tile is invalid");
                }
                else
                System.out.println(playGameMenuController.repairRail(playingCivilization,map.get(index),map));
            }
            else if (command.matches(deleteUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deleteUnitRegex1,command),playingCivilization,map,"delete"));
            }
            else if (command.matches(deleteUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deleteUnitRegex2,command),playingCivilization,map,"delete"));
            }
            else if (command.matches(unitPanelRegex)) {
                bool = false;
                System.out.println(playGameMenuController.unitPanel(playingCivilization, map));
            }
            else if (command.matches(unitGeneralPanelRegex)) {
                bool = false;
                System.out.println(playGameMenuController.generalUnitReview(playingCivilization, map));
            }
            else if (command.matches(victoryImprovementRegex)) {
                bool = false;
                System.out.println(playGameMenuController.victoryImprovement(playingCivilization, map));
            }
            else if (command.matches(recoverUnitRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(recoverUnitRegex1,command),playingCivilization,map,"recover"));
            }
            else if (command.matches(recoverUnitRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(recoverUnitRegex2,command),playingCivilization,map,"recover"));
            }
            else if (command.matches(updateUnitRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex1,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex2,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex3)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex3,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex4)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex4,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex5)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex5,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex6)) {
                bool = false;
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex6,command),playingCivilization,map));
            }
            else if(command.matches(cityPanelRegex)){
                bool = false;
                System.out.println(playGameMenuController.cityPanel(map,civilizations));
            }
            else if(command.matches(economicalReviewRegex)){
                bool = false;
                System.out.println(playGameMenuController.economicalReview(playingCivilization));
            }
            else if(command.matches(demographicsRegex)){
                bool = false;
                System.out.println(playGameMenuController.demographics(civilizations,map));
            }
            else if(command.matches(showCurrentScoreRegex)){
                bool = false;
                System.out.println(playGameMenuController.showCurrentScore(civilizations,map));
            }
            else if (command.matches(attackTileRegex1)) {
                System.out.println(playGameMenuController.preAttackTile(matcher(attackTileRegex1,command),playingCivilization,map));
            }
            else if (command.matches(attackTileRegex2)) {
                System.out.println(playGameMenuController.preAttackTile(matcher(attackTileRegex2,command),playingCivilization,map));
            }
            else if (command.matches(cancelCommandRegex)) {
                bool = false;
                Matcher matcher = Pattern.compile(cancelCommandRegex).matcher(command);
                matcher.find();
                int index = Integer.parseInt(matcher.group("number"));
                boolean isCivilian;
                if (matcher.group("type").equals("civilian")) isCivilian = true;
                else isCivilian = false;
                System.out.println(playGameMenuController.cancelCommand(playingCivilization,isCivilian,map,map.get(index)));
            }
            else if (command.matches(cheatCodeMoveUnitRegex1)) {
                bool = false;
                System.out.println(playGameMenuController.cheatTeleportUnit(matcher(cheatCodeMoveUnitRegex1,command),playingCivilization,map));
            }
            else if (command.matches(cheatCodeMoveUnitRegex2)) {
                bool = false;
                System.out.println(playGameMenuController.cheatTeleportUnit(matcher(cheatCodeMoveUnitRegex2,command),playingCivilization,map));
            }
            else if (command.matches(workOnTileRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(workOnTileRegex).matcher(command);
                matcher.find();
                int cityNumber = Integer.parseInt(matcher.group("cityNumber"));
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                int tileUnitNumber = Integer.parseInt(matcher.group("tileUnitNumber"));
                System.out.println(playGameMenuController.workOnTile(playingCivilization, cityNumber, tileNumber, tileUnitNumber, map));
            }
            else if (command.matches(createImprovementRegex)){
                Matcher matcher = Pattern.compile(createImprovementRegex).matcher(command);
                matcher.find();
                int tileUnitNumber = Integer.parseInt(matcher.group("tileUnitNumber"));
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                String improvementName = matcher.group("improvementName");
                System.out.println(playGameMenuController.createImprovement(playingCivilization, tileUnitNumber, tileNumber, improvementName, map));
            }
            else if (command.matches(removeImprovementRegex)){
                Matcher matcher = Pattern.compile(removeImprovementRegex).matcher(command);
                matcher.find();
                String improvementName = matcher.group("improvementName");
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                Improvement improvement = playGameMenuController.preRemoveImprovement(improvementName);
                if (improvement == null)
                    System.out.println("no such improvement exists!");
                else
                    System.out.println(playGameMenuController.removeImprovement(playingCivilization, improvement, tileNumber, map));
            }
            else if(command.matches(cheatIncreaseGoldRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(cheatIncreaseGoldRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseGold(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseFoodRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(cheatIncreaseFoodRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseFood(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseTechnologyRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(cheatIncreaseTechnologyRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseTechnology(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseHappinessRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(cheatIncreaseHappinessRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseHappiness(playingCivilization,amount));
            }
            else if (command.matches(cancelImprovementOnProcessRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(cancelImprovementOnProcessRegex).matcher(command);
                matcher.find();
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                Tile tile = map.get(tileNumber);
                System.out.println(playGameMenuController.cancelImprovementOnProcess(playingCivilization, tile));
            }
            else if (command.matches(repairImprovementRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(repairImprovementRegex).matcher(command);
                matcher.find();
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                int tileUnitNumber = Integer.parseInt(matcher.group("tileUnitNumber"));
                System.out.println(playGameMenuController.repairImprovement(playingCivilization, tileUnitNumber, tileNumber, map));
            }
            else if (command.matches(lootTileRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(lootTileRegex).matcher(command);
                matcher.find();
                int lootTileNumber = Integer.parseInt(matcher.group("lootTileNumber"));
                int tileUnitNumber = Integer.parseInt(matcher.group("tileUnitNumber"));
                System.out.println(playGameMenuController.lootTile(playingCivilization, tileUnitNumber, lootTileNumber, map));
            }
            else if (command.matches(chooseTechnologyToLearnRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(chooseTechnologyToLearnRegex).matcher(command);
                matcher.find();
                String technologyName = matcher.group("technologyName");
                System.out.println(playGameMenuController.chooseTechnologyToLearn(playingCivilization, technologyName));
            }
            else if (command.matches(changeTechnologyToLearnRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(changeTechnologyToLearnRegex).matcher(command);
                matcher.find();
                String technologyName = matcher.group("technologyName");
                System.out.println(playGameMenuController.changeTechnologyToLearn(playingCivilization, technologyName));
            }
            else if (command.matches(showTechnologyMenuRegex)) {
                bool = false;
                System.out.println(playGameMenuController.showTechnologyMenu(playingCivilization));
            }
            else if (command.matches(researchInformationRegex)) {
                System.out.println(playGameMenuController.researchInformation(playingCivilization));
                bool = false;
            }
            else if(command.matches(sendFriendlyRequestDiplomaticRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(sendFriendlyRequestDiplomaticRegex).matcher(command);
                matcher.find();
                String name = matcher.group("civilization");
                System.out.println(playGameMenuController.sendFriendlyRequestDiplomatic(playingCivilization,civilizations,name));
            }
            else if(command.matches(diplomaticInformationRegex)) {
                bool = false;
                System.out.println(playGameMenuController.diplomaticInformation(playingCivilization, map));
            }
            else if(command.matches(showFriendlyRequestsRegex)) {
                bool = false;
                System.out.println(playGameMenuController.showFriendlyRequests(playingCivilization));
            }
            else if(command.matches(acceptFriendlyRequestRegex)) {
                bool = false;
                Matcher matcher = Pattern.compile(acceptFriendlyRequestRegex).matcher(command);
                matcher.find();
                String name = matcher.group("name");
                System.out.println(playGameMenuController.acceptFriendlyRequest(playingCivilization,name));
            }
            else if(command.matches(denyFriendlyRequestRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(denyFriendlyRequestRegex).matcher(command);
                matcher.find();
                String name = matcher.group("name");
                System.out.println(playGameMenuController.denyFriendlyRequest(playingCivilization,name));
            }
            else if(command.matches(breakOathRegex)){
                bool = false;
                Matcher matcher = Pattern.compile(breakOathRegex).matcher(command);
                matcher.find();
                String name = matcher.group("name");
                System.out.println(playGameMenuController.breakTheOath(playingCivilization,name));
            }
            else if(command.matches(diplomaticReviewRegex)) {
                bool = false;
                System.out.println(playGameMenuController.diplomaticReview(playingCivilization));
            }
            else if (command.matches(showRoadsRegex)) {
                bool = false;
                System.out.println(playGameMenuController.roadsInfo(map));
            }
            else if (command.matches(attackCityRegex1)) {
                System.out.println(playGameMenuController.preAttackCity(matcher(attackCityRegex1,command),playingCivilization,map,civilizations));
            }
            else if (command.matches(attackCityRegex2)) {
                System.out.println(playGameMenuController.preAttackCity(matcher(attackCityRegex2,command),playingCivilization,map,civilizations));
            }
            else if(command.matches(showMessagesRegex)){
                bool = false;
                System.out.println(playGameMenuController.showMessages(playingCivilization));
            }
            else if(command.matches(showCitizensRegex)){
                System.out.println(playGameMenuController.showCitizens(playingCivilization));
            }
            else if(command.matches(nextTurnRegex)){
                String result = playGameMenuController.nextTurn(playingCivilization, map);

                if(!Objects.equals(result, "done"))
                    System.out.println(result);
                else {
                    counter++;
                    counter %= numOfCivilizations;
                    playingCivilization = civilizations.get(counter);
                    if(counter == 0)
                        PlayGameMenuController.turn++;
                    System.out.println("Civilization " + playingCivilization.getMember().getUsername() + " is playing!");
                }
            }
            else if(command.matches(showCurrentMenuRegex))
                System.out.println("Play Game Menu");
            else {
                bool = false;
                System.out.println("invalid command !");
            }



            ArrayList<Integer> civilization1new = new ArrayList<>();
            ArrayList<Integer> civilization2new = new ArrayList<>();   ///---> -1, 1
            ArrayList<Integer> civilization3new = new ArrayList<>();
            ArrayList<Integer> civilization4new = new ArrayList<>();
            ArrayList<Integer> civilization5new = new ArrayList<>();

            //TODO... Calling statusChecker Function 3 times
            if (numOfCivilizations == 2) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
            }
            else if (numOfCivilizations == 3) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
            }
            else if (numOfCivilizations == 4) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
                civilization4new = playGameMenuController.statusChecker(civilizations.get(3), map);
            }
            else if (numOfCivilizations == 5) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
                civilization4new = playGameMenuController.statusChecker(civilizations.get(3), map);
                civilization5new = playGameMenuController.statusChecker(civilizations.get(4), map);
            }


            //TODO... Calling statusComparator Function -> civilization1 = statusComparator(civilization1,civilization1new)
            if (numOfCivilizations == 2) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
            }
            else if (numOfCivilizations == 3) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
            }
            else if (numOfCivilizations == 4) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
                tileStatusOfCivilization4 = playGameMenuController.statusComparator(tileStatusOfCivilization4, civilization4new, zeroStatusTilesCivilisation4, map);

            }
            else if (numOfCivilizations == 5) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
                tileStatusOfCivilization4 = playGameMenuController.statusComparator(tileStatusOfCivilization4, civilization4new, zeroStatusTilesCivilisation4, map);
                tileStatusOfCivilization5 = playGameMenuController.statusComparator(tileStatusOfCivilization5, civilization5new, zeroStatusTilesCivilisation5, map);
            }
            if (counter == 0) {
                ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization1, map, zeroStatusTilesCivilisation1, ANSI_COLORS);
                types = playGameMenuController.setTileType(map, ANSI_COLORS, zeroStatusTilesCivilisation1, tileStatusOfCivilization1);
                unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation1, tileStatusOfCivilization1);
                unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation1, tileStatusOfCivilization1);
            }
            else if (counter == 1) {
                ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization2, map, zeroStatusTilesCivilisation2, ANSI_COLORS);
                types = playGameMenuController.setTileType(map, ANSI_COLORS, zeroStatusTilesCivilisation2, tileStatusOfCivilization2);
                unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation2, tileStatusOfCivilization2);
                unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation2, tileStatusOfCivilization2);
            }
            else if (counter == 2) {
                ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization3, map, zeroStatusTilesCivilisation3, ANSI_COLORS);
                types = playGameMenuController.setTileType(map, ANSI_COLORS, zeroStatusTilesCivilisation3, tileStatusOfCivilization3);
                unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation3, tileStatusOfCivilization3);
                unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation3, tileStatusOfCivilization3);
            }
            else if (counter == 3) {
                ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization4, map, zeroStatusTilesCivilisation4, ANSI_COLORS);
                types = playGameMenuController.setTileType(map, ANSI_COLORS, zeroStatusTilesCivilisation4, tileStatusOfCivilization4);
                unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation4, tileStatusOfCivilization4);
                unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation4, tileStatusOfCivilization4);
            }
            else if (counter == 4) {
                ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization5, map, zeroStatusTilesCivilisation5, ANSI_COLORS);
                types = playGameMenuController.setTileType(map, ANSI_COLORS, zeroStatusTilesCivilisation5, tileStatusOfCivilization5);
                unit1 = playGameMenuController.unitMaker(map, 0, zeroStatusTilesCivilisation5, tileStatusOfCivilization5);
                unit2 = playGameMenuController.unitMaker(map, 1, zeroStatusTilesCivilisation5, tileStatusOfCivilization5);
            }
            cv = playGameMenuController.cvMaker(map, playingCivilization);
            cityCenter = playGameMenuController.cityCenterMaker(map, playingCivilization);
            mapString = playGameMenuController.showMap(ANSI_COLORS, number, types, unit1, unit2, cv, cityCenter);

            if(bool)
                for (int i = 0; i < 77; i++)
                    System.out.println(mapString[i]);

            command = scan.nextLine();
        }
    }*/

}
