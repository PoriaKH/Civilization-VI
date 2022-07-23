package Model.FunctionsGson;

import Model.Member;

public class ChangeNickname {
    public String newNickname;
    public Member loggedInMember;

    public ChangeNickname(String newNickname,Member loggedInMember){
        this.newNickname = newNickname;
        this.loggedInMember = loggedInMember;
    }
}
