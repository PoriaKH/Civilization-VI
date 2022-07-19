package Model;

import View.PlayGameMenu;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class Citizen {
    private Tile tile;

    public Citizen(Tile tile){
        this.tile = tile;
        tile.setCitizen(this);
    }

    public Tile getTile() {
        return tile;
    }

    public static ArrayList<Citizen> copyListOfCitizens(City client, City server) {
        ArrayList<Citizen> citizens;
        citizens = updateCitizen(client, server);
        for (int i = 0; i < client.getCitizens().size(); i++) {
            for (int i1 = 0; i1 < citizens.size(); i1++) {
                if (client.getCitizens().get(i).equals(citizens.get(i1))) {
                    client.getCitizens().get(i).copyCitizen(citizens.get(i1));
                    break;
                }
            }
        }
        citizens = deleteCitizen(client, server);
        for (int i = 0; i < client.getCitizens().size(); i++) {
            for (Citizen citizen : citizens) {
                if (client.getCitizens().get(i).equals(citizen)) {
                    client.getCitizens().remove(i);
                    i--;
                }
            }
        }
        citizens = newCitizen(client, server);
        for (Citizen citizen : citizens) {
            Citizen newCitizen = new Citizen(getTile(citizen));
            client.getCitizens().add(newCitizen);
        }
        return client.getCitizens();
    }

    private static Tile getTile (Citizen citizen) {
        for (Tile tile1 : PlayGameMenu.tiles) {
            if (tile1.equals(citizen.getTile())) {
                return tile1;
            }
        }
        return null;
    }
    private void copyCitizen(Citizen citizen) {
        for (Tile tile1 : PlayGameMenu.tiles) {
            if (tile1.equals(citizen.getTile())) {
                this.tile = tile1;
                break;
            }
        }
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        tile.setCitizen(this);
    }

    public boolean equals (Citizen citizen) {
        if (this.tile.equals(citizen.tile)) return true;
        return false;
    }

    public static ArrayList<Citizen> updateCitizen (City client, City server) {
        ArrayList<Citizen> citizens = new ArrayList<>();
        for (Citizen clientCitizen : client.getCitizens()) {
            for (Citizen serverCitizen : server.getCitizens()) {
                if (serverCitizen.equals(clientCitizen)) citizens.add(serverCitizen);
            }
        }
        return citizens;
    }

    public static ArrayList<Citizen> deleteCitizen (City client, City server) {
        boolean doesExist = false;
        ArrayList<Citizen> citizens = new ArrayList<>();
        for (Citizen clientCitizen : client.getCitizens()) {
            for (Citizen serverCitizen : server.getCitizens()) {
                if (serverCitizen.equals(clientCitizen)) {
                    doesExist = true;
                    break;
                }
            }
            if (doesExist) {
                doesExist = false;
            }
            else {
                citizens.add(clientCitizen);
            }
        }
        return citizens;
    }

    public static ArrayList<Citizen> newCitizen (City client, City server) {
        boolean doesExist = false;
        ArrayList<Citizen> citizens = new ArrayList<>();
        for (Citizen serverCitizen : server.getCitizens()) {
            for (Citizen clientCitizen : client.getCitizens()) {
                if (serverCitizen.equals(clientCitizen)) {
                    doesExist = true;
                    break;
                }
            }
            if (doesExist) {
                doesExist = false;
            }
            else {
                citizens.add(serverCitizen);
            }
        }
        return citizens;
    }
}
