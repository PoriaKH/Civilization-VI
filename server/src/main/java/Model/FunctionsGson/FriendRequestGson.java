package Model.FunctionsGson;

import Model.Member;
import com.google.gson.annotations.Expose;

public class FriendRequestGson {
    @Expose
    public Member sender;
    @Expose
    public String receiverUsername;
}
