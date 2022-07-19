package Model;

import java.net.Socket;
import java.util.ArrayList;

public class GameGroup {
    public ArrayList<Civilization> civilizations = new ArrayList<>();
    public ArrayList<Tile> tiles = new ArrayList<>();
    public ArrayList<Socket> sockets = new ArrayList<>();
    public ArrayList<Member> members = new ArrayList<>();
    public ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
    public ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
    public ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
    public ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
    public ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();
}
