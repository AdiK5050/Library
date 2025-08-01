package io.adik5050.library.operations.user;

import io.adik5050.library.input.user.UserIdInputFromUser;
import io.adik5050.library.input.file.UserIdInputFromFiles;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class UserVerification {
    Scanner sc;
    private String userID;
    private String adminID;
    UserIdInputFromUser userIdInput;
    UserIdInputFromFiles userIDFromFiles;
    private final Map<String, String> ADMIN_ID;
    private final  Map<String, String> USER_ID;

    public UserVerification(Scanner sc) throws IOException {
        this.sc = sc;
        this.userIDFromFiles = new UserIdInputFromFiles();
        this.userIdInput = new UserIdInputFromUser(this.sc);
        this.ADMIN_ID = new HashMap<>(userIDFromFiles.getAdminIDs());
        this.USER_ID = new HashMap<>(userIDFromFiles.getUserIDs());
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean verifyID(String userInput) {
        for(Entry<String,String> entry : USER_ID.entrySet()) {
            if(entry.getValue().trim().equals(userInput)) return true;
        }
        return false;
    }

    public String getUserName() {
        if(!verifyID(userID)) return "User Not Found!";
        for(Entry<String, String> entry : USER_ID.entrySet())
            if(Objects.equals(entry.getValue().trim(), userID))
                return "Welcome! " + entry.getKey();
        return "Welcome!";
    }

    public boolean verifyAdminId(String adminInput) {
        for (Entry<String, String> entry : ADMIN_ID.entrySet()) {
            if(entry.getValue().trim().equals(adminInput)) return true;
        }
        return false;
    }

    public String getAdminName() {
        if(!verifyAdminId(adminID)) return "You are not an admin";
        for(Entry<String, String> entry : ADMIN_ID.entrySet()) {
            if(Objects.equals(entry.getValue().trim(), adminID))
                return "Welcome! " + entry.getKey();
        }
        return "Welcome!";
    }

}
