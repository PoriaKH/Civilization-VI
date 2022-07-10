package View;

import Model.GameSocket;
import Model.GsonRoom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class CommandProcessor {
    public static ArrayList<GsonRoom> rooms;

    public static void run(String command){
        if(command.startsWith("{\"creatorSocket")){
            Gson gson = new GsonBuilder().create();
            GsonRoom gsonRoom = gson.fromJson(command,GsonRoom.class);
            rooms.add(gsonRoom);
        }
    }
}
