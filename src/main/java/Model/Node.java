package Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Node {
    public Tile tile;

    public ArrayList<Node> neighbours = new ArrayList<>() ;
}

