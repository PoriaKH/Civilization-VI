import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static ServerSocket serverSocket;
    static {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Socket>> sockets = new ArrayList<>();


    public static void main(String[] args) {
        try {
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("socket accepted");
                new Thread(() -> {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        while (true){
                            String input = dataInputStream.readUTF();
//                            String result = process(input);
//                            dataOutputStream.writeUTF(result);
                            System.out.println(input);
                            dataOutputStream.flush();
                        }
                    }catch (IOException x){
                        x.printStackTrace();
                    }
                }).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
