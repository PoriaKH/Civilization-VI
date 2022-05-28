package View;

import Controller.ProfileMenuController;
import Model.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class ProfileMenu {
    public static Member loggedInMember;
    public static URL mainMenuFxml;
    public static URL profileMenuFxml;
    public static URL changeNicknameFxml;
    public static URL changePasswordFxml;
    public Stage stage;
    public Scene scene;
    public Parent root;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label nicknameLabel;

    public void changeProfilePicture(MouseEvent mouseEvent) {
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

    public void changeNick(MouseEvent mouseEvent) throws IOException {

    }

    public void changePass(MouseEvent mouseEvent) {

    }

    public void switchToProfileMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(profileMenuFxml);
        scene = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


//    public ProfileMenu(Member loggedInMember){
//        this.loggedInMember = loggedInMember;
//    }
    /*
    public void run(Scanner scan) throws IOException {
        System.out.println("entered Profile Menu!");

        ProfileMenuController profileMenuController = new ProfileMenuController(loggedInMember);

        String changeNicknameRegex1 = "(profile change --nickname )(?<nickname>.*)";
        String changeNicknameRegex2 = "(profile change -n )(?<nickname>.*)";
        String changePasswordRegex1 = "(profile change --password --current )(?<oldPassword>.*) --new (?<newPassword>.*)";
        String changePasswordRegex2 = "(profile change --password --new )(?<newPassword>.*) --current (?<oldPassword>.*)";
        String changePasswordRegex3 = "(profile change --password -cp )(?<oldPassword>.*) -np (?<newPassword>.*)";
        String menuShowCurrentRegex = "menu show-current";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit")){
            if(command.matches(changeNicknameRegex1) || command.matches(changeNicknameRegex2)){
                if(command.matches(changeNicknameRegex1))
                    System.out.println(profileMenuController.profileChangeNickname(command, changeNicknameRegex1));
                else if(command.matches(changeNicknameRegex2))
                    System.out.println(profileMenuController.profileChangeNickname(command, changeNicknameRegex2));
            }
            else if(command.matches(changePasswordRegex1) || command.matches(changePasswordRegex2) || command.matches(changePasswordRegex3)){
                if(command.matches(changePasswordRegex1))
                    System.out.println(profileMenuController.profileChangePassword(command, changePasswordRegex1));
                else if(command.matches(changePasswordRegex2))
                    System.out.println(profileMenuController.profileChangePassword(command, changePasswordRegex2));
                else if(command.matches(changePasswordRegex3))
                    System.out.println(profileMenuController.profileChangePassword(command, changePasswordRegex3));
            }
            else if(command.matches(menuShowCurrentRegex))
                System.out.println("Profile Menu");
            else
                System.out.println("invalid command");

            command = scan.nextLine();
        }
    }
     */
}
