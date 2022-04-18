package View;

import Controller.ProfileMenuController;
import Model.Member;

import java.util.Objects;
import java.util.Scanner;

public class ProfileMenu {
    private Member loggedInMember;
    public ProfileMenu(Member loggedInMember){
        this.loggedInMember = loggedInMember;
    }
    public void run(Scanner scan){
        ProfileMenuController profileMenuController = new ProfileMenuController();

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "exit menu")){
            //TODO...


            command = scan.nextLine();
        }
    }
}
