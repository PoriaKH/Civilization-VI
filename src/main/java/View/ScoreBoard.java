package View;

import Model.FunctionsGson.ScoreboardGson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.LoginMenu.mainMenuFxmlURL;

public class ScoreBoard {
    public static Stage stage;
    public static Scene lobbyScene;
    public static URL scoreboardFxmlURL;
    private BorderPane pane;
    private ScrollPane container = new ScrollPane();
    private HBox scoreHBox = new HBox(40);
    private Button back = new Button("back");

    public void initialize(ScoreboardGson scoreboardGson) throws IOException {
        ArrayList<String> memberScores = scoreboardGson.membersScores;
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<String> nickNames = new ArrayList<>();
        ArrayList<String> scores = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> statuses = new ArrayList<>();
        for (int i = 0; i < memberScores.size(); i++) {
            String[] split = memberScores.get(i).split(" \\ ");
            userNames.add(split[0]);
            nickNames.add(split[1]);
            scores.add(split[2]);
            dates.add(split[3]);
            statuses.add(split[4]);
        }
        showScoreboard(userNames, nickNames, scores, dates, statuses);
    }

    public void showScoreboard(ArrayList<String> usernames, ArrayList<String> nickNames, ArrayList<String> scores, ArrayList<String> dates, ArrayList<String> statuses) throws IOException {
        pane = FXMLLoader.load(scoreboardFxmlURL);
        VBox mainVbox = new VBox(20);
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
            stage.setScene(lobbyScene);
        });
        container.setPrefSize(1280, 720);
        container.setContent(scoreHBox);
        ArrayList<Text> usernameTexts = new ArrayList<>();
        ArrayList<Text> nicknameTexts = new ArrayList<>();
        ArrayList<Text> scoreTexts = new ArrayList<>();
        ArrayList<Text> dateTexts = new ArrayList<>();
        ArrayList<Text> statusTexts = new ArrayList<>();
        VBox usernameVbox = new VBox(30);
        VBox nicknameVbox = new VBox(30);
        VBox scoreVbox = new VBox(30);
        VBox dateVbox = new VBox(30);
        VBox statusVbox = new VBox(30);
        mainVbox.setAlignment(Pos.CENTER);
        scoreHBox.setAlignment(Pos.CENTER);
        Text text1 = new Text("username");
        Text text2 = new Text("nickname");
        Text text3 = new Text("score");
        Text text4 = new Text("last login");
        Text text5 = new Text("status");
        usernameVbox.getChildren().add(text1);
        nicknameVbox.getChildren().add(text2);
        scoreVbox.getChildren().add(text3);
        dateVbox.getChildren().add(text4);
        statusVbox.getChildren().add(text5);
        for (int i = 0; i < usernames.size(); i++) {
            usernameTexts.add(new Text(usernames.get(i)));
            nicknameTexts.add(new Text(nickNames.get(i)));
            scoreTexts.add(new Text(scores.get(i)));
            scoreTexts.add(new Text(dates.get(i)));
            statusTexts.add(new Text(statuses.get(i)));
            usernameVbox.getChildren().add(usernameTexts.get(i));
            nicknameVbox.getChildren().add(nicknameTexts.get(i));
            scoreVbox.getChildren().add(scoreTexts.get(i));
            dateVbox.getChildren().add(dateTexts.get(i));
            statusVbox.getChildren().add(statusTexts.get(i));
        }
        scoreHBox.getChildren().add(usernameVbox);
        scoreHBox.getChildren().add(nicknameVbox);
        scoreHBox.getChildren().add(scoreVbox);
        scoreHBox.getChildren().add(dateVbox);
        scoreHBox.getChildren().add(statusVbox);
        mainVbox.getChildren().add(back);
        mainVbox.getChildren().add(container);
        pane.getChildren().add(mainVbox);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}
