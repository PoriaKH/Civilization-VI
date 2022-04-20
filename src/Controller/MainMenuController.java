package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController {
    public Matcher getMatcher(String regex, String command){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        if (matcher.matches())
            return matcher;
        return null;
    }
    public void playGame(String command){

    }
}
