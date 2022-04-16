package View;

import Controller.PlayGameMenuController;
import Model.Tile;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PlayGameMenu {
    public void run(Scanner scan){
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();

        ArrayList<Tile> map = new ArrayList<>();
        map = playGameMenuController.mapCreator(18);

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){
            //TODO... Calling functions


            command = scan.nextLine();
        }
    }
}
