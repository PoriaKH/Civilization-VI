package View;

import Controller.MainMenuController;

import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
    public void run(Scanner scan){
        MainMenuController mainMenuController = new MainMenuController();
        PlayGameMenu playGameMenu = new PlayGameMenu();
        ProfileMenu profileMenu = new ProfileMenu();

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit") && !Objects.equals(command, "user logout")){
            //TODO...

            command = scan.nextLine();
        }
    }
}
