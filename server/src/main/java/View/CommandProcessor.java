package View;

import Controller.PlayGameMenuController;
import Model.*;
import Model.FunctionsGson.CheatGson;
import Model.FunctionsGson.CheatTeleport;
import Model.FunctionsGson.MapCreatorGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    public static PlayGameMenuController playGameMenuController = new PlayGameMenuController();

    public static void run(String command, GsonRoomArray gsonRoomArray, DataOutputStream dataOutputStream, Socket socket) throws IOException {
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
        else if(command.startsWith("join request:")){
            Matcher matcher = Pattern.compile("join request:(?<text>.*) (?<nick>.*)").matcher(command);
            matcher.find();
            String text = matcher.group("text");
            String nick = matcher.group("nick");
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                if(Objects.equals(text, gsonRoom.creatorMember.getNickname())){
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
            for(GameSocket gameSocket : gameSocketArray.gameSockets){
                for(Socket socket1 : allSockets){
                    if(gameSocket.socketPort == socket1.getPort()){
                        sockets2.add(socket1);
                    }
                }
            }
            sockets.add(sockets2);
        }
        else if (command.startsWith("mapCreator ")) {
            command = command.replace("mapCreator ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            MapCreatorGson mapCreatorGson = gson.fromJson(command, MapCreatorGson.class);
            playGameMenuController.mapCreator(mapCreatorGson.numOfCivilizations, mapCreatorGson.members, getGroup(socket));
        }
        else if (command.startsWith("cheatGold ")) {
            command = command.replace("cheatGold ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseGold(cheatGson.civilization, cheatGson.amount);
        }
        else if (command.startsWith("cheatFood ")) {
            command = command.replace("cheatFood ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseGold(cheatGson.civilization, cheatGson.amount);
        }
        else if (command.startsWith("cheatTechnology ")) {
            command = command.replace("cheatTechnology ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseGold(cheatGson.civilization, cheatGson.amount);
        }
        else if (command.startsWith("cheatHappiness ")) {
            command = command.replace("cheatHappiness ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(command, CheatGson.class);
            playGameMenuController.cheatIncreaseGold(cheatGson.civilization, cheatGson.amount);
        }
        else if (command.startsWith("teleport ")) {
            command = command.replace("teleport ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatTeleport cheatTeleport = gson.fromJson(command, CheatTeleport.class);
            playGameMenuController.cheatTeleportUnit(cheatTeleport.unit, cheatTeleport.numberOfDestination,
                    cheatTeleport.civilization, cheatTeleport.map);
        }
    }
    public static ArrayList<Socket> getGroup(Socket socket) {
        for (ArrayList<Socket> socketArrayList : sockets) {
            for (Socket socket1 : socketArrayList) {
                if (socket.equals(socket1)) return socketArrayList;
            }
        }
        return null;
    }
}
