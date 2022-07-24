package View;

import Model.Member;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class PreChatBox {
    public static URL mainMenuFxmlURL;
    public static URL preChatFxmlURL;
    public static Member loggedInMember;
    public ArrayList<String> playersUsername;
    public Scene scene;
    public Stage stage;
    public Label chatLabel;
    public TextField privateChatTF;

    public PreChatBox(){
        playersUsername = new ArrayList<>();
        try {
            CreateHost.dataOutputStream.writeUTF("pre chat box usernames");
            CreateHost.dataOutputStream.flush();
            String result = CreateHost.dataInputStream.readUTF();
            String[] usernames = result.split("\n");
            for (int i = 0; i < usernames.length; i++)
                playersUsername.add(usernames[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        BorderPane root = FXMLLoader.load(preChatFxmlURL);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void privateChat(MouseEvent mouseEvent) throws IOException {
        if (privateChatTF.getText() == null) {
            chatLabel.setText("enter a player");
            return;
        }
        if (privateChatTF.getText().equals(loggedInMember.getUsername())) {
            chatLabel.setText("you can't chat with yourself!!!!!");
            return;
        }
        for (int i = 0; i < playersUsername.size(); i++) {
            if (privateChatTF.getText().equals(playersUsername.get(i))){
                String fileName = "";
                if (loggedInMember.getUsername().compareTo(playersUsername.get(i)) >= 0)
                    fileName = loggedInMember.getUsername() + "-" + playersUsername.get(i);
                else
                    fileName = playersUsername.get(i) + "-" + loggedInMember.getUsername();
                CreateHost.dataOutputStream.writeUTF("private chat " + fileName);
                CreateHost.dataOutputStream.flush();
                String response = CreateHost.dataInputStream.readUTF();
                String[] oldMessages = response.split("\n");
                ChatBox chatBox = new ChatBox();
                chatBox.fileName = fileName;
                chatBox.oldMessage = new ArrayList<>();
                for (int j = 0; j < oldMessages.length; j++)
                    chatBox.oldMessage.add(oldMessages[j]);
                stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
                chatBox.stage = this.stage;
                ChatBox.loggedInMember = MainMenu.loggedInMember;
                chatBox.run();
            }
        }
    }

    public void switchToMainMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(mainMenuFxmlURL);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void publicChat(MouseEvent mouseEvent) throws IOException {
        CreateHost.dataOutputStream.writeUTF("public chat");
        CreateHost.dataOutputStream.flush();
        ChatBox chatBox = new ChatBox();
        chatBox.fileName = "messageFile";
        String response = CreateHost.dataInputStream.readUTF();
        String[] oldMessages = response.split("\n");
        chatBox.oldMessage = new ArrayList<>();
        for (int i = 0; i < oldMessages.length; i++)
            chatBox.oldMessage.add(oldMessages[i]);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        chatBox.stage = this.stage;
        ChatBox.loggedInMember = MainMenu.loggedInMember;
        chatBox.run();
    }
}
