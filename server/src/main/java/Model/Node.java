package Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Node {
    @Expose
    public Tile tile;
    @Expose
    public ArrayList<Node> neighbours = new ArrayList<>() ;
}

