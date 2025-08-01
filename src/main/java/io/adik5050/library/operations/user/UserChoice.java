package io.adik5050.library.operations.user;

import java.util.Scanner;
import io.adik5050.library.input.user.ChoiceInputFromUser;

public class UserChoice {

    Scanner sc;
    int userChoice;
    int adminChoice;
    ChoiceInputFromUser userChoiceInput;

    public UserChoice(Scanner sc) {
        this.sc = sc;
        this.userChoiceInput = new ChoiceInputFromUser(sc);
    }

    private boolean verifyChoice(int choice) {
        return (choice >= 0 && choice <= 4);
    }

    public int getUserChoice() {
        this.userChoice = Integer.parseInt( userChoiceInput.input());
        if(!verifyChoice(userChoice)) return -1;
        return userChoice;
    }

    public int getAdminChoice() {
        this.adminChoice = Integer.parseInt(userChoiceInput.inputAdminChoice());
        if(!verifyChoice(adminChoice)) return -1;
        return adminChoice;
    }
}
