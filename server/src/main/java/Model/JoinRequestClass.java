package Model;

public class JoinRequestClass {
    public Member member;
    public String text;
    public String nick;

    public JoinRequestClass(String text,String nick,Member member){
        this.member = member;
        this.text = text;
        this.nick = nick;
    }
}
