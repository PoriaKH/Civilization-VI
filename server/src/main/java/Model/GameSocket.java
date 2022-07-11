package Model;


public class GameSocket {
    public String socketHost;
    public int remotePort;
    public int socketPort;

    public GameSocket(String socketHost,int remotePort,int socketPort){
        this.socketHost = socketHost;
        this.remotePort = remotePort;
        this.socketPort = socketPort;
    }
    public String toString(){
        return "Host : " + socketHost + "RemotePort" + remotePort + " SocketPort : " + socketPort;
    }
}
