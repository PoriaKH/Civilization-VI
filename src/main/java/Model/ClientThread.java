package Model;

import Controller.PlayGameMenuController;
import Model.FunctionsGson.MapCreatorGson;
import View.PlayGameMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientThread extends Thread{
    public DataInputStream dataInputStream;
    @Override
    public void run() {
        while (true) {
            try {
                String response = dataInputStream.readUTF();
                commandProcessor(response);
            } catch (IOException e) {
                try {
                    dataInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void commandProcessor(String response) {
        if (response.startsWith("mapCreator ")) {
            response = response.replace("mapCreator ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            MapCreatorGson mapCreatorGson = gson.fromJson(response, MapCreatorGson.class);
            if (mapCreatorGson.civilizations != null)
            PlayGameMenu.civilizations = mapCreatorGson.civilizations;
            if (mapCreatorGson.map != null)
            PlayGameMenu.tiles = mapCreatorGson.map;
        }
    }
}
