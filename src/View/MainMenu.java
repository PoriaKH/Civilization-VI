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
    public void run(Scanner scan){


        MainMenuController mainMenuController = new MainMenuController();
        PlayGameMenu playGameMenu = new PlayGameMenu();
        ProfileMenu profileMenu = new ProfileMenu(loggedInMember);

        String playGameRegex = "";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit") && !Objects.equals(command, "user logout")){
            //TODO...

            if(command.matches(playGameRegex)){
                int numOfPlayers;
                ArrayList<Member> members = new ArrayList<>();
                ArrayList<String> userNames = new ArrayList<>();
                for(int i = 0; i < numOfPlayers; i++){
                    String nameInFile = "";
                    if(Objects.equals(userNames.get(i), nameInFile)){
                        Member newMember = new Member();
                        members.add(newMember);
                    }
                }
                playGameMenu.run(scan,numOfPlayers,members);
            }
            command = scan.nextLine();
        }
    }
}
