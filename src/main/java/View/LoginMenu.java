package View;

import Model.Member;
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
        /*
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

        bufferedWriter.write(usernameTF.getText() + " " + passwordTF.getText() + " 0 " + new Date());
        bufferedWriter.newLine();

        message.setText("user registered successfully");

        bufferedWriter.close();
         */
    }

    public void loginMouseAction(ActionEvent event) throws IOException {
        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+) (?<image>\\d) (?<date>.+)";
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        line = bufferedReader.readLine();
        while(line != null && !line.equals(""))
        {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");
            String filePassword = fileMatcher.group("password");
            String fileDate = fileMatcher.group("date");
            int fileImage = Integer.parseInt(fileMatcher.group("image"));

            if(Objects.equals(fileUsername, usernameTF.getText())){
                if(Objects.equals(filePassword, passwordTF.getText())){
                    int score = Integer.parseInt(fileMatcher.group("score"));
                    changeDate(fileUsername,fileNickname,filePassword,score,fileImage);
                    MainMenu.loggedInMember = new Member(usernameTF.getText(),fileNickname,passwordTF.getText(),score,fileImage,fileDate);
                    switchToMain(event);
                    message.setText("");
                }
                message.setText("Username and password did not match!");
                return;
            }

            line = bufferedReader.readLine();
        }
        fileReader.close();

        message.setText("Username and password did not match!");
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
