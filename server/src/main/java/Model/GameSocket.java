package Model;


public class GameSocket {
    public String socketHost;
    public int socketPort;

    public GameSocket(String socketHost,int socketPort){
        this.socketHost = socketHost;
        this.socketPort = socketPort;
    }
    public String toString(){
        return "Host : " + socketHost + " Port : " + socketPort;
    }
}
