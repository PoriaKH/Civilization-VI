package View;

import Controller.PlayGameMenuController;

import java.util.Objects;
import java.util.Scanner;

public class PlayGameMenu {
    public void run(Scanner scan){
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){
            //TODO... Calling functions


            command = scan.nextLine();
        }
    }
}
