package Model;
import java.util.ArrayList;


public class GsonRoom {
    public GameSocket creatorSocket;
    public ArrayList<GameSocket> sockets = new ArrayList<>();

    public Member creatorMember;
    public ArrayList<Member> members = new ArrayList<>();

    public GsonRoom(GameSocket creatorSocket,Member member) {
        this.creatorMember = member;
        this.creatorSocket = creatorSocket;
    }
    public String toString(){
        return "creatorSocket : " + creatorSocket + " sockets : " + sockets + " creatorMember : " + creatorMember + " members : " + members;
    }
}
