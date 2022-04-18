package View;

import Controller.LoginMenuController;
import Controller.MainMenuController;
import Model.Member;

import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public void run(Scanner scan){
        Member loggedInMember = new Member();

        LoginMenuController loginMenuController = new LoginMenuController();


        String loginRegex = "";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit")){

            //TODO... command.matches Call the LoginMenuController Functions


            command = scan.nextLine();
        }
    }
}
