package Controller;

import Model.Member;
import View.MainMenu;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    private Member loggedInMember;

    public Matcher getMatcher(String command,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        return matcher;
    }
    public String createUser(String command, String regex) throws IOException {
        Matcher matcher = getMatcher(command,regex);
        matcher.find();
        String username = matcher.group("username");
        String nickname = matcher.group("nickname");
        String password = matcher.group("password");

        String theRegex = "[^ \\t]+";
        if(!username.matches(theRegex))
            return "invalid username";
        if(!nickname.matches(theRegex))
            return "invalid nickname";
        if(!password.matches(theRegex))
            return "invalid password";


        File file = new File("users.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+)";
        while (line != null) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");

            if(Objects.equals(fileUsername, username))
                return "username already exists";
            if(Objects.equals(fileNickname, nickname))
                return "nickname already exists";

            stringBuilder.append(line);
            stringBuilder.append("\n");

            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(stringBuilder));

        bufferedWriter.write(username + " " + nickname + " " + password + " 0");
        bufferedWriter.newLine();

        bufferedWriter.close();

        return "user created successfully!";
    }

    public String login(String command, String regex, Scanner scan) throws IOException {
        if(this.loggedInMember != null)
            return "you are already logged in";

        Matcher matcher = getMatcher(command,regex);
        matcher.find();

        String username = matcher.group("username");
        String password = matcher.group("password");

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+)";
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        line = bufferedReader.readLine();
        while(line != null)
        {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String filePassword = fileMatcher.group("password");
            String fileNickname = fileMatcher.group("nickname");

            if(Objects.equals(fileUsername, username)){
                if(Objects.equals(filePassword, password)){
                    int score = Integer.parseInt(fileMatcher.group("score"));
                    this.loggedInMember = new Member(username, password, fileNickname, score);
                    MainMenu mainMenu = new MainMenu(loggedInMember);
                    mainMenu.run(scan);
                    this.loggedInMember = null;
                    return "user logged out successfully!";
                }
                return "Username and password didn’t match!";
            }

            line = bufferedReader.readLine();
        }
        fileReader.close();

        return "Username and password didn’t match!";
    }
}
