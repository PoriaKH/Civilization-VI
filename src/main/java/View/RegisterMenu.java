package View;

import Model.FunctionsGson.RegisterTF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.CreateHost.dataInputStream;
import static View.CreateHost.dataOutputStream;


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
        RegisterTF registerTF = new RegisterTF(usernameTF.getText(),nicknameTF.getText(),passwordTF.getText());
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(registerTF);
        dataOutputStream.writeUTF("register" + out);
        dataOutputStream.flush();

        String ans = dataInputStream.readUTF();

        if(ans.startsWith("setMessage")){
            ans = ans.substring(10);
            message.setText(ans);
        }
    }

    public void backClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(loginMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
