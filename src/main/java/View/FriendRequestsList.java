package View;

import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FriendRequestsList {
    public static Member member;
    public static Stage stage;

    public static URL lobbyURL;
    public static URL friendRequestsListURL;
    private BorderPane pane = new BorderPane();
    public Scene scene = new Scene(pane);
    private Button back = new Button("back");
    private ArrayList<Button> accept = new ArrayList<>();
    private ArrayList<Button> deny = new ArrayList<>();
    private ArrayList<HBox> hBoxes = new ArrayList<>();
    private ArrayList<Label> usernamesLabel = new ArrayList<>();
    private VBox vBox = new VBox(50);
    private VBox mainVBox = new VBox(50);
    private ScrollPane container = new ScrollPane();
    private Label spacing = new Label("                 ");

    public void run() throws IOException {
        System.out.println("fisrt");
        pane.getChildren().clear();
        vBox.getChildren().clear();
        mainVBox.getChildren().clear();
        //pane = new BorderPane();
        accept.clear();
        deny.clear();
        hBoxes.clear();
        usernamesLabel.clear();
        //vBox.getChildren().removeAll();
        //ainVBox.getChildren().removeAll();
        container.setContent(null);
        pane = FXMLLoader.load(friendRequestsListURL);
        vBox.setAlignment(Pos.CENTER);
        String request = "friend requests list " + member.getUsername();
        String response = "";
        try {
            CreateHost.dataOutputStream.writeUTF(request);
            CreateHost.dataOutputStream.flush();
            response = CreateHost.dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] usernames = response.split("\n");
        String[] usernameCopy = new String[usernames.length];
        int j = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (!usernames[i].equals("\\s") && !usernames[i].equals(""))
                usernameCopy[j++] = usernames[i];
        }
        if (j == 0){
            hBoxes.add(new HBox(50));
            Text friendsText = new Text("there is no friend requests!");
            friendsText.setStyle("-fx-font-size: 25;\n" +
                    "    -fx-border-color: #4d0000;\n" +
                    "    -fx-background-color: #8f0202;");
            hBoxes.get(0).getChildren().add(spacing);
            hBoxes.get(0).getChildren().add(friendsText);
            vBox.getChildren().add(hBoxes.get(0));
        }
        for (int i = 0; i < j; i++) {
            usernamesLabel.add(new Label(usernameCopy[i]));
            accept.add(new Button("accept"));
            deny.add(new Button("deny"));
            accept.get(i).setStyle("-fx-pref-width: 200;\n" +
                    "    -fx-pref-height: 20;\n" +
                    "    -fx-effect: dropshadow( one-pass-box , #d54444, 8 , 0.0 , 2 , 0 );\n" +
                    "    -fx-font-style: italic;\n" +
                    "    -fx-background-color:\n" +
                    "            linear-gradient(from 0% 93% to 0% 100%, rgba(115, 42, 213, 0.83) 0%, #326dda 100%),\n" +
                    "            #1a9bda,\n" +
                    "            #31a3e0,\n" +
                    "            radial-gradient(center 50% 50%, radius 100%, rgba(255, 84, 84, 0.7), #f11111);");
            deny.get(i).setStyle("-fx-pref-width: 200;\n" +
                    "    -fx-pref-height: 20;\n" +
                    "    -fx-effect: dropshadow( one-pass-box , #d54444, 8 , 0.0 , 2 , 0 );\n" +
                    "    -fx-font-style: italic;\n" +
                    "    -fx-background-color:\n" +
                    "            linear-gradient(from 0% 93% to 0% 100%, rgba(115, 42, 213, 0.83) 0%, #326dda 100%),\n" +
                    "            #1a9bda,\n" +
                    "            #31a3e0,\n" +
                    "            radial-gradient(center 50% 50%, radius 100%, rgba(255, 84, 84, 0.7), #f11111);");
            int finalI = i;
            accept.get(i).setOnMouseClicked(event -> {
                try {
                    CreateHost.dataOutputStream.writeUTF("accept friendRequest " + usernames[finalI] + " # " + member.getUsername());
                    CreateHost.dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    this.run();
                    System.out.println("hi");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            deny.get(i).setOnMouseClicked(event -> {
                try {
                    CreateHost.dataOutputStream.writeUTF("deny friendRequest " + usernames[finalI] + " # " + member.getUsername());
                    CreateHost.dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    this.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            hBoxes.add(new HBox(50));
            hBoxes.get(i).getChildren().add(spacing);
            hBoxes.get(i).getChildren().add(usernamesLabel.get(i));
            hBoxes.get(i).getChildren().add(accept.get(i));
            hBoxes.get(i).getChildren().add(deny.get(i));
            vBox.getChildren().add(hBoxes.get(i));
        }
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
            Pane mainPane = new Pane();
            try {
                mainPane = FXMLLoader.load(lobbyURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene = new Scene(mainPane);
            stage.setScene(scene);
            stage.show();
        });
        container.setPrefSize(1280, 600);
        container.setContent(vBox);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.getChildren().add(back);
        mainVBox.getChildren().add(container);
        pane.setCenter(mainVBox);
        scene.setRoot(pane);
        stage.setScene(scene);
        stage.show();
        System.out.println("endddd");
    }
}
