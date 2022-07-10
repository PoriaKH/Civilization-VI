package Model.Units;

import Model.Civilization;
import Model.Tile;
import com.google.gson.annotations.Expose;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.Serializable;
import java.net.URL;

public class Warrior extends Unit {
    @Expose
    private int xp;
    @Expose
    private int damage;
    @Expose
    private int range;//if range == -1 -> N/A
    @Expose
    private int rangedCombatDamage;//if .. == -1 -> N/A
    @Expose
    private boolean isScout;
    @Expose
    private boolean isWarrior;
    @Expose
    private boolean isArcher;
    @Expose
    private boolean isChariotArcher;
    @Expose
    private boolean isSpearman;
    @Expose
    private boolean isCatapult;
    @Expose
    private boolean isHorseMan;
    @Expose
    private boolean isSwordsMan;
    @Expose
    private boolean isCrossbowMan;
    @Expose
    private boolean isKnight;
    @Expose
    private boolean isLongswordMan;
    @Expose
    private boolean isPikeMan;
    @Expose
    private boolean isTrebuchet;
    @Expose
    private boolean isCanon;
    @Expose
    private boolean isCavalry;
    @Expose
    private boolean isLancer;
    @Expose
    private boolean isMusketMan;
    @Expose
    private boolean isRifleMan;
    @Expose
    private boolean isAntiTankGun;
    @Expose
    private boolean isArtillery;
    @Expose
    private boolean isInfantry;
    @Expose
    private boolean isPanzer;
    @Expose
    private boolean isTank;
    @Expose
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
        Image image = new Image(getURL().toExternalForm());
        ImagePattern imagePattern = new ImagePattern(image);
        this.setFill(imagePattern);
    }
    public ImagePattern getUnitPic () {
        Image image = new Image(getURL().toExternalForm());
        ImagePattern imagePattern = new ImagePattern(image);
        return imagePattern;
    }

    public URL getURL () {
        if (this.isTank()) {
           return unitsURL.get("Tank");
        } else if (this.isPanzer()) {
            return unitsURL.get("Panzer");
        } else if (this.isWarrior()) {
            return unitsURL.get("Warrior");
        } else if (this.isInfantry()) {
            return unitsURL.get("Infantry");
        } else if (this.isArtillery()) {
            return unitsURL.get("Artillery");
        } else if (this.isArcher()) {
            return unitsURL.get("Archer");
        } else if (this.isChariotArcher()) {
            return unitsURL.get("Chariot Archer");
        } else if (this.isScout()) {
            return unitsURL.get("Scout");
        } else if (this.isSpearman()) {
            return unitsURL.get("Spearman");
        } else if (this.isCatapult()) {
            return unitsURL.get("Catapult");
        } else if (this.isHorseMan()) {
            return unitsURL.get("Horseman");
        } else if (this.isSwordsMan()) {
            return unitsURL.get("Swordsman");
        } else if (this.isCrossbowMan()) {
            return unitsURL.get("Crossbowman");
        } else if (this.isKnight()) {
            return unitsURL.get("Knight");
        } else if (this.isLongswordMan()) {
            return unitsURL.get("Longswordsman");
        } else if (this.isPikeMan()) {
            return unitsURL.get("Pikeman");
        } else if (this.isTrebuchet()) {
            return unitsURL.get("Trebuchet");
        } else if (this.isCanon()) {
            return unitsURL.get("Canon");
        } else if (this.isCavalry()) {
            return unitsURL.get("Cavalry");
        } else if (this.isLancer()) {
            return unitsURL.get("Lancer");
        } else if (this.isMusketMan()) {
            return unitsURL.get("Musketman");
        } else if (this.isRifleMan()) {
            return unitsURL.get("Rifleman");
        } else if (this.isAntiTankGun()) {
            return unitsURL.get("Anti-Tank Gun");
        }
        return null;
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
    public void increaseXp(int amount){
        this.xp += amount;
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