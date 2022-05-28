package Model;

public class Member {
    private String username;
    private String password;
    private String nickname;
    private int score;
    private String date;
    private int imageNumber;

    public Member(String username, String nickname,String password, int score,int imageNumber,String date){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.score = score;
        this.date = date;
        this.imageNumber = imageNumber;
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
}
