package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class DiplomacyGson {
    @Expose
    public Civilization civilization;
    @Expose
    public Civilization selectedCivilization;
    @Expose
    public Member member;
}
