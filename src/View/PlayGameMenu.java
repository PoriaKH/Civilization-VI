package View;

import Controller.PlayGameMenuController;
import Model.Civilization;
import Model.Improvement;
import Model.Member;
import Model.Tile;
import Model.Units.Civilian;

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
        String number[] = {" 0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71"};
        String types[] = new String[72];
        String cv[] = new String[72];
        String unit1[] = new String[72];
        String unit2[] = new String[72];
        String mapString[] = new String[72];
        for (int i = 0; i < 72; i++){
            types[i] = "\u2588";
            unit1[i] = "\u2588" + "\u2588";
            unit2[i] = "\u2588" + "\u2588";
            cv[i] = "\u2588";
        }
        //jungle -> j, plat -> p, vahhe(oasis) -> v, marsh --> m, rainforest --> r, ice --> i
        types[0] = "j";
        types[13] = "p";
        types[17] = "p";
        types[19] = "p";
        types[20] = "p";
        types[22] = "p";
        types[33] = "j";
        types[34] = "j";
        types[66] = "j";
        types[71] = "j";
        ArrayList<Tile> map = new ArrayList<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation1 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation2 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation3 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation4 = new HashMap<>();
        HashMap<Integer, Tile> zeroStatusTilesCivilisation5 = new HashMap<>();
        map = playGameMenuController.mapCreator(numOfCivilizations,members);
        ArrayList<Civilization> civilizations = playGameMenuController.initializeCivilizations(numOfCivilizations, map, members);
        Civilization playingCivilization; // the civilization which is playing now
        int counter = 0; //count 0 to numOfCivilizations - 1
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

        for (int i = 0; i < civilizations.size(); i++) {
            for (int i1 = 0; i1 < civilizations.size(); i1++) {
                if (i != i1) {
                    civilizations.get(i).addCivilizationToWinsUnit(civilizations.get(i1));
                    civilizations.get(i).addCivilizationToLossesUnit(civilizations.get(i1));
                }
            }
        }

        String command;
        command = scan.nextLine();

        String showCurrentMenuRegex = "menu show-current";
        String createUnitRegex1 = "^create --unit (?<unitName>.+) tile --number (?<number>\\d+)$";
        String createUnitRegex2 = "^create tile --number (?<number>\\d+) --unit (?<unitName>.+)$";
        String moveUnitRegex1 = "^move --unit (?<unitName>.+) --path (?<numberO>\\d+ to ?<numberD>\\d+)$";
        String moveUnitRegex2 = "^move --path (?<numberO>\\d+ to ?<numberD>\\d+) --unit (?<unitName>.+)$";
        String sleepUnitRegex1 = "^sleep --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String sleepUnitRegex2 = "^sleep --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String alertUnitRegex1 = "^alert --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String alertUnitRegex2 = "^alert --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String fortifyRegex1 = "^fortify --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String fortifyRegex2 = "^fortify --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String healRegex1 = "^fortify heal --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String healRegex2 = "^fortify heal --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String deployRegex1 = "^deploy --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String deployRegex2 = "^deploy --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String rangedRegex1 = "^set up range --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String rangedRegex2 = "^set up range --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String wakeUpRegex1 = "^wake --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String wakeUpRegex2 = "^wake --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String createCityRegex = "create city (?<tile>\\d+)";
        String lockCitizenRegex = "lock citizen (?<origin>\\d+) (?<destination>\\d+)";//move citizen from origin to destination
        String purchaseTileRegex = "purchase tile (?<tile>\\d+)";
        String workOnTileRegex = "city (?<cityNumber>\\d+) citizen (?<citizenNumber>\\d+) work on --tile (?<tileNumber>\\d+)";
        String createImprovementRegex = "create improvement (?<improvementName>.+) --tile (?<tileNumber>\\d+) --civilian (?<civilianNumber>\\d+)";
        String removeImprovementRegex = "remove improvement (?<improvementName>.+) --tile (?<tileNumber>\\d+)";
        String createRoadRegex = "^create road on --tile (?<number>\\d+)$";
        String createRailwayRegex = "^create rail way on --tile (?<number>\\d+)$";
        String removeRoadRegex = "^remove road on --tile (?<number>\\d+)$";
        String removeRailwayRegex = "^remove rail way on --tile (?<number>\\d+)$";
        String repairRoadRegex = "^repair road on --tile (?<number>\\d+)$";
        String repairRailRegex = "^repair rail on --tile (?<number>\\d+)$";
        String deleteUnitRegex1 = "^delete --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String deleteUnitRegex2 = "^delete --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String unitPanelRegex = "^unit panel$";
        String unitGeneralPanelRegex = "^unit general panel$";
        String victoryImprovementRegex = "^victory improvement$";
        String recoverUnitRegex1 = "^recover --tile (?<number>\\d+) --unit (?<unitName>.+)$";
        String recoverUnitRegex2 = "^recover --unit (?<unitName>.+) --tile (?<number>\\d+)$";
        String updateUnitRegex1 = "^update warrior --tile (?<number>\\d+) --oldUnit (?<oldUnitName>.+) --newUnit (?<newUnitName>.+)$";
        String updateUnitRegex2 = "^update warrior --tile (?<number>\\d+) --newUnit (?<newUnitName>.+) --oldUnit (?<oldUnitName>.+)$";
        String updateUnitRegex3 = "^update warrior --oldUnit (?<oldUnitName>.+) --tile (?<number>\\d+) --newUnit (?<newUnitName>.+)$";
        String updateUnitRegex4 = "^update warrior --oldUnit (?<oldUnitName>.+) --newUnit (?<newUnitName>.+) --tile (?<number>\\d+)$";
        String updateUnitRegex5 = "^update warrior --newUnit (?<newUnitName>.+) --tile (?<number>\\d+) --oldUnit (?<oldUnitName>.+)$";
        String updateUnitRegex6 = "^update warrior --newUnit (?<newUnitName>.+) --oldUnit (?<oldUnitName>.+) --tile (?<number>\\d+)$";
        String cityPanelRegex = "city panel";
        String economicalReviewRegex = "economical review";
        String demographicsRegex = "demographics";
        String showCurrentScoreRegex = "show score";
        String cheatIncreaseGoldRegex = "cheat increase gold (?<amount>\\d+)";
        String cheatIncreaseFoodRegex = "cheat increase food (?<amount>\\d+)";
        String cheatIncreaseTechnologyRegex = "cheat increase technology (?<amount>\\d+)";
        String cheatIncreaseHappinessRegex = "cheat increase happiness (?<amount>\\d+)";
        String cancelImprovementOnProcessRegex = "cancel improvement on tile (?<tileNumber> \\d+)";
        String repairImprovementRegex = "repair improvements in tile (?<tileNumber>\\d+) unit (?<unitNumber>\\d+)";
        String lootTileRegex = "loot tile (?<tileNumber>\\d+) unit (?<unitNumber>\\d+)";
        String chooseTechnologyToLearnRegex = "learn technology (?<technologyName>.+)";
        String changeTechnologyToLearnRegex = "change technology to learn (?<technologyName>.+)";
        String showTechnologyMenuRegex = "show technology menu";
        String researchInformationRegex = "show research information";
        String attackTileRegex1 = "attackTile --tile (?<origin>\\d+) to --tile (?<destination>\\d+)";
        String attackTileRegex2 = "attackTile to --tile (?<destination>\\d+) --tile (?<origin>\\d+)";
        String cancelCommandRegex = "cancel unit making on --tile (?<number>\\d+) --type (?<type>.+)";
        String cheatCodeMoveUnitRegex1 = "^cheat code move --unit (?<unitName>.+) --path (?<numberO>\\d+ to ?<numberD>\\d+)$";
        String cheatCodeMoveUnitRegex2 = "^cheat code move --path (?<numberO>\\d+ to ?<numberD>\\d+) --unit (?<unitName>.+)$";
        String diplomaticInformationRegex = "diplomatic information";
        String sendFriendlyRequestDiplomaticRegex = "send friendly request to (?<civilization>.*)";
        String nextTurnRegex = "";

        mapString = playGameMenuController.showMap(ANSI_COLORS, number, types, unit1, unit2, cv);
        for (int i = 0; i < 72; i++)
            System.out.println(mapString[i]);

        while(!Objects.equals(command, "exit menu")) {





            //TODO... Calling functions using regex ( if(command.matches(regex) -> func(civ,map,...) )
            if (command.matches(createUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitMaker (matcher(createUnitRegex1, command), playingCivilization, map));
            }
            else if (command.matches(createUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitMaker (matcher(createUnitRegex2, command), playingCivilization, map));
            }
            else if (command.matches(moveUnitRegex1)) {
                System.out.println(playGameMenuController.preMoveUnit(matcher(moveUnitRegex1, command), playingCivilization, map));
            }
            else if (command.matches(moveUnitRegex2)) {
                System.out.println(playGameMenuController.preMoveUnit(matcher(moveUnitRegex2, command), playingCivilization, map));
            }
            else if (command.matches(sleepUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(sleepUnitRegex1, command), playingCivilization, map, "sleep"));
            }
            else if (command.matches(sleepUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(sleepUnitRegex2, command), playingCivilization, map, "sleep"));
            }
            else if (command.matches(alertUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(alertUnitRegex1,command), playingCivilization, map, "alert"));
            }
            else if (command.matches(alertUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(alertUnitRegex2,command), playingCivilization, map, "alert"));
            }
            else if (command.matches(fortifyRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(fortifyRegex1,command),playingCivilization,map,"fortify"));
            }
            else if (command.matches(fortifyRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(fortifyRegex2,command),playingCivilization,map,"fortify"));
            }
            else if (command.matches(healRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(healRegex1,command),playingCivilization,map,"heal"));
            }
            else if (command.matches(healRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(healRegex2,command),playingCivilization,map,"heal"));
            }
            else if (command.matches(deployRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deployRegex1,command),playingCivilization,map,"deploy"));
            }
            else if (command.matches(deployRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deployRegex2,command),playingCivilization,map,"deploy"));
            }
            else if (command.matches(rangedRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(rangedRegex1,command),playingCivilization,map,"range"));
            }
            else if (command.matches(rangedRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(rangedRegex2,command),playingCivilization,map,"range"));
            }
            else if (command.matches(wakeUpRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(wakeUpRegex1,command),playingCivilization,map,"wake"));
            }
            else if (command.matches(wakeUpRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(wakeUpRegex2,command),playingCivilization,map,"wake"));
            }
            else if(command.matches(createCityRegex))
                System.out.println(playGameMenuController.preCreateCity(matcher(createCityRegex,command),playingCivilization,map,civilizations));
            else if(command.matches(lockCitizenRegex))
                System.out.println(playGameMenuController.preLockCitizen(matcher(lockCitizenRegex,command),playingCivilization,map));
            else if(command.matches(purchaseTileRegex))
                System.out.println(playGameMenuController.prePurchaseTile(matcher(purchaseTileRegex,command),playingCivilization,map,civilizations));
            else if (command.matches(createRoadRegex)) {
                System.out.println(playGameMenuController.createRoad(playingCivilization, map.get(Integer.parseInt(matcher(createRoadRegex,command).group("number"))),map));
            }
            else if (command.matches(createRailwayRegex)) {
                System.out.println(playGameMenuController.createRailRoad(playingCivilization, map.get(Integer.parseInt(matcher(createRailwayRegex,command).group("number"))),map));
            }
            else if (command.matches(removeRoadRegex)) {
                System.out.println(playGameMenuController.removeRoad(playingCivilization, map.get(Integer.parseInt(matcher(removeRoadRegex,command).group("number"))),map));
            }
            else if (command.matches(removeRailwayRegex)) {
                System.out.println(playGameMenuController.removeRailRoad(playingCivilization, map.get(Integer.parseInt(matcher(removeRailwayRegex,command).group("number"))),map));
            }
            else if (command.matches(repairRoadRegex)) {
                System.out.println(playGameMenuController.repairRoad(playingCivilization,map.get(Integer.parseInt(matcher(repairRoadRegex,command).group("number"))),map));
            }
            else if (command.matches(repairRailRegex)) {
                System.out.println(playGameMenuController.repairRail(playingCivilization,map.get(Integer.parseInt(matcher(repairRailRegex,command).group("number"))),map));
            }
            else if (command.matches(deleteUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deleteUnitRegex1,command),playingCivilization,map,"delete"));
            }
            else if (command.matches(deleteUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(deleteUnitRegex2,command),playingCivilization,map,"delete"));
            }
            else if (command.matches(unitPanelRegex)) {
                System.out.println(playGameMenuController.unitPanel(playingCivilization, map));
            }
            else if (command.matches(unitGeneralPanelRegex)) {
                System.out.println(playGameMenuController.generalUnitReview(playingCivilization, map));
            }
            else if (command.matches(victoryImprovementRegex)) {
                System.out.println(playGameMenuController.victoryImprovement(playingCivilization, map));
            }
            else if (command.matches(recoverUnitRegex1)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(recoverUnitRegex1,command),playingCivilization,map,"recover"));
            }
            else if (command.matches(recoverUnitRegex2)) {
                System.out.println(playGameMenuController.preUnitBehaviour(matcher(recoverUnitRegex2,command),playingCivilization,map,"recover"));
            }
            else if (command.matches(updateUnitRegex1)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex1,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex2)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex2,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex3)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex3,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex4)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex4,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex5)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex5,command),playingCivilization,map));
            }
            else if (command.matches(updateUnitRegex6)) {
                System.out.println(playGameMenuController.preUpgradeUnit(matcher(updateUnitRegex6,command),playingCivilization,map));
            }
            else if(command.matches(cityPanelRegex)){
                System.out.println(playGameMenuController.cityPanel(map,civilizations));
            }
            else if(command.matches(economicalReviewRegex)){
                System.out.println(playGameMenuController.economicalReview(playingCivilization));
            }
            else if(command.matches(demographicsRegex)){
                System.out.println(playGameMenuController.demographics(civilizations,map));
            }
            else if(command.matches(showCurrentScoreRegex)){
                System.out.println(playGameMenuController.showCurrentScore(civilizations,map));
            }
            else if (command.matches(attackTileRegex1)) {
                System.out.println(playGameMenuController.preAttackTile(matcher(attackTileRegex1,command),playingCivilization,map));
            }
            else if (command.matches(attackTileRegex2)) {
                System.out.println(playGameMenuController.preAttackTile(matcher(attackTileRegex2,command),playingCivilization,map));
            }
            else if (command.matches(cancelCommandRegex)) {
                Matcher matcher = Pattern.compile(cancelCommandRegex).matcher(command);
                matcher.find();
                int index = Integer.parseInt(matcher.group("number"));
                boolean isCivilian;
                if (matcher.group("type").equals("civilian")) isCivilian = true;
                else isCivilian = false;
                System.out.println(playGameMenuController.cancelCommand(playingCivilization,isCivilian,map,map.get(index)));
            }
            else if (command.matches(cheatCodeMoveUnitRegex1)) {
                System.out.println(playGameMenuController.cheatTeleportUnit(matcher(cheatCodeMoveUnitRegex1,command),playingCivilization,map));
            }
            else if (command.matches(cheatCodeMoveUnitRegex2)) {
                System.out.println(playGameMenuController.cheatTeleportUnit(matcher(cheatCodeMoveUnitRegex2,command),playingCivilization,map));
            }
            else if (command.matches(workOnTileRegex)){
                Matcher matcher = Pattern.compile(workOnTileRegex).matcher(command);
                matcher.find();
                int cityNumber = Integer.parseInt(matcher.group("cityNumber"));
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                int citizenNumber = Integer.parseInt(matcher.group("citizenNumber"));
                System.out.println(playGameMenuController.workOnTile(playingCivilization, cityNumber, tileNumber, citizenNumber, map));
            }
            else if (command.matches(createImprovementRegex)){
                Matcher matcher = Pattern.compile(createImprovementRegex).matcher(command);
                matcher.find();
                int civilianNumber = Integer.parseInt(matcher.group("civilianNumber"));
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                String improvementName = matcher.group("improvementName");
                Civilian civilian = (Civilian) playGameMenuController.preCreateImprovement(civilianNumber, playingCivilization);
                System.out.println(playGameMenuController.createImprovement(playingCivilization, civilian, tileNumber, improvementName, map));
            }
            else if (command.matches(removeImprovementRegex)){
                Matcher matcher = Pattern.compile(removeImprovementRegex).matcher(command);
                matcher.find();
                String improvementName = matcher.group("improvementName");
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                Improvement improvement = playGameMenuController.preRemoveImprovement(improvementName);
                if (improvement == null)
                    System.out.println("no such improvement exists!");
                else
                    System.out.println(playGameMenuController.removeImprovement(playingCivilization, improvement, tileNumber, map));
            }
            else if(command.matches(cheatIncreaseGoldRegex)){
                Matcher matcher = Pattern.compile(cheatIncreaseGoldRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseGold(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseFoodRegex)){
                Matcher matcher = Pattern.compile(cheatIncreaseFoodRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseFood(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseTechnologyRegex)){
                Matcher matcher = Pattern.compile(cheatIncreaseTechnologyRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseTechnology(playingCivilization,amount));
            }
            else if(command.matches(cheatIncreaseHappinessRegex)){
                Matcher matcher = Pattern.compile(cheatIncreaseHappinessRegex).matcher(command);
                matcher.find();
                int amount = Integer.parseInt(matcher.group("amount"));
                System.out.println(playGameMenuController.cheatIncreaseHappiness(playingCivilization,amount));
            }
            else if (command.matches(cancelImprovementOnProcessRegex)){
                Matcher matcher = Pattern.compile(cancelImprovementOnProcessRegex).matcher(command);
                matcher.find();
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                Tile tile = map.get(tileNumber);
                System.out.println(playGameMenuController.cancelImprovementOnProcess(playingCivilization, tile));
            }
            else if (command.matches(repairImprovementRegex)){
                Matcher matcher = Pattern.compile(repairImprovementRegex).matcher(command);
                matcher.find();
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                int civilianNumber = Integer.parseInt(matcher.group("unitNumber"));
                System.out.println(playGameMenuController.repairImprovement(playingCivilization, civilianNumber, tileNumber, map));
            }
            else if (command.matches(lootTileRegex)){
                Matcher matcher = Pattern.compile(lootTileRegex).matcher(command);
                matcher.find();
                int tileNumber = Integer.parseInt(matcher.group("tileNumber"));
                int warriorNumber = Integer.parseInt(matcher.group("unitNumber"));
                System.out.println(playGameMenuController.lootTile(playingCivilization, warriorNumber, tileNumber, map));
            }
            else if (command.matches(chooseTechnologyToLearnRegex)){
                Matcher matcher = Pattern.compile(chooseTechnologyToLearnRegex).matcher(command);
                matcher.find();
                String technologyName = matcher.group("technologyName");
                System.out.println(playGameMenuController.chooseTechnologyToLearn(playingCivilization, technologyName));
            }
            else if (command.matches(chooseTechnologyToLearnRegex)){
                Matcher matcher = Pattern.compile(changeTechnologyToLearnRegex).matcher(command);
                matcher.find();
                String technologyName = matcher.group("technologyName");
                System.out.println(playGameMenuController.changeTechnologyToLearn(playingCivilization, technologyName));
            }
            else if (command.matches(showTechnologyMenuRegex))
                System.out.println(playGameMenuController.showTechnologyMenu(playingCivilization));
            else if (command.matches(researchInformationRegex))
                System.out.println(playGameMenuController.researchInformation(playingCivilization));
            else if(command.matches(sendFriendlyRequestDiplomaticRegex)){
                Matcher matcher = Pattern.compile(sendFriendlyRequestDiplomaticRegex).matcher(command);
                matcher.find();
                String name = matcher.group("civilization");
                System.out.println(playGameMenuController.sendFriendlyRequestDiplomatic(playingCivilization,civilizations,name));
            }
            else if(command.matches(diplomaticInformationRegex))
                System.out.println(playGameMenuController.diplomaticInformation(civilizations,map));
            else if(command.matches(nextTurnRegex)){
                String result = playGameMenuController.nextTurn(playingCivilization, map);

                if(!Objects.equals(result, "done"))
                    System.out.println(result);
                else {
                    counter++;
                    counter %= numOfCivilizations;
                    playingCivilization = civilizations.get(counter);
                    System.out.println("Civilization " + playingCivilization.getMember().getUsername() + " is playing!");
                }
            }
            else if(command.matches(showCurrentMenuRegex))
                System.out.println("Play Game Menu");
            else
                System.out.println("invalid command !");

            //TODO... check is there any unit with move left (harekat chand noobati)
            playGameMenuController.moveUnitWithMovesLeft (playingCivilization, map);





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
            types = playGameMenuController.setTileType(map);
            cv = playGameMenuController.cvMaker(map, playingCivilization);
            unit1 = playGameMenuController.unitMaker(map, 0);
            unit2 = playGameMenuController.unitMaker(map, 1);
            mapString = playGameMenuController.showMap(ANSI_COLORS, number, types, unit1, unit2, cv);
            for (int i = 0; i < 72; i++)
                System.out.println(mapString[i]);
        }
    }
}
