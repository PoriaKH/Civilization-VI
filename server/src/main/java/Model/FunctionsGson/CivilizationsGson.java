package Model.FunctionsGson;

import Model.Civilization;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class CivilizationsGson {
    @Expose
    public ArrayList<Civilization> civilizations;

    public CivilizationsGson(ArrayList<Civilization> civilizations) {
        this.civilizations = civilizations;
    }
}
