package View;

import Controller.PlayGameMenuController;
import Model.*;
import Model.FunctionsGson.*;
import Model.Units.Unit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sun.applet.Main;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    public static ArrayList<GsonRoom> rooms = new ArrayList<>();
    public static ArrayList<Socket> allSockets = new ArrayList<>();
    public static ArrayList<ArrayList<Socket>> sockets = new ArrayList<>();
    public static ArrayList<ArrayList<Member>> members = new ArrayList<>();
    public static PlayGameMenuController playGameMenuController = new PlayGameMenuController();
    public static ArrayList<GameGroup> gameGroups;
    public static ArrayList<Member> startedGameMembers = new ArrayList<>();

    public static void run(String command, GsonRoomArray gsonRoomArray, DataOutputStream dataOutputStream, Socket socket, DataInputStream dataInputStream) throws IOException, InterruptedException {
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
        else if(command.startsWith("{\"member\":")){
            System.out.println("still got it...");
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
        else if(command.startsWith("{\"members\":")){
            Gson gson = new GsonBuilder().create();
            MemberArray memberArray = gson.fromJson(command,MemberArray.class);
            startedGameMembers.addAll(memberArray.members);
        }
        else if(command.equals("give me startedGameMembers")){
            Gson gson = new GsonBuilder().create();
            MemberArray memberArray = new MemberArray();
            memberArray.members = startedGameMembers;
            String out = gson.toJson(memberArray);
            dataOutputStream.writeUTF(out);
            System.out.println("out =" + out);
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
        else if (command.startsWith("scoreboard ")){
            Gson gson = new GsonBuilder().create();
            command = command.replace("scoreboard " , "");
            ScoreboardGson scoreboardGson = gson.fromJson(command, ScoreboardGson.class);
            scoreboardGson.membersScores = playGameMenuController.scoreBoard(scoreboardGson, members);
            String request = gson.toJson(scoreboardGson);
            dataOutputStream.writeUTF(request);
            dataOutputStream.flush();
        }
        else if (command.startsWith("friendsList ")){
            Gson gson = new GsonBuilder().create();
            command = command.replace("friendsList " , "");
            FriendsListGson friendsListGson = gson.fromJson(command, FriendsListGson.class);
            friendsListGson.friendsUsernames = playGameMenuController.friendsList(friendsListGson.sender);
            String request = gson.toJson(friendsListGson);
            dataOutputStream.writeUTF(request);
            dataOutputStream.flush();
        }
        else if (command.startsWith("friendRequest ")){
            Gson gson = new GsonBuilder().create();
            command = command.replace("friendRequest " , "");
            FriendRequestGson friendRequestGson = gson.fromJson(command, FriendRequestGson.class);
            String response = playGameMenuController.addToFriendRequests(friendRequestGson);
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
        }
        else if (command.startsWith("friend requests list ")){
            command = command.replace("friend requests list ", "");
            String response = playGameMenuController.friendRequestsList(command);
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
        }
        else if (command.startsWith("friend profile ")){
            command = command.replace("friend profile ", "");
            String response = playGameMenuController.infoReader(command);
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
        }
        else if (command.startsWith("accept friendRequest ")){
            command = command.replace("accept friendRequest ", "");
            String[] splitParts = command.split(" # ");
            System.out.println("parts: " + splitParts[0] + "\t" + splitParts[1]);
            playGameMenuController.acceptRequest(splitParts[0], splitParts[1]);

        }
        else if (command.startsWith("deny friendRequest ")){
            command = command.replace("deny friendRequest ", "");
            String[] splitParts = command.split(" # ");
            playGameMenuController.denyRequest(splitParts[0], splitParts[1]);
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

            sendGuestOK(sockets2);

            GameGroup gameGroup = new GameGroup();
            gameGroup.sockets = sockets2;
            gameGroup.members = members2;
            System.out.println("members = " + members);


            gameGroup.tiles = playGameMenuController.mapCreator(members2.size(),members2);
            gameGroup.civilizations = playGameMenuController.initializeCivilizations(members2.size(), gameGroup.tiles, members2);
            gameGroup.civilizations.get(0).isMyTurn = true;
            gameGroups.add(gameGroup);
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

        else if (command.startsWith("saveGame ")) {
            command = command.replace("saveGame ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            EndGameGson endGameGson = gson.fromJson(command, EndGameGson.class);
            GameGroup gameGroup = getGroup(endGameGson.member);
            playGameMenuController.saveGame(gameGroup);
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
        else if (command.startsWith("EndGame ")) {
            command = command.replace("EndGame ", "");
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            EndGameGson endGameGson = gson.fromJson(command, EndGameGson.class);
            GameGroup gameGroup = getGroup(endGameGson.member);
            playGameMenuController.endGame(gameGroup);
        }
        else if(command.startsWith("login")){
            command = command.substring(5);
            Gson gson = new GsonBuilder().create();
            UserPassTF userPassTF = gson.fromJson(command,UserPassTF.class);
            System.out.println("userTF = " + userPassTF.getUsernameTF());
            System.out.println("passTF = " + userPassTF.getPasswordTF());
            String usernameTF = userPassTF.getUsernameTF();
            String passwordTF = userPassTF.getPasswordTF();
//            System.out.println(command);
            String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
            File file = new File("users2.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine();
            while(line != null && !line.equals(""))
            {
                Matcher fileMatcher = getMatcher(line, fileRegex);
                fileMatcher.find();
                String fileUsername = fileMatcher.group("username");
                String fileNickname = fileMatcher.group("nickname");
                String filePassword = fileMatcher.group("password");
                String fileDate = fileMatcher.group("date");
                int fileImage = Integer.parseInt(fileMatcher.group("image"));

                if(Objects.equals(fileUsername, usernameTF)){
                    if(Objects.equals(filePassword, passwordTF)){
                        int score = Integer.parseInt(fileMatcher.group("score"));
                        changeDate(fileUsername,fileNickname,filePassword,score,fileImage);
                        GotoMain gotoMain = new GotoMain(fileNickname,score,fileImage,fileDate);
                        Gson gson1 = new GsonBuilder().create();
                        String out = gson1.toJson(gotoMain);
                        dataOutputStream.writeUTF("gotoMain" + out);
                        return;
                    }
                    dataOutputStream.writeUTF("Username and password did not match!");
                    return;
                }

                line = bufferedReader.readLine();
            }
            fileReader.close();
        }
        else if(command.startsWith("register")){
            command = command.substring(8);
            Gson gson = new GsonBuilder().create();
            RegisterTF registerTF = gson.fromJson(command,RegisterTF.class);
            String usernameTF = registerTF.usernameTF;
            String passwordTF = registerTF.passwordTF;
            String nicknameTF = registerTF.nicknameTF;

            File file = new File("users2.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder("");
            String line = bufferedReader.readLine();

            String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
            while (line != null && !line.equals("")) {
                Matcher fileMatcher = getMatcher(line, fileRegex);
                fileMatcher.find();
                String fileUsername = fileMatcher.group("username");

                if(Objects.equals(fileUsername, usernameTF)) {
                    dataOutputStream.writeUTF("setMessageusername already exists");
                    return;
                }

                stringBuilder.append(line);
                stringBuilder.append("\n");

                line = bufferedReader.readLine();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(String.valueOf(stringBuilder));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            Random rand = new Random();
            int upperbound = 4;
            int int_random = rand.nextInt(upperbound);

            bufferedWriter.write(usernameTF + " " + nicknameTF + " " + passwordTF + " 0 " + int_random + " " + dtf.format(now));
            bufferedWriter.newLine();

            dataOutputStream.writeUTF("setMessageuser registered successfully");

            bufferedWriter.close();
        }
        else if(command.startsWith("changePic")) {
            Gson gson = new GsonBuilder().create();
            Member member = gson.fromJson(command.substring(10),Member.class);
            if (command.startsWith("changePic0")) {
                changeProf(0,member);
            } else if (command.startsWith("changePic1")) {
                changeProf(1,member);
            } else if (command.startsWith("changePic2")) {
                changeProf(2,member);
            } else if (command.startsWith("changePic3")) {
                changeProf(3,member);
            }
        }
        else if(command.startsWith("changePassword")){
            command = command.substring(14);
            Gson gson = new GsonBuilder().create();
            ChangePassword changePassword = gson.fromJson(command,ChangePassword.class);
            String newPassword = changePassword.newPassword;
            Member loggedInMember = changePassword.loggedInMember;

            String date = "";
            String username = loggedInMember.getUsername();
            File file = new File("users2.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder("");
            String line = bufferedReader.readLine();
            String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
            while (line != null && !line.equals("")) {
                Matcher fileMatcher = getMatcher(line, fileRegex);
                fileMatcher.find();
                String fileUsername = fileMatcher.group("username");
                date = fileMatcher.group("date");

                if(!Objects.equals(fileUsername, username)) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                line = bufferedReader.readLine();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(String.valueOf(stringBuilder));
            bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + newPassword + " " + loggedInMember.getScore() + " " + loggedInMember.getImageNumber() + " " + date);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        else if(command.startsWith("changeNick")){
            command = command.substring(10);
            Gson gson = new GsonBuilder().create();
            ChangeNickname changeNickname = gson.fromJson(command,ChangeNickname.class);
            Member loggedInMember = changeNickname.loggedInMember;
            String newNickname = changeNickname.newNickname;

            String username = loggedInMember.getUsername();

            boolean inUse = false;
            File file = new File("users2.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder("");
            String line = bufferedReader.readLine();
            String date = "", image = "";

            String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
            while (line != null && !line.equals("")) {
                Matcher fileMatcher = getMatcher(line, fileRegex);
                fileMatcher.find();
                String fileUsername = fileMatcher.group("username");
                String fileNickname = fileMatcher.group("nickname");
                date = fileMatcher.group("date");

                if(!Objects.equals(fileUsername, username)) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                if(Objects.equals(fileNickname, newNickname)){
                    inUse = true;
                }
                line = bufferedReader.readLine();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            bufferedWriter.write(String.valueOf(stringBuilder));
            if(!inUse)
                bufferedWriter.write(loggedInMember.getUsername() + " " + newNickname + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore() + " " + loggedInMember.getImageNumber() + " " + date);
            else
                bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore() + " " + loggedInMember.getImageNumber() + " " + date);

            bufferedWriter.newLine();

            bufferedWriter.close();

            if(inUse)
                dataOutputStream.writeUTF("true");
            else
                dataOutputStream.writeUTF("false");
        }
    }
    public static void changeProf(int imageNumber,Member loggedInMember) throws IOException {
        String username = loggedInMember.getUsername();
        File file = new File("users2.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();
        String date = "";
        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            date = fileMatcher.group("date");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore() + " " + imageNumber + " " + date);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private static void sendGuestOK(ArrayList<Socket> sockets2) throws IOException {
        for (int i = 1; i < sockets2.size(); i++) {
            DataOutputStream dataOutputStream = new DataOutputStream(sockets2.get(i).getOutputStream());
            dataOutputStream.writeUTF("ok");
            dataOutputStream.flush();
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
    private static Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }
    private static void changeDate(String fileUsername, String fileNickname, String filePassword, int score, int imageNumber) throws IOException {
        File file = new File("users2.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();

            String username = fileMatcher.group("username");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        bufferedWriter.write(String.valueOf(stringBuilder));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        bufferedWriter.write(fileUsername + " " + fileNickname + " " + filePassword + " " + score + " " + imageNumber + " " + dtf.format(now));

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
