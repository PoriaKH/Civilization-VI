package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    public Matcher getMatcher(String regex,String command){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        return matcher;
    }
    public boolean userExist(String command){

    }
    public String createUser(String command, String regex){
        Matcher matcher = getMatcher(command,regex);
        matcher.find();
    }
    public String login(String command){

    }
}
