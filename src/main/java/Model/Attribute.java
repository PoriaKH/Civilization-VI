package Model;



public class Attribute {
    private int food;
    private int gold;
    private int production;
    private int combatChange;
    private int mpCost;

    private boolean isPlat;//Jolge
    private boolean isJungle;//isBlocker
    private boolean isIce;
    private boolean isRainForest;
    private boolean isMarsh;//Mordab
    private boolean isOasis;//Vahhe
    private boolean isBlocker;

    public Attribute(boolean isPlat, boolean isJungle, boolean isIce, boolean isRainForest, boolean isMarsh, boolean isOasis){
        this.isPlat = isPlat;
        this.isJungle = isJungle;
        this.isIce = isIce;
        this.isRainForest = isRainForest;
        this.isMarsh = isMarsh;
        this.isOasis = isOasis;
        if(isJungle)
            this.isBlocker = true;

        this.food = 0;
        this.gold = 0;
        this.production = 0;
        this.combatChange = 0;
        this.mpCost = 0;

        //
        if(isPlat){
            this.food = 2;
            this.combatChange = -33;
            this.mpCost = 1;
        }
        else if(isJungle){
            this.food = 1;
            this.production = 1;
            this.combatChange = 25;
            this.mpCost = 2;
        }
        else if(isIce){
            this.mpCost = 100000;
        }
        else if(isRainForest){
            this.food = 1;
            this.production = -1;
            this.combatChange = 25;
            this.mpCost = 2;
        }
        else if(isMarsh){
            this.food = -1;
            this.combatChange = -33;
            this.mpCost = 2;
        }
        else if(isOasis){
            this.food = 3;
            this.gold = 1;
            this.combatChange = -33;
            this.mpCost = 1;
        }
        //
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public boolean isIce() {
        return isIce;
    }

    public boolean isJungle() {
        return isJungle;
    }

    public boolean isMarsh() {
        return isMarsh;
    }

    public boolean isOasis() {
        return isOasis;
    }

    public boolean isPlat() {
        return isPlat;
    }

    public boolean isRainForest() {
        return isRainForest;
    }

    public int getFood() {
        return food;
    }

    public int getGold() {
        return gold;
    }

    public int getProduction() {
        return production;
    }

    public int getCombatChange() {
        return combatChange;
    }

    public boolean isBlocker() {
        return isBlocker;
    }
}