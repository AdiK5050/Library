package io.adik5050.library.operations.user;

import io.adik5050.library.input.user.Input;
import io.adik5050.library.input.user.UserIdInputFromUser;

import java.util.*;

public class UserVerification {
    Scanner sc;
    static final  Map<String, String> USER_ID = new HashMap<>();

    static{
        USER_ID.put("user_1", "USER1ALSDKFJEO3432");
        USER_ID.put("user_2", "USER2LAKJDFI2435");
    }

    public UserVerification(Scanner sc) {this.sc = sc;}
    UserIdInputFromUser uid = new UserIdInputFromUser(sc);

    String UserId = uid.input();

    public boolean verifyID(String input) {
        return USER_ID.containsValue(input);
    }

    public String giveAccessIfVerified() {
        if(!verifyID(UserId)) return "User Not Found";
        return "Welcome!";
    }

}
