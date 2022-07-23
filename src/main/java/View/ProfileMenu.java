package View;

import Controller.ProfileMenuController;
import Model.FunctionsGson.ChangeNickname;
import Model.FunctionsGson.ChangePassword;
import Model.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static View.CreateHost.dataInputStream;
import static View.CreateHost.dataOutputStream;

public class ProfileMenu {
    public static Member loggedInMember;
    public static URL mainMenuFxml;
    public static URL profileMenuFxml;
    public static URL changeNicknameFxml;
    public static URL changePasswordFxml;
    public static URL changeProfilePicFxml;
    public static URL firstPic;
    public static URL secondPic;
    public static URL thirdPic;
    public static URL forthPic;
    public Stage stage;
    public Scene scene;
    public Parent root;
    public TextField nicknameTF;
    public TextField passwordTF;
    public Label passwordLabel;
    public Label nicknameLabel;

    private Matcher getMatcher(String command, String regex) {
        return Pattern.compile(regex).matcher(command);
    }

    public void changeProfilePicture(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(changeProfilePicFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changePassword(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(changePasswordFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changeNickname(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(changeNicknameFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(mainMenuFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



    public void profileChangeNickname(MouseEvent mouseEvent) throws IOException {

        boolean inUse;
        String newNickname = nicknameTF.getText();
        String nicknameRegex = "[^ \\t]+";

        if(!newNickname.matches(nicknameRegex)) {
            nicknameLabel.setText("invalid nickname");
            return;
        }
        if(newNickname.equals(loggedInMember.getNickname())) {
            nicknameLabel.setText("please enter a new nickname");
            return;
        }
        ChangeNickname changeNickname = new ChangeNickname(newNickname,loggedInMember);
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(changeNickname);
        dataOutputStream.writeUTF("changeNick" + out);
        dataOutputStream.flush();
        //
        String ans = dataInputStream.readUTF();
        inUse = ans.equals("true");

        if(inUse){
            nicknameLabel.setText("user with this nickname already exists!");
            return;
        }

        loggedInMember.setNickname(newNickname);
        switchToProfileMenu(mouseEvent);
    }

    public void profileChangePassword(MouseEvent mouseEvent) throws IOException {

        String newPassword = passwordTF.getText();
        String oldPassword = loggedInMember.getPassword();
        String date = "";

        String passwordRegex = "[^ \\t]+";
        if(!newPassword.matches(passwordRegex)) {
            passwordLabel.setText("invalid password type");
            return;
        }

        if(!Objects.equals(oldPassword, loggedInMember.getPassword())) {
            passwordLabel.setText("current password is invalid");
            return;
        }

        if(Objects.equals(oldPassword, loggedInMember.getPassword()) && Objects.equals(oldPassword, newPassword)) {
            passwordLabel.setText("please enter a new password");
            return;
        }
        ChangePassword changePassword = new ChangePassword(newPassword,loggedInMember);
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(changePassword);
        dataOutputStream.writeUTF("changePassword" + out);
        dataOutputStream.flush();


        loggedInMember.setPassword(newPassword);
        switchToProfileMenu(mouseEvent);
    }

    public void changePass(MouseEvent mouseEvent) throws IOException {
        profileChangePassword(mouseEvent);
    }

    public void switchToProfileMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(profileMenuFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changeNick(MouseEvent mouseEvent) throws IOException {
        profileChangeNickname(mouseEvent);
    }


    public void changeProf(int imageNumber, MouseEvent mouseEvent) throws IOException {
        String username = loggedInMember.getUsername();
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();
        String date = "";
        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            date = fileMatcher.group("date");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore() + " " + imageNumber + " " + date);
        bufferedWriter.newLine();
        bufferedWriter.close();
        switchToProfileMenu(mouseEvent);
    }

    public void setFirstPic(MouseEvent mouseEvent) throws IOException {
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF("changePic0" + out);
        loggedInMember.setImageNumber(0);
        switchToProfileMenu(mouseEvent);
    }

    public void setSecondPic(MouseEvent mouseEvent) throws IOException {
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF("changePic1" + out);
        loggedInMember.setImageNumber(1);
        switchToProfileMenu(mouseEvent);
    }

    public void setThirdPic(MouseEvent mouseEvent) throws IOException {
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF("changePic2" + out);
        loggedInMember.setImageNumber(2);
        switchToProfileMenu(mouseEvent);
    }

    public void setForthPic(MouseEvent mouseEvent) throws IOException {
        Gson gson = new GsonBuilder().create();
        String out = gson.toJson(loggedInMember);
        dataOutputStream.writeUTF("changePic3" + out);
        loggedInMember.setImageNumber(3);
        switchToProfileMenu(mouseEvent);
    }
}
