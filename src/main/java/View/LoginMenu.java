package View;

import Controller.LoginMenuController;
import Model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {
    public static URL mainMenuFxmlURL;
    public Parent root;
    public Stage stage;
    public Scene scene;

    public void buttonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(mainMenuFxmlURL);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
/*
    public void run(Scanner scan) throws IOException {

        LoginMenuController loginMenuController = new LoginMenuController();

        String menuShowCurrentRegex = "menu show-current";
        String userCreateRegex1 = "(user create --username )(?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)";
        String userCreateRegex2 = "(user create --username )(?<username>.*) --password (?<password>.*) --nickname (?<nickname>.*)";
        String userCreateRegex3 = "(user create --nickname )(?<nickname>.*) --username (?<username>.*) --password (?<password>.*)";
        String userCreateRegex4 = "(user create --nickname )(?<nickname>.*) --password (?<password>.*) --username (?<username>.*)";
        String userCreateRegex5 = "(user create --password )(?<password>.*) --nickname (?<nickname>.*) --username (?<username>.*)";
        String userCreateRegex6 = "(user create --password )(?<password>.*) --username (?<username>.*) --nickname (?<nickname>.*)";
        String userCreateRegex7 = "(user create -u )(?<username>.*) -n (?<nickname>.*) -p (?<password>.*)";
        String userLoginRegex1 = "(user login --username )(?<username>.*) --password (?<password>.*)";
        String userLoginRegex2 = "(user login --password )(?<password>.*) --username (?<username>.*)";
        String userLoginRegex3 = "(user login -u )(?<username>.*) -p (?<password>.*)";

        String command;
        command = scan.nextLine();

        while(!Objects.equals(command, "menu exit")){
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
            else if(command.matches(userLoginRegex1) || command.matches(userLoginRegex2) || command.matches(userLoginRegex3)){
                if(command.matches(userLoginRegex1))
                    System.out.println(loginMenuController.login(command,userLoginRegex1,scan));
                else if(command.matches(userLoginRegex2))
                    System.out.println(loginMenuController.login(command,userLoginRegex2,scan));
                else if(command.matches(userLoginRegex3))
                    System.out.println(loginMenuController.login(command,userLoginRegex3,scan));
            }
            else if(command.matches(menuShowCurrentRegex))
                System.out.println("Login Menu");
            else
                System.out.println("invalid command");

            command = scan.nextLine();
        }
    }
    */
}
