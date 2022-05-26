package Controller;

import Model.Member;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenuController {
    public static Member loggedInMember;
/*
    public ProfileMenuController(Member loggedInMember){
        this.loggedInMember = loggedInMember;
    }

    public Matcher getMatcher(String command,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        return matcher;
    }

    public String profileChangeNickname(String command, String regex) throws IOException {
        Matcher matcher = getMatcher(command,regex);
        matcher.find();

        String newNickname = matcher.group("nickname");
        String nicknameRegex = "[^ \\t]+";

        if(!newNickname.matches(nicknameRegex))
            return "invalid nickname";
        if(newNickname.equals(loggedInMember.getNickname()))
            return "please enter a new nickname";

        String username = loggedInMember.getUsername();

        //
        boolean inUse = false;
        File file = new File("users.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            if(Objects.equals(fileNickname, newNickname)){
                inUse = true;
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        bufferedWriter.write(String.valueOf(stringBuilder));
        if(!inUse)
            bufferedWriter.write(loggedInMember.getUsername() + " " + newNickname + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore());
        else
            bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + loggedInMember.getPassword() + " " + loggedInMember.getScore());

        bufferedWriter.newLine();

        bufferedWriter.close();
        //
        if(inUse)
            return "user with nickname " + newNickname + " already exists";

        loggedInMember.setNickname(newNickname);
        return "nickname changed successfully!";
    }
    public String profileChangePassword(String command, String regex) throws IOException {
        Matcher matcher = getMatcher(command, regex);
        matcher.find();

        String newPassword = matcher.group("newPassword");
        String oldPassword = matcher.group("oldPassword");

        String passwordRegex = "[^ \\t]+";
        if(!newPassword.matches(passwordRegex))
            return "invalid password type";

        if(!Objects.equals(oldPassword, loggedInMember.getPassword()))
            return "current password is invalid";

        if(Objects.equals(oldPassword, loggedInMember.getPassword()) && Objects.equals(oldPassword, newPassword))
            return "please enter a new password";


        String username = loggedInMember.getUsername();
        //
        File file = new File("users.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder("");
        String line = bufferedReader.readLine();

        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+)";
        while (line != null && !line.equals("")) {
            Matcher fileMatcher = getMatcher(line, fileRegex);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");

            if(!Objects.equals(fileUsername, username)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            line = bufferedReader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.write(loggedInMember.getUsername() + " " + loggedInMember.getNickname() + " " + newPassword + " " + loggedInMember.getScore());

        bufferedWriter.newLine();

        bufferedWriter.close();
        //

        loggedInMember.setPassword(newPassword);
        return "password changed successfully!";
    }
 */
}
