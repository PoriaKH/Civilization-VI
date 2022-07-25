package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CitizenWorkGson {
    @Expose
    public ArrayList<Integer> tileNumbers;
    @Expose
    public int cityIndex;
    @Expose
    public Civilization civilization;
    @Expose
    public Member member;

}
