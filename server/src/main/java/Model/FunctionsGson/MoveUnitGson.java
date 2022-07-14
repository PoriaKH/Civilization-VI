package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import Model.Units.Unit;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class MoveUnitGson {
    @Expose
    public Member member;
    @Expose
    public Unit unit;
    @Expose
    public int numberOfDestination;
    @Expose
    public Civilization civilization;
    @Expose
    public ArrayList<Tile> map;
}
