package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class NextTurnGson {
    @Expose
    public Member member;
    @Expose
    public Civilization civilization;
}
