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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String YELLOW = "\u001B[33m";// --> dessert
    public static final String DARK_GREEN = "\u001b[32m";// --> midow
    public static final String LIGHT_GREEN = "\u001b[32;1m";// --> plain
    public static final String BLUE = "\u001B[34m";// --> ocean
    public static final String BROWN = "\u001B[34m";// --> mountain
    public static final String PURPLE = "\u001B[35m";// --> thundra
    public static final String ICY = "\u001B[37m";// --> ice
    public static final String CYAN = "\033[0;36m";// --> hill


    public Matcher matcher(String regex, String command){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches())
            return matcher;
        return null;
    }

    public void run(Scanner scan, int numOfCivilizations, ArrayList<Member> members){
        PlayGameMenuController playGameMenuController = new PlayGameMenuController();
        String ANSI_COLORS[] = new String[72];
        ANSI_COLORS[0] = BROWN;
        ANSI_COLORS[1] = DARK_GREEN;
        ANSI_COLORS[2] = DARK_GREEN;
        ANSI_COLORS[3] = BLUE;
        ANSI_COLORS[4] = BLUE;
        ANSI_COLORS[5] = BLUE;
        ANSI_COLORS[6] = LIGHT_GREEN;
        ANSI_COLORS[7] = DARK_GREEN;
        ANSI_COLORS[8] = DARK_GREEN;
        ANSI_COLORS[9] = LIGHT_GREEN;
        ANSI_COLORS[10] = BLUE;
        ANSI_COLORS[11] = LIGHT_GREEN;
        ANSI_COLORS[12] = CYAN;
        ANSI_COLORS[13] = BROWN;
        ANSI_COLORS[14] = CYAN;
        ANSI_COLORS[15] = PURPLE;
        ANSI_COLORS[16] = ICY;
        ANSI_COLORS[17] = CYAN;
        ANSI_COLORS[18] = YELLOW;
        ANSI_COLORS[19] = CYAN;
        ANSI_COLORS[20] = LIGHT_GREEN;
        ANSI_COLORS[21] = BLUE;
        ANSI_COLORS[22] = PURPLE;
        ANSI_COLORS[23] = YELLOW;
        ANSI_COLORS[24] = YELLOW;
        ANSI_COLORS[25] = ICY;
        ANSI_COLORS[26] = ICY;
        ANSI_COLORS[27] = BLUE;
        ANSI_COLORS[28] = PURPLE;
        ANSI_COLORS[29] = YELLOW;
        ANSI_COLORS[30] = PURPLE;
        ANSI_COLORS[31] = ICY;
        ANSI_COLORS[32] = BLUE;
        ANSI_COLORS[33] = BROWN;
        ANSI_COLORS[34] = BROWN;
        ANSI_COLORS[35] = PURPLE;
        ANSI_COLORS[36] = YELLOW;
        ANSI_COLORS[37] = BLUE;
        ANSI_COLORS[38] = BLUE;
        ANSI_COLORS[39] = YELLOW;
        ANSI_COLORS[40] = YELLOW;
        ANSI_COLORS[41] = YELLOW;
        ANSI_COLORS[42] = PURPLE;
        ANSI_COLORS[43] = ICY;
        ANSI_COLORS[44] = PURPLE;
        ANSI_COLORS[45] = YELLOW;
        ANSI_COLORS[46] = YELLOW;
        ANSI_COLORS[47] = LIGHT_GREEN;
        ANSI_COLORS[48] = PURPLE;
        ANSI_COLORS[49] = YELLOW;
        ANSI_COLORS[50] = LIGHT_GREEN;
        ANSI_COLORS[51] = LIGHT_GREEN;
        ANSI_COLORS[52] = LIGHT_GREEN;
        ANSI_COLORS[53] = PURPLE;
        ANSI_COLORS[54] = YELLOW;
        ANSI_COLORS[55] = ICY;
        ANSI_COLORS[56] = LIGHT_GREEN;
        ANSI_COLORS[57] = LIGHT_GREEN;
        ANSI_COLORS[58] = LIGHT_GREEN;
        ANSI_COLORS[59] = YELLOW;
        ANSI_COLORS[60] = PURPLE;
        ANSI_COLORS[61] = LIGHT_GREEN;
        ANSI_COLORS[62] = YELLOW;
        ANSI_COLORS[63] = YELLOW;
        ANSI_COLORS[64] = YELLOW;
        ANSI_COLORS[65] = PURPLE;
        ANSI_COLORS[66] = BROWN;
        ANSI_COLORS[67] = YELLOW;
        ANSI_COLORS[68] = YELLOW;
        ANSI_COLORS[69] = YELLOW;
        ANSI_COLORS[70] = PURPLE;
        ANSI_COLORS[71] = BROWN;
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
//TODO check she regex ha....
        String showCurrentMenuRegex = "menu show-current";
        String createUnitRegex1 = "^create --unit (?<unitName>.+) in --coordinate x: (?<x>//d+) y: (?<y>//d+)$";
        String createUnitRegex2 = "^create in --coordinate x: (?<x>//d+) y: (?<y>//d+) --unit (?<unitName>.+)$";

        playGameMenuController.showMap(ANSI_COLORS);
        while(!Objects.equals(command, "exit menu")) {
            //TODO... check is there any unit with move left (harekat chand noobati)




            //TODO... Calling functions using regex ( if(command.matches(regex) -> func(civ,map,...) )
            if (command.matches(createUnitRegex1)) {
               playGameMenuController.preUnitMaker (matcher(createUnitRegex1, command), playingCivilization, map);
            }
            else if (command.matches(createUnitRegex2)) {
                playGameMenuController.preUnitMaker (matcher(createUnitRegex1, command), playingCivilization, map);
            }





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
            ANSI_COLORS = playGameMenuController.setTileColors(tileStatusOfCivilization1, map, zeroStatusTilesCivilisation1, ANSI_COLORS);
            playGameMenuController.showMap(ANSI_COLORS);
        }
    }
}
