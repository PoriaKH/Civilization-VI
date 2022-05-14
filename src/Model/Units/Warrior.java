package Model.Units;

import Model.Civilization;
import Model.Tile;

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

    public Warrior(Civilization civilization, Tile origin, int health, int MP, int mp, int duration, int goldCost, boolean isCivilian, int xp, int damage, int range, int rangedCombatDamage, boolean isScout, boolean isWarrior, boolean isArcher, boolean isChariotArcher, boolean isSpearman, boolean isCatapult, boolean isHorseMan, boolean isSwordsMan, boolean isCrossbowMan, boolean isKnight, boolean isLongswordMan, boolean isPikeMan, boolean isTrebuchet, boolean isCanon, boolean isCavalry, boolean isLancer, boolean isMusketMan, boolean isRifleMan, boolean isAntiTankGun, boolean isArtillery, boolean isInfantry, boolean isPanzer, boolean isTank) {
        super(civilization, origin, health, MP, mp, duration, goldCost, isCivilian);
        this.xp = xp;
        this.damage = damage;
        this.range = range;
        this.rangedCombatDamage = rangedCombatDamage;
        this.isScout = isScout;
        this.isWarrior = isWarrior;
        this.isArcher = isArcher;
        this.isChariotArcher = isChariotArcher;
        this.isSpearman = isSpearman;
        this.isCatapult = isCatapult;
        this.isHorseMan = isHorseMan;
        this.isSwordsMan = isSwordsMan;
        this.isCrossbowMan = isCrossbowMan;
        this.isKnight = isKnight;
        this.isLongswordMan = isLongswordMan;
        this.isPikeMan = isPikeMan;
        this.isTrebuchet = isTrebuchet;
        this.isCanon = isCanon;
        this.isCavalry = isCavalry;
        this.isLancer = isLancer;
        this.isMusketMan = isMusketMan;
        this.isRifleMan = isRifleMan;
        this.isAntiTankGun = isAntiTankGun;
        this.isArtillery = isArtillery;
        this.isInfantry = isInfantry;
        this.isPanzer = isPanzer;
        this.isTank = isTank;
    }

    public void setReadyForRangedBattle(boolean readyForRangedBattle) {
        this.isReadyForRangedBattle = readyForRangedBattle;
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

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getRangedCombatDamage() {
        return rangedCombatDamage;
    }

    public void setRangedCombatDamage(int rangedCombatDamage) {
        this.rangedCombatDamage = rangedCombatDamage;
    }

    public int getRange() {
        return range;
    }

    public int getXp() {
        return xp;
    }

    public boolean isReadyForRangedBattle() {
        return isReadyForRangedBattle;
    }
}