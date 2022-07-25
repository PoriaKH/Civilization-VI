package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

public class ChangeResourceGson {
    @Expose
    public int tileNumber;
    @Expose
    public String resourceName;
    @Expose
    public Member member;
}
