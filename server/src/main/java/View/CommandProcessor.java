package View;

import Model.GameSocket;
import Model.GsonRoom;
import Model.GsonRoomArray;
import Model.Member;
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
    public static ArrayList<GsonRoom> rooms;

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
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                if(Objects.equals(gsonRoom.creatorMember.getNickname(), text)){
                    String str = gson.toJson(gsonRoom,GsonRoom.class);
                    dataOutputStream.writeUTF(str);
                    break;
                }
            }
        }
        else if(command.startsWith("join request:")){
            Matcher matcher = Pattern.compile("join request:(?<text>.*) (?<nick>.*)").matcher(command);
            matcher.find();
            String text = matcher.group("text");
            String nick = matcher.group("nick");
            for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
                if(Objects.equals(text, gsonRoom.creatorMember.getNickname())){
                    gsonRoom.nicknames.add(nick);
                    System.out.println("socket.getPort = " + socket.getPort());
                    System.out.println("socket.getLocalPort = " + socket.getLocalPort());
                    GameSocket gameSocket = new GameSocket(socket.getLocalAddress().toString(),socket.getLocalPort(),socket.getPort());
                    gsonRoom.sockets.add(gameSocket);
                    break;
                }
            }
        }
    }
}
