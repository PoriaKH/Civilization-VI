import Model.*;
import View.CommandProcessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Objects;

import static View.CommandProcessor.allSockets;

public class Main {
    public static ServerSocket serverSocket;
    static {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Socket>> sockets = new ArrayList<>();
    public static ArrayList<ArrayList<Member>> members = new ArrayList<>();
    public static ArrayList<GsonRoom> rooms = new ArrayList<>();
    // todo
    public static ArrayList<GameGroup> gameGroups = new ArrayList<>();

    public static void main(String[] args) {
        GsonRoomArray gsonRoomArray = new GsonRoomArray();
        CommandProcessor.rooms = rooms;
        CommandProcessor.sockets = sockets;
        CommandProcessor.members = members;
        CommandProcessor.gameGroups = gameGroups;
        CommandProcessor.members = members;

        try {
            while (true){
                Socket socket = serverSocket.accept();
                allSockets.add(socket);
                System.out.println("socket accepted");
                new Thread(() -> {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        while (true){
                            String input = dataInputStream.readUTF();
                            System.out.println(input);
                            CommandProcessor.run(input,gsonRoomArray,dataOutputStream,socket,dataInputStream);
//                            String result = process(input);
//                            dataOutputStream.writeUTF(result);
                            System.out.println(rooms);
                            System.out.println(rooms.size());
                            dataOutputStream.flush();
                        }
                    }catch (SocketException e){
                        System.out.println("Disconnected : " + socket);
                        int socketPort = socket.getPort();
                        removeRoom(socketPort,gsonRoomArray);
                        removePlayer(socket,gsonRoomArray);
                        removeSocket(socket);
                    }
                    catch (IOException x){
                        x.printStackTrace();
                    }
                }).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void removePlayer(Socket socket,GsonRoomArray gsonRoomArray){
        int port = socket.getPort();
        for(GsonRoom gsonRoom : gsonRoomArray.gsonRooms){
            int index = 0;
            for(GameSocket gameSocket : gsonRoom.sockets){
                System.out.println("port = " + port);
                System.out.println("socketPort = " + gameSocket.socketPort);
                if(gameSocket.socketPort == port){
                    System.out.println("are we in ?");
                    gsonRoom.sockets.remove(gameSocket);
                    gsonRoom.members.remove(index);
                    gsonRoom.nicknames.remove(index);
                    break;
                }
                index++;
            }
        }
    }
    public static void removeRoom(int socketPort,GsonRoomArray gsonRoomArray){
        for(GsonRoom room : rooms){
            if(room.creatorSocket.socketPort == socketPort) {
                rooms.remove(room);
                gsonRoomArray.gsonRooms.remove(room);
                break;
            }
        }
    }
    public static void removeSocket(Socket socket){
        sockets.remove(socket);
    }
}
