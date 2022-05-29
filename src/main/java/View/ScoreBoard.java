package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public Parent root;
    public Stage stage;
    public Scene scene;

    public VBox list;

    private Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }

    public void initialize() throws IOException {
        ArrayList<String> users = new ArrayList<>();
        ArrayList<Integer> points = new ArrayList<>();
        ArrayList<String> nicknames = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<date>.+)";
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        line = bufferedReader.readLine();
        while(line != null && !line.equals(""))
        {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");
            int fileScore = Integer.parseInt(fileMatcher.group("score"));
            String fileDate = fileMatcher.group("date");
            users.add(fileUsername);
            points.add(fileScore);
            nicknames.add(fileNickname);
            dates.add(fileDate);

            line = bufferedReader.readLine();
        }
        fileReader.close();
        int userCounter = 1;
        int tempSize = points.size();
        for(int i = 0; i < points.size() + 1; i++){
            if(i == 10)
                break;

            int max = -1;
            int index = 0;
            for(int j = 0; j < points.size(); j++){
                if(points.get(j) > max){
                    max = points.get(j);
                    index = j;
                }
            }
            Text text = new Text(userCounter + "- " + nicknames.get(index) + " : " + points.get(index) + "  :          " + dates.get(index));
            text.setFill(Paint.valueOf("#086400"));
            text.setFont(Font.font("Verdana", FontWeight.BOLD, 23));
            list.getChildren().add(text);
            list.getChildren().add(new Text("--------------------------------------------------------------------------------------------------------------------------------"));
            users.remove(index);
            points.remove(index);
            nicknames.remove(index);
            dates.remove(index);
            i = 0;
            userCounter++;
        }

    }

    public void backClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(mainMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
