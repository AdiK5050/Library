package io.adik5050.library.operations.user;

import io.adik5050.library.input.user.UserIdInputFromUser;
import io.adik5050.library.input.file.UserIdInputFromFiles;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class UserVerification {
    Scanner sc;
    String userID;
    UserIdInputFromUser userIdInput;
    UserIdInputFromFiles userIDFromFiles = new UserIdInputFromFiles();
    private final Map<String, String> ADMIN_ID = new HashMap<>(userIDFromFiles.getAdminIDs());
    private final  Map<String, String> USER_ID = new HashMap<>(userIDFromFiles.getUserIDs());

    public UserVerification(Scanner sc) throws IOException {
        this.sc = sc;
        this.userIdInput = new UserIdInputFromUser(this.sc);
        this.userID = userIdInput.input();
    }

    public boolean verifyID(String userInput) {
        for(Entry<String,String> entry : USER_ID.entrySet()) {
            if(entry.getValue().trim().equals(userInput)) return true;
        }
        return false;
    }

    public String giveAccessIfVerified() {
        if(!verifyID(userID)) return "User Not Found!";
        for(Entry<String, String> entry : USER_ID.entrySet())
            if(Objects.equals(entry.getValue().trim(), userID))
                return "Welcome! " + entry.getKey();
        return "Welcome!";
    }

    public boolean verifyAdminId(String userInput) {
        for (Entry<String, String> entry : ADMIN_ID.entrySet()) {
            if(entry.getValue().equals(userInput)) return true;
        }
        return false;
    }

    public String giveAdminAccessIfVerified() {
        if(!verifyAdminId(userID)) return "You are not an admin";
        for(Entry<String, String> entry : ADMIN_ID.entrySet()) {
            if(Objects.equals(entry.getValue(), userID))
                return "Welcome! " + entry.getKey();
        }
        return "Welcome!";
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("USER1KJHGFDS9876");
        UserVerification testObj = new UserVerification(sc);
        System.out.println(testObj.giveAccessIfVerified());
    }
}
