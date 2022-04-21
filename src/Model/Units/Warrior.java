package Model.Units;

public class Warrior extends Unit{
    private int xp;
    private int damage;
    private int range;//if range == -1 -> N/A
    private int rangedCombatDamage;//if .. == -1 -> N/A

    private boolean isScout;
    private boolean isWarrior;
    private boolean isArcher;
    private boolean isChariotArcher;
    private boolean isSpearman;
    private boolean isCatapult;
    private boolean isHorseMan;
    private boolean isSwordsMan;
    private boolean isCrossbowMan;
    private boolean isKnight;
    private boolean isLongswordMan;
    private boolean isPikeMan;
    private boolean isTrebuchet;
    private boolean isCanon;
    private boolean isCavalry;
    private boolean isLancer;
    private boolean isMusketMan;
    private boolean isRifleMan;
    private boolean isAntiTankGun;
    private boolean isArtillery;
    private boolean isInfantry;
    private boolean isPanzer;
    private boolean isTank;

    private boolean isReadyForRangedBattle;

    public boolean isScout() {
        return isScout;
    }

    public boolean isWarrior() {
        return isWarrior;
    }

    public boolean isArcher() {
        return isArcher;
    }

    public boolean isChariotArcher() {
        return isChariotArcher;
    }

    public boolean isSpearman() {
        return isSpearman;
    }

    public boolean isCatapult() {
        return isCatapult;
    }

    public boolean isHorseMan() {
        return isHorseMan;
    }

    public void setReadyForRangedBattle(boolean readyForRangedBattle) {
        isReadyForRangedBattle = readyForRangedBattle;
    }

    public boolean isSwordsMan() {
        return isSwordsMan;
    }

    public boolean isCrossbowMan() {
        return isCrossbowMan;
    }

    public boolean isKnight() {
        return isKnight;
    }

    public boolean isLongswordMan() {
        return isLongswordMan;
    }

    public boolean isPikeMan() {
        return isPikeMan;
    }

    public boolean isTrebuchet() {
        return isTrebuchet;
    }

    public boolean isCanon() {
        return isCanon;
    }

    public boolean isCavalry() {
        return isCavalry;
    }

    public boolean isLancer() {
        return isLancer;
    }

    public boolean isMusketMan() {
        return isMusketMan;
    }

    public boolean isRifleMan() {
        return isRifleMan;
    }

    public boolean isAntiTankGun() {
        return isAntiTankGun;
    }

    public boolean isArtillery() {
        return isArtillery;
    }

    public boolean isInfantry() {
        return isInfantry;
    }

    public boolean isPanzer() {
        return isPanzer;
    }

    public boolean isTank() {
        return isTank;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
}
