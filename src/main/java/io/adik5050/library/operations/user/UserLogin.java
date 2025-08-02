package io.adik5050.library.operations.user;

import io.adik5050.library.input.file.NewUserID;
import io.adik5050.library.input.user.UserNameInputFromUser;

import java.io.IOException;
import java.util.Scanner;

public class UserLogin {

    Scanner sc;
    NewUserID newUserIDObj;
    UserNameInputFromUser userNameInputFromUserObj;

    public UserLogin(Scanner sc) throws IOException {
        this.sc = sc;
        this.newUserIDObj = new NewUserID();
        this.userNameInputFromUserObj = new UserNameInputFromUser(this.sc);
    }

    public String generateUserID() throws IOException {
        String userName = userNameInputFromUserObj.input();
        for(int i = 0; i < 5; i++) {
            String createdUID = newUserIDObj.createUID();
            if(newUserIDObj.checkUID(createdUID)) return newUserIDObj.addNewUser(userName, createdUID);
        }
        return "Couldn't Sign Up. Try again Later!";
    }
}
