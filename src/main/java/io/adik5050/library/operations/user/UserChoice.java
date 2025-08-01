package io.adik5050.library.operations.user;

import java.util.Scanner;
import io.adik5050.library.input.user.ChoiceInputFromUser;

public class UserChoice {

    Scanner sc;
    int userChoice;
    ChoiceInputFromUser userChoiceInput;

    public UserChoice(Scanner sc) {
        this.sc = sc;
        this.userChoiceInput = new ChoiceInputFromUser(sc);
        this.userChoice = Integer.parseInt( userChoiceInput.input());
    }

    private boolean verifyChoice(int choice) {
        return (choice >= 0 && choice <= 4);
    }

    public int getUserChoice() {
        if(!verifyChoice(userChoice)) return -1;
        return userChoice;
    }
}
