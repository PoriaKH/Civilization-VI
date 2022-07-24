package Model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class Member {
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String nickname;
    @Expose
    private int score;
    @Expose
    private String date;
    @Expose
    private int imageNumber;
    @Expose
    private ArrayList<Member> friends;
    @Expose
    public boolean isAutoSaveActive = false;

    public Member(String username, String nickname,String password, int score,int imageNumber,String date){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.score = score;
        this.date = date;
        this.imageNumber = imageNumber;
        friends = new ArrayList<>();
    }

    public Member() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String toString(){
        return "username : " + username + " nickname : " + nickname + " password" + password;
    }

    public boolean equals(Member member) {
        if (this.username.equals(member.getUsername()) &&
                this.password.equals(member.getPassword()) &&
                this.nickname.equals(member.getNickname())) return true;
        return false;
    }
}
