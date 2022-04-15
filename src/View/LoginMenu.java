package View;

import Controller.LoginMenuController;
import Controller.MainMenuController;

import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public void run(Scanner scan){
        LoginMenuController loginMenuController = new LoginMenuController();
        MainMenu mainMenu = new MainMenu();

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit")){

            //TODO... command.matches Call the LoginMenuController Functions
            mainMenu.run(scan);

            command = scan.nextLine();
        }
    }
}
