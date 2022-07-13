package Model;

import java.net.Socket;
import java.util.ArrayList;

public class GameGroup {
    public ArrayList<Civilization> civilizations = new ArrayList<>();
    public ArrayList<Tile> tiles = new ArrayList<>();
    public ArrayList<Socket> sockets = new ArrayList<>();
    public ArrayList<Member> members = new ArrayList<>();
}
