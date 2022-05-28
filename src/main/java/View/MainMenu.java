package View;

import Controller.MainMenuController;
import Model.Member;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sun.tools.jar.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    public static Member loggedInMember;
    public static URL scoreBoardFxmlURL;

    public static URL gameMenuFxmlURL;

    public static URL profileFxmlURL;

    public Parent root;

    public Stage stage;

    public Scene scene;


    public void gameMenuSwitch(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(gameMenuFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void profileMenuSwitch(MouseEvent mouseEvent) throws IOException {
        ProfileMenu.loggedInMember = MainMenu.loggedInMember;
        root = FXMLLoader.load(profileFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void scoreboardSwitch(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(scoreBoardFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        loggedInMember = null;
        root = FXMLLoader.load(RegisterMenu.loginMenuFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


//    public MainMenu(Member loggedInMember){
//        this.loggedInMember = loggedInMember;
//    }
    /*
    public void run(Scanner scan) throws IOException {
        System.out.println("user logged in successfully!");
        MainMenuController mainMenuController = new MainMenuController();
        PlayGameMenu playGameMenu = new PlayGameMenu();
        ProfileMenu profileMenu = new ProfileMenu(loggedInMember);
        String enterProfileMenuRegex = "\\s*menu\\s+enter\\s+Profile\\s+Menu\\s*";
        String exitMenuRegex = "\\s*menu\\s+exit\\s*";
        String showCurrentMenuRegex = "\\s*menu\\s+show-current\\s*";
        String logoutRegex = "\\s*user\\s+logout\\s*";
        String playGameRegex1 = "\\s*play\\s+game\\s+--player1\\s+(?<username1>\\S+)";
        String playGameRegex2 = "\\s*play\\s+game\\s+--player1\\s+(?<username1>\\S+)\\s+--player2\\s+(?<username2>\\S+)";
        String playGameRegex3 = "\\s*play\\s+game\\s+--player1\\s+(?<username1>\\S+)\\s+--player2\\s+(?<username2>\\S+)\\s+--player3\\s+(?<username3>\\S+)";
        String playGameRegex4 = "\\s*play\\s+game\\s+--player1\\s+(?<username1>\\S+)\\s+--player2\\s+(?<username2>\\S+)\\s+--player3\\s+(?<username3>\\S+)\\s+--player4\\s+(?<username4>\\S+)";
        String command;
        ArrayList<Member> allMembers = mainMenuController.getAllMembers();

        while(true){
            command = scan.nextLine();
            if (mainMenuController.getMatcher(exitMenuRegex, command) != null) {
                break;
            }
            else if (mainMenuController.getMatcher(logoutRegex, command) != null){
                break;
            }
            else if (mainMenuController.getMatcher(showCurrentMenuRegex, command) != null)
                System.out.println("Main Menu");
            else if(command.matches(playGameRegex1)) {
                Matcher matcher = Pattern.compile(playGameRegex1).matcher(command);
                matcher.find();
                ArrayList<String> userNames = new ArrayList<>();
                userNames.add(matcher.group("username1"));
                int numOfPlayers = 1;
                ArrayList<Member> players = new ArrayList<>();
                players.add(loggedInMember);
                boolean ourBool = true;
                for (int i = 0; i < numOfPlayers; i++) {
                    boolean exist = false;
                    for (int j = 0; j < allMembers.size(); j++) {
                        if (allMembers.get(j).getUsername().equals(userNames.get(i))){
                            players.add(allMembers.get(j));
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        System.out.println("user with this username doesn't exist!");
                        ourBool = false;
                        break;
                    }
                }
                if(ourBool)
                    playGameMenu.run(scan, players.size(), players);
            }
            else if(command.matches(playGameRegex2)) {
                Matcher matcher = Pattern.compile(playGameRegex2).matcher(command);
                matcher.find();
                ArrayList<String> userNames = new ArrayList<>();
                userNames.add(matcher.group("username1"));
                userNames.add(matcher.group("username2"));
                int numOfPlayers = 2;
                ArrayList<Member> players = new ArrayList<>();
                players.add(loggedInMember);
                boolean ourBool = true;
                for (int i = 0; i < numOfPlayers; i++) {
                    boolean exist = false;
                    for (int j = 0; j < allMembers.size(); j++) {
                        if (allMembers.get(j).getUsername().equals(userNames.get(i))){
                            players.add(allMembers.get(j));
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        System.out.println("user with this username doesn't exist!");
                        ourBool = false;
                        break;
                    }
                }
                if(ourBool)
                    playGameMenu.run(scan, players.size(), players);
            }
            else if(command.matches(playGameRegex3)) {
                Matcher matcher = Pattern.compile(playGameRegex1).matcher(command);
                matcher.find();
                ArrayList<String> userNames = new ArrayList<>();
                userNames.add(matcher.group("username1"));
                userNames.add(matcher.group("username2"));
                userNames.add(matcher.group("username3"));
                int numOfPlayers = 3;
                ArrayList<Member> players = new ArrayList<>();
                players.add(loggedInMember);
                boolean ourBool = true;
                for (int i = 0; i < numOfPlayers; i++) {
                    boolean exist = false;
                    for (int j = 0; j < allMembers.size(); j++) {
                        if (allMembers.get(j).getUsername().equals(userNames.get(i))){
                            players.add(allMembers.get(j));
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        System.out.println("user with this username doesn't exist!");
                        ourBool = false;
                        break;
                    }
                }
                if(ourBool)
                    playGameMenu.run(scan, players.size(), players);
            }
            else if(command.matches(playGameRegex4)) {
                Matcher matcher = Pattern.compile(playGameRegex1).matcher(command);
                matcher.find();
                ArrayList<String> userNames = new ArrayList<>();
                userNames.add(matcher.group("username1"));
                userNames.add(matcher.group("username2"));
                userNames.add(matcher.group("username3"));
                userNames.add(matcher.group("username4"));
                int numOfPlayers = 4;
                ArrayList<Member> players = new ArrayList<>();
                players.add(loggedInMember);
                boolean ourBool = true;
                for (int i = 0; i < numOfPlayers; i++) {
                    boolean exist = false;
                    for (int j = 0; j < allMembers.size(); j++) {
                        if (allMembers.get(j).getUsername().equals(userNames.get(i))){
                            players.add(allMembers.get(j));
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        System.out.println("user with this username doesn't exist!");
                        ourBool = false;
                        break;
                    }
                }
                if(ourBool)
                    playGameMenu.run(scan, players.size(), players);
            }
            else if(mainMenuController.getMatcher(enterProfileMenuRegex, command) != null)
                profileMenu.run(scan);
            else
                System.out.println("invalid command");
        }

    }
     */
}
