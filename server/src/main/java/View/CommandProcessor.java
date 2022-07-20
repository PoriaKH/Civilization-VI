package View;

import Controller.PlayGameMenuController;
import Model.*;
import Model.FunctionsGson.*;
import Model.Units.Unit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    public static ArrayList<GsonRoom> rooms = new ArrayList<>();
    public static ArrayList<Socket> allSockets = new ArrayList<>();
    public static ArrayList<ArrayList<Socket>> sockets = new ArrayList<>();
    public static ArrayList<ArrayList<Member>> members = new ArrayList<>();
    public static PlayGameMenuController playGameMenuController = new PlayGameMenuController();
    public static ArrayList<GameGroup> gameGroups;

    public static void run(String command, GsonRoomArray gsonRoomArray, DataOutputStream dataOutputStream, Socket socket, DataInputStream dataInputStream) throws IOException {
        if(command.startsWith("{\"creatorSocket")){
            Gson gson = new GsonBuilder().create();
            GsonRoom gsonRoom = gson.fromJson(command,GsonRoom.class);
            rooms.add(gsonRoom);
            gsonRoomArray.gsonRooms.add(gsonRoom);
        }
        else if(command.startsWith("{\"username")){
            Gson gson = new GsonBuilder().create();
            Member member = gson.fromJson(command,Member.class);
            for(GsonRoom room : rooms){
                if(Objects.equals(room.creatorMember.getUsername(), member.getUsername())){
                    rooms.remove(room);
                    gsonRoomArray.gsonRooms.remove(room);
                    break;
                }
            }
            for(GsonRoom room : rooms){
                int index = 0;
                for(String str : room.nicknames){
                    if(Objects.equals(str, member.getNickname())){
                        room.nicknames.remove(index);
                        room.members.remove(index);
                        room.sockets.remove(index);
                        break;
                    }
                    index++;
                }
            }
        }
        else if(Objects.equals(command,"return hosts")){
            Gson gson = new GsonBuilder().create();
            String str = gson.toJson(gsonRoomArray);
            dataOutputStream.writeUTF(str);
            System.out.println(str);
        }
        else if(command.startsWith("set gson room:")){
            Matcher matcher = Pattern.compile("set gson room:(?<text>.*)").matcher(command);
            matcher.find();
            String text = matcher.group("text");
            Gson gson = new GsonBuilder().create();
//            System.out.println(gsonRoomArray.gsonRooms.size());
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
//                System.out.println("are we here");
                if(Objects.equals(gsonRoom.creatorMember.getNickname(), text)){
                    String str = gson.toJson(gsonRoom,GsonRoom.class);
                    dataOutputStream.writeUTF(str);
                    return;
                }
            }
            dataOutputStream.writeUTF("null");
        }
        else if(command.startsWith("{\"member")){
            Gson gson = new GsonBuilder().create();
            JoinRequestClass joinRequestClass = gson.fromJson(command,JoinRequestClass.class);

            String text = joinRequestClass.text;
            String nick = joinRequestClass.nick;
            Member member = joinRequestClass.member;

            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                if(Objects.equals(text, gsonRoom.creatorMember.getNickname())){
                    gsonRoom.members.add(member);
                    gsonRoom.nicknames.add(nick);
                    GameSocket gameSocket = new GameSocket(socket.getLocalAddress().toString(),socket.getLocalPort(),socket.getPort());
                    gsonRoom.sockets.add(gameSocket);
                    break;
                }
            }
        }
        else if(command.equals("amIKicked")){
            System.out.println("socket.getPort = " + socket.getPort());
            System.out.println("socket.getLocalPort = " + socket.getLocalPort());
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                for(GameSocket gameSocket : gsonRoom.sockets){
                    if(gameSocket.socketPort == socket.getPort()){
                        dataOutputStream.writeUTF("false");
                        return;
                    }
                }
            }
            dataOutputStream.writeUTF("true");
        }
        else if(command.startsWith("kick:")){
            Matcher matcher = Pattern.compile("kick:(?<nick>.*)").matcher(command);
            matcher.find();
            String nick = matcher.group("nick");
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                int index = 0;
                for(String str : gsonRoom.nicknames){
                    if(Objects.equals(str, nick)){
                        gsonRoom.sockets.remove(index);
                        gsonRoom.nicknames.remove(index);
                        gsonRoom.members.remove(index);
                        return;
                    }
                    index++;
                }
            }
        }
        else if(command.startsWith("{\"gameSockets")){
            Gson gson = new GsonBuilder().create();
            GameSocketArray gameSocketArray = gson.fromJson(command,GameSocketArray.class);
            ArrayList<Socket> sockets2 = new ArrayList<>();
            ArrayList<Member> members2 = new ArrayList<>();
            for(GameSocket gameSocket : gameSocketArray.gameSockets){
                for(Socket socket1 : allSockets){
                    if(gameSocket.socketPort == socket1.getPort()){
                        sockets2.add(socket1);
                    }
                }
                members2.add(gameSocket.member);
            }
            sockets.add(sockets2);
            members.add(members2);

            dataOutputStream.writeUTF("give me members");
            dataOutputStream.flush();

            String str = dataInputStream.readUTF();
            Gson gson1 = new GsonBuilder().create();
            GsonRoom gsonRoom = gson1.fromJson(str,GsonRoom.class);
            members2 = gsonRoom.members;

            GameGroup gameGroup = new GameGroup();
            gameGroup.sockets = sockets2;
            gameGroup.members = members2;
            System.out.println("members = " + members);


            gameGroup.tiles = playGameMenuController.mapCreator(members.size(),members2);
            gameGroup.civilizations = playGameMenuController.initializeCivilizations(members.size(), gameGroup.tiles, members2);
            gameGroup.civilizations.get(0).isMyTurn = true;

            // TODO ... kian sakht map ro check kon
            int numOfCivilizations = gameGroup.civilizations.size();
            ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
            ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
            ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
            ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
            ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();

            if (numOfCivilizations == 2) {
                tileStatusOfCivilization1 = playGameMenuController.statusChecker(gameGroup.civilizations.get(0), gameGroup.tiles);
                tileStatusOfCivilization2 = playGameMenuController.statusChecker(gameGroup.civilizations.get(1), gameGroup.tiles);///   ----> -1 , 1
            }
            else if (numOfCivilizations == 3) {
                tileStatusOfCivilization1 = playGameMenuController.statusChecker(gameGroup.civilizations.get(0), gameGroup.tiles);
                tileStatusOfCivilization2 = playGameMenuController.statusChecker(gameGroup.civilizations.get(1), gameGroup.tiles);///   ----> -1 , 1
                tileStatusOfCivilization3 = playGameMenuController.statusChecker(gameGroup.civilizations.get(2), gameGroup.tiles);
            }
            else if (numOfCivilizations == 4) {
                tileStatusOfCivilization1 = playGameMenuController.statusChecker(gameGroup.civilizations.get(0), gameGroup.tiles);
                tileStatusOfCivilization2 = playGameMenuController.statusChecker(gameGroup.civilizations.get(1), gameGroup.tiles);///   ----> -1 , 1
                tileStatusOfCivilization3 = playGameMenuController.statusChecker(gameGroup.civilizations.get(2), gameGroup.tiles);
                tileStatusOfCivilization4 = playGameMenuController.statusChecker(gameGroup.civilizations.get(3), gameGroup.tiles);
            }
            else if (numOfCivilizations == 5){
                tileStatusOfCivilization1 = playGameMenuController.statusChecker(gameGroup.civilizations.get(0), gameGroup.tiles);
                tileStatusOfCivilization2 = playGameMenuController.statusChecker(gameGroup.civilizations.get(1), gameGroup.tiles);
                tileStatusOfCivilization3 = playGameMenuController.statusChecker(gameGroup.civilizations.get(2), gameGroup.tiles);///   ----> -1 , 1
                tileStatusOfCivilization4 = playGameMenuController.statusChecker(gameGroup.civilizations.get(3), gameGroup.tiles);
                tileStatusOfCivilization5 = playGameMenuController.statusChecker(gameGroup.civilizations.get(4), gameGroup.tiles);
            }
            gameGroup.tileStatusOfCivilization1 = tileStatusOfCivilization1;
            gameGroup.tileStatusOfCivilization2 = tileStatusOfCivilization2;
            gameGroup.tileStatusOfCivilization3 = tileStatusOfCivilization3;
            gameGroup.tileStatusOfCivilization4 = tileStatusOfCivilization4;
            gameGroup.tileStatusOfCivilization5 = tileStatusOfCivilization5;

            /*for (int i = 0; i < 72; i++)
                gameGroup.tiles.get(i).generatingTile(tileStatusOfCivilization1.get(i));*/

            for (int i = 0; i < gameGroup.civilizations.size(); i++) {
                for (int i1 = 0; i1 < gameGroup.civilizations.size(); i1++) {
                    if (i != i1) {
                        gameGroup.civilizations.get(i).addCivilizationToWinsUnit(gameGroup.civilizations.get(i1));
                        gameGroup.civilizations.get(i).addCivilizationToLossesUnit(gameGroup.civilizations.get(i1));
                    }
                }
            }
            GameGroupData gameGroupData = new GameGroupData(gameGroup.civilizations, gameGroup.tiles);
            gameGroupData.result = "newGame";
            playGameMenuController.sendMessageToAllClients(gameGroup, gameGroupData);
        }


        else if (command.startsWith("cheatGold ")) {
            command = command.replace("cheatGold ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseGold(cheatGson.civilization, cheatGson.amount, getGroup(cheatGson.member));
        }
        else if (command.startsWith("cheatFood ")) {
            command = command.replace("cheatFood ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseFood(cheatGson.civilization, cheatGson.amount, getGroup(cheatGson.member));
        }
        else if (command.startsWith("cheatTechnology ")) {
            command = command.replace("cheatTechnology ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseTechnology(cheatGson.civilization, cheatGson.amount, getGroup(cheatGson.member));
        }
        else if (command.startsWith("cheatHappiness ")) {
            command = command.replace("cheatHappiness ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseHappiness(cheatGson.civilization, cheatGson.amount, getGroup(cheatGson.member));
        }
        else if (command.startsWith("teleport ")) {
            command = command.replace("teleport ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatTeleport cheatTeleport = gson.fromJson(command, CheatTeleport.class);
            GameGroup gameGroup = getGroup(cheatTeleport.member);
            playGameMenuController.cheatTeleportUnit(cheatTeleport.unit, cheatTeleport.numberOfDestination,
                    cheatTeleport.civilization, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("moveUnit ")) {
            command = command.replace("moveUnit ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            MoveUnitGson moveUnitGson = gson.fromJson(command, MoveUnitGson.class);
            GameGroup gameGroup = getGroup(moveUnitGson.member);
            playGameMenuController.preMoveUnit(moveUnitGson.unit, moveUnitGson.numberOfDestination,
                    moveUnitGson.civilization, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("unitMaker ")) {
            command = command.replace("unitMaker ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            UnitMakingGson unitMakingGson = gson.fromJson(command, UnitMakingGson.class);
            GameGroup gameGroup = getGroup(unitMakingGson.member);
            playGameMenuController.preUnitMaker(unitMakingGson.unitName, unitMakingGson.index,
                    unitMakingGson.civilization, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("createCity ")) {
            command = command.replace("createCity ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            CreateCityGson createCityGson = gson.fromJson(command, CreateCityGson.class);
            GameGroup gameGroup = getGroup(createCityGson.member);
            playGameMenuController.createCity(createCityGson.civilization, createCityGson.tileNumber,
                    gameGroup.tiles, gameGroup.civilizations, gameGroup);
        }
        else if (command.startsWith("attackTile ")) {
            command = command.replace("attackTile ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            AttackTileGson attackTileGson = gson.fromJson(command, AttackTileGson.class);
            GameGroup gameGroup = getGroup(attackTileGson.member);
            playGameMenuController.preAttackTile(attackTileGson.attacker, attackTileGson.destinationIndex,
                    attackTileGson.civilization, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("attackCity ")) {
            command = command.replace("attackCity ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            AttackCityGson attackCityGson = gson.fromJson(command, AttackCityGson.class);
            GameGroup gameGroup = getGroup(attackCityGson.member);
            playGameMenuController.preAttackCity(attackCityGson.attacker, attackCityGson.destinationIndex,
                    attackCityGson.civilization, gameGroup.tiles, gameGroup.civilizations, gameGroup);
        }
        else if (command.startsWith("unitBehave ")) {
            command = command.replace("unitBehave ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            UnitBehaviourGson unitBehaviourGson = gson.fromJson(command, UnitBehaviourGson.class);
            GameGroup gameGroup = getGroup(unitBehaviourGson.member);
            playGameMenuController.preUnitBehaviour(unitBehaviourGson.unit, unitBehaviourGson.civilization,
                    gameGroup.tiles, unitBehaviourGson.command, gameGroup);
        }
        else if (command.startsWith("lootTile ")) {
            command = command.replace("lootTile ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            LootTileGson lootTileGson = gson.fromJson(command, LootTileGson.class);
            GameGroup gameGroup = getGroup(lootTileGson.member);
            playGameMenuController.lootTile(lootTileGson.civilization, lootTileGson.tileNumber,
                    lootTileGson.destinationTileNumber, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("chooseTechnology ")) {
            command = command.replace("chooseTechnology ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            ChooseTechnologyGson chooseTechnologyGson = gson.fromJson(command, ChooseTechnologyGson.class);
            GameGroup gameGroup = getGroup(chooseTechnologyGson.member);
            playGameMenuController.chooseTechnologyToLearn(chooseTechnologyGson.civilization,
                    chooseTechnologyGson.technologyName, gameGroup);
        }
        else if (command.startsWith("changeTechnology ")) {
            command = command.replace("changeTechnology ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            ChooseTechnologyGson chooseTechnologyGson = gson.fromJson(command, ChooseTechnologyGson.class);
            GameGroup gameGroup = getGroup(chooseTechnologyGson.member);
            playGameMenuController.changeTechnologyToLearn(chooseTechnologyGson.civilization,
                    chooseTechnologyGson.technologyName, gameGroup);
        }
        else if (command.startsWith("createImprovement ")) {
            command = command.replace("createImprovement ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            CreateImprovementGson createImprovementGson = gson.fromJson(command, CreateImprovementGson.class);
            GameGroup gameGroup = getGroup(createImprovementGson.member);
            playGameMenuController.createImprovement(createImprovementGson.civilization, createImprovementGson.tileUnitNumber,
                    createImprovementGson.tileNumber, createImprovementGson.improvementName, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("createRoad ")) {
            command = command.replace("createRoad ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.createRoad(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("createRail ")) {
            command = command.replace("createRail ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.createRailRoad(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("removeRoad ")) {
            command = command.replace("removeRoad ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.removeRoad(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("removeRail ")) {
            command = command.replace("removeRail ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.removeRailRoad(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("repairRoad ")) {
            command = command.replace("repairRoad ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.repairRoad(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("repairRail ")) {
            command = command.replace("repairRail ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RoadFunctionsGson roadFunctionsGson = gson.fromJson(command, RoadFunctionsGson.class);
            GameGroup gameGroup = getGroup(roadFunctionsGson.member);
            playGameMenuController.repairRail(roadFunctionsGson.civilization, roadFunctionsGson.tile,
                    gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("removeImprovement ")) {
            command = command.replace("removeImprovement ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            RemoveImprovementGson removeImprovementGson = gson.fromJson(command, RemoveImprovementGson.class);
            GameGroup gameGroup = getGroup(removeImprovementGson.member);
            playGameMenuController.removeImprovement(removeImprovementGson.civilization,
                    removeImprovementGson.improvement, removeImprovementGson.tileNumber, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("upgradeUnit ")) {
            command = command.replace("upgradeUnit ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            UpgradeUnitGson upgradeUnitGson = gson.fromJson(command, UpgradeUnitGson.class);
            GameGroup gameGroup = getGroup(upgradeUnitGson.member);
            playGameMenuController.preUpgradeUnit(upgradeUnitGson.oldUnit, upgradeUnitGson.newUnitName,
                    upgradeUnitGson.index, upgradeUnitGson.civilization, gameGroup.tiles, gameGroup);
        }
        else if (command.startsWith("nextTurn ")) {
            command = command.replace("nextTurn ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            NextTurnGson nextTurnGson = gson.fromJson(command, NextTurnGson.class);
            GameGroup gameGroup = getGroup(nextTurnGson.member);
            playGameMenuController.nextTurn(nextTurnGson.civilization, gameGroup.tiles, gameGroup);
        }





    }



    // get game group of a member
    public static GameGroup getGroup(Member member) {
        GameGroup group;
        for (GameGroup gameGroup : gameGroups) {
            for (Member member1 : gameGroup.members) {
                if (member1.equals(member)) return gameGroup;
            }
        }
        return null;
    }
}
