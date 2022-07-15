package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import Model.Units.Unit;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class UpgradeUnitGson {
    @Expose
    public Member member;
    @Expose
    public Unit oldUnit;
    @Expose
    public String newUnitName;
    @Expose
    public int index;
    @Expose
    public Civilization civilization;
}
