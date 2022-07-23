package View;

import Model.FunctionsGson.GotoMain;
import Model.FunctionsGson.UserPassTF;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.CreateHost.dataInputStream;
import static View.CreateHost.dataOutputStream;


public class LoginMenu {
    public static URL mainMenuFxmlURL;
    public static URL registerMenuFxmlURL;
    public Parent root;
    public Stage stage;
    public Scene scene;
    public TextField usernameTF;
    public PasswordField passwordTF;
    public Text message;

    private Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }

    public void registerMouseClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(registerMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginMouseAction(ActionEvent event) throws IOException {
        Gson gson = new GsonBuilder().create();
        UserPassTF userPassTF = new UserPassTF(usernameTF.getText(),passwordTF.getText());
        String out = gson.toJson(userPassTF);
        dataOutputStream.writeUTF("login" + out);
        dataOutputStream.flush();

        String ans = dataInputStream.readUTF();

        if(ans.startsWith("gotoMain")){
            ans = ans.substring(8);
            Gson gson1 = new GsonBuilder().create();
            GotoMain gotoMain = gson1.fromJson(ans,GotoMain.class);
            String fileNickname = gotoMain.fileNickname;
            int score = gotoMain.score;
            int fileImage = gotoMain.fileImage;
            String fileDate = gotoMain.fileDate;

            MainMenu.loggedInMember = new Member(usernameTF.getText(),fileNickname,passwordTF.getText(),score,fileImage,fileDate);
            ProfileMenu.loggedInMember = MainMenu.loggedInMember;
            switchToMain(event);
            message.setText("");
        }
        else {
            System.out.println(ans);
            message.setText("Username and password did not match!");
        }

    }

    private void changeDate(String fileUsername, String fileNickname, String filePassword, int score, int imageNumber) throws IOException {
        File file = new File("users.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();

            String username = fileMatcher.group("username");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        bufferedWriter.write(String.valueOf(stringBuilder));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        bufferedWriter.write(fileUsername + " " + fileNickname + " " + filePassword + " " + score + " " + imageNumber + " " + dtf.format(now));

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    public void switchToMain(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(mainMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
