package Model.FunctionsGson;

import Model.Civilization;
import Model.Member;
import Model.Tile;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CreateCityGson {
    @Expose
    public Member member;
    @Expose
    public Civilization civilization;
    @Expose
    public int tileNumber;
}
