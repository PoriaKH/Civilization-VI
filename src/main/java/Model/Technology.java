package Model;

public class Technology {
    private boolean isAgriculture;
    private boolean isAnimalHusbandry;
    private boolean isArchery;
    private boolean isBronzeWorking;
    private boolean isCalendar;
    private boolean isMasonry;
    private boolean isMining;
    private boolean isPottery;
    private boolean isTheWheel;
    private boolean isTrapping;
    private boolean isWriting;
    private boolean isConstruction;
    private boolean isHorsebackRiding;
    private boolean isIronWorking;
    private boolean isMathematics;
    private boolean isPhilosophy;
    private boolean isChivalry;
    private boolean isCivilService;
    private boolean isCurrency;
    private boolean isEducation;
    private boolean isEngineering;
    private boolean isMachinery;
    private boolean isMetalCasting;
    private boolean isPhysics;
    private boolean isSteel;
    private boolean isTheology;
    private boolean isAcoustics;
    private boolean isArchaeology;
    private boolean isBanking;
    private boolean isChemistry;
    private boolean isEconomics;
    private boolean isFertilizer;
    private boolean isGunpowder;
    private boolean isMetallurgy;
    private boolean isMilitaryScience;
    private boolean isPrintingPress;
    private boolean isRifling;
    private boolean isScientificTheory;
    private boolean isBiology;
    private boolean isCombustion;
    private boolean isDynamite;
    private boolean isElectricity;
    private boolean isRadio;
    private boolean isRailroad;
    private boolean isReplaceableParts;
    private boolean isParts;
    private boolean isSteamPower;
    private boolean isTelegraph;
    private int cost;
    private String name;

    public Technology(boolean isAgriculture, boolean isAnimalHusbandry, boolean isArchery, boolean isBronzeWorking,
                      boolean isCalendar, boolean isMasonry, boolean isMining, boolean isPottery, boolean isTheWheel,
                      boolean isTrapping, boolean isWriting, boolean isConstruction, boolean isHorsebackRiding,
                      boolean isIronWorking, boolean isMathematics, boolean isPhilosophy, boolean isChivalry,
                      boolean isCivilService, boolean isCurrency, boolean isEducation, boolean isEngineering,
                      boolean isMachinery, boolean isMetalCasting, boolean isPhysics, boolean isSteel, boolean isTheology,
                      boolean isAcoustics, boolean isArchaeology, boolean isBanking, boolean isChemistry,
                      boolean isEconomics, boolean isFertilizer, boolean isGunpowder, boolean isMetallurgy,
                      boolean isMilitaryScience, boolean isPrintingPress, boolean isRifling, boolean isScientificTheory,
                      boolean isBiology, boolean isCombustion, boolean isDynamite, boolean isElectricity,
                      boolean isRadio, boolean isRailroad, boolean isReplaceable, boolean isParts, boolean isSteamPower,
                      boolean isTelegraph){
        this.isAgriculture = isAgriculture;
        this.isAnimalHusbandry = isAnimalHusbandry;
        this.isArchery = isArchery;
        this.isBronzeWorking = isBronzeWorking;
        this.isCalendar = isCalendar;
        this.isMasonry = isMasonry;
        this.isMining = isMining;
        this.isPottery = isPottery;
        this.isTheWheel = isTheWheel;
        this.isTrapping = isTrapping;
        this.isWriting = isWriting;
        this.isConstruction = isConstruction;
        this.isHorsebackRiding = isHorsebackRiding;
        this.isIronWorking = isIronWorking;
        this.isMathematics = isMathematics;
        this.isPhilosophy = isPhilosophy;
        this.isChivalry = isChivalry;
        this.isCivilService = isCivilService;
        this.isCurrency = isCurrency;
        this.isEducation = isEducation;
        this.isEngineering = isEngineering;
        this.isMachinery = isMachinery;
        this.isMetalCasting = isMetalCasting;
        this.isPhysics = isPhysics;
        this.isSteel = isSteel;
        this.isTheology = isTheology;
        this.isAcoustics = isAcoustics;
        this.isArchaeology = isArchaeology;
        this.isBanking = isBanking;
        this.isChemistry = isChemistry;
        this.isEconomics = isEconomics;
        this.isFertilizer = isFertilizer;
        this.isGunpowder = isGunpowder;
        this.isMetallurgy = isMetallurgy;
        this.isMilitaryScience = isMilitaryScience;
        this.isPrintingPress = isPrintingPress;
        this.isRifling = isRifling;
        this.isScientificTheory = isScientificTheory;
        this.isBiology = isBiology;
        this.isCombustion = isCombustion;
        this.isDynamite = isDynamite;
        this.isElectricity = isElectricity;
        this.isRadio = isRadio;
        this.isRailroad = isRailroad;
        this.isReplaceableParts = isReplaceable;
        this.isParts = isParts;
        this.isSteamPower = isSteamPower;
        this.isTelegraph = isTelegraph;
        if (isAgriculture) {
            this.cost = 20;
            this.name = "Agriculture";
        }
        else if (isAnimalHusbandry) {
            this.cost = 35;
            this.name = "AnimalHusbandry";
        }
        else if (isArchery) {
            this.cost = 35;
            this.name = "Archery";
        }
        else if (isBronzeWorking) {
            this.cost = 55;
            this.name = "BronzeWorking";
        }
        else if (isCalendar) {
            this.cost = 70;
            this.name = "Calendar";
        }
        else if (isMasonry) {
            this.cost = 55;
            this.name = "Masonry";
        }
        else if (isMining) {
            this.cost = 35;
            this.name = "Mining";
        }
        else if (isPottery) {
            this.cost = 35;
            this.name = "Pottery";
        }
        else if (isTheWheel) {
            this.cost = 55;
            this.name = "TheWheel";
        }
        else if (isTrapping) {
            this.cost = 55;
            this.name = "Trapping";
        }
        else if (isWriting) {
            this.cost = 55;
            this.name = "Writing";
        }
        else if (isConstruction) {
            this.cost = 100;
            this.name = "Construction";
        }
        else if (isHorsebackRiding) {
            this.cost = 100;
            this.name = "HorsebackRiding";
        }
        else if (isIronWorking) {
            this.cost = 150;
            this.name = "IronWorking";
        }
        else if (isMathematics) {
            this.cost = 100;
            this.name = "Mathematics";
        }
        else if (isPhilosophy) {
            this.cost = 100;
            this.name = "Philosophy";
        }
        else if (isChivalry) {
            this.cost = 440;
            this.name = "Chivalry";
        }
        else if (isCivilService) {
            this.cost = 400;
            this.name = "CivilService";
        }
        else if (isCurrency) {
            this.cost = 250;
            this.name = "Currency";
        }
        else if (isEducation) {
            this.cost = 440;
            this.name = "Education";
        }
        else if (isEngineering) {
            this.cost = 250;
            this.name = "Engineering";
        }
        else if (isMachinery) {
            this.cost = 440;
            this.name = "Machinery";
        }
        else if (isMetalCasting) {
            this.cost = 240;
            this.name = "MetalCasting";
        }
        else if (isPhysics) {
            this.cost = 440;
            this.name = "Physics";
        }
        else if (isSteel) {
            this.cost = 440;
            this.name = "Steel";
        }
        else if (isTheology) {
            this.cost = 250;
            this.name = "Theology";
        }
        else if (isAcoustics) {
            this.cost = 650;
            this.name = "Acoustics";
        }
        else if (isArchaeology) {
            this.cost = 1300;
            this.name = "Archaeology";
        }
        else if (isBanking) {
            this.cost = 650;
            this.name = "Banking";
        }
        else if (isChemistry) {
            this.cost = 900;
            this.name = "Chemistry";
        }
        else if (isEconomics) {
            this.cost = 900;
            this.name = "Economics";
        }
        else if (isFertilizer) {
            this.cost = 1300;
            this.name = "Fertilizer";
        }
        else if (isGunpowder) {
            this.cost = 680;
            this.name = "Gunpowder";
        }
        else if (isMetallurgy) {
            this.cost = 900;
            this.name = "Metallurgy";
        }
        else if (isMilitaryScience) {
            this.cost = 1300;
            this.name = "MilitaryScience";
        }
        else if (isPrintingPress) {
            this.cost = 650;
            this.name = "PrintingPress";
        }
        else if (isRifling) {
            this.cost = 1425;
            this.name = "Rifling";
        }
        else if (isScientificTheory) {
            this.cost = 1300;
            this.name = "ScientificTheory";
        }
        else if (isBiology) {
            this.cost = 1680;
            this.name = "Biology";
        }
        else if (isCombustion) {
            this.cost = 2200;
            this.name = "Combustion";
        }
        else if (isDynamite) {
            this.cost = 1900;
            this.name = "Dynamite";
        }
        else if (isElectricity) {
            this.cost = 1900;
            this.name = "Electricity";
        }
        else if (isRadio) {
            this.cost = 2200;
            this.name = "Radio";
        }
        else if (isRailroad) {
            this.cost = 1900;
            this.name = "Railroad";
        }
        else if (isReplaceable) {
            this.cost = 1900;
            this.name = "ReplaceableParts";
        }
        else if (isSteamPower) {
            this.cost = 1680;
            this.name = "SteamPower";
        }
        else if (isTelegraph) {
            this.cost = 2200;
            this.name = "Telegraph";
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAgriculture() {
        return isAgriculture;
    }

    public boolean isAnimalHusbandry() {
        return isAnimalHusbandry;
    }

    public boolean isArchery() {
        return isArchery;
    }

    public boolean isBronzeWorking() {
        return isBronzeWorking;
    }

    public boolean isCalendar() {
        return isCalendar;
    }

    public boolean isMasonry() {
        return isMasonry;
    }

    public boolean isMining() {
        return isMining;
    }

    public boolean isPottery() {
        return isPottery;
    }

    public boolean isTheWheel() {
        return isTheWheel;
    }

    public boolean isTrapping() {
        return isTrapping;
    }

    public boolean isWriting() {
        return isWriting;
    }

    public boolean isConstruction() {
        return isConstruction;
    }

    public boolean isHorsebackRiding() {
        return isHorsebackRiding;
    }

    public boolean isIronWorking() {
        return isIronWorking;
    }

    public boolean isMathematics() {
        return isMathematics;
    }

    public boolean isPhilosophy() {
        return isPhilosophy;
    }

    public boolean isChivalry() {
        return isChivalry;
    }

    public boolean isCivilService() {
        return isCivilService;
    }

    public boolean isCurrency() {
        return isCurrency;
    }

    public boolean isEducation() {
        return isEducation;
    }

    public boolean isEngineering() {
        return isEngineering;
    }

    public boolean isMachinery() {
        return isMachinery;
    }

    public boolean isMetalCasting() {
        return isMetalCasting;
    }

    public boolean isPhysics() {
        return isPhysics;
    }

    public boolean isSteel() {
        return isSteel;
    }

    public boolean isTheology() {
        return isTheology;
    }

    public boolean isAcoustics() {
        return isAcoustics;
    }

    public boolean isArchaeology() {
        return isArchaeology;
    }

    public boolean isBanking() {
        return isBanking;
    }

    public boolean isChemistry() {
        return isChemistry;
    }

    public boolean isEconomics() {
        return isEconomics;
    }

    public boolean isFertilizer() {
        return isFertilizer;
    }

    public boolean isGunpowder() {
        return isGunpowder;
    }

    public boolean isMetallurgy() {
        return isMetallurgy;
    }

    public boolean isMilitaryScience() {
        return isMilitaryScience;
    }

    public boolean isPrintingPress() {
        return isPrintingPress;
    }

    public boolean isRifling() {
        return isRifling;
    }

    public boolean isScientificTheory() {
        return isScientificTheory;
    }

    public boolean isBiology() {
        return isBiology;
    }

    public boolean isCombustion() {
        return isCombustion;
    }

    public boolean isDynamite() {
        return isDynamite;
    }

    public boolean isElectricity() {
        return isElectricity;
    }

    public boolean isRadio() {
        return isRadio;
    }

    public boolean isRailroad() {
        return isRailroad;
    }

    public boolean isReplaceableParts() {
        return isReplaceableParts;
    }

    public boolean isParts() {
        return isParts;
    }

    public boolean isSteamPower() {
        return isSteamPower;
    }

    public boolean isTelegraph() {
        return isTelegraph;
    }

    public int getCost() {
        return cost;
    }

}
