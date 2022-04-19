package Model;

public class Member {
    private String username;
    private String password;
    private String nickname;
    private int score;

    public Member(String username, String password, int score){
        this.username = username;
        this.password = password;
        this.score = score;
    }
}
