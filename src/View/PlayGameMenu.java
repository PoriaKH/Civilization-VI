package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Member;
import Model.Tile;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;

public class PlayGameMenu {

    public Matcher matcher(String regex, String command){
        Matcher matcher;

        return matcher;
    }

    public void run(Scanner scan, int numOfCivilizations, ArrayList<Member> members){
        ArrayList<Civilization> civilizations = new ArrayList<>();
        for(int i = 0; i < numOfCivilizations; i++){

        }
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();

        ArrayList<Tile> map = new ArrayList<>();
        map = playGameMenuController.mapCreator(numOfCivilizations,members);
        //1 -> vazeh   0 -> moshakhas   -1 -> fog of war
        ArrayList<Integer> civilization1 = new ArrayList<>();
        ArrayList<Integer> civilization2 = new ArrayList<>();   ///   ----> -1 , 0, 1
        ArrayList<Integer> civilization3 = new ArrayList<>();
        //TODO... Calling statusChecker Function 3 times
        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){


            //TODO... Calling functions


            command = scan.nextLine();

            ArrayList<Integer> civilization1new = new ArrayList<>();
            ArrayList<Integer> civilization2new = new ArrayList<>();   ///---> -1  ,   1
            ArrayList<Integer> civilization3new = new ArrayList<>();
            //TODO... Calling statusChecker Function 3 times


            //TODO... Calling statusComparator Function -> civilization1 = statusComparator(civilization1,civilization1new)

        }
    }
}
