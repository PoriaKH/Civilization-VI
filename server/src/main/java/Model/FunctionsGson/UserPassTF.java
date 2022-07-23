package Model.FunctionsGson;

import javafx.scene.control.TextField;

public class UserPassTF {

    private String usernameTF;
    private String passwordTF;

    public UserPassTF(String usernameTF,String passwordTF){
        this.usernameTF = usernameTF;
        this.passwordTF = passwordTF;
    }

    public String getUsernameTF() {
        return usernameTF;
    }

    public String getPasswordTF() {
        return passwordTF;
    }
}
