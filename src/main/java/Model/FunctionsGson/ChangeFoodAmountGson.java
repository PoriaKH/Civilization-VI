package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

public class ChangeFoodAmountGson {
    @Expose
    public int amount;
    @Expose
    public String civilizationName;
    @Expose
    public Member member;
}
