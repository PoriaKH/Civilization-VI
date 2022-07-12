package Model;

import Controller.PlayGameMenuController;
import Model.FunctionsGson.CheatGson;
import Model.FunctionsGson.MapCreatorGson;
import View.PlayGameMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.IOException;


public class ClientThread extends Thread{
    public DataInputStream dataInputStream;
    public PlayGameMenuController playGameMenuController = new PlayGameMenuController();
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
            if (mapCreatorGson.map != null) {
                playGameMenuController.loadTileForCitizen(mapCreatorGson.map);
                playGameMenuController.loadTileForBuilding(mapCreatorGson.map);
                playGameMenuController.loadOriginTileForUnit(mapCreatorGson.map);
                PlayGameMenu.tiles = mapCreatorGson.map;
            }
            if (mapCreatorGson.civilizations != null) {
                playGameMenuController.loadCivilizationForBuilding(mapCreatorGson.civilizations);
                PlayGameMenu.civilizations = mapCreatorGson.civilizations;
            }
        }
        else if (response.startsWith("cheat ")) {
            response = response.replace("cheat ", "");
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
            CheatGson cheatGson = gson.fromJson(response, CheatGson.class);
            if (cheatGson.tiles != null) {
                playGameMenuController.loadTileForCitizen(cheatGson.tiles);
                playGameMenuController.loadTileForBuilding(cheatGson.tiles);
                playGameMenuController.loadOriginTileForUnit(cheatGson.tiles);
                PlayGameMenu.tiles = cheatGson.tiles;
            }
            if (cheatGson.civilizations != null) {
                playGameMenuController.loadCivilizationForBuilding(cheatGson.civilizations);
                PlayGameMenu.civilizations = cheatGson.civilizations;
            }
        }
    }
}
