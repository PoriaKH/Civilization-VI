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
    public static ArrayList<Member> players;
    public Scene scene;
    public Stage stage;
    public Label chatLabel;
    public TextField privateChatTF;

    public void run() throws IOException {
        BorderPane root = FXMLLoader.load(preChatFxmlURL);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void privateChat(MouseEvent mouseEvent) throws FileNotFoundException {
        if (privateChatTF.getText() == null) {
            chatLabel.setText("enter a player");
            return;
        }
        if (privateChatTF.getText().equals(loggedInMember.getUsername())) {
            chatLabel.setText("you can't chat with yourself!!!!!");
            return;
        }
        for (int i = 0; i < players.size(); i++) {
            if (privateChatTF.getText().equals(players.get(i).getUsername())){
                File file = new File("src/main/resources/privateMessages/" + loggedInMember.getUsername() + "-" + players.get(i).getUsername()+ ".txt");
                ChatBox chatBox = new ChatBox();
                chatBox.file = file;
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

    public void publicChat(MouseEvent mouseEvent) throws FileNotFoundException {
        File file = new File("src/main/resources/messageFile.txt");
        ChatBox chatBox = new ChatBox();
        chatBox.file = file;
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        chatBox.stage = this.stage;
        ChatBox.loggedInMember = MainMenu.loggedInMember;
        chatBox.run();
    }
}
