package View;

import Controller.ProfileMenuController;

import java.util.Objects;
import java.util.Scanner;

public class ProfileMenu {
    public void run(Scanner scan){
        ProfileMenuController profileMenuController = new ProfileMenuController();

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){
            //TODO...


            command = scan.nextLine();
        }
    }
}
