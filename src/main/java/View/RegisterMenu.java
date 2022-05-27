package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterMenu {
    public static URL loginMenuFxmlURL;
    public TextField usernameTF;
    public TextField nicknameTF;
    public PasswordField passwordTF;

    public Parent root;
    public Stage stage;
    public Scene scene;
    public Text message;

    private Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher;
    }

    public void registerMouseClicked(MouseEvent mouseEvent) throws IOException {
        String userAndPassRegex = "[a-zA-Z\\d!@#$%^&*?<>.]+";
        if(!usernameTF.getText().matches(userAndPassRegex) || !passwordTF.getText().matches(userAndPassRegex)){
            message.setText("invalid username or password");
            return;
        }

        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");

            if(Objects.equals(fileUsername, usernameTF.getText())) {
                message.setText("username already exists");
                return;
            }

            stringBuilder.append(line);
            stringBuilder.append("\n");

            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(stringBuilder));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        bufferedWriter.write(usernameTF.getText() + " " + nicknameTF.getText() + " " + passwordTF.getText() + " 0 " + dtf.format(now));
        bufferedWriter.newLine();

        message.setText("user registered successfully");

        bufferedWriter.close();
    }

    public void backClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(loginMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
