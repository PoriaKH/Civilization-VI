package Model.FunctionsGson;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class OtherDataGson {
    @Expose
    public String result;
    @Expose
    public int index; // index socket ha .
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization1 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization2 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization3 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization4 = new ArrayList<>();
    @Expose
    public ArrayList<Integer> tileStatusOfCivilization5 = new ArrayList<>();

    public OtherDataGson(GameGroupData gameGroupData) {
        this.result = gameGroupData.result;
        this.index = gameGroupData.index;
        this.tileStatusOfCivilization1 = gameGroupData.tileStatusOfCivilization1;
        this.tileStatusOfCivilization2 = gameGroupData.tileStatusOfCivilization2;
        this.tileStatusOfCivilization3 = gameGroupData.tileStatusOfCivilization3;
        this.tileStatusOfCivilization4 = gameGroupData.tileStatusOfCivilization4;
        this.tileStatusOfCivilization5 = gameGroupData.tileStatusOfCivilization5;
    }
}
