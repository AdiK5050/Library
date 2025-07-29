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
    private final  Map<String, String> USER_ID = new HashMap<>(userIDFromFiles.getUserIDs());

    public UserVerification(Scanner sc) throws IOException {
        this.sc = sc;
        this.userIdInput = new UserIdInputFromUser(this.sc);
        this.userID = userIdInput.input();
    }

    public boolean verifyID(String userInput) {
        for(Entry<String,String> entry : USER_ID.entrySet()) {
            if(entry.getValue().equals(userInput)); return true;
        }
        return USER_ID.containsValue(userInput);
    }
    public void getUSER_ID() {
        USER_ID.entrySet().stream()
                .forEach(entry-> System.out.println(entry.getKey() + entry.getValue()));
    }

    public String giveAccessIfVerified() {
        if(!verifyID(userID)) return "User Not Found!";
        for(Entry<String, String> entry : USER_ID.entrySet())
            if(Objects.equals(entry.getValue(), userID))
                return "Welcome! " + entry.getKey();
        return "Welcome!";
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner( "USER20ZXCVBNRE2583");
        UserVerification testObject = new UserVerification(sc);
        System.out.println(testObject.verifyID(String.valueOf(sc)));
        System.out.println(testObject.giveAccessIfVerified());
        System.out.println(testObject.userID);
        testObject.getUSER_ID();
    }
}
