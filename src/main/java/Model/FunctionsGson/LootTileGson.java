package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class LootTileGson {
    @Expose
    public Member member;
    @Expose
    public Civilization civilization;
    @Expose
    public int tileNumber;
    @Expose
    public int destinationTileNumber;
}
