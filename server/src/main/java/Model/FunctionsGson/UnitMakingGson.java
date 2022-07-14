package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class UnitMakingGson {
    @Expose
    public Member member;
    @Expose
    public String unitName;
    @Expose
    public int index;
    @Expose
    public Civilization civilization;
    @Expose
    public ArrayList<Tile> map;
}
