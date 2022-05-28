package View;

import Controller.ProfileMenuController;
import Model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class ProfileMenu {
    public static Member loggedInMember;
    public static URL mainMenuFxml;
    @FXML
    private Button mainMenu;
    @FXML
    private Button changeNickname;
    @FXML
    private Button changePassword;
    @FXML
    private Button changeProfilePic;

    public void changeProfilePicture(MouseEvent mouseEvent) {
    }

    public void changePassword(MouseEvent mouseEvent) {
    }

    public void changeNickname(MouseEvent mouseEvent) {
    }

    public void switchToMainMenu(MouseEvent mouseEvent) {
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
