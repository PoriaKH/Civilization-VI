package View;

import Model.FunctionsGson.FriendsListGson;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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
    private Pane pane = new Pane();
    private Scene scene;
    private Button back = new Button("back");
    private ScrollPane container = new ScrollPane();
    private VBox vBox = new VBox(50);
    private VBox mainVBox = new VBox(50);
    public static Member sender;
    private ArrayList<String> friends = new ArrayList<>();

    public void run() throws IOException {
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
        mainVBox.getChildren().add(back);
        mainVBox.getChildren().add(container);
        container.setPrefSize(1280, 600);
        container.setContent(vBox);
        Text subText = new Text("your friends: ");
        vBox.getChildren().add(subText);
        ArrayList<HBox> hBoxes = new ArrayList<>();
        ArrayList<Text> friendsText = new ArrayList<>();
        ArrayList<Button> profileButtons = new ArrayList<>();
        if (friends.size() == 0) {
            friendsText.add(new Text("you have no friends![how dark :( ]"));
            vBox.getChildren().add(friendsText.get(0));
        }
        for (int i = 0; i < friends.size(); i++) {
            hBoxes.add(new HBox(50));
            profileButtons.add(new Button("profile"));
            friendsText.add(new Text(friends.get(i)));
            hBoxes.get(i).getChildren().add(friendsText.get(i));
            hBoxes.get(i).getChildren().add(profileButtons.get(i));
            vBox.getChildren().add(hBoxes.get(i));
        }
        pane.getChildren().add(mainVBox);
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
