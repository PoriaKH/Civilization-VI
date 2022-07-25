package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

public class ChangeGoldAmountGson {
    @Expose
    public int amount;
    @Expose
    public String civilizationName;
    @Expose
    public Member member;
}
