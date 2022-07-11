package Model;

import java.util.ArrayList;


public class GsonRoom {
    public GameSocket creatorSocket;
    public ArrayList<GameSocket> sockets = new ArrayList<>();

    public Member creatorMember;
    public ArrayList<String> nicknames = new ArrayList<>();

    public GsonRoom(GameSocket creatorSocket, Member member) {
        this.creatorMember = member;
        this.creatorSocket = creatorSocket;
        nicknames.add(member.getNickname());
        sockets.add(creatorSocket);
    }
}
