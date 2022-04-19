package View;

import Controller.LoginMenuController;
import Controller.MainMenuController;
import Model.Member;

import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public void run(Scanner scan){
        Member loggedInMember = new Member();

        LoginMenuController loginMenuController = new LoginMenuController();

        String showCurrentMenuRegex = "";
        String userCreateRegex1 = "(user create --username )(?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)";
        String userCreateRegex2 = "(user create --username )(?<username>.*) --password (?<password>.*) --nickname (?<nickname>.*)";
        String userCreateRegex3 = "(user create --nickname )(?<nickname>.*) --username (?<username>.*) --password (?<password>.*)";
        String userCreateRegex4 = "(user create --nickname )(?<nickname>.*) --password (?<password>.*) --username (?<username>.*)";
        String userCreateRegex5 = "(user create --password )(?<password>.*) --nickname (?<nickname>.*) --username (?<username>.*)";
        String userCreateRegex6 = "(user create --password )(?<password>.*) --username (?<username>.*) --nickname (?<nickname>.*)";
        String userCreateRegex7 = "(user create -u )(?<username>.*) -n (?<nickname>.*) -p (?<password>.*)";
        String loginRegex = "";
        String enterMainMenuRegex = "";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit")){
            //TODO... command.matches Call the LoginMenuController Functions
            if(command.matches(userCreateRegex1) || command.matches(userCreateRegex2) || command.matches(userCreateRegex3) || command.matches(userCreateRegex4) || command.matches(userCreateRegex5) || command.matches(userCreateRegex6) || command.matches(userCreateRegex7)){
                if(command.matches(userCreateRegex1))
                    System.out.println(loginMenuController.createUser(command,userCreateRegex1));
                else if(command.matches(userCreateRegex2))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex2));
                else if(command.matches(userCreateRegex3))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex3));
                else if(command.matches(userCreateRegex4))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex4));
                else if(command.matches(userCreateRegex5))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex5));
                else if(command.matches(userCreateRegex6))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex6));
                else if(command.matches(userCreateRegex7))
                    System.out.println(loginMenuController.createUser(command, userCreateRegex7));
            }

            command = scan.nextLine();
        }
    }
}
