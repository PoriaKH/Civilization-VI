package View;

import Model.FunctionsGson.FriendRequestGson;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SendFriendRequest {
    public static URL sendFriendRequestURL;
    public static Member sender;
    public static Stage stage;
    public Scene scene;
    public static URL lobbyURL;
    private BorderPane pane = new BorderPane();
    private Button back = new Button("back");
    private Button send = new Button("add");
    private Label label = new Label();
    private Label empty = new Label();
    private VBox vBox = new VBox(50);
    private TextField textField = new TextField();
    public void run() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {
        pane = FXMLLoader.load(sendFriendRequestURL);
        pane.setPrefSize(1280, 720);
        back.setStyle("-fx-pref-width: 200;\n" +
                "    -fx-pref-height: 20;\n" +
                "    -fx-effect: dropshadow( one-pass-box , #d54444, 8 , 0.0 , 2 , 0 );\n" +
                "    -fx-font-style: italic;\n" +
                "    -fx-background-color:\n" +
                "            linear-gradient(from 0% 93% to 0% 100%, rgba(115, 42, 213, 0.83) 0%, #326dda 100%),\n" +
                "            #1a9bda,\n" +
                "            #31a3e0,\n" +
                "            radial-gradient(center 50% 50%, radius 100%, rgba(255, 84, 84, 0.7), #f11111);");
        back.setOnMouseClicked(event -> {
            try {
                pane = FXMLLoader.load(lobbyURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        });

        send.setStyle("-fx-pref-width: 200;\n" +
                "    -fx-pref-height: 20;\n" +
                "    -fx-effect: dropshadow( one-pass-box , #d54444, 8 , 0.0 , 2 , 0 );\n" +
                "    -fx-font-style: italic;\n" +
                "    -fx-background-color:\n" +
                "            linear-gradient(from 0% 93% to 0% 100%, rgba(115, 42, 213, 0.83) 0%, #326dda 100%),\n" +
                "            #1a9bda,\n" +
                "            #31a3e0,\n" +
                "            radial-gradient(center 50% 50%, radius 100%, rgba(255, 84, 84, 0.7), #f11111);");

        label.setStyle("-fx-font-size: 20;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(empty);
        vBox.getChildren().add(label);
        textField.setPromptText("enter the username you want to send request");
        textField.setMaxWidth(500);
        vBox.getChildren().add(textField);
        vBox.getChildren().add(send);
        vBox.getChildren().add(back);
        pane.setCenter(vBox);
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        send.setOnMouseClicked(event -> {
            String username = textField.getText();
            textField.clear();
            FriendRequestGson friendRequestGson = new FriendRequestGson();
            friendRequestGson.sender = sender;
            friendRequestGson.receiverUsername = username;
            Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
            String request = gson.toJson(friendRequestGson);
            String response = "";
            try {
                CreateHost.dataOutputStream.writeUTF("friendRequest " + request);
                CreateHost.dataOutputStream.flush();
                response = CreateHost.dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response.equals("no such username exists"))
                label.setText("no such username exists");
            else if (response.equals("this user is already your friend"))
                label.setText("this user is already your friend");
            else if (response.equals("friend request has been sent successfully"))
                label.setText("friend request has been sent successfully");
        });
    }
}
