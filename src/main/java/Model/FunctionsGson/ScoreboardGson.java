package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class ScoreboardGson {
    @Expose
    public Member member;
    @Expose
    public ArrayList<String> membersScores;
}
