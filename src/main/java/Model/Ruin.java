package Model;

import Model.Units.Unit;
import com.google.gson.annotations.Expose;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Ruin extends Rectangle {
    @Expose
    private Technology freeTechnology;
    @Expose
    private int freeGold; //1 to 6

    public Ruin() {
        boolean[] type = new boolean[48];
        for (int i = 0; i < 48; i++)
            type[i] = false;
        int index = (int)(Math.random() * 47);
        type[index] = true;
        freeTechnology = new Technology(type[0], type[1], type[2], type[3], type[4], type[5],
        type[6], type[7], type[8], type[9], type[10], type[11], type[12], type[13], type[14], type[15],
        type[16], type[17], type[18], type[19], type[20], type[21], type[22], type[23], type[24], type[25],
        type[26], type[27], type[28], type[29], type[30], type[31], type[32], type[33], type[34], type[35],
        type[36], type[37], type[38], type[39], type[40], type[41], type[42], type[43], type[44], type[45],
        type[46], type[47]);
        freeGold = (int)((Math.random() * 5)) + 1;
        index = (int)((Math.random()) * 2);
    }

    public Technology getFreeTechnology() {
        return freeTechnology;
    }

    public int getFreeGold() {
        return freeGold;
    }

    public void copyField(Ruin ruin) {
        this.freeTechnology = ruin.getFreeTechnology();
        this.freeGold = ruin.getFreeGold();
    }
}
