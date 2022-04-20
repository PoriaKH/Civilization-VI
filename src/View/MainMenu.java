package View;

import Controller.MainMenuController;
import Model.Member;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
    private Member loggedInMember;
    public MainMenu(Member loggedInMember){
        this.loggedInMember = loggedInMember;
    }
    public void run(Scanner scan, LoginMenu loginMenu){
        System.out.println("user logged in successfully!");
        MainMenuController mainMenuController = new MainMenuController();
        PlayGameMenu playGameMenu = new PlayGameMenu();
        ProfileMenu profileMenu = new ProfileMenu(loggedInMember);
        String exitMenuRegex = "\\s*menu\\s+exit\\s*";
        String showCurrentMenuRegex = "\\s*menu\\s+show-current\\s*";
        String logoutRegex = "\\s*user\\s+logout\\s*";
        String playGameRegex = "\\s*play\\s+game\\s+(--player\\d{1,}\\s+?<username>){1,}";
        String command;

        while(true){
            command = scan.nextLine();
            if (mainMenuController.getMatcher(exitMenuRegex, command) != null)
                break;
            else if (mainMenuController.getMatcher(logoutRegex, command) != null){
                System.out.println("user logged out successfully!");
                break;
            }
            else if (mainMenuController.getMatcher(showCurrentMenuRegex, command) != null)
                System.out.println("Main Menu");
            else if(mainMenuController.getMatcher(playGameRegex, command) != null) {
                int numOfPlayers;
                ArrayList<Member> members = new ArrayList<>();
                ArrayList<String> userNames = new ArrayList<>();
                for (int i = 0; i < numOfPlayers; i++) {
                    String nameInFile = "";
                    if (Objects.equals(userNames.get(i), nameInFile)) {
                        Member newMember = new Member();
                        members.add(newMember);
                    }
                }
                playGameMenu.run(scan, numOfPlayers, members);
            }
            else
                System.out.println("invalid command");
        }

    }
}
