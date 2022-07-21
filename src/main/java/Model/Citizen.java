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
        ArrayList<Citizen> citizensServer = server.getCitizens();
        ArrayList<Citizen> citizensClient = new ArrayList<>();
        for (Citizen citizen : citizensServer) {
            citizen.setTile(getCitizenTile(citizen.getTile()));
            citizensClient.add(citizen);
        }
        return citizensClient;
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
        if (tile == null) return;
        this.tile = tile;
        tile.setCitizen(this);
    }

    public boolean equals (Citizen citizen) {
        if (citizen == null) {
            System.out.println("citizen");
            return false;
        }
        else {
            System.out.println("tileCitizen : " + citizen.getTile());
        }
        if (this == null) {
            System.out.println("this");
            return false;
        }
        else {
            System.out.println("tileThis : " + this.getTile());
        }
        if (this.getTile().equals(citizen.getTile())) return true;
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

    private static Tile getCitizenTile(Tile tile) {
        for (Tile tile1 : PlayGameMenu.tiles) {
            if (tile1.equals(tile)) return tile1;
        }
        return null;
    }
}
