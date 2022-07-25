package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

public class RejectMessageGson {
    @Expose
    public String civilization;
    @Expose
    public String messageCivilization;
    @Expose
    public Member member;
}
