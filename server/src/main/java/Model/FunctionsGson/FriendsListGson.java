package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class FriendsListGson {
    @Expose
    public Member sender;
    @Expose
    public ArrayList<String> friendsUsernames;
}
