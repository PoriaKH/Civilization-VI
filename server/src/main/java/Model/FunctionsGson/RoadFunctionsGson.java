package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import com.google.gson.annotations.Expose;

public class RoadFunctionsGson {
    @Expose
    public Member member;
    @Expose
    public Civilization civilization;
    @Expose
    public Tile tile;
}
