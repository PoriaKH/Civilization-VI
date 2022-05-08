package Model;

public class Improvement {
    private int food;
    private int production;
    private int gold;
    private boolean isWorking;//gharat nashode ast.(kharab nashode ast)

    private boolean isCamp;
    private boolean isFarm;
    private boolean isLumberMill;
    private boolean isMine;
    private boolean isPaddock;//CheraGah
    private boolean isAgriculture;
    private boolean isStoneMine;
    private boolean isTradingPost;
    private boolean isLaboratory;
    public Improvement(boolean isCamp, boolean isFarm, boolean isLumberMill, boolean isMine, boolean isPaddock,
                       boolean isAgriculture, boolean isStoneMine, boolean isTradingPost, boolean isLaboratory, int food, int production, int gold){
        this.isCamp = isCamp;
        this.isFarm = isFarm;
        this.isLumberMill = isLumberMill;
        this.isMine = isMine;
        this.isPaddock = isPaddock;
        this.isAgriculture = isAgriculture;
        this.isStoneMine = isStoneMine;
        this.isTradingPost = isTradingPost;
        this.isLaboratory = isLaboratory;
        this.isWorking = true;
        this.food = food;
        this.production = production;
        this.gold = gold;
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

    public boolean isAgriculture() {
        return isAgriculture;
    }

    public boolean isCamp() {
        return isCamp;
    }

    public boolean isFarm() {
        return isFarm;
    }

    public boolean isLaboratory() {
        return isLaboratory;
    }

    public boolean isLumberMill() {
        return isLumberMill;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isPaddock() {
        return isPaddock;
    }

    public boolean isStoneMine() {
        return isStoneMine;
    }

    public boolean isTradingPost() {
        return isTradingPost;
    }

    public boolean isWorking() {
        return isWorking;
    }
    public void setIsWorking(boolean isWorking){
        this.isWorking = isWorking;
    }
}
