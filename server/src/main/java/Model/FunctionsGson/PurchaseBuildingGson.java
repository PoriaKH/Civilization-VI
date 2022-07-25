package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class PurchaseBuildingGson {
    @Expose
    public String buildingName;
    @Expose
    public Civilization civilization;
    @Expose
    public int tileNumber;
    @Expose
    public Member member;
}
