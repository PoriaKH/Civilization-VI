package Model;

import Controller.PlayGameMenuController;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Civilization {
    @Expose
    public boolean isMyTurn = false;
    @Expose
    private Member member;
    @Expose
    private String firstLetterOfName;
    @Expose
    private String name;
    @Expose
    private City capital;
    @Expose
    private int science;
    @Expose
    private int sciencePerTurn;
    @Expose
    private ArrayList<Technology> technologies;
    @Expose
    private int gold;
    @Expose
    private int goldPerTurn;
    @Expose
    private int happiness;
    @Expose
    private ArrayList<City> cities;
    @Expose
    private ArrayList<String> trades;
    @Expose
    private ArrayList<String> messages; // (int)turn : message
    @Expose
    private HashMap<Civilization, Integer> winsInUnitsWar = new HashMap<>(); // tamadon shekast khorde va tedad bakht haye on ra neshan mide
    @Expose
    private HashMap<Civilization, Integer> lossesInUnitsWar = new HashMap<>(); // tamadon pirooz va tedad bord haye on ra neshan mide
    @Expose
    private int point;//to compare civilizations
    @Expose
    private boolean isLearningTechnology = false;
    @Expose
    private ArrayList<Civilization> friendlyRequests;
    @Expose
    private ArrayList<Civilization> friends;
    @Expose
    private Technology workingOnTechnology;//if == null -> have to choose
    @Expose
    private HashMap<Technology, Integer> technologyEarnedPercent;

    public Civilization(Member member, City capital){
        this.name = member.getNickname();
        this.firstLetterOfName = name.substring(0, 1);
        this.happiness = 10;
        friendlyRequests = new ArrayList<>();
        friends = new ArrayList<>();
        messages = new ArrayList<>();
        this.member = member;
        this.capital = capital;
        cities = new ArrayList<>();
        cities.add(capital);
        this.science = 0;
        technologies = new ArrayList<>();
        trades = new ArrayList<>();
        technologyEarnedPercent = new HashMap<>();
//        this.gold = 10;
        //temporary
        this.gold = 1000;
        //temporary
        capital.getCenterTile().addBuilding(new Building("Castle",this,capital.getCenterTile()));
    }

    public void acceptFriendlyRequest(Civilization civilization){
        this.friendlyRequests.remove(civilization);
        civilization.friendlyRequests.remove(this);
        this.friends.add(civilization);
        civilization.friends.add(this);
        String message = PlayGameMenuController.turn + " : " + this.name + " : accepted your friendly request, now you are allies";
        civilization.addMessage(message);
    }
    public void denyFriendlyRequest(Civilization civilization){
        this.friendlyRequests.remove(civilization);
        civilization.friendlyRequests.remove(this);
        String message = PlayGameMenuController.turn + " : " + this.name + " : denied your friendly request !";
        civilization.addMessage(message);
    }
    public void breakTheOath(Civilization civilization){
        this.friends.remove(civilization);
        civilization.friends.remove(this);
        String message = PlayGameMenuController.turn + " : " + this.name + " : broke the oath, now you are enemies";
        civilization.messages.add(message);
    }
    public void addMessage(String message){
        this.messages.add(message);
    }

    public String getName() {
        return name;
    }

    public Member getMember() {
        return member;
    }

    public String getFirstLetterOfName() {
        return firstLetterOfName;
    }

    public City getCapital() {
        return capital;
    }

    public int getScience() {
        return science;
    }

    public int getGold() {
        return gold;
    }

    public int getGoldPerTurn() {
        return goldPerTurn;
    }

    public int getHappiness() {
        return happiness;
    }

    public ArrayList<String> getTrades() {
        return trades;
    }

    public Technology getWorkingOnTechnology() {
        return workingOnTechnology;
    }

    public HashMap<Technology, Integer> getTechnologyEarnedPercent() {
        return technologyEarnedPercent;
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void updateCountOfUnitWin (Civilization civilization, int count) {
        winsInUnitsWar.replace(civilization, count);
    }
    public void updateCountOfUnitLose (Civilization civilization, int count) {
        lossesInUnitsWar.replace(civilization, count);
    }

    public void setSciencePerTurn(int sciencePerTurn) {
        this.sciencePerTurn = sciencePerTurn;
    }

    public Integer getCountOfWins (Civilization civilization) {
        return winsInUnitsWar.get(civilization);
    }
    public Integer getCountOfLosses (Civilization civilization) {
        return lossesInUnitsWar.get(civilization);
    }
    public void addCivilizationToWinsUnit (Civilization civilization) {
        winsInUnitsWar.put(civilization, 0);
    }
    public void addCivilizationToLossesUnit (Civilization civilization) {
        lossesInUnitsWar.put(civilization, 0);
    }

    public ArrayList<Civilization> getFriends() {
        return friends;
    }

    public HashMap<Civilization, Integer> getWinsInUnitsWar() {
        return winsInUnitsWar;
    }

    public HashMap<Civilization, Integer> getLossesInUnitsWar() {
        return lossesInUnitsWar;
    }

    public int getPoint(){//set and get
        this.point = 0;
        //every city adds 15
        point += cities.size();
        //every tile adds 5 point
        //every unit adds 10 points;
        for(City city : cities){
            for(Tile tile : city.getTiles()){
                point += 10 * tile.getUnits().size();//for units
                point += 5;//for tile
            }
        }
        //each science adds 2 points
        point += 2 * science;
        //each building adds 12 pts
        for(City city : cities){
            for(Tile tile : city.getTiles()){
                if(tile.getBuilding() != null)
                    point += 12;
            }
        }
        //
        return point;
    }
    public void setGold(int amount){
        this.gold += amount;
    }

    public void setHappiness(int amount) {
        this.happiness += amount;
    }

    public void setScience(int science) {
        this.science += science;
    }

    public void addTechnology (Technology technology){
        this.technologies.add(technology);
    }

    public boolean isLearningTechnology() {
        return isLearningTechnology;
    }
    public void setIsLearningTechnology(boolean isLearningTechnology){
        this.isLearningTechnology = isLearningTechnology;
    }

    public void addToTechnologyEarnedPercent(Technology technology, Integer roundLeft){
        if (!this.technologyEarnedPercent.containsKey(technology))
            this.technologyEarnedPercent.put(technology, roundLeft);
        this.workingOnTechnology = technology;
    }
    public void reduceTechnologyRound(){
        if (workingOnTechnology  == null)
            return;
        int roundLeft = this.technologyEarnedPercent.get(this.workingOnTechnology) - 1;
        if (roundLeft == 0) {
            isLearningTechnology = false;
            this.technologyEarnedPercent.remove(this.workingOnTechnology);
            this.addTechnology(this.workingOnTechnology);
            String message = "you have learnt " + this.workingOnTechnology.getName();
            messages.add(message);
            workingOnTechnology = null;
        }
        // TODO plus one
        setScience(sciencePerTurn / (roundLeft * 2 + 1));
        this.technologyEarnedPercent.replace(this.workingOnTechnology, roundLeft);
    }

    public void removeFriend (Civilization civilization) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(civilization)) {
                friends.remove(i);
                break;
            }
        }
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public ArrayList<Civilization> getFriendlyRequests() {
        return friendlyRequests;
    }

    public void addCity (City city) {
        cities.add(city);
    }

    public void removeCity(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals(city)) {
                cities.remove(i);
                break;
            }
        }
    }
    public String toString(){

        return this.name;
    }

    public void setCapital(City city) {
        this.capital = city;
    }

    public boolean equals(Civilization civilization) {
        if (this.getName().equals(civilization.getName()) &&
                this.getMember().equals(civilization.getMember())) return true;
        return false;
    }
}
