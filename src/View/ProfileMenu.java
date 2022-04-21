package View;

import Controller.ProfileMenuController;
import Model.Member;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ProfileMenu {
    private Member loggedInMember;

    public ProfileMenu(Member loggedInMember){
        this.loggedInMember = loggedInMember;
    }
    public void run(Scanner scan) throws IOException {
        ProfileMenuController profileMenuController = new ProfileMenuController(loggedInMember);

        String changeNicknameRegex1 = "(profile change --nickname )(?<nickname>.*)";
        String changeNicknameRegex2 = "(profile change -n )(?<nickname>.*)";
        String changePasswordRegex1 = "(profile change --password --current )(?<oldPassword>.*) --new (?<newPassword>.*)";
        String changePasswordRegex2 = "(profile change --password --new )(?<newPassword>.*) --current (?<oldPassword>.*)";
        String changePasswordRegex3 = "(profile change --password -cp )(?<oldPassword>.*) -np (?<newPassword>.*)";
        String menuShowCurrentRegex = "menu show-current";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){
            //TODO...
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
}
