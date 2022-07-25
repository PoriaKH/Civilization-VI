package View;

import Model.FunctionsGson.FriendsListGson;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FriendsList {
    public static Stage stage;
    public static URL lobbyURL;
    public static URL friendsListURL;
    private BorderPane pane = new BorderPane();
    private Scene scene;
    private Button back = new Button("back");
    private Label label = new Label("your friends :");
    private ScrollPane container = new ScrollPane();
    private VBox vBox = new VBox(50);
    private VBox mainVBox = new VBox(50);
    private Label spacing = new Label("                         ");
    public static Member sender;
    private ArrayList<String> friends = new ArrayList<>();

    public void run() throws IOException {
        pane = FXMLLoader.load(friendsListURL);
        FriendsListGson friendsListGson = new FriendsListGson();
        friendsListGson.sender = sender;
        friendsListGson.friendsUsernames = friends;
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        String request = gson.toJson(friendsListGson);
        CreateHost.dataOutputStream.writeUTF("friendsList " + request);
        CreateHost.dataOutputStream.flush();
        String response = CreateHost.dataInputStream.readUTF();
        FriendsListGson friendsListGson1 = gson.fromJson(response, FriendsListGson.class);
        friends = friendsListGson1.friendsUsernames;
        initializeList();
    }

    public void initializeList(){
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
        label.setStyle("-fx-font-size: 25;\n" +
                "    -fx-font-family: Ebrima;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgb(255, 0, 47), 6, 0.0 , 0 , 2 );");
        mainVBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.getChildren().add(back);
        mainVBox.getChildren().add(label);
        mainVBox.getChildren().add(container);
        container.setPrefSize(1280, 600);
        container.setContent(vBox);
        ArrayList<HBox> hBoxes = new ArrayList<>();
        ArrayList<Label> friendsText = new ArrayList<>();
        ArrayList<Button> profileButtons = new ArrayList<>();
        if (friends.size() == 0) {
            hBoxes.add(new HBox(50));
            hBoxes.get(0).getChildren().add(spacing);
            friendsText.add(new Label("you have no friends! how dark :( "));
            friendsText.get(0).setStyle("-fx-font-size: 25;\n" +
                    "    -fx-border-color: #4d0000;\n" +
                    "    -fx-background-color: #8f0202;");
            hBoxes.get(0).getChildren().add(friendsText.get(0));
            vBox.getChildren().add(hBoxes.get(0));
        }
        for (int i = 0; i < friends.size(); i++) {
            hBoxes.add(new HBox(50));
            friendsText.add(new Label(friends.get(i)));
            profileButtons.add(new Button("profile"));
            int finalI = i;
            profileButtons.get(i).setOnMouseClicked(event -> {
                String response = "";
                try {
                    CreateHost.dataOutputStream.writeUTF("friend profile " + friends.get(finalI));
                    CreateHost.dataOutputStream.flush();
                    response = CreateHost.dataInputStream.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] userInfo = response.split(" ");
                FriendProfile friendProfile = new FriendProfile();
                FriendProfile.stage = stage;
                friendProfile.friendsList = this;
                try {
                    friendProfile.run(userInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            hBoxes.get(i).getChildren().add(spacing);
            hBoxes.get(i).getChildren().add(friendsText.get(i));
            hBoxes.get(i).getChildren().add(profileButtons.get(i));
            vBox.getChildren().add(hBoxes.get(i));
        }
        pane.setCenter(mainVBox);
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
