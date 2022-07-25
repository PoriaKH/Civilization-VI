package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class TradeRequestGson {
    @Expose
    public int selectedGive;
    @Expose
    public Civilization civilization;
    @Expose
    public String selectedCivilizationName;
    @Expose
    public int giveAmount;
    @Expose
    public int needAmount;
    @Expose
    public String giveName;
    @Expose
    public String needName;
    @Expose
    public Member member;

}
