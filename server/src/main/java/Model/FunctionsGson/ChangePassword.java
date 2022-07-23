package Model.FunctionsGson;

import Model.Member;

public class ChangePassword {
    public String newPassword;
    public Member loggedInMember;

    public ChangePassword(String newPassword,Member loggedInMember){
        this.newPassword = newPassword;
        this.loggedInMember = loggedInMember;
    }
}
