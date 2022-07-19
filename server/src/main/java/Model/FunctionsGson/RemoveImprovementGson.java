package Model.FunctionsGson;

import Model.Civilization;
import Model.Improvement;
import Model.Member;
import com.google.gson.annotations.Expose;

public class RemoveImprovementGson {
    @Expose
    public Member member;
    @Expose
    public Civilization civilization;
    @Expose
    public Improvement improvement;
    @Expose
    public int tileNumber;
}
