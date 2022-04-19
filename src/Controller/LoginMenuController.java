package Controller;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    public Matcher getMatcher(String command,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        return matcher;
    }
    public boolean userExist(String command){

    }
    public String createUser(String command, String regex) throws IOException {
        Matcher matcher = getMatcher(command,regex);
        matcher.find();
        String username = matcher.group("username");
        String nickname = matcher.group("nickname");
        String password = matcher.group("password");

        String theRegex = "[^ \\t]*";
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

        return "user created successfully";
    }

    public String login(String command){

    }
}
