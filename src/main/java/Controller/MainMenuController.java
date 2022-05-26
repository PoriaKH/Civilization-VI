package Controller;

import Model.Member;
import View.MainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController {
    /*
    public Matcher getMatcher(String regex, String command){
        Matcher matcher = Pattern.compile(regex).matcher(command);

        if(command.matches(regex))
            return matcher;
        else
            return null;
    }
    public ArrayList<Member> getAllMembers() throws IOException {
        ArrayList<Member> members = new ArrayList<>();
        //
        String fileRegex = "(?<username>.*) (?<nickname>.*) (?<password>.*) (?<score>\\d+)";
        File file = new File("users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        line = bufferedReader.readLine();
        while(line != null && !line.equals(""))
        {
            Matcher fileMatcher = getMatcher(fileRegex, line);
            fileMatcher.find();
            String fileUsername = fileMatcher.group("username");
            String fileNickname = fileMatcher.group("nickname");
            String filePassword = fileMatcher.group("password");
            int fileScore = Integer.parseInt(fileMatcher.group("score"));
            Member member = new Member(fileUsername, filePassword, fileNickname, fileScore);
            members.add(member);

            line = bufferedReader.readLine();
        }
        fileReader.close();
        //

        return members;
    }
     */
}
