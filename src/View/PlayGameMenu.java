package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Member;
import Model.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayGameMenu {

    public Matcher matcher(String regex, String command){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches())
            return matcher;
        return null;
    }

    public void run(Scanner scan, int numOfCivilizations, ArrayList<Member> members){
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();

        ArrayList<Tile> map = new ArrayList<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation1 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation2 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation3 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation4 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation5 = new HashMap<>();
        map = playGameMenuController.mapCreator(numOfCivilizations,members);
        ArrayList<Civilization> civilizations = playGameMenuController.initializeCivilizations(numOfCivilizations, map, members);
        Civilization playingCivilization; // the civilization which is playing now
        int counter = 0;
        playingCivilization = civilizations.get(counter);


        ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
        ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();
        //1 -> vazeh   0 -> moshakhas   -1 -> fog of war
        if (numOfCivilizations == 2) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
        }
        else if (numOfCivilizations == 3) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);
        }
        else if (numOfCivilizations == 4) {
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);///   ----> -1 , 1
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);
            tileStatusOfCivilization4 = playGameMenuController.statusChecker(civilizations.get(3), map);
        }
        else if (numOfCivilizations == 5){
            tileStatusOfCivilization1 = playGameMenuController.statusChecker(civilizations.get(0), map);
            tileStatusOfCivilization2 = playGameMenuController.statusChecker(civilizations.get(1), map);
            tileStatusOfCivilization3 = playGameMenuController.statusChecker(civilizations.get(2), map);///   ----> -1 , 1
            tileStatusOfCivilization4 = playGameMenuController.statusChecker(civilizations.get(3), map);
            tileStatusOfCivilization5 = playGameMenuController.statusChecker(civilizations.get(4), map);
        }
        //TODO... Calling statusChecker Function 3 times
        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){




            //TODO... Calling functions using regex ( if(command.matches(regex) -> func(civ,map,...) )





            command = scan.nextLine();

            ArrayList<Integer> civilization1new = new ArrayList<>();
            ArrayList<Integer> civilization2new = new ArrayList<>();   ///---> -1, 1
            ArrayList<Integer> civilization3new = new ArrayList<>();
            ArrayList<Integer> civilization4new = new ArrayList<>();
            ArrayList<Integer> civilization5new = new ArrayList<>();

            //TODO... Calling statusChecker Function 3 times
            if (numOfCivilizations == 2) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
            }
            else if (numOfCivilizations == 3) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
            }
            else if (numOfCivilizations == 4) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
                civilization4new = playGameMenuController.statusChecker(civilizations.get(3), map);
            }
            else if (numOfCivilizations == 5) {
                civilization1new = playGameMenuController.statusChecker(civilizations.get(0), map);
                civilization2new = playGameMenuController.statusChecker(civilizations.get(1), map);
                civilization3new = playGameMenuController.statusChecker(civilizations.get(2), map);
                civilization4new = playGameMenuController.statusChecker(civilizations.get(3), map);
                civilization5new = playGameMenuController.statusChecker(civilizations.get(4), map);
            }

            //TODO... Calling statusComparator Function -> civilization1 = statusComparator(civilization1,civilization1new)
            if (numOfCivilizations == 2) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
            }
            else if (numOfCivilizations == 3) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
            }
            else if (numOfCivilizations == 4) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
                tileStatusOfCivilization4 = playGameMenuController.statusComparator(tileStatusOfCivilization4, civilization4new, zeroStatusTilesCivilisation4, map);

            }
            else if (numOfCivilizations == 5) {
                tileStatusOfCivilization1 = playGameMenuController.statusComparator(tileStatusOfCivilization1, civilization1new, zeroStatusTilesCivilisation1, map);
                tileStatusOfCivilization2 = playGameMenuController.statusComparator(tileStatusOfCivilization2, civilization2new, zeroStatusTilesCivilisation2, map);
                tileStatusOfCivilization3 = playGameMenuController.statusComparator(tileStatusOfCivilization3, civilization3new, zeroStatusTilesCivilisation3, map);
                tileStatusOfCivilization4 = playGameMenuController.statusComparator(tileStatusOfCivilization4, civilization4new, zeroStatusTilesCivilisation4, map);
                tileStatusOfCivilization5 = playGameMenuController.statusComparator(tileStatusOfCivilization5, civilization5new, zeroStatusTilesCivilisation5, map);
            }
        }
    }
}
