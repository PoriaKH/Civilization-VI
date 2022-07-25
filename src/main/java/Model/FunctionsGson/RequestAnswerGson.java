package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

public class RequestAnswerGson {
    @Expose
    public Civilization civilization;
    @Expose
    public String civilizationName;
    @Expose
    public Member member;
}
